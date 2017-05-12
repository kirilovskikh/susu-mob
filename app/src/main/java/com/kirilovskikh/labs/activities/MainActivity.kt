package com.kirilovskikh.labs.activities

import butterknife.OnClick
import com.kirilovskikh.labs.R

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate() {
    }

    @OnClick(R.id.lab1Button)
    fun onLab1Click() {
        startActivity(Lab1Activity.newIntent(this))
    }

    @OnClick(R.id.lab3Button)
    fun onLab3Click() {
        startActivity(Lab3Activity.newIntent(this))
    }

    @OnClick(R.id.lab4Button)
    fun onLab4Click() {
        startActivity(Lab4Activity.newIntent(this))
    }

}
