package com.yetkin.androidrxjava.data.model

data class PhotoResponse(
    val total: Long? = null,
    val totalHits: Int? = null,
    val hits: List<PhotoModel>? = null
)