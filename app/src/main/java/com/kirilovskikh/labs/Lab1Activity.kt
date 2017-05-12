package com.kirilovskikh.labs

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import org.jetbrains.anko.intentFor

/**
 * Created by kirilovskikh on 12.05.17.
 */
class Lab1Activity : BaseActivity() {

    @BindView(R.id.textView) lateinit var textView: TextView
    @BindView(R.id.editText) lateinit var editText: EditText

    companion object {
        fun newIntent(context: Context) = context.intentFor<Lab1Activity>()
    }

    override fun getLayoutId(): Int = R.layout.lab_1_activity

    override fun onCreate() {
    }

    @OnClick(R.id.applyButton)
    fun onApplyButtonClick() {
        textView.text = editText.text
    }

}