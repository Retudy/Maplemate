package com.android.maplemate.ViewModel

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.maplemate.Repository.SecondFragmentRepository

//class SecondFragmentViewModelFactory(private val dataStore: DataStore<Preferences>, private val repository: SecondFragmentRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(SecondFragmentViewModel::class.java)) {
//            return SecondFragmentViewModel(dataStore, repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}