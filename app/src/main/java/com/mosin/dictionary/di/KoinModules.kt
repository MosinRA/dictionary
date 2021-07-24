package com.mosin.dictionary.di

import androidx.room.Room
import com.mosin.dictionary.model.datasource.RetrofitImplementation
import com.mosin.dictionary.model.datasource.RoomDataBaseImplementation
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.model.repository.RepositoryImplementation
import com.mosin.dictionary.model.repository.RepositoryImplementationLocal
import com.mosin.dictionary.model.repository.RepositoryLocal
import com.mosin.dictionary.room.HistoryDataBase
import com.mosin.dictionary.view.main.MainActivity
import com.mosin.dictionary.view.main.MainInteractor
import com.mosin.dictionary.view.main.MainViewModel
import com.mosin.model.dto.SearchResultDto
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module


fun injectDependencies() = loadModules
private val loadModules by lazy {
    loadKoinModules(listOf(application, mainScreen))
}

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}