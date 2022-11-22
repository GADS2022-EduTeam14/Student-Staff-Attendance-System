package com.andela.eduteam14.android_app.core.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.extensions.onClick
import com.andela.eduteam14.android_app.databinding.FragmentEmailVerificationBinding
import com.andela.eduteam14.android_app.databinding.FragmentRegisterBinding

class EmailVerificationFragment : Fragment(), UiAction {

    private var _binding: FragmentEmailVerificationBinding? = null
    private val binding get() = _binding

    private lateinit var dummy: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailVerificationBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        dummy.onClick { findNavController().navigate(R.id.action_emailVerificationFragment_to_loginFragment) }
    }

    override fun initViews() {
        dummy = binding?.Dummy!!
    }

    override fun onDestroyComponents() {

    }
}