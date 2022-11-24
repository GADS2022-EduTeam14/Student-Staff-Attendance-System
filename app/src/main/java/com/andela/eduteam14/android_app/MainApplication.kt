package com.andela.eduteam14.android_app

import android.app.Application
import com.andela.eduteam14.android_app.core.di.CoreComponent

class MainApplication : Application() {
    val coreComponent: CoreComponent by lazy { CoreComponent(this) }
}