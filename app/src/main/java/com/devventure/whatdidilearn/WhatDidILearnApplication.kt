package com.devventure.whatdidilearn

import android.app.Application
import com.devventure.whatdidilearn.DI.LearnedItemModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class WhatDidILearnApplication: Application() {
    /*val database by lazy {
        LearnedItemDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO))
    }
    val repository by lazy {
        LearnedItemRepository(database.learnedItemDao())
    }*/

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WhatDidILearnApplication)
            modules(LearnedItemModule.module)
        }
    }
}