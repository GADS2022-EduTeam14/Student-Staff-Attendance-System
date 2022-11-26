package com.andela.eduteam14.android_app.core.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.andela.eduteam14.android_app.core.data.mock.AttendanceDataSource
import com.andela.eduteam14.android_app.core.data.mock.AttendanceRegistry
import com.andela.eduteam14.android_app.core.data.models.LocalClassAttendance
import kotlinx.coroutines.launch

class SchoolViewModel(
    private val registry: AttendanceRegistry,
    private val datasource: AttendanceDataSource,
) : ViewModel() {
    val entries = datasource.allDailies

    val history = datasource.history

    val attendanceRegistry = registry

    var currentClass = 1

    var classHasNext = currentClass < registry.numberOfClasses

    var classHasPrevious = currentClass > 1 && currentClass <= registry.numberOfClasses

    var isLowestClass = currentClass == 1

    var isHighestClass = currentClass == registry.numberOfClasses

    private var _classAttendanceList: ArrayList<LocalClassAttendance> =
        ArrayList(registry.numberOfClasses)

    fun initAttendanceList() {
        viewModelScope.launch {
            val container = arrayListOf<LocalClassAttendance>()
            for (i in 0 until registry.numberOfClasses) {
                container.add(
                    LocalClassAttendance(
                        classId = i + 1,
                        className = "Grade ${i + 1}",
                    )
                )
            }
            _classAttendanceList.addAll(container)
        }
    }

    fun getClassAttendanceById(id: Int, onResult: (LocalClassAttendance) -> Unit) {
        val current = _classAttendanceList.filter { it.classId == id }
        onResult(current[0])
    }

    fun next(onResult: (LocalClassAttendance) -> Unit, onCommit: () -> Unit) {
        if (classHasNext) {
            currentClass += 1
            getClassAttendanceById(currentClass, onResult)
        }

        if (isHighestClass) {
            onCommit()
        }
    }

    fun previous(onResult: (LocalClassAttendance) -> Unit, onApproachLastClass: () -> Unit) {
        if (classHasPrevious) {
            currentClass -= 1
            getClassAttendanceById(currentClass, onResult)
        }

        if (isLowestClass) {
            onApproachLastClass()
        }
    }


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