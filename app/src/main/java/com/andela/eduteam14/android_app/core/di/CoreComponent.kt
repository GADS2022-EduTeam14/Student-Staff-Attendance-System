package com.andela.eduteam14.android_app.core.di

import android.app.Application
import com.andela.eduteam14.android_app.core.data.mock.AttendanceDataSource
import com.andela.eduteam14.android_app.core.data.mock.AttendanceRegistry

class CoreComponent(application: Application) {

    val dataSource: AttendanceDataSource by lazy { provideDataSource() }

    val registry: AttendanceRegistry by lazy { provideRegistry() }

    private fun provideDataSource(): AttendanceDataSource = AttendanceDataSource()

    private fun provideRegistry(): AttendanceRegistry = AttendanceRegistry()
}