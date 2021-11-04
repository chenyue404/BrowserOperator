package com.chenyue404.BrowserOperator.extends

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.chenyue404.BrowserOperator.App

fun Context.color(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}

fun Fragment.color(@ColorRes color: Int): Int {
    return context?.color(color) ?: -1
}

fun View.color(@ColorRes color: Int): Int {
    return context.color(color)
}

fun Context.drawable(@DrawableRes drawableId: Int): Drawable? {
    return ContextCompat.getDrawable(this, drawableId)
}

fun Fragment.drawable(@DrawableRes drawableId: Int): Drawable? {
    return context?.drawable(drawableId)
}

fun View.drawable(@DrawableRes drawableId: Int): Drawable? {
    return context.drawable(drawableId)
}

fun Context.dimen(@DimenRes dimen: Int): Int {
    return resources.getDimensionPixelSize(dimen)
}

fun Fragment.dimen(@DimenRes dimen: Int): Int {
    return context?.dimen(dimen) ?: 0
}

fun View.dimen(@DimenRes dimen: Int): Int {
    return context.dimen(dimen)
}

fun string(@StringRes resId: Int): String {
    return App.gContext.resources.getString(resId)
}

fun string(@StringRes resId: Int, vararg items: Any): String {
    return App.gContext.resources.getString(resId, *items)
}

fun stringArray(@ArrayRes resId: Int): Array<String> {
    return App.gContext.resources.getStringArray(resId)
}

fun Context.boolean(@BoolRes bool: Int): Boolean {
    return resources.getBoolean(bool)
}

fun Fragment.boolean(@BoolRes bool: Int): Boolean {
    return context?.boolean(bool) ?: false
}

fun View.boolean(@BoolRes bool: Int): Boolean {
    return context.boolean(bool)
}

fun boolean(@BoolRes bool: Int): Boolean {
    return App.gContext.boolean(bool)
}

fun int(@IntegerRes resId: Int): Int {
    return App.gContext.resources.getInteger(resId)
}

fun Context.int(@IntegerRes int: Int): Int {
    return App.gContext.resources.getInteger(int)
}

fun Fragment.int(@IntegerRes int: Int): Int {
    return App.gContext.resources.getInteger(int)
}

fun View.int(@IntegerRes int: Int): Int {
    return App.gContext.resources.getInteger(int)
}