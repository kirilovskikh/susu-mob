package com.kirilovskikh.labs.activities

import android.content.Context
import com.kirilovskikh.labs.R
import org.jetbrains.anko.intentFor

/**
 * Created by kirilovskikh on 13.05.17.
 */
class Lab4Activity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) = context.intentFor<Lab4Activity>()
    }

    override fun getLayoutId(): Int = R.layout.lab_4_activity

    override fun onCreate() {

    }

}