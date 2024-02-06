package com.android.maplemate.ViewModel

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.maplemate.BuildConfig
import com.android.maplemate.Data.Equipment
import com.android.maplemate.Data.MapleData
import com.android.maplemate.Service.ApiServiceMaple
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


class SecondFragmentViewModel : ViewModel() {
    companion object {

        private const val TAG = "SecondFragmentViewModel"
        private val startTime: LocalTime = LocalTime.of(0, 0)
        private val endTime: LocalTime = LocalTime.of(4, 0)
    }

    //시간 관련 변수

    private val currentDate: LocalDate = LocalDate.now()
    private var yesterday =
        currentDate.minusDays(1)  // yesterday 의값은 oncreate 에서 조건에 따라 변하므로 var로 선언
    private val now: LocalDateTime = LocalDateTime.now()
    private val Context.preferenceDataStore: DataStore<Preferences> by preferencesDataStore(name = "getOcid")
    private lateinit var testApikey: String

    // 닉네임,식별자
    private lateinit var mapleNickName: String
    private lateinit var getocid: String

    //캐릭터 정보 데이터
    private val _CharacterImage = MutableLiveData<String?>()
    val CharacterImage: LiveData<String?> get() = _CharacterImage

    private val _CharacterLevel = MutableLiveData<String>()
    val CharacterLevel: LiveData<String> get() = _CharacterLevel

    private val _WorldName = MutableLiveData<String>()

    val WorldName: LiveData<String> get() = _WorldName

    private val _CharacterName = MutableLiveData<String>()
    val CharacterName: LiveData<String> get() = _CharacterName

    private val _CharacterGuildName = MutableLiveData<String>()
    val CharacterGuildName: LiveData<String> get() = _CharacterGuildName

    private val _CharacterExpRate = MutableLiveData<String>()
    val CharacterExpRate: LiveData<String> get() = _CharacterExpRate

    private val _searchInput = MutableLiveData<String>()
    val searchInput: LiveData<String>
        get() = _searchInput

    private val _EquipmentList = MutableLiveData<List<Equipment.ItemEquipment?>>() // 장비 데이터
    val EquipmentList: LiveData<List<Equipment.ItemEquipment?>>
        get() = _EquipmentList

    private val _userData = MutableLiveData<MapleData>()
    val userData: LiveData<MapleData> get() = _userData


    // 초기값 설정
    init {
        Log.d(TAG, "SecondFragmentViewModel - 생성자 호출")
        _EquipmentList.value = emptyList()
        testApikey = "${BuildConfig.nexon_api_key}"

        if (now.toLocalTime().isAfter(SecondFragmentViewModel.startTime) && now.toLocalTime()
                .isBefore(
                    SecondFragmentViewModel.endTime
                )
        ) {
            Log.d("TimeCheck", "현재 시간은 00시~04시 사이입니다(넥슨 홈페이지 업데이트 이전).")
            yesterday = currentDate.minusDays(2)
            Log.d("TimeCheck", "yesterday: ${yesterday}")
        } else {
            yesterday = currentDate.minusDays(1)
            Log.d("TimeCheck", "현재 시간은 04시 이후입니다(업데이트 후).")
            Log.d("TimeCheck", "yesterday: ${yesterday}")
        }
    }


    fun setUserInput(mapleNickName: String) {
        _searchInput.value = mapleNickName
    }

    fun apiRequest(mapleNickName: String) {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiservicemaple: ApiServiceMaple = retrofit.create(ApiServiceMaple::class.java)

        val mapleCall: Call<MapleData> = apiservicemaple.getocid(
            testApikey,
            mapleNickName,
        )

        mapleCall.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {

                val mapleInfo = response.body()

                getocid = mapleInfo?.ocid.toString()
                Log.d("testApikey", "testApikey = ${testApikey} ")
                val characterCall = apiservicemaple.getCharacter(
                    testApikey,
                    "${getocid}",
                    "$yesterday"
                )
                var UnionCall = apiservicemaple.getUnion(
                    testApikey, "${getocid}", "${yesterday}"
                )
                var equipmentCall = apiservicemaple.getEquipment(
                    testApikey, "${getocid}", "${yesterday}"
                )
                if (getocid != null) {

                    characterCall.enqueue(object : Callback<MapleData> {
                        override fun onResponse(
                            call: Call<MapleData>,
                            response: Response<MapleData>
                        ) {
                            handleApiResponse(response)
                        }

                        override fun onFailure(call: Call<MapleData>, t: Throwable) {

                            call.cancel()
                        }
                    })
                    equipmentCall.enqueue(object : Callback<Equipment> {
                        override fun onResponse(
                            call: Call<Equipment>,
                            response: Response<Equipment>
                        ) {
                            handleEquipmentResponse(response)

                        }

                        override fun onFailure(call: Call<Equipment>, t: Throwable) {
                            call.cancel()
                        }
                    })
                }
            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                call.cancel()
            }
        })
    }

    private fun handleApiResponse(response: Response<MapleData>) {
        if (response.isSuccessful) {
            val data = response.body()

            _userData.value = data!! // LiveData 업데이트

            // 나머지 UI 데이터도 LiveData로 업데이트
            _CharacterImage.value = "${data?.characterImage}"
            _CharacterLevel.value = "레벨:${data?.characterLevel}"
            _WorldName.value = "서버:${data?.worldName}"
            _CharacterName.value = "닉네임:${data?.characterName}"
            _CharacterGuildName.value = "길드명:${data?.characterGuildName}"
            _CharacterExpRate.value = "경험치:${data?.characterExpRate}%"
        } else {
            // 실패 처리
            Log.e(TAG, "API 호출 실패: ${response.code()}")
        }
    }

    // 기존 데이터 업데이트 메서드
    private fun handleEquipmentResponse(response: Response<Equipment>) {
        if (response.isSuccessful) {
            val data = response.body()?.itemEquipment

            // 문자열 긴거 찾기용 로그
            Log.d("장비", "${data?.joinToString("\n") { it?.itemName ?: "null" }}")
            Log.d("장비","에디등급:${data?.joinToString("\n") { it?.potentialOptionGrade ?: "null" }}")
            Log.d("등급", "에디등급: ${data?.map { it?.additionalPotentialOptionGrade }}")
            Log.d("등급", "윗잠등급: ${data?.map { it?.potentialOptionGrade }}")
            Log.d("추옵", "윗잡등급: ${data?.map { it?.itemAddOption }}")
//            Log.d("추옵", "윗잡등급: ${data?.joinToString("\n") { it?.itemAddOption ?: "null" }}")
            Log.d("윗잠","윗잠1번옵션:${data?.map { it?.potentialOption1 }}")
            Log.d("윗잠","윗잠2번옵션:${data?.map { it?.potentialOption3 }}")
            Log.d("윗잠","윗잠3번옵션:${data?.map { it?.potentialOption3 }}")


            Log.d("잠재","에디1번옵션:${data?.map { it?.additionalPotentialOption1 }}")
            Log.d("잠재","에디2번옵션:${data?.map { it?.additionalPotentialOption2 }}")
            Log.d("잠재","에디3번옵션:${data?.map { it?.additionalPotentialOption3 }}")


            if (!data.isNullOrEmpty()) {

                addDataItem(data)
            }
        }
    }

    fun addDataItem(newItem: List<Equipment.ItemEquipment?>) {

            _EquipmentList.value = newItem
    }
}