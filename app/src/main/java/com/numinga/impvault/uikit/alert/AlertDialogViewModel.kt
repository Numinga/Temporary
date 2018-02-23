package com.numinga.impvault.uikit.alert

import android.support.annotation.IdRes
import com.numinga.impvault.R

/**
 * Created by Ivan on 1/21/2018.
 */
class AlertDialogViewModel {
    var id : Int = 0
    var positive : String? = null
    var neutral : String? = null
    var negative : String? = null
    var isError : Boolean = true
    @IdRes var title : Int = R.string.errorTitle
    @IdRes var message : Int = R.string.errorUnknown
    var buttons : List<Int>? = null

    enum class AlertButtons {
        POSITIVE,
        NEUTRAL,
        NEGATIVE
    }
}