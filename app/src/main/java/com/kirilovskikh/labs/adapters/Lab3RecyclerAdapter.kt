package com.kirilovskikh.labs.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.kirilovskikh.labs.R
import com.kirilovskikh.labs.data.SimpleListModel
import org.jetbrains.anko.onClick

/**
 * Created by kirilovskikh on 12.05.17.
 */
class Lab3RecyclerAdapter(private val context: Context,
                          private val items: List<SimpleListModel>,
                          private val onItemClick: (pos: Int) -> Unit) : RecyclerView.Adapter<Lab3RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lab_3_recycler_item, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].text
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View, onItemClick: (pos: Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.textView) lateinit var textView: TextView

        init {
            ButterKnife.bind(this, itemView)
            itemView.onClick { onItemClick.invoke(adapterPosition) }
        }

    }

}