package com.android.maplemate.UI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.maplemate.Data.Equipment
import okhttp3.internal.notifyAll

enum class ActionType {
    Search,
}

class SecondFragmentViewModel : ViewModel() {
    companion object {
        private const val TAG = "SecondFragmentViewModel"
    }

    private val _dataList = MutableLiveData<List<Equipment.ItemEquipment>>()
    val dataList: LiveData<List<Equipment.ItemEquipment>>
        get() = _dataList

    // 초기값 설정
    init {
        Log.d(TAG, "SecondFragmentViewModel - 생성자 호출")
        _dataList.value = emptyList()
    }

    fun updateValue(actionType: ActionType, newDataList: List<Equipment.ItemEquipment>? = null) {
        when (actionType) {
            ActionType.Search -> {
                newDataList?.let {
                    _dataList.value = it
                }
            }
        }
    }
    fun updateDataList(newDataList: List<Equipment.ItemEquipment>) {
        _dataList.value = newDataList
    }
}
