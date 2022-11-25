package com.andela.eduteam14.android_app.core.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.domain.usecase.ChooseOrganizationDialogUseCase
import com.andela.eduteam14.android_app.core.ui.OrganizationBaseActivity
import com.andela.eduteam14.android_app.core.ui.SchoolBaseActivity
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.extensions.goto
import com.andela.eduteam14.android_app.core.ui.extensions.onClick
import com.andela.eduteam14.android_app.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), UiAction {

    private lateinit var createAccountBtn: Button
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding

    private lateinit var login: TextView

    private lateinit var dialogUseCase: ChooseOrganizationDialogUseCase


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        dialogUseCase = ChooseOrganizationDialogUseCase(requireContext(), this)

        createAccountBtn.onClick {
            loadDialog()
        }

        login.onClick {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun loadDialog() {
       dialogUseCase(
           onChooseSchool = {
               (activity as AuthActivity).goto(SchoolBaseActivity::class.java)
           },
           onChooseOrganization = {
               (activity as AuthActivity).goto(OrganizationBaseActivity::class.java)
           }
       )
    }



    override fun initViews() {
        createAccountBtn = binding?.RegisterFragmentRegisterBtn!!
        login = binding?.OldUser!!
    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }
}