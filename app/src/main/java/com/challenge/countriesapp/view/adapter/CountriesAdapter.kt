package com.challenge.countriesapp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.challenge.countriesapp.databinding.ItemViewBinding
import com.challenge.countriesapp.model.CountryResponse

class CountriesAdapter(
    private val item: MutableList<CountryResponse> = mutableListOf()

): RecyclerView.Adapter<CountriesViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<CountryResponse>){
        if (item != newItems) {
            item.clear()
            item.addAll(newItems)

            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) =
        holder.bind(item[position])
}

class CountriesViewHolder(
    private val binding: ItemViewBinding
): ViewHolder(binding.root) {

    fun bind(country: CountryResponse) {
        if (!country.name.isNullOrEmpty()) {binding.txtName.text = "${country.name}, "} else {binding.txtName.text = "Name not available, "}
        if (!country.region.isNullOrEmpty()) {binding.txtRegion.text = country.region} else {binding.txtRegion.text = "Region not available"}
        if (!country.code.isNullOrEmpty()) {binding.txtCode.text = country.code} else {binding.txtCode.text = "Code not available"}
        if (!country.capital.isNullOrEmpty()) {binding.txtCapital.text = country.capital} else {binding.txtCapital.text = "Capital not available"}
    }

}