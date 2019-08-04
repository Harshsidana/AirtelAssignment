package com.appstreet.fitness

import androidx.multidex.MultiDexApplication
import com.appstreet.base.timber.CrashReportTree
import com.appstreet.fitness.di.Modules
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, Modules.getAll())
        Timber.plant(CrashReportTree())
    }
}