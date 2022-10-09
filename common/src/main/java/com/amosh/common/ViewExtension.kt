package com.amosh.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.amosh.common.R

fun ImageView.loadImagesWithGlideExt(url: String) {
    Glide.with(this.context)
        .load(url)
        .error(R.drawable.error)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}