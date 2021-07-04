package com.mosin.dictionary.di

import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.model.datasource.RetrofitImplementation
import com.mosin.dictionary.model.datasource.RoomDataBaseImplementation
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.model.repository.RepositoryImplementation
import com.mosin.dictionary.view.main.MainInteractor
import com.mosin.dictionary.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}