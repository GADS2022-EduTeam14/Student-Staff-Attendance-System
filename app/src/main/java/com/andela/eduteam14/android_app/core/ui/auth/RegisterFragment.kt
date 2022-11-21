package com.andela.eduteam14.android_app.core.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), UiAction {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        initViews()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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