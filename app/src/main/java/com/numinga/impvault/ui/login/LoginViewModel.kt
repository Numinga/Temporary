package com.numinga.impvault.ui.login

import com.numinga.impvault.core.PreferenceManager
import com.numinga.impvault.core.ResourceManager
import javax.inject.Inject

/**
 * Created by Ivan on 1/21/2018.
 */
class LoginViewModel @Inject constructor(var preferenceManager: PreferenceManager) {
    private var login : String = ""
    private var pass : String = ""

    fun confirm() {
        if (login.isEmpty()) {

        } else if (pass.isEmpty()) {

        } else {

        }
    }

    interface LoginView {

    }
}