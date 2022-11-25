package com.andela.eduteam14.android_app.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andela.eduteam14.android_app.core.data.mock.AttendanceDataSource
import com.andela.eduteam14.android_app.core.data.mock.AttendanceRegistry

class OrganizationViewModel(
    private val registry: AttendanceRegistry,
    private val datasource: AttendanceDataSource,
) : ViewModel() {
    val entries = datasource.allDailies

    val history = datasource.history

    val attendanceRegistry = registry

}


@Suppress("UNCHECKED_CAST")
class OrganizationViewModelFactory(
    private val registry: AttendanceRegistry,
    private val datasource: AttendanceDataSource,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(OrganizationViewModel::class.java)) {
            OrganizationViewModel(registry, datasource) as T
        } else throw IllegalArgumentException("Unknown ViewModel class")
    }
}