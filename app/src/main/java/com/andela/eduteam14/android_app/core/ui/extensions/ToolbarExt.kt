package com.andela.eduteam14.android_app.core.ui.extensions

import android.view.MenuItem
import android.view.View
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

fun MaterialToolbar.onItemClick(handler: (MenuItem) -> Unit) {
    setOnMenuItemClickListener {
        handler(it)
        true
    }
}

fun MaterialToolbar.onNavigationClick(handler: (View) -> Unit) {
    setNavigationOnClickListener {
        handler(it)
    }
}