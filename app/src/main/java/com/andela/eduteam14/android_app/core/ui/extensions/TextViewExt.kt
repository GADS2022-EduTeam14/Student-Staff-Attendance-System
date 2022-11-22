package com.andela.eduteam14.android_app.core.ui.extensions

import android.widget.Button
import android.widget.TextView

fun TextView.onClick(handler: () -> Unit) {
    setOnClickListener {
        handler()
    }
}

fun TextView.onLongClick(handler: () -> Unit) {
    setOnLongClickListener {
        handler()
        true
    }
}