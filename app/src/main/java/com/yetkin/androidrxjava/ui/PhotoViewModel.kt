package com.yetkin.androidrxjava.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.yetkin.androidrxjava.data.repository.PhotoRepository

class PhotoViewModel @ViewModelInject constructor(private val photoRepository: PhotoRepository) : ViewModel()