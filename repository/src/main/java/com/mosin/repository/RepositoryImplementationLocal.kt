package com.mosin.dictionary.model.repository

import com.mosin.dictionary.model.data.AppState
import com.mosin.dictionary.model.datasource.DataSourceLocal
import com.mosin.model.dto.SearchResultDto

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResultDto>>) :
    RepositoryLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}