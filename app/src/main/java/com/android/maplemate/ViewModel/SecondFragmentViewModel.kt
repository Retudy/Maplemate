package com.android.maplemate.ViewModel

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import com.android.maplemate.Repository.SecondFragmentRepository
import com.android.maplemate.UI.SecondFragment

class SecondFragmentViewModel(
    private val dataStore: DataStore<Preferences>,
    private val repository: SecondFragmentRepository
):ViewModel() {
}