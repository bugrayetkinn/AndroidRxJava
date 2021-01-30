package com.yetkin.androidrxjava.data.network

import com.yetkin.androidrxjava.data.model.PhotoModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("")
    fun getPhotos(
        @Query("key") key: String,
        @Path("q") query: String,
        @Path("image_type") imageType: String
    ): Single<List<PhotoModel>>

}