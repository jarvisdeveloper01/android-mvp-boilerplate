package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class CompositeDisposableModule {
    @Provides
    @ActivityScope
    fun providesCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}