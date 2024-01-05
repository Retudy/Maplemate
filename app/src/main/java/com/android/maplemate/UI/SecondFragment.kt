package com.android.maplemate.UI

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import coil.load
import com.android.maplemate.BuildConfig
import com.android.maplemate.Data.MapleData
import com.android.maplemate.Service.ApiServiceMaple
import com.android.maplemate.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class SecondFragment : Fragment() {

    companion object {
        fun newInstance(): SecondFragment = SecondFragment()
    }

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var testApikey: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        testApikey = "${BuildConfig.nexon_api_key}"

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


        binding.btnNo.setOnClickListener {
            binding.apply {
                boxSearch.isVisible = true
                blancYesOrNo.isVisible = false
            }
            binding.btnSearch.setOnClickListener {
                binding.apply {
                    boxSearch.isVisible = false
                    boxResult.isVisible = true
                }
                lifecycleScope.launch {
                    apiRequest()
                }
            }

        }
        binding.btnYes.setOnClickListener {
            binding.apply {
                binding.boxResult.isVisible = true
                binding.blancYesOrNo.isVisible = false
            }
            lifecycleScope.launch {
                blancRequest()
            }
        }
        binding.ivBackButton.setOnClickListener {
            binding.apply {
                boxResult.isVisible = false
                boxSearch.isVisible = true
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun apiRequest() {

        //1.Retrofit 객체 초기화입
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //2. service 객체 생성
        val apiservicemaple: ApiServiceMaple = retrofit.create(ApiServiceMaple::class.java)

        //3. Call객체 생성
        val mapleNickName = binding.searchView.text.toString()
        Log.d("getNickName", "${mapleNickName}")
        val mapleCall = apiservicemaple.getocid(
            testApikey,
            mapleNickName,
        )

        //4. 네트워크 통신
        mapleCall.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {

                val mapleInfo = response.body()

                //입력받은 캐릭터명은 식별자를 얻음과 동시에 저장하는(SharedPreferences)로직 추가.
                //입력받은캐릭터명 = ocid(식별자) 형태로 저장,불러옴
                //1.입력받은캐릭명(mapleNickName)이 Sharedprefereces에 존재하지않으면 ocid(식별자)를 조회하고 getocid(testApikey,mapleNickName) ->저장로직추가 > character(testApikey,mapleNickName,date)
                //2.입력받은캐릭명(mapleNickName)이 Sharedprefereces에 존재(!=null)하면 캐릭명과 일치하는 ocid를  찾아 변수 srefgetocid 에 담고, character(testApikey,srefgetocid,date) 를받아 쿼리에 넣어 요청.

                if (mapleInfo != null) {
                    var getOcid = "${mapleInfo.ocid}"
                    Log.d("getOcid", "${getOcid}")
                    //캐릭터 정보 조회 요청 로직을 characterCall에 담음
                    val characterCall = apiservicemaple.getCharacter(
                        testApikey,
                        "${getOcid}",
                        "2023-12-30"
                    )
                    if (getOcid != null) {
                        Log.d("characterCall 시작직전", "${getOcid}")

                        characterCall.enqueue(object : Callback<MapleData> {
                            override fun onResponse(
                                call: Call<MapleData>,
                                response: Response<MapleData>
                            ) {

                                val mapleInfo2 = response.body()
                                Log.d("mapleInfo2test", "mapleInfo2: ${mapleInfo2}")

                                if (mapleInfo2 != null) {

                                    Log.d("mapleInfo2success", "mapleInfo2: ${mapleInfo2}")
                                    binding.apply {
                                        binding.ivCharacterImage.load(mapleInfo2.characterImage)
                                        tvCharacterLevel.text = "Lv:${mapleInfo2.characterLevel}"
                                        tvWorldName.text = "서버: ${mapleInfo2.worldName}"
                                        tvCharacterName.text = "닉네임: ${mapleInfo2.characterName}"
                                        tvCharacterGuildName.text =
                                            "길드: ${mapleInfo2.characterGuildName}"
                                        tvCharacterExpRate.text =
                                            "경험치: ${mapleInfo2.characterExpRate}%"
                                    }


                                } else {

                                    Log.d("mapleInfo2", "mapleInfo2: ${mapleInfo2}")
                                }
                            }

                            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                                Log.e("Debug", "API Request Failed", t)
                                call.cancel()
                            }

                        })
                    }


                } else {

                    Log.e("Fuxxk", "mapleInfo: ${mapleInfo}")
                    Log.d("Fuxxk", "response: ${response}")
                }

            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                Log.e("Debug", "API Request Failed", t)
                call.cancel()
            }

        })

    }

    private fun blancRequest() {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiservicemaple: ApiServiceMaple = retrofit.create(ApiServiceMaple::class.java)


        val mapleNickName = binding.searchView.text.toString()
        var mapleCall = apiservicemaple.getocid(
            testApikey,
            "블랑",
        )
        binding.ivBackButton.setOnClickListener {
            binding.apply {
                boxResult.isVisible = false
                boxSearch.isVisible = true
            }
            binding.btnSearch.setOnClickListener {
                mapleCall = apiservicemaple.getocid(testApikey, mapleNickName)
            }
        }

        mapleCall.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {

                val mapleInfo = response.body()

                if (mapleInfo != null) {
                    var getOcid = "${mapleInfo.ocid}"
                    Log.d("getocid", "${getOcid}")

                    val charaterCall = apiservicemaple.getCharacter(
                        testApikey,
                        "${getOcid}",
                        "2023-12-30"
                    )
                    if (getOcid != null) {
                        Log.d("characterCall 시작직전", "${getOcid}")

                        charaterCall.enqueue(object : Callback<MapleData> {
                            override fun onResponse(
                                call: Call<MapleData>,
                                response: Response<MapleData>
                            ) {

                                val mapleInfo2 = response.body()
                                Log.d("mapleInfo2test", "mapleInfo2: ${mapleInfo2}")

                                if (mapleInfo2 != null) {

                                    Log.d("mapleInfo2success", "mapleInfo2: ${mapleInfo2}")
                                    binding.apply {

                                        ivCharacterImage.load(mapleInfo2.characterImage)
                                        tvCharacterLevel.text = "Lv:${mapleInfo2.characterLevel}"
                                        tvWorldName.text = "서버:${mapleInfo2.worldName}"
                                        tvCharacterName.text = "닉네임:${mapleInfo2.characterName}"
                                        tvCharacterGuildName.text = "길드:${mapleInfo2.characterGuildName}"
                                        tvCharacterExpRate.text = "경험치:${mapleInfo2.characterExpRate}%"

                                    }


                                } else {

                                    Log.d("mapleInfo2", "mapleInfo2: ${mapleInfo2}")
                                }
                            }

                            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                                Log.e("Debug", "API Request Failed", t)
                                call.cancel()
                            }

                        })
                    }


                } else {

                    Log.e("Fuxxk", "mapleInfo: ${mapleInfo}")
                    Log.d("Howtypelog", "etInputUserName: ${binding.searchView}")
                    Log.d("Fuxxk", "response: ${response}")
                }

            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                Log.e("Debug", "API Request Failed", t)
                call.cancel()
            }

        })

    }


    private fun apiRequest2() {

        //1.Retrofit 객체 초기화입
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //2. service 객체 생성
        val apiservicemaple: ApiServiceMaple = retrofit.create(ApiServiceMaple::class.java)

        //3. Call객체 생성
        val mapleNickName = binding.searchView.text.toString()
        Log.d("getNickName", "${mapleNickName}")
        val mapleCall = apiservicemaple.getocid(
            testApikey,
            mapleNickName,
        )

        //4. 네트워크 통신
        mapleCall.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {

                val mapleInfo = response.body()

                //입력받은 캐릭터명은 식별자를 얻음과 동시에 저장하는(SharedPreferences)로직 추가.
                //입력받은캐릭터명 = ocid(식별자) 형태로 저장,불러옴
                //1.입력받은캐릭명(mapleNickName)이 Sharedprefereces에 존재하지않으면 ocid(식별자)를 조회하고 getocid(testApikey,mapleNickName) ->저장로직추가 > character(testApikey,mapleNickName,date)
                //2.입력받은캐릭명(mapleNickName)이 Sharedprefereces에 존재(!=null)하면 캐릭명과 일치하는 ocid를  찾아 변수 srefgetocid 에 담고, character(testApikey,srefgetocid,date) 를받아 쿼리에 넣어 요청.

                if (mapleInfo != null) {
                    var getOcid = "${mapleInfo.ocid}"
                    Log.d("getOcid", "${getOcid}")
                    //캐릭터 정보 조회 요청 로직을 characterCall에 담음
                    val characterCall = apiservicemaple.getCharacter(
                        testApikey,
                        "${getOcid}",
                        "2023-12-30"
                    )
                    if (getOcid != null) {
                        Log.d("characterCall 시작직전", "${getOcid}")

                        characterCall.enqueue(object : Callback<MapleData> {
                            override fun onResponse(
                                call: Call<MapleData>,
                                response: Response<MapleData>
                            ) {

                                val mapleInfo2 = response.body()
                                Log.d("mapleInfo2test", "mapleInfo2: ${mapleInfo2}")

                                if (mapleInfo2 != null) {

                                    Log.d("mapleInfo2success", "mapleInfo2: ${mapleInfo2}")
                                    binding.apply {
                                        binding.ivCharacterImage.load(mapleInfo2.characterImage)
                                        tvCharacterLevel.text = "Lv:${mapleInfo2.characterLevel}"
                                        tvWorldName.text = "서버: ${mapleInfo2.worldName}"
                                        tvCharacterName.text = "닉네임: ${mapleInfo2.characterName}"
                                        tvCharacterGuildName.text = "길드: ${mapleInfo2.characterGuildName}"
                                        tvCharacterExpRate.text = "경험치: ${mapleInfo2.characterExpRate}%"
                                    }


                                } else {

                                    Log.d("mapleInfo2", "mapleInfo2: ${mapleInfo2}")
                                }
                            }

                            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                                Log.e("Debug", "API Request Failed", t)
                                call.cancel()
                            }

                        })
                    }


                } else {

                    Log.e("Fuxxk", "mapleInfo: ${mapleInfo}")
                    Log.d("Fuxxk", "response: ${response}")
                }

            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                Log.e("Debug", "API Request Failed", t)
                call.cancel()
            }

        })

    }
}
