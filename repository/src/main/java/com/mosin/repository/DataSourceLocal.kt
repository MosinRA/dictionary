package com.mosin.dictionary.model.datasource

import com.mosin.dictionary.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}