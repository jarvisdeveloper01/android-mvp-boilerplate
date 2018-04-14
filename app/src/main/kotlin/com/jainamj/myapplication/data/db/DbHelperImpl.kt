package com.jainamj.myapplication.data.db

import com.jainamj.myapplication.data.db.repository.newsletters.DbNewsLetterItem
import com.jainamj.myapplication.data.db.repository.newsletters.NewsLetterRepo
import io.reactivex.Observable
import javax.inject.Inject


class DbHelperImpl @Inject constructor(var newsLetterRepo: NewsLetterRepo) : DbHelper {

    // news letters

    override fun addAllNewsLetter(newsLetter: List<DbNewsLetterItem>): Observable<List<Long>> =
            newsLetterRepo.addAllNewsLetter(newsLetter)

    override fun addNewsLetter(newsLetter: DbNewsLetterItem): Observable<Long> =
            newsLetterRepo.addNewsLetter(newsLetter)

    override fun updateNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean> =
            newsLetterRepo.updateNewsLetter(newsLetter)

    override fun deleteNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean> =
            newsLetterRepo.deleteNewsLetter(newsLetter)

    override fun getAllNewsLetter(): Observable<List<DbNewsLetterItem>> =
            newsLetterRepo.getAllNewsLetter()

    // other db repo
}