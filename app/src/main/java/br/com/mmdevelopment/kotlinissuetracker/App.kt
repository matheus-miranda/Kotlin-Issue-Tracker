package br.com.mmdevelopment.kotlinissuetracker

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Default class when app starts
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }
    }
}