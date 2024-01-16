package com.android.maplemate.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.maplemate.R
import com.android.maplemate.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnResult.setOnClickListener {
            result()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun result() {

        val a = binding.etInputFuelEfficiency.text.toString().toIntOrNull()
        val b = binding.etInputOilPrice.text.toString().toIntOrNull()
        val c = binding.etInputDistance.text.toString().toIntOrNull()

        if (a != null && b != null && c != null) {

            val result = b / a
            val expend = result * c

            binding.tvResult.text = "km/${result}원 목적지까지 총:${expend}원"

            when {
              result <= 0 -> Toast.makeText(context, "연비와 기름값을 제대로 입력해주세요", Toast.LENGTH_SHORT).show()
            }

        }
    }
}