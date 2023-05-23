package com.challenge.countriesapp.rest

import android.util.Log
import com.challenge.countriesapp.model.CountryResponse
import com.challenge.countriesapp.utils.FailureResponse
import com.challenge.countriesapp.utils.NullResponse
import com.challenge.countriesapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface CountriesRepository{
    fun getCountries(): Flow<UIState<List<CountryResponse>>>
}

class CountriesRepositoryImpl : CountriesRepository {

    override fun getCountries(): Flow<UIState<List<CountryResponse>>> = flow {
        emit(UIState.LOADING)
        try {
            val response = RetrofitHelper.service.getCountries()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it))
                } ?: throw NullResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }

        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }

    }
}
