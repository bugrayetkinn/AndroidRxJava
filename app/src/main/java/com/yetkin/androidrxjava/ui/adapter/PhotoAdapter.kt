package com.yetkin.androidrxjava.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yetkin.androidrxjava.data.model.PhotoItemViewState
import com.yetkin.androidrxjava.data.model.PhotoModel
import com.yetkin.androidrxjava.databinding.ItemPhotoBinding

class PhotoAdapter : ListAdapter<PhotoModel, PhotoAdapter.PhotoHolder>(DiffCallBack) {

    class PhotoHolder(private val itemPhotoBinding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(itemPhotoBinding.root) {

        fun bind(photoModel: PhotoModel) {
            itemPhotoBinding.itemViewState = PhotoItemViewState(photoModel)
        }
    }

    companion object {
        val DiffCallBack = object : DiffUtil.ItemCallback<PhotoModel>() {
            override fun areItemsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder =
        PhotoHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) =
        holder.bind(getItem(position))
}