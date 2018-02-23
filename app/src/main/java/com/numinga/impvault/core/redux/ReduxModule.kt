package com.numinga.impvault.core.redux

import dagger.Module
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Ivan on 1/14/2018.
 */

@Module
class ReduxModule : Storage.OnStateChanged<AppState> {

    private val appState: BehaviorSubject<AppState>

    constructor(state: AppState) {
        appState = BehaviorSubject.createDefault(state)
    }

    override fun onChange(state: AppState) {
        appState.onNext(state)
    }

    private fun <STATE>checkAndNotify(subject : BehaviorSubject<STATE>, state : STATE) {
        if (state != subject.value){
            subject.onNext(state)
        }
    }
}