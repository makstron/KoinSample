package com.klim.koinsample.data._retrofit.apis.feedback

import retrofit2.http.GET

interface PostApi {

    @GET("posts/")
    suspend fun getAll(): ArrayList<PostPOJO>

}