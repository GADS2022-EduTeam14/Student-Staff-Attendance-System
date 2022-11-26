package com.andela.eduteam14.android_app.core.data.models

import java.util.UUID

data class LocalStaffAttendance(
    val attendanceId: String,
    val numberOfMales: Long,
    val numberOfFemales: Long,
    val malesPresent: Long,
    val femalesPresent: Long,
    val schoolName: String,
    val dateModified: String,

    ) {

    companion object {
        val Default = LocalStaffAttendance(
            attendanceId = UUID.randomUUID().toString(),
            numberOfMales = 30,
            numberOfFemales = 40,
            malesPresent = 27,
            femalesPresent = 32,
            schoolName = "Maryland International College",
            dateModified = "March 13, 2022"
        )
    }

}