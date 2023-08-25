package com.example.fabiobuitrago_taller01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fabiobuitrago_taller01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        countries();
    }

    private fun countries(){
        binding.countriesButton.setOnClickListener(){
            val intent = Intent(this, CountriesListActivity::class.java)
            val selectedContinent = binding.spinner.selectedItem

            intent.putExtra("continent", selectedContinent.toString())
            startActivity(intent)
        }

    }
}