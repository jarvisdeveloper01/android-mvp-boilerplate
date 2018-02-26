package com.jainamj.myapplication.di.modules

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
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

    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("DROP TABLE `users`")
//            database.execSQL(CREATE)
        }
    }

    @Provides
    @AppScope
    fun gitDatabase(@AppContext context: Context): GitDb =
            Room.databaseBuilder(context, GitDb::class.java, AppConstants.GIT_DB_NAME)
//                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @AppScope
    fun provideUsersRepoHelper(gitDb: GitDb): UserRepo = UserRepoImpl(gitDb.userDao())

}