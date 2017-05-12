package com.kirilovskikh.labs.activities

import android.content.Context
import android.widget.TextView
import butterknife.BindView
import com.kirilovskikh.labs.R
import com.kirilovskikh.labs.data.SimpleListModel
import org.jetbrains.anko.intentFor

/**
 * Created by kirilovskikh on 13.05.17.
 */
class Lab3DetailActivity : BaseActivity() {

    @BindView(R.id.textView) lateinit var textView: TextView

    companion object {

        private val EXTRA_MODEL = "extra_model"

        fun newIntent(context: Context, model: SimpleListModel) = context.intentFor<Lab3DetailActivity>(EXTRA_MODEL to model)

    }

    override fun getLayoutId(): Int = R.layout.lab_3_detail_activity

    override fun onCreate() {
        val model: SimpleListModel = intent.getSerializableExtra(EXTRA_MODEL) as SimpleListModel
        textView.text = model.text
    }

}