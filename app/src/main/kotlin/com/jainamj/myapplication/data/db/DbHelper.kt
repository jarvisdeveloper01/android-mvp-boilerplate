package com.jainamj.myapplication.data.db

import com.jainamj.myapplication.data.db.repository.newsletters.DbNewsLetterItem
import io.reactivex.Observable

interface DbHelper {

    // news letters

    fun addAllNewsLetter(newsLetter: List<DbNewsLetterItem>): Observable<List<Long>>
    fun addNewsLetter(newsLetter: DbNewsLetterItem): Observable<Long>
    fun updateNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean>
    fun deleteNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean>
    fun getAllNewsLetter(): Observable<List<DbNewsLetterItem>>

    // other db repo
}