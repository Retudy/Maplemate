package com.android.maplemate.UI

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import coil.load
import com.android.maplemate.BuildConfig
import com.android.maplemate.Data.MapleData
import com.android.maplemate.Service.ApiServiceMaple
import com.android.maplemate.databinding.FragmentSecondBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.time.LocalDate


class SecondFragment : Fragment() {
    companion object {
        fun newInstance(): SecondFragment = SecondFragment()
    }

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var testApikey: String
    private lateinit var mapleNickName: String
    private lateinit var getocid:String
    private val currentDate: LocalDate = LocalDate.now()
    private val yesterday = currentDate.minusDays(1)
    private val Context.preferenceDataStore: DataStore<Preferences> by preferencesDataStore(name = "getOcid")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testApikey = "${BuildConfig.nexon_api_key}"
        mapleNickName = ""
        getocid = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {
             mapleNickName = binding.searchView.text.toString()

            if (mapleNickName.isNotBlank()){
                binding.apply {
                    binding.boxSearch.isVisible = false
                    binding.boxResult.isVisible = true
                }
                lifecycleScope.launch {
                    apiRequest(mapleNickName)
                }
            }
            else{
                Toast.makeText(requireContext(), "입력값이없어 UI가 변경되지 않음", Toast.LENGTH_SHORT).show()
                Log.d("nexon","입력값이없어 UI가 변경되지 않음")
            }
        }
        binding.ivBackButton.setOnClickListener {
            binding.apply {
                boxResult.isVisible = false
                boxSearch.isVisible = true
            }
        }
        binding.ivBackgroundImage.setOnClickListener {
            lifecycleScope.launch {
                delete()
            }
            Log.d("nexon","dataStore 를 비웠습니다.")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    private fun apiRequest(mapleNickName:String) {
    Log.d("nexon","$yesterday")
        //1.Retrofit 객체 초기화
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //2. service 객체 생성
        val apiservicemaple: ApiServiceMaple = retrofit.create(ApiServiceMaple::class.java)

        //3. Call객체 생성
        val mapleCall: Call<MapleData> = apiservicemaple.getocid(
            testApikey,
            mapleNickName,
        )
        // 입력을받고, dataStore에 키값이 있는지 검증
        lifecycleScope.launch {
            val key = stringPreferencesKey(mapleNickName)
            val dataStore = requireContext().preferenceDataStore
            //Flow를 수집하여 데이터를 얻음
            val preferences = dataStore.data.first()
            val storedValue = preferences[key] ?: ""

            if ( storedValue != "" ) {
                Log.d("nexon","데이터를 로드하여 호출량 Count:-2 (장비/유니온/)")
                Log.d("nexon","입력받은닉네임:${mapleNickName}")

                lifecycleScope.launch {

                    val loadedValue = load(mapleNickName).first()  //Flow에서 쿼리 = key 로 조회한 value값 추출
                    // 저장된값이 없을때 ( load() 함수를 보시면 string 값으로 value값을 저장해 "" 을 기본값으로 하였습니다.
                    if (loadedValue != ""){
                        var UnionCall = apiservicemaple.getUnion(
                            testApikey,loadedValue,"${yesterday}"
                        )
                        var characterCall = apiservicemaple.getCharacter(
                            testApikey,loadedValue,"${yesterday}"
                        )
                        var equipmentCall = apiservicemaple.getEquipment(
                            testApikey,loadedValue,"${yesterday}"
                        )

                        characterCall.enqueue(object  : Callback<MapleData>{
                            override fun onResponse(
                                call: Call<MapleData>,
                                response: Response<MapleData>
                            ) {
                                val data = response.body()

                                binding.ivCharacterImage.load(data?.characterImage)
                                binding.tvCharacterLevel.text = "레벨:${data?.characterLevel}"
                                binding.tvWorldName.text = "서버:${data?.worldName}"
                                binding.tvCharacterName.text = "닉네임:${data?.characterName}"
                                binding.tvCharacterGuildName.text = "길드명:${data?.characterGuildName}"
                                binding.tvCharacterExpRate.text = "경험치:${data?.characterExpRate}%"
                            }

                            override fun onFailure(call: Call<MapleData>, t: Throwable) {
                                call.cancel()
                            }
                        })
                        UnionCall.enqueue(object  : Callback<MapleData>{
                            override fun onResponse(
                                call: Call<MapleData>,
                                response: Response<MapleData>
                            ) {
                                val data = response.body()

                                binding.tvUnion.text = "유니온:${data?.unionLevel}"

                            }

                            override fun onFailure(call: Call<MapleData>, t: Throwable) {
                                call.cancel()
                            }
                        })
                    }
                }}
            else{
                Log.d("nexon","저장된 데이터가 없어 호출량 -3 (식벌자/기본정보/유니온")
                //4. 네트워크 통신
                mapleCall.enqueue(object : Callback<MapleData> {
                    override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {

                        val mapleInfo = response.body()

                        getocid = mapleInfo?.ocid.toString()
                        lifecycleScope.launch{ save(mapleNickName) } // mapleCall을 부르게되면 즉시 키값을 저장함

                        val characterCall = apiservicemaple.getCharacter(
                            testApikey,
                            "${getocid}",
                            "$yesterday"
                        )
                        var UnionCall = apiservicemaple.getUnion(
                            testApikey,"${getocid}","${yesterday}"
                        )
                        //getocid 가 null 이 아니면 = getocid가 획득된경우 (이전에 로컬에서 조회한적이 없는경우)
                        if(getocid != null){

                            characterCall.enqueue(object  : Callback<MapleData>{
                                override fun onResponse(
                                    call: Call<MapleData>,
                                    response: Response<MapleData>
                                ) {
                                    val data = response.body()

                                    binding.ivCharacterImage.load(data?.characterImage)
                                    binding.tvCharacterLevel.text = "레벨:${data?.characterLevel}"
                                    binding.tvWorldName.text = "서버:${data?.worldName}"
                                    binding.tvCharacterName.text = "닉네임:${data?.characterName}"
                                    binding.tvCharacterGuildName.text = "길드명:${data?.characterGuildName}"
                                    binding.tvCharacterExpRate.text = "경험치:${data?.characterExpRate}%"
                                }

                                override fun onFailure(call: Call<MapleData>, t: Throwable) {
                                    Log.d("도착","${getocid}")
                                    call.cancel()
                                }
                            })
                            UnionCall.enqueue(object : Callback<MapleData>{
                                override fun onResponse(
                                    call: Call<MapleData>,
                                    response: Response<MapleData>
                                ) {
                                    val data = response.body()
                                    binding.tvUnion.text = "유니온:${data?.unionLevel}"
                                }

                                override fun onFailure(call: Call<MapleData>, t: Throwable) {
                                    TODO("Not yet implemented")
                                }
                            })
                        }
                    }

                    override fun onFailure(call: Call<MapleData>, t: Throwable) {

                        call.cancel()
                    }
                })
            }
        }
    }
    private suspend fun save(value: String): String {
        mapleNickName = binding.searchView.text.toString()
        val key = stringPreferencesKey(mapleNickName)
        val valueToSave = getocid
        val dataStore = requireContext().preferenceDataStore
        dataStore.edit { preferences ->
            preferences[key] = valueToSave
        }
        return valueToSave
    }
    private suspend fun load(inputUserName: String): Flow<String> {
        val key = stringPreferencesKey(inputUserName)
        val dataStore = requireContext().preferenceDataStore
        return dataStore.data
            .catch { e ->
                if (e is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw e
                }
            }
            .map { preferences ->
                val loadedValue = preferences[key] ?: ""
                loadedValue
            }
    }
    private suspend fun delete(){
        val dataStore = requireContext().preferenceDataStore
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
