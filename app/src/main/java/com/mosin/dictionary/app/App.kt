package com.mosin.dictionary.app

import android.app.Application
import com.mosin.dictionary.di.application
import com.mosin.dictionary.di.historyScreen
import com.mosin.dictionary.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}