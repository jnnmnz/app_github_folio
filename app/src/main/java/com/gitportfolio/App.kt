package com.gitportfolio

import android.app.Application
import com.gitportfolio.data.di.DataModule
import com.gitportfolio.domain.di.DomainModule
import com.gitportfolio.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
        }
        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}