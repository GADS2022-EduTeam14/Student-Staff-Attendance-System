package com.andela.eduteam14.android_app.core.ui.extensions

import android.widget.Button

fun Button.onClick(handler: () -> Unit) {
    setOnClickListener {
        handler()
    }
}