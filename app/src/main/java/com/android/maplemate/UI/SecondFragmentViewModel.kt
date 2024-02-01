package com.android.maplemate.UI

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import coil.load
import com.android.maplemate.BuildConfig
import com.android.maplemate.Data.Equipment
import com.android.maplemate.Data.MapleData
import com.android.maplemate.Service.ApiServiceMaple
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


class SecondFragmentViewModel : ViewModel() {
    companion object {
        private const val TAG = "SecondFragmentViewModel"
            private val startTime: LocalTime = LocalTime.of(0, 0)
            private val endTime: LocalTime = LocalTime.of(4, 0)
        private val currentDate: LocalDate = LocalDate.now()
        private var yesterday = currentDate.minusDays(1)  // yesterday 의값은 oncreate 에서 조건에 따라 변하므로 var로 선언
        private val now: LocalDateTime = LocalDateTime.now()
        private val Context.preferenceDataStore: DataStore<Preferences> by preferencesDataStore(name = "getOcid")
        private lateinit var testApikey:String

    }
    private lateinit var mapleNickName:String
    private val _searchInput = MutableLiveData<String>()
    val searchInput: LiveData<String>
        get() = _searchInput

    private val _dataList = MutableLiveData<List<Equipment.ItemEquipment>>()
    val dataList: LiveData<List<Equipment.ItemEquipment>>
        get() = _dataList


    // 초기값 설정
    init {
        Log.d(TAG, "SecondFragmentViewModel - 생성자 호출")
        _dataList.value = emptyList()
        testApikey = "${BuildConfig.nexon_api_key}"
    }

    fun updateDataList(newDataList: List<Equipment.ItemEquipment>) {
        _dataList.value = newDataList
    }
    fun setUserInput(mapleNickName: String){
        _searchInput.value = mapleNickName
    }
}
