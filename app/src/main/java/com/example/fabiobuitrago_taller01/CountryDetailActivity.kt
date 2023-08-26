package com.example.fabiobuitrago_taller01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fabiobuitrago_taller01.databinding.ActivityDetailsBinding

/**
 *  Coded by: Fabio Luis Buitrago Ochoa
 */
class CountryDetailActivity : AppCompatActivity() {

    private var selectedCountry: Country? = null // Initialize with null
    private lateinit var binding: ActivityDetailsBinding

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           then this Bundle contains the data it most recently supplied in
     *                           onSaveInstanceState(Bundle). Note: Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Get the selected country object from the intent's extras
        selectedCountry = intent.getParcelableExtra("selected_country")

        // Call the init function to populate views with selected country's details
        init()
    }

    /**
     * Initialize the details view with data from the selected country.
     * Uses the selectedCountry object to populate various views with country details.
     */
    private fun init() {
        // Check if selectedCountry is not null using the safe call operator (let)
        selectedCountry?.let { country ->
            // Load the country's flag image using Glide and populate the ImageView
            Glide.with(this).load(country.urlImage).into(binding.imageFlag)

            // Populate various TextViews with country details
            binding.countryName.text = country.name
            binding.countryNativeName.text = country.nativeName
            binding.subRegion.text = country.subRegion
            binding.alpha3Code.text = country.code

            binding.alpha2Code.text = country.alpha2Code
            binding.currencyCode.text = country.currencyCode
            binding.currency.text = country.currency
            binding.latitude.text = resources.getString(R.string.details_latitude, country.latitude)
            binding.longitude.text = resources.getString(R.string.details_longitude, country.longitude)
            binding.nativeLanguage.text = resources.getString(R.string.native_language, country.nativeLanguage)
            binding.area.text = resources.getString(R.string.area, country.area)
        }
    }
}