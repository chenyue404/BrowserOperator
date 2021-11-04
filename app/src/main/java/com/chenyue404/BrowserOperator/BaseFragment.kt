package com.chenyue404.BrowserOperator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by cy on 2021/11/4.
 */
abstract class BaseFragment : Fragment() {
    protected var mRoot: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mRoot?.let {
            val localViewGroup = it.parent
            if (localViewGroup is ViewGroup) {
                localViewGroup.removeView(it)
            }
        } ?: run {
            mRoot = inflater.inflate(getLayoutResId(), container, false)
        }
        return mRoot!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(mRoot!!)
    }

    fun <T : View> findViewById(id: Int): T = mRoot!!.findViewById(id)

    abstract fun getLayoutResId(): Int

    abstract fun initView(root: View)

}