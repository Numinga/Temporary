package com.numinga.impvault.core.app

import android.app.Application
import com.numinga.impvault.core.PreferenceManager
import com.numinga.impvault.core.ResourceManager
import com.numinga.impvault.core.redux.AppReducer
import com.numinga.impvault.core.redux.AppState
import com.numinga.impvault.core.redux.ReduxModule
import com.numinga.impvault.core.redux.Storage

/**
 * Created by Numinga on 12/10/2017.
 */

class AppContextImpl() : Application(), AppContext {

    private val component: AppComponent

    companion object {
        lateinit var resourceManager: ResourceManager
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    init {
        val appState = AppState()
        val reduxModule = ReduxModule(appState)
        val preferenceManager = PreferenceManager()
        component = DaggerAppComponent.builder()
                .appModule(AppModule(Storage(AppReducer(), appState, reduxModule), this, preferenceManager))
                .build()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}