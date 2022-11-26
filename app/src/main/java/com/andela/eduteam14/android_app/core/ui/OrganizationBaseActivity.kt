package com.andela.eduteam14.android_app.core.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.andela.eduteam14.android_app.MainApplication
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.di.CoreComponent
import com.andela.eduteam14.android_app.databinding.ActivityBaseBinding
import com.andela.eduteam14.android_app.databinding.ActivityOrganizationBaseBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class OrganizationBaseActivity : AppCompatActivity(), UiAction {

    private lateinit var navView: BottomNavigationView
    private var _binding: ActivityOrganizationBaseBinding? = null

    private val binding get() = _binding

    lateinit var coreComponent: CoreComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coreComponent = (application as MainApplication).coreComponent

        _binding = ActivityOrganizationBaseBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        initViews()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.OrganizationBaseNavHostFragment)
                    as NavHostFragment

        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)

    }

    override fun initViews() {
       navView = binding?.OrganizationBottomNav!!
    }

    override fun onDestroyComponents() {

    }
}