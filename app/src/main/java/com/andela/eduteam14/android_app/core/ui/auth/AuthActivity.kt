package com.andela.eduteam14.android_app.core.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.settings.GO_TO_LOGIN
import com.andela.eduteam14.android_app.core.ui.settings.KEY_DESTINATION
import com.andela.eduteam14.android_app.databinding.ActivityAuthBinding


class AuthActivity : AppCompatActivity(), UiAction {

    private lateinit var navController: NavController
    private var _binding: ActivityAuthBinding? = null

    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.RegisterNavHostFragment)
                    as NavHostFragment

        navController = navHostFragment.navController


    }

    override fun onStart() {
        super.onStart()

        if (intent.getStringExtra(KEY_DESTINATION) == GO_TO_LOGIN) {
            jumpTo(R.id.loginFragment)
        }
    }

    private fun jumpTo(id: Int) {
        navController.navigateUp()
        navController.navigate(id)
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