package com.numinga.impvault.uikit.alert.redux

import com.numinga.impvault.core.redux.Action
import com.numinga.impvault.uikit.alert.AlertDialogViewModel

/**
 * Created by Ivan on 1/21/2018.
 */
class AlertClickAction(val button: AlertDialogViewModel.AlertButtons? = null) : Action