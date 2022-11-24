package com.andela.eduteam14.android_app.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andela.eduteam14.android_app.core.data.mock.AttendanceDataSource
import com.andela.eduteam14.android_app.core.data.mock.AttendanceRegistry

class SchoolViewModel(
    private val registry: AttendanceRegistry,
    private val datasource: AttendanceDataSource,
) : ViewModel() {
    val entries = datasource.allDailies
}


@Suppress("UNCHECKED_CAST")
class SchoolViewModelFactory(
    private val registry: AttendanceRegistry,
    private val datasource: AttendanceDataSource,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SchoolViewModel::class.java)) {
            SchoolViewModel(registry, datasource) as T
        } else throw IllegalArgumentException("Unknown ViewModel class")
    }
}