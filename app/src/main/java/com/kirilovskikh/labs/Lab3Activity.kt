package com.kirilovskikh.labs

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import org.jetbrains.anko.intentFor

/**
 * Created by kirilovskikh on 12.05.17.
 */
class Lab3Activity : BaseActivity() {

    @BindView(R.id.recyclerView) lateinit var recyclerView: RecyclerView

    companion object {

        fun newIntent(context: Context) = context.intentFor<Lab3Activity>()

    }

    override fun getLayoutId(): Int = R.layout.lab_3_activity

    override fun onCreate() {
        val adapter = Lab3RecyclerAdapter(this, generateItems())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun generateItems(): List<SimpleListModel> = (0..200).map { SimpleListModel(it.toLong(), it.toString()) }

}