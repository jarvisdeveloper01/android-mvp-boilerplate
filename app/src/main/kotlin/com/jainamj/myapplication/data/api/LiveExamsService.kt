package com.jainamj.myapplication.data.api

import com.jainamj.myapplication.data.api.models.liveexams.Container
import io.reactivex.Observable
import retrofit2.http.GET

interface LiveExamsService {

    @GET("api/beforeSignUp")
    fun getLanguages(): Observable<Container>
}