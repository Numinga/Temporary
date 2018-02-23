package com.numinga.impvault.core.framework

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Created by Ivan on 2/2/2018.
 */
class ViewModelStorage {


    interface ViewModelDelegate<VIEW : View, VIEWMODEL : ViewModel<VIEW>> {
        fun initViewModelHolder() : ViewModelHolder<VIEW, VIEWMODEL>?

        fun onLoadViewModelHolder(holder : ViewModelHolder<VIEW, VIEWMODEL>)

        fun afterCrash()
    }

    companion object {
        val KEY : String = "VIEW_MODEL_HELPER_KEY"
        val array : IndexArray<ViewModelHolder<*, *>> = IndexArray()

        fun <VIEW : View, VIEWMODEL : ViewModel<VIEW>> loadViewModel(bundle : Bundle?, delegate : ViewModelDelegate<VIEW, VIEWMODEL>) : Int {
            val key : Int

            if (null == bundle) {
                key = put(delegate.initViewModelHolder()!!)
            } else {
                key = bundle.getInt(KEY, 0)
            }

            val holder : ViewModelHolder<VIEW, VIEWMODEL>? = get(key) as ViewModelHolder<VIEW, VIEWMODEL>?
            if (null != holder) {
                delegate.onLoadViewModelHolder(holder)
            } else {
                delegate.afterCrash()
            }

            return key
        }

        fun persistKey(key : Int, bundle : Bundle?) {
            bundle?.putInt(KEY, key)
        }

        fun removeKey(key : Int, activity : FragmentActivity) {
            if (activity.isFinishing) {
                removeKey(key)
            }
        }

        fun removeKey(key : Int, fragment : Fragment) {
            if (isRemoving(fragment)) {
                removeKey(key)
            }
        }

        private fun removeKey(key : Int) {
            val holder : ViewModelHolder<*, *>? = get(key)
        }

        private fun isRemoving(fragment: Fragment) : Boolean {
            return fragment.isRemoving
            || fragment.activity.isFinishing
            || isParentFragmentRemoving(fragment)
        }

        private fun isParentFragmentRemoving(fragment: Fragment) : Boolean {
            var root : Fragment = fragment
            while (null != root.parentFragment) {
                root = root.parentFragment
                if (root.isRemoving)
                    return true
            }

            return false
        }

        private fun put(holder : ViewModelHolder<*, *>) : Int {
            return array.put(holder)
        }

        private fun get(key : Int) : ViewModelHolder<*, *>? {
            return array.get(key)
        }
    }
}