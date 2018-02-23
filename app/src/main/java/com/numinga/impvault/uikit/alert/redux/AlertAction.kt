package com.numinga.impvault.uikit.alert.redux

import android.support.annotation.IdRes
import com.numinga.impvault.R
import com.numinga.impvault.core.redux.Action

/**
 * Created by Ivan on 1/21/2018.
 */
data class AlertAction(val id : Int = 0,
        @IdRes val title : Int = R.string.errorTitle,
        @IdRes val message: Int = R.string.errorUnknown,
        val isError: Boolean = true,
        val buttons : List<Int> = listOf(R.string.ok)) : Action