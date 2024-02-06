package com.android.maplemate.UI

import android.os.Bundle
import android.os.Handler
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
import com.android.maplemate.ItemSpacingDecoration
import com.android.maplemate.R
import com.android.maplemate.ViewModel.SecondFragmentViewModel
import com.android.maplemate.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    companion object {
        fun newInstance(): SecondFragment = SecondFragment()
    }

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SecondFragmentViewModel by viewModels()
    private val dataList = mutableListOf<Equipment.ItemEquipment?>()
    private val adapter by lazy { SecondFragmentAdapter(requireContext(),dataList) }

    private lateinit var mapleNickName: String


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

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing) //리싸이클러뷰 간격 설정

        binding.rvEqupipment.addItemDecoration(ItemSpacingDecoration(spacingInPixels))
        observeViewModel()





        binding.btnSearch.setOnClickListener {

            mapleNickName = binding.searchView.text.trim().replace(Regex(" "), "")
            viewModel.setUserInput(mapleNickName)

            if (mapleNickName.isNotBlank()) {

                binding.apply {
                    binding.boxSearch.isVisible = false
                    binding.boxResult.isVisible = true
                }

                viewModel.apiRequest(mapleNickName)

            } else {
                Toast.makeText(requireContext(), "캐릭터명을 입력해주세요", Toast.LENGTH_SHORT).show()
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

    private fun observeViewModel() {
        viewModel.userData.observe(viewLifecycleOwner) { newDataList ->
            // 새로운 데이터 리스트로 UI 업데이트
            updateUI(newDataList)

        }
        viewModel.EquipmentList.observe(viewLifecycleOwner) { newDataList ->
            // 리싸이클러뷰 데이터 업데이트
            Handler().postDelayed({
                adapter.submitList(newDataList)
            }, 500) // 1000밀리초(1초)의 딜레이


        }
    }

    private fun updateUI(userData: MapleData?) {

        userData.let {
            binding.ivCharacterImage.load(it?.characterImage)
            binding.tvCharacterLevel.text = "레벨: ${it?.characterLevel}"
            binding.tvWorldName.text = "서버: ${it?.worldName}"
            binding.tvCharacterName.text = "닉네임: ${it?.characterName}"
            binding.tvCharacterGuildName.text = "길드명: ${it?.characterGuildName}"
            binding.tvCharacterExpRate.text = "경험치: ${it?.characterExpRate}%"

        }
    }

}