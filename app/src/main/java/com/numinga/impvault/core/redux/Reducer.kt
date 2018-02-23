package com.numinga.impvault.core.redux

/**
 * Created by Ivan on 1/14/2018.
 */
interface Reducer<STATE> {
    fun reduce(lastState : STATE, action : Action): STATE
}