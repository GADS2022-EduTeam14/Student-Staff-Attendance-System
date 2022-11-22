package com.andela.eduteam14.android_app.core.ui.extensions

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.andela.eduteam14.android_app.R

fun AppCompatActivity.goto(
    component: Class<*>,
) {
    this.startActivity(
        Intent(this, component)
    )
}

fun ShowToast(context: Context) {
    Toast.makeText(
        context,
        context.getString(R.string.not_yet_implemented),
        Toast.LENGTH_SHORT
    )
        .show()
}