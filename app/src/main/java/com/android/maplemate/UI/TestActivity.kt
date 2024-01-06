package com.android.maplemate.UI

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.android.maplemate.databinding.ActivityTestBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.IOException


class TestActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTestBinding.inflate(layoutInflater) }

    //datastore 객체를 불러옴
    private val Context.dataStore:
            DataStore<Preferences> by preferencesDataStore( name = "Ocid" )

    private lateinit var stringKey:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)


        binding.btnsave.setOnClickListener {
            //저장되는 함수
            val input = binding.etInputName.text.toString()
            if (input.isNotBlank()) {
                stringKey = input
                lifecycleScope.launch {
                    save(input)
                }
            } else {
                Toast.makeText(this@TestActivity, "입력값이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnLoad.setOnClickListener {
            //불러오는 함수
            val input = binding.etInputName.text.toString()
            lifecycleScope.launch {
                // 데이터 불러오기
                load(input)
                val loadedValue = load(input).first()

                binding.tvTest.text = loadedValue
            }


        }
    }

    private suspend fun save(value: String): String {
        val key = stringPreferencesKey(stringKey) // 여기서 stringkey를 사용
        val valueToSave = "${key}로 부터 추출된 ocid "
        dataStore.edit {
            it[key] = valueToSave
        }
        return valueToSave
    }

    private suspend fun load(inputUserName: String): Flow<String> {
        return dataStore.data
            .catch { e ->
                if (e is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw e
                }
            }
            .map { preferences ->
                val loadedValue = preferences[stringPreferencesKey(inputUserName)] ?: "기본 텍스트입니다."
                loadedValue
            }
    }

}
