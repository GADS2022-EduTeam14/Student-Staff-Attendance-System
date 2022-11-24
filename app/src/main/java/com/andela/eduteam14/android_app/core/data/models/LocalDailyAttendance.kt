package com.andela.eduteam14.android_app.core.data.models

import java.util.UUID

data class LocalDailyAttendance(
    val attendanceId: String,
    val studentAttendance: LocalStudentAttendance,
    val staffAttendance: LocalStaffAttendance,
) {
    companion object {
        val Default = LocalDailyAttendance(
            attendanceId = UUID.randomUUID().toString(),
            studentAttendance = LocalStudentAttendance.Default,
            staffAttendance = LocalStaffAttendance.Default,
        )
    }


}