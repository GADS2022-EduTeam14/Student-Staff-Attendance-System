package com.andela.eduteam14.android_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.auth.AuthActivity
import com.andela.eduteam14.android_app.core.ui.extensions.goto
import com.andela.eduteam14.android_app.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), UiAction {
    private var teamName: TextView? = null
    private var binding: ActivitySplashBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        initViews()

        onLoadSplashScreen()

        Handler(Looper.getMainLooper()).postDelayed({
           goto(AuthActivity::class.java)
        }, 3000)
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