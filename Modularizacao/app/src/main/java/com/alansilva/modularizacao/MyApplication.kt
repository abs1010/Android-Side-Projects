package com.alansilva.modularizacao

import android.app.Application
import com.alansilva.data.di.dataModules
import com.alansilva.modularizacao.di.presentationModule
import di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}
