package com.mosin.history.view.history

import com.mosin.dictionary.model.data.AppState
import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.model.repository.RepositoryLocal
import com.mosin.dictionary.viewmodel.Interactor


class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}