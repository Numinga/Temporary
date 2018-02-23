package com.numinga.impvault.core.framework

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by Ivan on 2/2/2018.
 */
class ViewModelFragment<VIEW : View, VIEWMODEL : ViewModel<VIEW>> : Fragment(), ViewModelStorage.ViewModelDelegate<VIEW, VIEWMODEL> {
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

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        key = ViewModelStorage.loadViewModel(savedInstanceState, this)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        viewModel?.bind(this as VIEW)
    }

    override fun onPause() {
        viewModel?.unbind()
        super.onPause()
    }

    override fun onDetach() {
        ViewModelStorage.removeKey(key, this)
        super.onDetach()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        ViewModelStorage.persistKey(key, outState)
    }
}