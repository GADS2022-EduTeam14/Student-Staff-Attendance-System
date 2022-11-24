package com.andela.eduteam14.android_app.core.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andela.eduteam14.android_app.core.data.models.LocalAttendanceHistory
import com.andela.eduteam14.android_app.databinding.AttendanceHistoryItemBinding

class HistorySchoolAdapter :
    ListAdapter<LocalAttendanceHistory, HistorySchoolAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val itemBinding: AttendanceHistoryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(history: LocalAttendanceHistory) {
            itemBinding.apply {
                HistorySchoolName.text = history.schoolName
                HistoryState.text = history.status
                HistoryDate.text = history.date
            }
        }
    }

    private class DiffUtilCallback : DiffUtil.ItemCallback<LocalAttendanceHistory>() {
        override fun areItemsTheSame(
            oldItem: LocalAttendanceHistory,
            newItem: LocalAttendanceHistory
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: LocalAttendanceHistory,
            newItem: LocalAttendanceHistory
        ): Boolean {
            return oldItem.historyId == newItem.historyId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AttendanceHistoryItemBinding.inflate(
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