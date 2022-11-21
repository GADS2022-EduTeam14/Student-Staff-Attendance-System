package com.andela.eduteam14.android_app.core.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), UiAction {
    private var binding: ActivityRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding?.root)

    }

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun onDestroyComponents() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }
}