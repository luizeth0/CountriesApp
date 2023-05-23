package com.challenge.countriesapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.countriesapp.model.CountryResponse
import com.challenge.countriesapp.rest.CountriesRepository
import com.challenge.countriesapp.rest.CountriesRepositoryImpl
import com.challenge.countriesapp.rest.ServiceApi
import com.challenge.countriesapp.utils.UIState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CountryViewModel(
): ViewModel() {

    private val countryRepository  = CountriesRepositoryImpl()
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val _country: MutableStateFlow<UIState<List<CountryResponse>>> = MutableStateFlow(UIState.LOADING)
    val country: StateFlow<UIState<List<CountryResponse>>> get() = _country

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch(ioDispatcher) {
            countryRepository.getCountries().collect{
                _country.value = it
            }
        }
    }

}