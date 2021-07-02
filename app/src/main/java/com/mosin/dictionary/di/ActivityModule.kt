package com.mosin.dictionary.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.mosin.dictionary.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
