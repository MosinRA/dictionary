package com.mosin.repository.api

import com.mosin.model.dto.SearchResultDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<SearchResultDto>>
}

