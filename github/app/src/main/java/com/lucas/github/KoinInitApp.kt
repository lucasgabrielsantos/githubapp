package com.lucas.github

import android.app.Application
import com.lucas.github.di.KoinInitializer

class KoinInitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer.initialize(this)
    }
}