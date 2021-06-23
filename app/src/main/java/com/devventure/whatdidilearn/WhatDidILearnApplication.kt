package com.devventure.whatdidilearn

import android.app.Application
import com.devventure.whatdidilearn.data.LearnedItemDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class WhatDidILearnApplication : Application() {
    val database by lazy {
        LearnedItemDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO))
    }
}