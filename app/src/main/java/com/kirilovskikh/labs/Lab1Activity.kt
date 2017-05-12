package com.kirilovskikh.labs

import android.content.Context
import android.os.Bundle
import android.util.Log
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
        private val EXTRA_TEXT_VALUE = "extra_text_value"
        private val EXTRA_EDIT_VALUE = "extra_edit_value"

        fun newIntent(context: Context) = context.intentFor<Lab1Activity>()
    }

    override fun getLayoutId(): Int = R.layout.lab_1_activity

    override fun onCreate() {
        if (savedInstanceState != null) {
            textView.text = savedInstanceState?.getString(EXTRA_TEXT_VALUE)
            val editTextValue = savedInstanceState?.getString(EXTRA_EDIT_VALUE)
            editText.setText(editTextValue)
            editText.setSelection(editTextValue?.length ?: 0)
        }
    }

    override fun onSaveInstanceState(bundle: Bundle?) {
        super.onSaveInstanceState(bundle)

        if (bundle != null) {
            bundle.putString(EXTRA_TEXT_VALUE, textView.text.toString())
            bundle.putString(EXTRA_EDIT_VALUE, editText.text.toString())
        }
    }

    @OnClick(R.id.applyButton)
    fun onApplyButtonClick() {
        Log.d("kirilovskikh", editText.text.toString())
        textView.text = editText.text
    }

}