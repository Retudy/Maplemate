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
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.android.maplemate.Adapter.SecondFragmentAdapter
import com.android.maplemate.Data.Equipment
import com.android.maplemate.Data.MapleData
import com.android.maplemate.ViewModel.SecondFragmentViewModel
import com.android.maplemate.databinding.FragmentSecondBinding
import java.time.LocalDate
import java.time.LocalDateTime


class SecondFragment : Fragment() {
    companion object {
        fun newInstance(): SecondFragment = SecondFragment()
    }

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SecondFragmentViewModel by viewModels()
    private val dataList = mutableListOf<Equipment.ItemEquipment?>()
    private val adapter by lazy { SecondFragmentAdapter(dataList) }

    private lateinit var mapleNickName: String


    private val currentDate: LocalDate = LocalDate.now()
    private var yesterday =
        currentDate.minusDays(1)  // yesterday 의값은 oncreate 에서 조건에 따라 변하므로 var로 선언y
    private val now: LocalDateTime = LocalDateTime.now()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mapleNickName = ""

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


        binding.rvEqupipment.adapter = adapter  // 리싸이클러뷰 위젯 = adapter (내가만든 어뎁터)
        binding.rvEqupipment.layoutManager = LinearLayoutManager(context) // (레이아웃 매니저 설정)

        viewModel.userData.observe(viewLifecycleOwner) { userData ->
            updateUI(userData)
        }



        binding.btnSearch.setOnClickListener {

            mapleNickName = binding.searchView.text.trim().replace(Regex(" "), "")
            viewModel.setUserInput(mapleNickName)

            if (mapleNickName.isNotBlank()) {
                binding.apply {
                    binding.boxSearch.isVisible = false
                    binding.boxResult.isVisible = true
                }
                // viewmodel에서 api를 호출하도록 수정
                viewModel.apiRequest(mapleNickName)
            } else {
                Toast.makeText(requireContext(), "입력값이없어 UI가 변경되지 않음", Toast.LENGTH_SHORT).show()
                Log.d("nexon", "입력값이없어 UI가 변경되지 않음")
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


    private fun updateUI(userData: MapleData?) {

        userData.let {
            binding.ivCharacterImage.load(it?.characterImage)
            binding.tvCharacterLevel.text = "레벨:${it?.characterLevel}"
            binding.tvWorldName.text = "서버:${it?.worldName}"
            binding.tvCharacterName.text = "닉네임:${it?.characterName}"
            binding.tvCharacterGuildName.text = "길드명:${it?.characterGuildName}"
            binding.tvCharacterExpRate.text = "경험치:${it?.characterExpRate}%"

        }

    }
}
