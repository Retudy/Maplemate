package com.android.maplemate.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.maplemate.Adapter.SecondFragmentAdapter
import com.android.maplemate.databinding.ActivityTestBinding


class TestActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTestBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        val dataList = mutableListOf<String>()

        dataList.add("하이네스 어새신 보닛")
        dataList.add("하이넷 던위치팬츠")
        dataList.add("하이네스 던위치 햇")

    }
}