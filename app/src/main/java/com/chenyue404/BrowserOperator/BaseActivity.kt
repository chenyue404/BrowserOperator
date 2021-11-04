package com.chenyue404.BrowserOperator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by cy on 2021/11/4.
 */
abstract class BaseActivity : AppCompatActivity() {
    private var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initBeforeSetContent()
        super.onCreate(savedInstanceState)
        val layoutId = getLayoutId()
        if (layoutId > 0) {
            rootView = LayoutInflater.from(this).inflate(layoutId, null)
            setContentView(rootView)
        }
        initView()
    }

    open fun initBeforeSetContent() {}

    abstract fun getLayoutId(): Int

    abstract fun initView()
}