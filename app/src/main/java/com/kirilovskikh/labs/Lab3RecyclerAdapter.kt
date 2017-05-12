package com.kirilovskikh.labs

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

/**
 * Created by kirilovskikh on 12.05.17.
 */
class Lab3RecyclerAdapter(private val context: Context,
                          private val items: List<SimpleListModel>) : RecyclerView.Adapter<Lab3RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lab_3_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].text
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.textView) lateinit var textView: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

    }

}