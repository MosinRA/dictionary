package com.mosin.dictionary.view.main


import com.mosin.dictionary.model.data.AppState
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.model.repository.RepositoryLocal
import com.mosin.dictionary.utils.mapSearchResultToResult
import com.mosin.dictionary.viewmodel.Interactor
import com.mosin.model.dto.SearchResultDto


class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
