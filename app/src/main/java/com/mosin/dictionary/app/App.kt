package com.mosin.dictionary.app

import android.app.Application
import com.mosin.dictionary.di.application
import com.mosin.dictionary.di.mainScreen
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}