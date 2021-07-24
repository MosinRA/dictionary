package com.mosin.dictionary.model.datasource

import com.mosin.dictionary.model.data.AppState
import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.room.HistoryDao
import com.mosin.model.dto.SearchResultDto


class RoomDataBaseImplementation(private val historyDao: HistoryDao) : DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}