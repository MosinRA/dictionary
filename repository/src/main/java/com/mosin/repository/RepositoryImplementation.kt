package com.mosin.dictionary.model.repository

import com.mosin.dictionary.model.datasource.DataSource
import com.mosin.model.dto.SearchResultDto

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}

