package com.mosin.dictionary.di

import com.mosin.dictionary.di.NAME_LOCAL
import com.mosin.dictionary.di.NAME_REMOTE
import dagger.Module
import dagger.Provides
import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.model.datasource.DataSource
import com.mosin.dictionary.model.datasource.RetrofitImplementation
import com.mosin.dictionary.model.datasource.RoomDataBaseImplementation
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.model.repository.RepositoryImplementation
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImplementation()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomDataBaseImplementation()
}
