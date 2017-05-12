package com.kirilovskikh.labs.activities

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.kirilovskikh.labs.R
import com.kirilovskikh.labs.adapters.Lab4RecyclerAdapter
import com.kirilovskikh.labs.data.ImageLoader
import com.kirilovskikh.labs.data.news.NewsRepository
import org.jetbrains.anko.intentFor
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by kirilovskikh on 13.05.17.
 */
class Lab4Activity : BaseActivity() {

    @BindView(R.id.recyclerView) lateinit var recyclerView: RecyclerView

    private val repository = NewsRepository()
    private val adapter = Lab4RecyclerAdapter(this, ImageLoader(this), mutableListOf())

    companion object {
        fun newIntent(context: Context) = context.intentFor<Lab4Activity>()
    }

    override fun getLayoutId(): Int = R.layout.lab_4_activity

    override fun onCreate() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        repository.fetch(null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.addItems(it)
                    adapter.notifyDataSetChanged()
                })
    }

}