package com.numinga.impvault.core.framework

import android.databinding.BaseObservable
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by Ivan on 1/14/2018.
 */
abstract class ViewModelObservable<in T : View> : BaseObservable(), ViewModel<T> {
    private var initialized : Boolean = false
    private var internalView : T? = null
    private var subscriptions : CompositeSubscription = CompositeSubscription()

    /**
     * Called once when view is attached.
     * Can be used for first initialization like inserting first fragment
     */
    private fun init() {
    }

    override fun destroy() {
    }

    override fun bind(view: T) {
        internalView = view

        if (!initialized) {
            init()
            initialized = true
        }
    }

    override fun unbind() {
        subscriptions.clear()
        internalView = null
    }

    protected fun subscribe(subscription : Subscription) {
        subscriptions.add(subscription)
    }
}