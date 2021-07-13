package com.mosin.dictionary.model.repository


interface Repository<T> {

    suspend fun getData(word: String): T
}
