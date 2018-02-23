package com.numinga.impvault.core.app

import com.numinga.impvault.core.redux.ReduxModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ivan on 12/10/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ReduxModule::class))
interface AppComponent {
    fun inject(appContext: AppContext)
}