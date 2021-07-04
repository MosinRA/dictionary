package com.mosin.dictionary.model.repository

import com.mosin.dictionary.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}