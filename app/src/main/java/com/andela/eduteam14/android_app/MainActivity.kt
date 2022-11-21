package com.andela.eduteam14.android_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.andela.eduteam14.android_app.core.ui.onboarding.Onboarding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Start onboarding screen
    fun startOnbardingIntent(view : View){
        val intent = Intent(this, Onboarding::class.java)
        startActivity(intent)
    }
}