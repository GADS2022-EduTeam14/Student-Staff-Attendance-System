package com.andela.eduteam14.android_app.core.ui.attendance

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.data.mock.AttendanceRegistry
import com.andela.eduteam14.android_app.core.domain.usecase.ChooseMemberDialogUseCase
import com.andela.eduteam14.android_app.core.domain.usecase.ChooseOrganizationDialogUseCase
import com.andela.eduteam14.android_app.core.ui.SchoolBaseActivity
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.extensions.onClick
import com.andela.eduteam14.android_app.core.ui.home.SchoolHomeAdapter
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModel
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModelFactory
import com.andela.eduteam14.android_app.databinding.FragmentAttendanceSchoolBinding

class AttendanceSchoolFragment : Fragment(), UiAction {
    private var _binding: FragmentAttendanceSchoolBinding? = null

    private val binding get() = _binding

    private lateinit var dialogUseCase: ChooseMemberDialogUseCase

    private lateinit var recyclerView: RecyclerView
    private lateinit var homeAdapter: SchoolHomeAdapter
    private lateinit var registry: AttendanceRegistry

    private val viewModel: SchoolViewModel by viewModels {
        SchoolViewModelFactory(
            (activity as SchoolBaseActivity).coreComponent.registry,
            (activity as SchoolBaseActivity).coreComponent.dataSource,
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        registry = (activity as SchoolBaseActivity).coreComponent.registry
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttendanceSchoolBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        dialogUseCase = ChooseMemberDialogUseCase(requireContext(), this)

        (activity as SchoolBaseActivity).showFab()

        homeAdapter = SchoolHomeAdapter(requireContext(), registry)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }

        homeAdapter.submitList(viewModel.entries)

        (activity as SchoolBaseActivity).recordFab.onClick { loadDialog() }

    }

    private fun loadDialog() {
        dialogUseCase(
            onChooseStaff = {
                findNavController().navigate(
                    R.id.action_attendanceSchoolFragment_to_staffAttendanceFragment
                )
            },

            onChooseStudent = {
                findNavController().navigate(
                    R.id.action_attendanceSchoolFragment_to_studentAttendanceFragment
                )
            },
        )
    }

    override fun initViews() {
        recyclerView = binding?.SchoolAttendanceRecyclerView!!

    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }
}