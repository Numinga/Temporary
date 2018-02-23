package com.numinga.impvault.core.framework

/**
 * Created by Ivan on 2/2/2018.
 */
class IndexArray<T> {

    private val list : ArrayList<T> = arrayListOf()

    fun get(index : Int) : T {
        return list[index]
    }

    fun put(holder : T) : Int {
        val index : Int = list.size
        list.add(index, holder)
        return index
    }

    fun remove(index : Int) {
        list.removeAt(index)
    }
}