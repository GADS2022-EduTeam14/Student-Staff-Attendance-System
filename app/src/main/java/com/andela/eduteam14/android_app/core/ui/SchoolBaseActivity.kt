package com.andela.eduteam14.android_app.core.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.andela.eduteam14.android_app.MainApplication
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.di.CoreComponent
import com.andela.eduteam14.android_app.core.ui.extensions.onItemClick
import com.andela.eduteam14.android_app.core.ui.settings.GO_TO_LOGIN
import com.andela.eduteam14.android_app.core.ui.settings.KEY_DESTINATION
import com.andela.eduteam14.android_app.databinding.ActivityBaseBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class SchoolBaseActivity : AppCompatActivity(), UiAction {

    private lateinit var navController: NavController
    private lateinit var navView: BottomNavigationView
    private var _binding: ActivityBaseBinding? = null

    private val binding get() = _binding
    lateinit var coreComponent: CoreComponent

    private lateinit var toolbar: MaterialToolbar
    private lateinit var fab: ExtendedFloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coreComponent = (application as MainApplication).coreComponent

        _binding = ActivityBaseBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        initViews()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.BaseNavHostFragment)
                    as NavHostFragment

        navController = navHostFragment.navController
        navView.setupWithNavController(navController)


        handleMenuClicks(onStartSearch = { onStartSearch() })

        hideFab()

    }


    override fun onResume() {
        super.onResume()

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: Called")
    }

    fun hideFab() {
        fab.hide()
    }

    fun showFab() {
        fab.show()
    }

    private fun onStartSearch() {
        Toast.makeText(this, "Search will commence", Toast.LENGTH_SHORT).show()
    }

    private fun handleMenuClicks(onStartSearch: () -> Unit) {
        toolbar.onItemClick {
            when (it.itemId) {
                R.id.search_school -> {
                    onStartSearch()
                }
            }
        }

    }

    override fun initViews() {
        navView = binding?.SchoolBottomNav!!
        toolbar = binding?.BaseToolbar!!
        fab = binding?.BaseExtendedFab!!
    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }

    companion object {
        val TAG = "SchoolBaseActivity"
    }
}