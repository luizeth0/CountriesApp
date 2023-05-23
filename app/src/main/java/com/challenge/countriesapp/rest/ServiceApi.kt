package com.challenge.countriesapp.rest

import com.challenge.countriesapp.model.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("countries.json")
    suspend fun getCountries(): Response<List<CountryResponse>>


    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/"
    }


}