package com.jainamj.myapplication.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class CompositeDisposableModule {
    @Provides
    @Singleton
    fun providesCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}