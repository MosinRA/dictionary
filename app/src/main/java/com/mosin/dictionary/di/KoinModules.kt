package com.mosin.dictionary.di

import androidx.room.Room
import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.model.datasource.RetrofitImplementation
import com.mosin.dictionary.model.datasource.RoomDataBaseImplementation
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.model.repository.RepositoryImplementation
import com.mosin.dictionary.model.repository.RepositoryImplementationLocal
import com.mosin.dictionary.model.repository.RepositoryLocal
import com.mosin.dictionary.room.HistoryDataBase
import com.mosin.dictionary.view.main.MainInteractor
import com.mosin.dictionary.view.main.MainViewModel
import com.mosin.history.view.history.HistoryInteractor
import com.mosin.history.view.history.HistoryViewModel
import org.koin.dsl.module


val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(
        RoomDataBaseImplementation(get())
    )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}