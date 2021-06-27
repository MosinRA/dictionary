package com.mosin.dictionary.repo

import io.reactivex.Observable

interface Repository<T> {

    fun getData(word: String): Observable<T>
}
