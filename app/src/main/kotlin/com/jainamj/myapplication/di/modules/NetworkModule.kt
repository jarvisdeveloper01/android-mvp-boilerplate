package com.jainamj.myapplication.di.modules

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jainamj.myapplication.BuildConfig
import com.jainamj.myapplication.data.api.GitService
import com.jainamj.myapplication.data.api.LiveExamsService
import com.jainamj.myapplication.di.qualifiers.AppContext
import com.jainamj.myapplication.di.qualifiers.GitRetrofit
import com.jainamj.myapplication.di.qualifiers.LiveExamsRetrofit
import com.jainamj.myapplication.di.scopes.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [AppContextModule::class])
class NetworkModule {

    @Provides
    @AppScope
    fun httpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @AppScope
    fun stethoInterceptor(): StethoInterceptor = StethoInterceptor()

    @Provides
    @AppScope
    fun httpCache(@AppContext context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024    // 10 MB cache
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @AppScope
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        return gsonBuilder.create()
    }


    @Provides
    @AppScope
    fun okhttpClient(cache: Cache,
                     httpLoggingInterceptor: HttpLoggingInterceptor,
                     stethoInterceptor: StethoInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .addNetworkInterceptor(stethoInterceptor)
                    .cache(cache).build()


    @Provides
    @AppScope
    @GitRetrofit
    fun gitRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BuildConfig.GIT_API_BASE_URL)
            .build()

    @Provides
    @AppScope
    @LiveExamsRetrofit
    fun liveExamsRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BuildConfig.LIVE_EXAMS_API_BASE_URL)
            .build()

    @Provides
    @AppScope
    fun gitApiInterface(@GitRetrofit retrofit: Retrofit): GitService =
            retrofit.create<GitService>(GitService::class.java)

    @Provides
    @AppScope
    fun liveExamsApiInterface(@LiveExamsRetrofit retrofit: Retrofit): LiveExamsService =
            retrofit.create<LiveExamsService>(LiveExamsService::class.java)

}