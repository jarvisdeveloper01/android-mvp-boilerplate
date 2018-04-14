package com.jainamj.myapplication.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.jainamj.myapplication.AppConstants
import com.jainamj.myapplication.data.db.MyAppDb
import com.jainamj.myapplication.data.db.repository.newsletters.NewsLetterImpl
import com.jainamj.myapplication.data.db.repository.newsletters.NewsLetterRepo
import com.jainamj.myapplication.di.qualifiers.AppContext
import com.jainamj.myapplication.di.scopes.AppScope
import dagger.Module
import dagger.Provides


@Module(includes = [AppContextModule::class])
class DbModule {

    @Provides
    @AppScope
    fun myAppDb(@AppContext context: Context): MyAppDb =
            Room.databaseBuilder(context, MyAppDb::class.java, AppConstants.DB_NAME)
                    // TODO: replace fallbackToDestructiveMigration() with appropriate migrations
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @AppScope
    fun provideNewsLetterRepoHelper(myAppDb: MyAppDb): NewsLetterRepo = NewsLetterImpl(myAppDb.newsLetterDao())

}