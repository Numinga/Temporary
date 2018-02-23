package com.numinga.impvault.ui.login.redux

/**
 * Created by Ivan on 1/21/2018.
 */

data class LoginState(val mode:Mode = Mode.Login, val actor: Actor = Actor.Init, val login:String? = null, val pass:String? = null) {
    enum class Mode {
        Init,
        Login,
        Finish
    }

    enum class Actor {
        Init,
        Confirm
    }
}