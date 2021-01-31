package com.yetkin.androidrxjava.data.model

data class PhotoItemViewState(
    val photoModel: PhotoModel
) {

    fun userImageUrl() = photoModel.userImageURL ?: ""

    fun userName() = photoModel.user ?: ""

    fun previewImageUrl() = photoModel.previewURL ?: ""

    fun like() = photoModel.likes.toString()

    fun comment() = photoModel.comments.toString()

    fun download() = photoModel.downloads.toString()
}