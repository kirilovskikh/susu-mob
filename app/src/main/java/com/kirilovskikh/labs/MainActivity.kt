package com.kirilovskikh.labs

import android.widget.Button
import butterknife.BindView
import butterknife.OnClick

class MainActivity : BaseActivity() {

    @BindView(R.id.lab1Button) lateinit var but: Button

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate() {
    }

    @OnClick(R.id.lab1Button)
    fun onLab1Click() {

    }

}
