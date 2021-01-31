package com.yetkin.androidrxjava.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.yetkin.androidrxjava.databinding.ActivityMainBinding
import com.yetkin.androidrxjava.ui.adapter.PhotoAdapter
import com.yetkin.androidrxjava.util.Status
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class PhotosActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: PhotoViewModel by viewModels()

    private val photoAdapter = PhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        initializeRecycler()

        observePhotos()
    }

    private fun initializeRecycler() {
        recyclerPhotos.apply {
            setHasFixedSize(true)
            adapter = photoAdapter
        }
    }

    private fun observePhotos() {
        viewModel.photos.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.hits?.let { list ->
                        photoAdapter.submitList(list)
                    }
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                }
            }
        })
    }
}