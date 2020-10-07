package com.jainamj.myapplication.di.modules

import android.content.Context
import androidx.room.Room
import com.jainamj.myapplication.AppConstants
import com.jainamj.myapplication.data.db.MyAppDb
import com.jainamj.myapplication.data.db.repository.newsletters.NewsLetterImpl
import com.jainamj.myapplication.data.db.repository.newsletters.NewsLetterRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DbModule {

    @Provides
    @Singleton
    fun myAppDb(@ApplicationContext context: Context): MyAppDb =
            Room.databaseBuilder(context, MyAppDb::class.java, AppConstants.DB_NAME)
                    // TODO: replace fallbackToDestructiveMigration() with appropriate migrations
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    fun provideNewsLetterRepoHelper(myAppDb: MyAppDb): NewsLetterRepo = NewsLetterImpl(myAppDb.newsLetterDao())

}