package com.andela.eduteam14.android_app.core.ui.auth

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.extensions.onClick
import com.andela.eduteam14.android_app.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), UiAction {

    private lateinit var createAccountBtn: Button
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding

    private lateinit var login: TextView


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

        createAccountBtn.onClick {
            loadDialog()
        }

        login.onClick {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun loadDialog() {
        showDialog(
            onChooseOrganization = {
                findNavController().navigate(
                    R.id.action_registerFragment_to_emailVerificationFragment
                )
            },
            onChooseSchool = {
                findNavController().navigate(
                    R.id.action_registerFragment_to_emailVerificationFragment
                )
            }
        )
    }

    private fun showDialog(
        onChooseOrganization: () -> Unit,
        onChooseSchool: () -> Unit,
    ) {
        val builder = AlertDialog.Builder(
            requireContext(),
            R.style.CustomAlertDialog
        ).create()

        val view =
            layoutInflater.inflate(R.layout.choose_organization_dialog_layout, null)

        val chooseOrganization =
            view.findViewById<Button>(R.id.ChooseOrganization)

        chooseOrganization.onClick {
            builder.dismiss()
            onChooseOrganization()
        }

        val chooseSchool =
            view.findViewById<Button>(R.id.ChooseSchool)

        chooseSchool.onClick {
            builder.dismiss()
            onChooseSchool()
        }

        builder.setView(view)

        builder.setCanceledOnTouchOutside(true)

        builder.show()
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