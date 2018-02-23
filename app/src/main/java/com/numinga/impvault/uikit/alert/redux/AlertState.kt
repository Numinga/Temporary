package com.numinga.impvault.uikit.alert.redux

import android.support.annotation.IdRes
import com.numinga.impvault.R
import com.numinga.impvault.uikit.alert.AlertDialogViewModel

/**
 * Created by Ivan on 1/21/2018.
 */
data class AlertState(private val mode: Mode = Mode.Finish,
                      private val id : Int = 0,
                      @IdRes private val title: Int = R.string.errorTitle,
                      @IdRes private val message: Int = R.string.errorUnknown,
                      private val isError: Boolean = true,
                      private val buttons: List<Int> = listOf(R.string.ok),
                      private val button : AlertDialogViewModel.AlertButtons? = null) {

    enum class Mode {
        Init,
        Click,
        Finish
    }
}