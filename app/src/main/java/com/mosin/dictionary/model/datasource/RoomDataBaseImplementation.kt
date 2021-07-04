package com.mosin.dictionary.model.datasource

import com.mosin.dictionary.model.data.AppState
import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.room.HistoryDao
import com.mosin.dictionary.utils.convertDataModelSuccessToEntity
import com.mosin.dictionary.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}