package com.yetkin.androidrxjava.data.network

import com.yetkin.androidrxjava.data.model.PhotoResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/api/")
    fun getPhotos(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("image_type") imageType: String
    ): Single<PhotoResponse>
}