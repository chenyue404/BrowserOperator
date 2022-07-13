package com.chenyue404.browserOperator

import android.app.Application
import android.content.Context

/**
 * Created by cy on 2021/11/4.
 */
class App : Application() {

    companion object {
        lateinit var gContext: App
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        gContext = this
    }
}