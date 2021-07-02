package com.mosin.dictionary.di

import dagger.Module
import dagger.Provides
import com.mosin.dictionary.model.data.DataModel
import com.mosin.dictionary.model.repository.Repository
import com.mosin.dictionary.view.main.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
