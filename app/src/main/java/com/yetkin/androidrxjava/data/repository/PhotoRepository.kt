package com.yetkin.androidrxjava.data.repository

import com.yetkin.androidrxjava.data.model.PhotoResponse
import com.yetkin.androidrxjava.data.network.Api
import com.yetkin.androidrxjava.util.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

const val API_KEY = "15425294-904f9024d8a82d7e4c75f5248"
const val QUERY = "yellow+flowers"
const val IMAGE_TYPE = "photo"

class PhotoRepository @Inject constructor(private val api: Api) {

    fun getPhotos(): Observable<Resource<PhotoResponse>> =
        Observable.create<Resource<PhotoResponse>> { emitter ->

            emitter.onNext(Resource.Loading())
            api.getPhotos(API_KEY, QUERY, IMAGE_TYPE)
                .subscribe(
                    { response ->
                        emitter.onNext(Resource.Success(response))
                        emitter.onComplete()
                    },
                    { error ->
                        emitter.onNext(Resource.Error(error.message.toString()))
                        emitter.onComplete()
                    }
                )
        }
}
