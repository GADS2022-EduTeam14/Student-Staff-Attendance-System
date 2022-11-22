package com.andela.eduteam14.android_app.core.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.databinding.ActivityAuthBinding


class AuthActivity : AppCompatActivity(), UiAction {

    private var _binding: ActivityAuthBinding? = null

    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.RegisterNavHostFragment)
        as NavHostFragment

        val navController = navHostFragment.navController


    }


    override fun initViews() {

    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }

}