package com.andela.eduteam14.android_app.core.ui.history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andela.eduteam14.android_app.core.ui.SchoolBaseActivity
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.home.SchoolHomeAdapter
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModel
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModelFactory
import com.andela.eduteam14.android_app.databinding.FragmentHistorySchoolBinding
import com.andela.eduteam14.android_app.databinding.FragmentHomeSchoolBinding

class HistorySchoolFragment : Fragment(), UiAction {

    private var _binding: FragmentHistorySchoolBinding? = null
    private val binding get() = _binding

    private lateinit var recyclerView: RecyclerView
    private lateinit var historyAdapter: HistorySchoolAdapter

    private val viewModel: SchoolViewModel by viewModels {
        SchoolViewModelFactory(
            (activity as SchoolBaseActivity).coreComponent.registry,
            (activity as SchoolBaseActivity).coreComponent.dataSource,
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistorySchoolBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        (activity as SchoolBaseActivity).hideFab()

        historyAdapter = HistorySchoolAdapter()


        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = historyAdapter
        }

        historyAdapter.submitList(viewModel.history)

    }


    override fun initViews() {
        recyclerView = binding?.HistorySchoolRecyclerView!!
    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }

}