package com.android.maplemate.UI.cody

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.maplemate.BuildConfig
import com.android.maplemate.Data.MapleData
import com.android.maplemate.Data.RetrofitModule
import com.android.maplemate.UI.SecondFragment
import com.android.maplemate.databinding.FragmentCodyBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CodyFragment : Fragment() {

    private var _binding: FragmentCodyBinding? = null
    private val binding get() = _binding!!

    private lateinit var secondFragment: SecondFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCodyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initView() {

    }

    private fun initViewModel() = binding.apply {

        secondFragment = SecondFragment()

        btnCodySearch.setOnClickListener {
            Log.d("btnCodySearch", edtCodyName.text.toString())

            val nickName = edtCodyName.text.trim().toString()

            if (nickName.isNotBlank()) {
                getNickName(nickName)
                Log.d("btnCodySearchgogo", edtCodyName.text.toString())

            } else {
                Toast.makeText(context, "캐릭터 명을 확인해 주세요", Toast.LENGTH_SHORT).show()
                Log.d("btnCodySearchnono", edtCodyName.text.toString())

            }
        }
    }

    private fun getNickName(nickName: String) {
        val service = RetrofitModule.createMapleApiService()
        val call: Call<MapleData> = service.getocid(
            apiKey = BuildConfig.nexon_api_key, charactername = nickName
        )

        call.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        showFullDialog(response.body()?.ocid.toString())
                        Log.d(
                            "responseOcid", response.body()?.ocid.toString()
                        )
                    }
                } else {
                    Log.d("responseError", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {
                Log.d("responseFail", t.toString())
            }
        })
    }

    fun showFullDialog(ocid: String) {
//        hideOrShowBottomNavigationView(requireContext(), false)
        val childFragment = CodyDetailFragment()
        val args = Bundle()
        args.putString("ocid", ocid)
        childFragment.arguments = args
        childFragment.show(parentFragmentManager, "CodyDetailFragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}