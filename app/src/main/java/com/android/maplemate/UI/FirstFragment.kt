package com.android.maplemate.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.android.maplemate.Data.BithumData
import com.android.maplemate.Service.ApiServiceBithum
import com.android.maplemate.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FirstFragment : Fragment() {
    companion object {
        fun newInstance(): FirstFragment = FirstFragment()
    }

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchBtn.setOnClickListener {
            //초기화
            binding.resultText.text = ""
            //api 호출
            lifecycleScope.launch { //코루틴스코프로 돌려봄 (1차)
                apiRequest()
            }
        }



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * HTTP api 호출
     * 작성자: 윤동현
     */
    private fun apiRequest() {
        //1.Retrofit 객체 초기화
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.bithumb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //2. service 객체 생성
        val apiService: ApiServiceBithum = retrofit.create(ApiServiceBithum::class.java)

        //3. Call객체 생성
        val coinNm = binding.coinEdit.text.toString().uppercase()// 입력값, 대문자로
        val tickerCall = apiService.getCoinTicker(coinNm, "KRW")

        //4. 네트워크 통신
        tickerCall.enqueue(object : Callback<BithumData> {
            override fun onResponse(call: Call<BithumData>, response: Response<BithumData>) {
                //호출데이터
                val bithumData = response.body()

                binding.resultText.append("status :${bithumData?.status}\n")
                binding.resultText.append("closing_price :${bithumData?.data?.closing_price}\n")
                binding.resultText.append("opening_price :${bithumData?.data?.opening_price}\n")
                binding.resultText.append("max_price :${bithumData?.data?.max_price}\n")
                binding.resultText.append("min_price :${bithumData?.data?.min_price}\n")
            }

            override fun onFailure(call: Call<BithumData>, t: Throwable) {
                //오류 시 발생
                call.cancel()
            }

        })

    }
}