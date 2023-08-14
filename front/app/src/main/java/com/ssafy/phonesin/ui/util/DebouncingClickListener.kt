package com.ssafy.phonesin.ui.util

import android.view.View

abstract class DebouncingClickListener(private val delayMillis: Long = 1000L) : View.OnClickListener {

    private var lastClickTimes = mutableMapOf<View, Long>()

    final override fun onClick(v: View) {
        val currentTime = System.currentTimeMillis()
        val lastClickTime = lastClickTimes[v] ?: 0L

        if (currentTime - lastClickTime > delayMillis) {
            lastClickTimes[v] = currentTime
            onDebouncedClick(v)
        }
    }

    abstract fun onDebouncedClick(v: View)
}

fun View.setDebouncingClickListener(delayMillis: Long = 1000L, onDebouncedClick: (View) -> Unit) {
    this.setOnClickListener(object : DebouncingClickListener(delayMillis) {
        override fun onDebouncedClick(v: View) {
            onDebouncedClick(v)
        }
    })
}
