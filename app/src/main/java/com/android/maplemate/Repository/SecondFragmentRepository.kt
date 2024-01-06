package com.android.maplemate.Repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

class SecondFragmentRepository(
    private val dataStore: DataStore<Preferences>
) {
}