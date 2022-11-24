package com.andela.eduteam14.android_app.core.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andela.eduteam14.android_app.MainApplication
import com.andela.eduteam14.android_app.core.data.mock.AttendanceRegistry
import com.andela.eduteam14.android_app.core.ui.SchoolBaseActivity
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModel
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModelFactory
import com.andela.eduteam14.android_app.databinding.FragmentHomeSchoolBinding

class HomeSchoolFragment : Fragment(), UiAction {

    private var _binding: FragmentHomeSchoolBinding? = null

    private val binding get() = _binding

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
        _binding = FragmentHomeSchoolBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        homeAdapter = SchoolHomeAdapter(requireContext(), registry)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }

        homeAdapter.submitList(viewModel.entries)

    }


    override fun initViews() {
        recyclerView = binding?.SchoolHomeRecyclerView!!
    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }
}