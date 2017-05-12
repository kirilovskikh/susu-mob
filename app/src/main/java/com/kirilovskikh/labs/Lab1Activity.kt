package com.kirilovskikh.labs

import android.content.Context
import org.jetbrains.anko.intentFor

/**
 * Created by kirilovskikh on 12.05.17.
 */
class Lab1Activity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) = context.intentFor<Lab1Activity>()
    }

    override fun getLayoutId(): Int = R.layout.lab_1_activity

    override fun onCreate() {
    }

}