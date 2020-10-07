package com.jainamj.myapplication.di.modules

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jainamj.myapplication.AppConstants
import com.jainamj.myapplication.BuildConfig
import com.jainamj.myapplication.base.network.MyAppUnwrapperConverterFactory
import com.jainamj.myapplication.data.api.MyAppService
import com.jainamj.myapplication.data.preference.PrefHelper
import com.jainamj.myapplication.di.qualifiers.MyAppInterceptor
import com.jainamj.myapplication.di.qualifiers.MyAppRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor =
            if (BuildConfig.BUILD_TYPE.equals("release"))
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            else
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    @Provides
    @Singleton
    fun stethoInterceptor(): StethoInterceptor = StethoInterceptor()

    @Provides
    @MyAppInterceptor
    @Singleton
    fun myAppInterceptor(prefHelper: PrefHelper): Interceptor = Interceptor {
        var request = it.request()

        if (request.header("No-Authentication") == null) {
            request = request.newBuilder()
//                    .addHeader("DeviceId", prefHelper.deviceId)
//                    .addHeader("DeviceToken", prefHelper.deviceToken)
//                    .addHeader("AuthenticationToken", prefHelper.authenticationToken)
                    .build()
        }

        request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .build()

        it.proceed(request)
    }

    @Provides
    @Singleton
    fun httpCache(@ApplicationContext context: Context): Cache =
            Cache(context.cacheDir, AppConstants.CACHE_SIZE)

    @Provides
    @Singleton
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        return gsonBuilder.create()
    }


    @Provides
    @Singleton
    fun okhttpClient(cache: Cache,
                     httpLoggingInterceptor: HttpLoggingInterceptor,
                     stethoInterceptor: StethoInterceptor,
                     @MyAppInterceptor myAppInterceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .readTimeout(AppConstants.API_TIMEOUT_TIME, TimeUnit.SECONDS)
                .connectTimeout(AppConstants.API_TIMEOUT_TIME, TimeUnit.SECONDS)
                .addInterceptor(myAppInterceptor)

        if (!BuildConfig.BUILD_TYPE.equals("release")) {
            builder.addInterceptor(httpLoggingInterceptor)
                    .addNetworkInterceptor(stethoInterceptor)
        }

        return builder.cache(cache).build()
    }


    @Provides
    @MyAppRetrofit
    @Singleton
    fun myAppRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MyAppUnwrapperConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BuildConfig.API_BASE_URL)
            .build()

    @Singleton
    @Provides
    fun myAppApiInterface(@MyAppRetrofit retrofit: Retrofit): MyAppService =
            retrofit.create<MyAppService>(MyAppService::class.java)

}