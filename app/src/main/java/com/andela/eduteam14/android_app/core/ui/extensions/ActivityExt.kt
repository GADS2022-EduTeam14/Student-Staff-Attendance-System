package com.andela.eduteam14.android_app.core.ui.extensions

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.andela.eduteam14.android_app.R
import java.io.Serializable

fun AppCompatActivity.goto(
    component: Class<*>,
) {
    this.startActivity(
        Intent(this, component)
    )
}


fun <T : Parcelable> AppCompatActivity.goto(
    component: Class<*>,
    key: String,
    extra: T,
) {
    val intent = Intent(this, component)
    intent.putExtra(key, extra)
    this.startActivity(intent)
}


fun <T : Serializable> AppCompatActivity.goto(
    component: Class<*>,
    key: String,
    extra: T,
) {
    val intent = Intent(this, component)
    intent.putExtra(key, extra)
    this.startActivity(intent)
}


fun AppCompatActivity.goto(
    component: Class<*>,
    key: String,
    extra: String,
) {
    val intent = Intent(this, component)
    intent.putExtra(key, extra)
    this.startActivity(intent)
}


fun AppCompatActivity.goto(
    component: Class<*>,
    key: String,
    extra: Int,
) {
    val intent = Intent(this, component)
    intent.putExtra(key, extra)
    this.startActivity(intent)
}

fun AppCompatActivity.goto(
    component: Class<*>,
    key: String,
    extra: Boolean,
) {
    val intent = Intent(this, component)
    intent.putExtra(key, extra)
    this.startActivity(intent)
}


fun AppCompatActivity.goto(
    component: Class<*>,
    key: String,
    extra: Float,
) {
    val intent = Intent(this, component)
    intent.putExtra(key, extra)
    this.startActivity(intent)
}


fun AppCompatActivity.goto(
    component: Class<*>,
    key: String,
    extra: Double,
) {
    val intent = Intent(this, component)
    intent.putExtra(key, extra)
    this.startActivity(intent)
}


fun ShowToast(context: Context) {
    Toast.makeText(
        context,
        context.getString(R.string.not_yet_implemented),
        Toast.LENGTH_SHORT
    )
        .show()
}