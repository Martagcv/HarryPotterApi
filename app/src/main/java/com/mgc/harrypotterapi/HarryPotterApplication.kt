package com.mgc.harrypotterapi

import android.app.Application
import com.mgc.harrypotterapi.di.dataModule
import com.mgc.harrypotterapi.di.domainModule
import com.mgc.harrypotterapi.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class HarryPotterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@HarryPotterApplication)

            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}
