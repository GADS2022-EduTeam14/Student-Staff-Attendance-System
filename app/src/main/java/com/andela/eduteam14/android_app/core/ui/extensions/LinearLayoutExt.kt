package com.andela.eduteam14.android_app.core.ui.extensions

import android.widget.Button
import android.widget.LinearLayout

fun LinearLayout.onClick(handler: () -> Unit) {
    setOnClickListener {
        handler()
    }
}