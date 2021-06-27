package com.mosin.dictionary.presenter

import com.mosin.data.AppState
import com.mosin.dictionary.base.BaseView

interface Presenter<T : AppState, V : BaseView> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
