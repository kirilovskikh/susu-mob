package com.kirilovskikh.labs.activities

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.kirilovskikh.labs.R
import com.kirilovskikh.labs.adapters.Lab3RecyclerAdapter
import com.kirilovskikh.labs.data.SimpleListModel
import org.jetbrains.anko.intentFor

/**
 * Created by kirilovskikh on 12.05.17.
 */
class Lab3Activity : BaseActivity() {

    @BindView(R.id.recyclerView) lateinit var recyclerView: RecyclerView

    private val items = generateItems()

    companion object {

        fun newIntent(context: Context) = context.intentFor<Lab3Activity>()

    }

    override fun getLayoutId(): Int = R.layout.lab_3_activity

    override fun onCreate() {
        setBackButton()

        val adapter = Lab3RecyclerAdapter(this, items, onItemClick = { onItemClick(it) })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun onItemClick(position: Int) {
        startActivity(Lab3DetailActivity.newIntent(this, items[position]))
    }

    private fun generateItems(): List<SimpleListModel> = (0..200).map { SimpleListModel(it.toLong(), "$it $it $it") }

}