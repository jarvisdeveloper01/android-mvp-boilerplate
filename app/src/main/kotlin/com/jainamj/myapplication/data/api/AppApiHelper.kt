package com.jainamj.myapplication.data.api

import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.data.api.models.liveexams.Container
import io.reactivex.Observable
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(var gitService: GitService, var liveExamsService: LiveExamsService) : ApiHelper {

    override fun getUserRepos(username: String): Observable<UserInfo> = gitService.getUserInfo(username)

    override fun getLanguagesBeforeSignup(): Observable<Container> = liveExamsService.getLanguages()

}