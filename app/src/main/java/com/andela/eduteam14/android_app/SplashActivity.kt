package com.andela.eduteam14.android_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.databinding.ActivityMainBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), UiAction {
    private var teamName: TextView? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        initViews()

        onLoadSplashScreen()
    }

    private fun onLoadSplashScreen() {
        val fadeInAnimation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fade_in,
        )

        teamName?.startAnimation(fadeInAnimation)
    }

    override fun initViews() {
        teamName = binding?.SplashScreenTeamName
    }

    override fun onDestroyComponents() {
        binding = null
    }

    override fun onDestroy() {
       onDestroyComponents()
        super.onDestroy()
    }
}