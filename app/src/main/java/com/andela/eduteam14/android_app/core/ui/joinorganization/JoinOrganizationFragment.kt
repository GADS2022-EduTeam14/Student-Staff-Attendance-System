package com.andela.eduteam14.android_app.core.ui.joinorganization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.extensions.ShowToast
import com.andela.eduteam14.android_app.databinding.FragmentJoinOrganizationBinding
import com.andela.eduteam14.android_app.databinding.FragmentRegisterBinding

class JoinOrganizationFragment : Fragment(), UiAction {

    private var _binding: FragmentJoinOrganizationBinding? = null

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJoinOrganizationBinding.inflate(inflater, container, false)

        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()


    }

    override fun initViews() {
        ShowToast(requireContext())
    }

    override fun onDestroyComponents() {

    }

}