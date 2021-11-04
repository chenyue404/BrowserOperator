package com.chenyue404.BrowserOperator

import android.app.Application
import android.content.Context
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog

/**
 * Created by cy on 2021/11/4.
 */
class App : Application() {

    companion object {
        lateinit var gContext: App
    }

    override fun onCreate() {
        super.onCreate()
        XLog.init(
            LogConfiguration.Builder()
                .logLevel(if (BuildConfig.DEBUG) LogLevel.ALL else LogLevel.NONE)
                .enableBorder()
                .enableStackTrace(1)
                .build()
        )

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        gContext = this
    }
}