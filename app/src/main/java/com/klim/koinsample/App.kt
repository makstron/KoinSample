package com.klim.koinsample

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.klim.koinsample.data.di.dataSourcesModule
import com.klim.koinsample.data.di.dbModule
import com.klim.koinsample.data.di.repositoriesModule
import com.klim.koinsample.data.di.retrofitModule
import com.klim.koinsample.domain.di.useCasesModule
import com.klim.koinsample.ui.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // start a KoinApplication in Global context
        startKoin {
            // use Android logger - Level.INFO by default
            androidLogger(Level.DEBUG)
            //inject Android context
            androidContext(this@App)
            // declare used modules
            modules(viewModelsModule + useCasesModule + repositoriesModule + dataSourcesModule + dbModule + retrofitModule)
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}