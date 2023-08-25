package com.example.fabiobuitrago_taller01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fabiobuitrago_taller01.databinding.ActivityCountriesBinding
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
        }
    }
}