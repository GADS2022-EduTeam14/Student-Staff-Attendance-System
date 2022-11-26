package com.andela.eduteam14.android_app.core.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity(), UiAction {

    private var _binding: ActivitySearchBinding? = null

    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        initViews()
    }

    override fun initViews() {

    }

    override fun onDestroyComponents() {

    }
}