package com.example.fabiobuitrago_taller01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fabiobuitrago_taller01.databinding.ActivityMainBinding

/**
 *  Coded by: Fabio Luis Buitrago Ochoa
 */

class MainActivity : AppCompatActivity() {

    // View binding instance for the main activity's layout
    private lateinit var binding: ActivityMainBinding

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           then this Bundle contains the data it most recently supplied in
     *                           onSaveInstanceState(Bundle). Note: Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        countries();
    }

    /**
     * Set up the behavior for the "Countries" button.
     * When the button is clicked, it launches the CountriesListActivity with the selected continent.
     */
    private fun countries(){
        binding.countriesButton.setOnClickListener(){
            val intent = Intent(this, CountriesListActivity::class.java)
            val selectedContinent = binding.spinner.selectedItem

            intent.putExtra("continent", selectedContinent.toString())
            startActivity(intent)
        }

    }
}