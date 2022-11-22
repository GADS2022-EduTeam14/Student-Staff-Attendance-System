package com.andela.eduteam14.android_app.core.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.OrganizationBaseActivity
import com.andela.eduteam14.android_app.core.ui.SchoolBaseActivity
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.extensions.ShowToast
import com.andela.eduteam14.android_app.core.ui.extensions.goto
import com.andela.eduteam14.android_app.core.ui.extensions.onClick
import com.andela.eduteam14.android_app.core.ui.extensions.onLongClick
import com.andela.eduteam14.android_app.databinding.FragmentLoginBinding
import com.andela.eduteam14.android_app.databinding.FragmentRegisterBinding

class LoginFragment : Fragment(), UiAction {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding

    private lateinit var login: Button
    private lateinit var registerInstead: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        registerInstead.onClick { findNavController().navigate(R.id.action_loginFragment_to_registerFragment) }

        login.onClick { (activity as AuthActivity).goto(SchoolBaseActivity::class.java) }

    }

    override fun initViews() {
        login = binding?.LoginFragmentLoginBtn!!
        registerInstead = binding?.NewUser!!
    }

    override fun onDestroyComponents() {

    }
}