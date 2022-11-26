package com.andela.eduteam14.android_app.core.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.data.mock.AttendanceRegistry
import com.andela.eduteam14.android_app.core.data.models.LocalDailyAttendance
import com.andela.eduteam14.android_app.databinding.DailyAttendanceItemBinding

class SchoolHomeAdapter(
    private val context: Context,
    private val registry: AttendanceRegistry,
) : ListAdapter<LocalDailyAttendance, SchoolHomeAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val itemBinding: DailyAttendanceItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(attendance: LocalDailyAttendance) {
            itemBinding.apply {

                totalMalesStaff.text = context.getString(
                    R.string.total_male_staff,
                    registry.numberOfMaleStaff.toString()
                )

                totalFemalesStaff.text = context.getString(
                    R.string.total_female_staff,
                    registry.numberOfFemaleStaff.toString()
                )

                totalMalesStudent.text = context.getString(
                    R.string.male_student,
                    registry.numberOfMaleStudents.toString()
                )

                totalFemalesStudent.text = context.getString(
                    R.string.female_student,
                    registry.numberOfFemaleStudents.toString()
                )

                time.text = attendance.staffAttendance.dateModified

                SchoolName.text = attendance.staffAttendance.schoolName

                MaleStaffPresent.text = context.getString(
                    R.string.male_staff,
                    attendance.staffAttendance.malesPresent.toString()
                )
                FemaleStaffPresent.text = context.getString(
                    R.string.female_staff,
                    attendance.staffAttendance.femalesPresent.toString()
                )

                MaleStudentPresent.text = context.getString(
                    R.string.male_student,
                    attendance.studentAttendance.malesPresent.toString()
                )

                FemaleStudentPresent.text = context.getString(
                    R.string.female_student,
                    attendance.studentAttendance.femalesPresent.toString()
                )

                MaleStaffAbsent.text = context.getString(
                    R.string.male_staff,
                    (registry.numberOfMaleStaff - attendance.staffAttendance.malesPresent).toString()
                )

                FemaleStaffAbsent.text = context.getString(
                    R.string.female_staff,
                    (registry.numberOfFemaleStaff - attendance.staffAttendance.femalesPresent).toString()
                )


                MaleStudentAbsent.text = context.getString(
                    R.string.male_student,
                    (registry.numberOfMaleStudents - attendance.studentAttendance.malesPresent).toString()
                )

                FemaleStudentAbsent.text = context.getString(
                    R.string.female_student,
                    (registry.numberOfFemaleStudents - attendance.studentAttendance.femalesPresent).toString()
                )
            }
        }
    }

    private class DiffUtilCallback :
        DiffUtil.ItemCallback<LocalDailyAttendance>() {
        override fun areItemsTheSame(
            oldItem: LocalDailyAttendance,
            newItem: LocalDailyAttendance
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: LocalDailyAttendance,
            newItem: LocalDailyAttendance
        ): Boolean {
            return oldItem.attendanceId == newItem.attendanceId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DailyAttendanceItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}