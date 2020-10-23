package com.jainamj.myapplication.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class CompositeDisposableModule {
    @Provides
    fun providesCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}