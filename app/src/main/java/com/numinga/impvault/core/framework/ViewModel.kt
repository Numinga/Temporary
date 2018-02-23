package com.numinga.impvault.core.framework

/**
 * Created by Ivan on 1/13/2018.
 */

interface ViewModel<in T : View> {

    fun destroy()

    fun bind(view : T)

    fun unbind()
}