package com.jainamj.myapplication.data.db.repository.newsletters

import io.reactivex.Observable

interface NewsLetterRepo {

    fun addAllNewsLetter(newsletters: List<DbNewsLetterItem>): Observable<List<Long>>

    fun addNewsLetter(newsLetter: DbNewsLetterItem): Observable<Long>

    fun updateNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean>

    fun deleteNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean>

   /* fun findNewsLetter(id: Long): Observable<DbNewsLetterItem>*/

    fun getAllNewsLetter(): Observable<List<DbNewsLetterItem>>
}