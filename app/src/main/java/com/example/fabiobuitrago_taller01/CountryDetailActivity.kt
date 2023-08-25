package com.example.fabiobuitrago_taller01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fabiobuitrago_taller01.databinding.ActivityDetailsBinding

class CountryDetailActivity : AppCompatActivity() {

    var selectedCountry: Country? = null // Initialize with null
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        selectedCountry = intent.getParcelableExtra("selected_country")

        init()
    }

    fun init() {
        selectedCountry?.let { country ->
            Glide.with(this).load(country.urlImage).into(binding.imageFlag)
            binding.countryName.text = country.name
            binding.countryNativeName.text = country.nativeName
            binding.subRegion.text = country.subRegion
            binding.alpha3Code.text = country.code
            binding.alpha2Code.text = country.alpha2Code
            binding.currencyCode.text = country.currencyCode
            binding.currency.text = country.currency
            binding.latitude.text = country.latitude
            binding.longitude.text = country.longitude
            binding.nativeLanguage.text = country.nativeLanguage
            binding.area.text = country.area
        }
    }
}