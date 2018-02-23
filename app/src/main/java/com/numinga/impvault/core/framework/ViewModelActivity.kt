package com.numinga.impvault.core.framework

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity

/**
 * Created by Ivan on 2/2/2018.
 */
abstract class ViewModelActivity<VIEW : View, VIEWMODEL : ViewModel<VIEW>> : FragmentActivity(), ViewModelStorage.ViewModelDelegate<VIEW, VIEWMODEL> {

    var viewModel : VIEWMODEL? = null

    var key : Int = 0

    fun initViewModel() {

    }

    override fun initViewModelHolder(): ViewModelHolder<VIEW, VIEWMODEL>? {
        initViewModel()

        return ViewModelHolder(viewModel)
    }

    override fun onLoadViewModelHolder(holder: ViewModelHolder<VIEW, VIEWMODEL>) {
        viewModel = holder.viewModel
    }

    override fun afterCrash() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        key = ViewModelStorage.loadViewModel(savedInstanceState, this)
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        super.onResume()
        viewModel?.bind(this as VIEW)
    }

    override fun onPause() {
        viewModel?.unbind()
        super.onPause()
    }

    override fun onDestroy() {
        ViewModelStorage.removeKey(key, this)
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        ViewModelStorage.persistKey(key, outState)
    }
}