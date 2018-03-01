package com.jainamj.myapplication.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.jainamj.myapplication.AppConstants
import com.jainamj.myapplication.data.db.GitDb
import com.jainamj.myapplication.data.db.repository.users.UserRepo
import com.jainamj.myapplication.data.db.repository.users.UserRepoImpl
import com.jainamj.myapplication.di.qualifiers.AppContext
import com.jainamj.myapplication.di.scopes.AppScope
import dagger.Module
import dagger.Provides


@Module(includes = [AppContextModule::class])
class DbModule {

    @Provides
    @AppScope
    fun gitDatabase(@AppContext context: Context): GitDb =
            Room.databaseBuilder(context, GitDb::class.java, AppConstants.GIT_DB_NAME)
                    .fallbackToDestructiveMigration() // TODO: replace this with appropriate migrations
                    .build()

    @Provides
    @AppScope
    fun provideUsersRepoHelper(gitDb: GitDb): UserRepo = UserRepoImpl(gitDb.userDao())

}