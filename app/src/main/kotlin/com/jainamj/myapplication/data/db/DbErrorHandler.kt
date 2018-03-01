package com.jainamj.myapplication.data.db

import android.database.sqlite.SQLiteConstraintException
import timber.log.Timber

object DbErrorHandler {

    const val CONSTRAINT_ERROR = -1L
    const val ERROR_NOT_HANDLED = -2L

    fun handleDbError(error: Throwable): Long = when (error) {
        is SQLiteConstraintException -> {
            Timber.e("handle constraint exception")
            CONSTRAINT_ERROR
        }
        else -> {
            Timber.e("error wasn't be handled")
            Timber.e(error)
            ERROR_NOT_HANDLED

        }
    }
}