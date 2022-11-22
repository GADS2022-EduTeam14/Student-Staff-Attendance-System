package com.andela.eduteam14.android_app.core.ui.addschool

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
import com.andela.eduteam14.android_app.databinding.FragmentAddSchoolBinding
import com.andela.eduteam14.android_app.databinding.FragmentRegisterBinding

class AddSchoolFragment : Fragment(), UiAction {

    private var _binding: FragmentAddSchoolBinding? = null
    private val binding get() = _binding

    private lateinit var mainItem: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddSchoolBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        mainItem.onClick { findNavController().navigate(R.id.action_addSchoolFragment_to_joinOrganizationFragment) }
    }

    override fun initViews() {
        mainItem = binding?.MainItem!!
    }

    override fun onDestroyComponents() {

    }


}