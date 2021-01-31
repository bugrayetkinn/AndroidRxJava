package com.yetkin.androidrxjava.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yetkin.androidrxjava.data.model.PhotoResponse
import com.yetkin.androidrxjava.data.repository.PhotoRepository
import com.yetkin.androidrxjava.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(private val photoRepository: PhotoRepository) :
    ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _photos = MutableLiveData<Resource<PhotoResponse>>()
    val photos: LiveData<Resource<PhotoResponse>> get() = _photos

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        compositeDisposable.add(
            photoRepository
                .getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    _photos.value = it
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}