package com.kirilovskikh.labs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

/**
 * Created by kirilovskikh on 12.05.17.
 */
abstract class BaseActivity : AppCompatActivity(), BaseUI {

    protected var savedInstanceState: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
        ButterKnife.bind(this)
        this.savedInstanceState = savedInstanceState

        onCreate()
    }

}