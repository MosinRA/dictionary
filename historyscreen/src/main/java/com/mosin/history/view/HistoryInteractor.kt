package com.mosin.history.view

import com.mosin.dictionary.model.data.AppState
import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.model.repository.RepositoryLocal
import com.mosin.dictionary.utils.mapSearchResultToResult
import com.mosin.dictionary.viewmodel.Interactor
import com.mosin.model.dto.SearchResultDto


class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}