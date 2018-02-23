package com.numinga.impvault.ui.login.redux

import com.numinga.impvault.core.redux.Action
import com.numinga.impvault.core.redux.Reducer

/**
 * Created by Ivan on 1/21/2018.
 */
class LoginReducer : Reducer<LoginState> {

    override fun reduce(lastState: LoginState, action: Action): LoginState {
        when (action::class.java.simpleName) {
            LoginInitAction::class.java.simpleName -> {
                return LoginState()
            }
            LoginFinishAction::class.java.simpleName -> {
                return lastState
                        .copy(mode = LoginState.Mode.Finish,
                                actor = LoginState.Actor.Init)
            }
            LoginConfirmAction::class.java.simpleName -> {
                val loginConfirmAction: LoginConfirmAction = action as LoginConfirmAction
                return lastState
                        .copy(actor = LoginState.Actor.Confirm,
                                login = loginConfirmAction.login,
                                pass = loginConfirmAction.pass)
            }
        }
        return lastState
    }
}