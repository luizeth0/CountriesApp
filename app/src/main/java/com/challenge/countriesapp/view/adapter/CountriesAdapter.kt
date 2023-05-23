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
        binding.txtName.text = "${country.name}, "
        binding.txtRegion.text = country.region
        binding.txtCode.text = country.code
        binding.txtCapital.text = country.capital


    }

}