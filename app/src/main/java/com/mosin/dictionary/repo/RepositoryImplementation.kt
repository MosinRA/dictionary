package com.mosin.dictionary.repo

import com.mosin.data.DataModel
import com.mosin.dictionary.datasource.DataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    private val cache = mutableMapOf<String, List<DataModel>>()

    override fun getData(word: String): Observable<List<DataModel>> {
        if (cache.containsKey(word)) return Observable.just(cache[word])
        return dataSource.getData(word)
            .doOnNext { cache[word] = it }
    }
}