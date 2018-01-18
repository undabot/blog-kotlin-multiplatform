package com.undabot.youoweme

import android.app.Application
import coroutineContext
import kotlinx.coroutines.experimental.android.UI

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        coroutineContext = UI
    }
}