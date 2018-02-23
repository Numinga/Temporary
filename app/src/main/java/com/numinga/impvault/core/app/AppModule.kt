package com.numinga.impvault.core.app

import com.numinga.impvault.core.PreferenceManager
import com.numinga.impvault.core.redux.AppState
import com.numinga.impvault.core.redux.Storage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ivan on 12/10/2017.
 */

@Module
class AppModule(private val storage: Storage<AppState>,
                private val app: AppContext,
                private val preferenceManager: PreferenceManager) {
    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideContext(): AppContext = app
}