package com.andela.eduteam14.android_app.core.ui.attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andela.eduteam14.android_app.core.ui.OrganizationBaseActivity
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.home.OrganizationHomeAdapter
import com.andela.eduteam14.android_app.core.ui.viewmodel.OrganizationViewModel
import com.andela.eduteam14.android_app.core.ui.viewmodel.OrganizationViewModelFactory
import com.andela.eduteam14.android_app.databinding.FragmentAttendanceOrganizationBinding
import com.andela.eduteam14.android_app.databinding.FragmentHomeOrganizationBinding

class AttendanceOrganizationFragment : Fragment(), UiAction {

    private var _binding : FragmentAttendanceOrganizationBinding? = null

    private val binding get() = _binding

    private lateinit var recyclerView: RecyclerView
    private lateinit var organizationAdapter: OrganizationHomeAdapter

    private val viewModel: OrganizationViewModel by viewModels {
        OrganizationViewModelFactory(
            (activity as OrganizationBaseActivity).coreComponent.registry,
            (activity as OrganizationBaseActivity).coreComponent.dataSource,
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttendanceOrganizationBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()


        organizationAdapter = OrganizationHomeAdapter(requireContext(), viewModel.attendanceRegistry)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = organizationAdapter
        }

        organizationAdapter.submitList(viewModel.entries)

    }

    override fun initViews() {
        recyclerView = binding?.OrganizationAttendanceRecyclerView!!
    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }

}