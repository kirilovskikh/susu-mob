package com.kirilovskikh.labs.data

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by kirilovskikh on 13.05.17.
 */
class ImageLoader(private val context: Context) {

    fun load(imageView: ImageView, url: String?) {
        Picasso.with(context)
                .load(url)
                .into(imageView)
    }

}