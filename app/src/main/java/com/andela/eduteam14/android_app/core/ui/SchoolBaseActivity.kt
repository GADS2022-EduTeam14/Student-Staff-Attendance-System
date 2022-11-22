package com.andela.eduteam14.android_app.core.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.databinding.ActivityBaseBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class SchoolBaseActivity : AppCompatActivity(), UiAction {

    private lateinit var navView: BottomNavigationView
    private var _binding: ActivityBaseBinding? = null

    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityBaseBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        initViews()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.BaseNavHostFragment)
                    as NavHostFragment

        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)

    }

    override fun initViews() {
        navView = binding?.SchoolBottomNav!!
    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }
}