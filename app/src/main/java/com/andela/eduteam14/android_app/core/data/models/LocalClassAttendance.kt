package com.andela.eduteam14.android_app.core.data.models

data class LocalClassAttendance(
    val classId: Int,
    val className: String,
    val maleStudents: Long = 0,
    val femaleStudents: Long = 0,
) {
    companion object {
        val Default = LocalClassAttendance(
            classId = 1,
            className = "Grade 1",
            maleStudents = 23,
            femaleStudents = 12,
        )
    }
}