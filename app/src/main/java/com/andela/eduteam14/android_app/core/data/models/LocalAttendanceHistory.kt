package com.andela.eduteam14.android_app.core.data.models

import java.util.UUID

data class LocalAttendanceHistory(
    val historyId: String,
    val schoolName: String,
    val status: String,
    val date: String,
) {
    companion object {
        val Default = LocalAttendanceHistory(
            historyId = UUID.randomUUID().toString(),
            schoolName = "Maryland International College",
            status = "Received by The Federal Ministry of Education Abuja, Nigeria.",
            date = "March 12, 2022"
        )
    }
}