package com.jainamj.myapplication.data.db.repository.newsletters

import com.jainamj.myapplication.data.db.DbErrorHandler.handleDbError
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class NewsLetterImpl @Inject constructor(var newsLetterDao: NewsLetterDao) : NewsLetterRepo {

    override fun addAllNewsLetter(newsletters: List<DbNewsLetterItem>): Observable<List<Long>> =
            Observable.fromCallable { newsLetterDao.addAllNewsLettertoDb(newsletters) }
                    .doOnNext { Timber.e(it.toString()) }
                    .doOnError {
                        Timber.e("addAllNewsLetter onError: $it")
                    }


    override fun addNewsLetter(newsLetter: DbNewsLetterItem): Observable<Long> =
            Observable.fromCallable { newsLetterDao.insertNewsLetter(newsLetter) }
                    .doOnNext { Timber.e(it.toString()) }
                    .onErrorReturn { error -> handleDbError(error) }


    override fun updateNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNewsLetter(newsLetter: DbNewsLetterItem): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* override fun findNewsLetter(id: Long): Observable<DbNewsLetterItem> =
             Observable.fromCallable { newsLetterDao.findNewsLetter(id) }*/

    override fun getAllNewsLetter(): Observable<List<DbNewsLetterItem>> =
            Observable.fromCallable { newsLetterDao.getAllNewsLetter() }
}