package com.yetkin.androidrxjava.data.model

data class PhotoModel(
    val id: Int? = null,
    val pageURL: String? = null,
    val type: String? = null,
    val tags: String? = null,
    val previewURL: String? = null,
    val previewWidth: Int? = null,
    val previewHeight: Int? = null,
    val webformatURL: String? = null,
    val webformatWidth: Int? = null,
    val webformatHeight: String? = null,
    val largeImageURL: String? = null,
    val imageWidth: Int? = null,
    val imageHeight: Int? = null,
    val imageSize: Long? = null,
    val views: Int? = null,
    val downloads: Int? = null,
    val favorites: Int? = null,
    val likes: Int? = null,
    val comments: Int? = null,
    val user_id: Long? = null,
    val user: String? = null,
    val userImageURL: String? = null
)