package com.challenge.countriesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.withCreated
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.countriesapp.databinding.ActivityMainBinding
import com.challenge.countriesapp.utils.NullResponse
import com.challenge.countriesapp.utils.UIState
import com.challenge.countriesapp.view.adapter.CountriesAdapter
import com.challenge.countriesapp.viewmodel.CountryViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val countryViewModel by lazy{
        ViewModelProvider(this)[CountryViewModel::class.java]
    }

    private val countryAdapter by lazy {
        CountriesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvCountries.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = countryAdapter
        }
        getCountries()

    }

    private fun getCountries() {
        lifecycleScope.launch {
            countryViewModel.country.collect{ state ->
                when(state) {
                    is UIState.ERROR -> {
                        NullResponse()
                    }
                    is UIState.LOADING -> {
                        Toast.makeText(this@MainActivity, "Loading...", Toast.LENGTH_SHORT).show()
                    }
                    is UIState.SUCCESS -> {
                        countryAdapter.updateItems(state.response)
                    }
                }
            }
        }
    }
}