package com.andela.eduteam14.android_app.core.data.models

import java.util.UUID

data class LocalStudentAttendance(
    val attendanceId: String,
    val numberOfMales: Long,
    val numberOfFemales: Long,
    val malesPresent: Long,
    val femalesPresent: Long,
    val schoolName: String,
    val dateModified: String,

    ) {
    companion object {
        val Default = LocalStudentAttendance(
            attendanceId = UUID.randomUUID().toString(),
            numberOfMales = 2030,
            numberOfFemales = 4000,
            malesPresent = 2027,
            femalesPresent = 3992,
            schoolName = "Maryland International College",
            dateModified = "March 13, 2022"
        )
    }

}