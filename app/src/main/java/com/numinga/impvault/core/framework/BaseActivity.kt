package com.numinga.impvault.core.framework

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import com.numinga.impvault.core.app.AppContext

/**
 * Created by Ivan on 1/13/2018.
 */
class BaseActivity<VIEW : View, VIEWMODEL : ViewModel<VIEW>> : ViewModelActivity<VIEW, VIEWMODEL>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        create()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        create()
    }

    private fun create() {

    }

    private fun getAppContext(): AppContext {
        return this.application as AppContext
    }
}