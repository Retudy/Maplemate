package com.android.maplemate.UI

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.IOException


class TestActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTestBinding.inflate(layoutInflater) }

    //datastore 객체를 불러옴
    private val Context.dataStore:
            DataStore<Preferences> by preferencesDataStore(name = "settings")
    private val stringKey = "key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        binding.btnsave.setOnClickListener {
            //저장되는 함수
            val input = binding.etInputName.text.toString()

            lifecycleScope.launch { save(input) }
            Toast.makeText(this, "입력받은 텍스트:${input}가 정상적으로 저장되었습니다.", Toast.LENGTH_SHORT).show()
        }
        binding.btnLoad.setOnClickListener {
            //불러오는 함수
            val input = binding.etInputName.text.toString()
            lifecycleScope.launch {
                // 데이터 불러오기
                val loadedValue = load(input).first()

                if (loadedValue.isNotEmpty()) {
                    // 값이 존재하면 해당 값을 사용
                    Toast.makeText(
                        this@TestActivity,
                        "불러온 내용은: $loadedValue 입니다",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // 값이 없을 경우 예외 처리
                    Toast.makeText(
                        this@TestActivity,
                        "입력받은 텍스트의 정보가 없어 불러올 수 없습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


        }
    }

    private suspend fun save(value: String) {
        val key = stringPreferencesKey(stringKey)
        val currentValues = loadAllValues().toMutableSet()
        currentValues.add(value)
        dataStore.edit {
            it[key] = currentValues.joinToString(",")
        }
    }

    private suspend fun loadAllValues(): Flow<Set<String>> {
        val key = stringPreferencesKey(stringKey)
        return dataStore.data
            .catch { e ->
                if (e is IOException) {
                    emit(emptySet())
                } else {
                    throw e
                }
            }
            .map { preferences ->
                preferences[key]?.split(",")?.toSet() ?: emptySet()
            }
    }

    private suspend fun load(value: String): Flow<String> {
        return loadAllValues()
            .map { savedValues ->
                val matchingValues = savedValues.filter { it == value }
                if (matchingValues.isNotEmpty()) {
                    matchingValues.joinToString(", ")
                } else {
                    "입력받은 텍스트의 정보가 없어 불러와지지 않습니다."
                }
            }
    }


}
