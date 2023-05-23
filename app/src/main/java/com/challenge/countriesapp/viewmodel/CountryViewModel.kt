package com.challenge.countriesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.countriesapp.model.CountryResponse
import com.challenge.countriesapp.rest.CountriesRepositoryImpl
import com.challenge.countriesapp.utils.UIState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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