package com.numinga.impvault.uikit.alert.redux

import com.numinga.impvault.core.redux.Action
import com.numinga.impvault.core.redux.Reducer

/**
 * Created by Ivan on 1/21/2018.
 */
class AlertReducer : Reducer<AlertState> {
    override fun reduce(lastState: AlertState, action: Action): AlertState {
        when (action::class.java.simpleName) {
            AlertAction::class.java.simpleName -> {
                val alertAction : AlertAction = action as AlertAction
                return AlertState(AlertState.Mode.Init, alertAction.id, alertAction.title, alertAction.message, alertAction.isError, alertAction.buttons)
            }
            AlertClickAction::class.java.simpleName -> {
                val alertClickAction: AlertClickAction = action as AlertClickAction
                return lastState.copy(AlertState.Mode.Finish, button = alertClickAction.button)
            }
        }
        return lastState
    }
}