package com.kirilovskikh.labs.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.kirilovskikh.labs.R
import com.kirilovskikh.labs.data.ImageLoader
import com.kirilovskikh.labs.data.NewsModel

/**
 * Created by kirilovskikh on 13.05.17.
 */
class Lab4RecyclerAdapter(private val context: Context,
                          private val imageLoader: ImageLoader,
                          private val items: MutableList<NewsModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_NEWS = 0
    private val TYPE_ADVERTISING = 1

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = if (items[position].isAdvertising) TYPE_ADVERTISING else TYPE_NEWS

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_NEWS -> NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.lab_4_news_recycler_item, parent, false))
            TYPE_ADVERTISING -> AdvertisingViewHolder(LayoutInflater.from(context).inflate(R.layout.lab_4_advertising_recycler_item, parent, false))
            else -> NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.lab_4_news_recycler_item, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val item = items[position]
        if (holder is NewsViewHolder) {

            if (item.image == null) {
                holder.newsImage.visibility = View.GONE
            } else {
                holder.newsImage.visibility = View.VISIBLE
                imageLoader.load(holder.newsImage, item.image)
            }

            holder.textView.text = item.text

        } else if (holder is AdvertisingViewHolder) {
            imageLoader.load(holder.imageView, item.image)
        }
    }

    fun addItems(list: List<NewsModel>) {
        items.addAll(list)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.newsImage) lateinit var newsImage: ImageView
        @BindView(R.id.textView) lateinit var textView: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }

    class AdvertisingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.imageView) lateinit var imageView: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }
    }

}