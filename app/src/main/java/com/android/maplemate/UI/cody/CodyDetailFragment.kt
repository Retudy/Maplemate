package com.android.maplemate.UI.cody

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import coil.load
import com.android.maplemate.BuildConfig
import com.android.maplemate.Data.Cash
import com.android.maplemate.Data.MapleData
import com.android.maplemate.Data.RetrofitModule
import com.android.maplemate.databinding.FragmentCodyDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

class CodyDetailFragment : DialogFragment() {
    private var _binding: FragmentCodyDetailBinding? = null
    private val binding: FragmentCodyDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCodyDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ocid = arguments?.getString("ocid")
        Log.d("codyDetailOcid", ocid.toString())

        if (ocid != null) {
            getCodyData(ocid)
            getProfileImage(ocid)
        }

        initView()

    }

    private fun initView() {
        binding.imgCodyBack.setOnClickListener {
            dismiss()
        }
    }

    private fun initViewModel() {

    }


    private fun getCodyData(ocid: String) {
        val service = RetrofitModule.createMapleApiService()
        val call: Call<Cash> = service.getCashItem(
            apiKey = BuildConfig.nexon_api_key, ocid = ocid, date = "2024-02-01"
        )

        call.enqueue(object : Callback<Cash> {

            override fun onResponse(call: Call<Cash>, response: Response<Cash>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val iconUrl = responseBody?.cashItemEquipmentPreset2?.firstOrNull()?.cashItemIcon
                    if (!iconUrl.isNullOrEmpty()) {
                        Log.d("test12345", iconUrl)
                    }
                } else {
                    Log.d("responseError", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<Cash>, t: Throwable) {
                Log.d("responseError", t.toString())

            }
        })
    }

    private fun getProfileImage(ocid: String) {
        val service = RetrofitModule.createMapleApiService()
        val call: Call<MapleData> = service.getCharacter(
            apiKey = BuildConfig.nexon_api_key, ocid = ocid, date = LocalDate.now().minusDays(1).toString()
        )
        call.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val avatar = responseBody?.characterImage
                    if (!avatar.isNullOrEmpty()) {
                        binding.imgCodyMainAvatar.load(avatar)
                        Log.d("test12345", avatar)
                    }
                }
            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        Util.hideOrShowBottomNavigationView(requireContext(), true)
        _binding = null
    }

}