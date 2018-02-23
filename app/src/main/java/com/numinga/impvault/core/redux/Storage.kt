package com.numinga.impvault.core.redux

import com.orhanobut.logger.Logger

/**
 * Created by Ivan on 1/14/2018.
 */

class Storage<in STATE>(private var reducer : Reducer<STATE>, private var state: STATE, private val listener: OnStateChanged<STATE>) : Dispatcher {

    override fun dispatch(action: Action) {
        Logger.d("Action: " + action::class.java.simpleName)

        val newState : STATE = reducer.reduce(state, action)
        if (!isEqualState(newState)) {
            state = newState
            listener.onChange(newState)
        }
    }

    private fun isEqualState(newState : STATE): Boolean {
        return if (null != state)
            state == newState
        else
            null == newState
    }

    interface OnStateChanged<in STATE> {
        fun onChange(state : STATE)
    }
}