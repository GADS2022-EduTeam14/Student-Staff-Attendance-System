package com.andela.eduteam14.android_app.core.ui.attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.data.models.LocalClassAttendance
import com.andela.eduteam14.android_app.core.domain.usecase.ChooseOrganizationDialogUseCase
import com.andela.eduteam14.android_app.core.ui.SchoolBaseActivity
import com.andela.eduteam14.android_app.core.ui.UiAction
import com.andela.eduteam14.android_app.core.ui.extensions.onClick
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModel
import com.andela.eduteam14.android_app.core.ui.viewmodel.SchoolViewModelFactory
import com.andela.eduteam14.android_app.databinding.FragmentStudentAttendanceBinding
import com.google.android.material.textfield.TextInputEditText

class StudentAttendanceFragment : Fragment(), UiAction {

    private var _binding: FragmentStudentAttendanceBinding? = null
    private val binding get() = _binding

    private lateinit var next: Button
    private lateinit var previous: Button

    private lateinit var males: TextInputEditText
    private lateinit var females: TextInputEditText
    private lateinit var className: TextView

    private val viewModel: SchoolViewModel by viewModels {
        SchoolViewModelFactory(
            (activity as SchoolBaseActivity).coreComponent.registry,
            (activity as SchoolBaseActivity).coreComponent.dataSource,
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentAttendanceBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        (activity as SchoolBaseActivity).recordFab.hide()


        viewModel.initAttendanceList()

        viewModel.getClassAttendanceById(viewModel.currentClass) {
            bind(it)
        }

        processClassNavigation()


    }


    private fun processClassNavigation() {
        next.onClick {
            viewModel.next(
                onResult = {
                    bind(it)
                },
                onCommit = {
                },
            )
        }

        previous.onClick {
            Toast.makeText(requireContext(), "Previous", Toast.LENGTH_SHORT).show()
        }
    }

    private fun bind(attendance: LocalClassAttendance) {
        className.text = attendance.className
        males.setText(attendance.maleStudents.toString())
        females.setText(attendance.femaleStudents.toString())
    }


    override fun initViews() {
        next = binding?.StudentAttendanceFragmentNextBtn!!
        previous = binding?.StudentAttendanceFragmentPreviousBtn!!
        className = binding?.className!!
        males = binding?.StudentAttendanceFragmentMaleEdit!!
        females = binding?.StudentAttendanceFragmentFemaleEdit!!
    }

    override fun onDestroyComponents() {
        _binding = null
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }
}