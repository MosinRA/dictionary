package com.mosin.dictionary.model.repository

import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
