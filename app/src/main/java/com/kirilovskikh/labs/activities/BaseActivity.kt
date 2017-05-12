package com.kirilovskikh.labs.activities

/**
 * Created by kirilovskikh on 12.05.17.
 */
abstract class BaseActivity : android.support.v7.app.AppCompatActivity(), BaseUI {

    protected var savedInstanceState: android.os.Bundle? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
        butterknife.ButterKnife.bind(this)
        this.savedInstanceState = savedInstanceState

        onCreate()
    }

}