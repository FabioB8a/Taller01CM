package com.example.fabiobuitrago_taller01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fabiobuitrago_taller01.databinding.ActivityCountriesBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

/**
 *  Coded by: Fabio Luis Buitrago Ochoa
 */
class CountriesListActivity: AppCompatActivity() {

    // View binding instance for the activity's layout
    private lateinit var binding: ActivityCountriesBinding

    /**
     * A companion object containing constant values for the countries' JSON file.
     */
    companion object {
        // The name of the JSON file containing countries' data
        private const val COUNTRIES_FILE = "paises.json"
    }

    // A mutable list to hold country objects
    private val countries: MutableList<Country> = mutableListOf()

    // The selected region for which countries' data is being loaded
    private var region: String? = ""

    // A JSONArray to store the loaded JSON data containing countries' information
    lateinit var countriesJSON: JSONArray

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           then this Bundle contains the data it most recently supplied in
     *                           onSaveInstanceState(Bundle). Note: Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountriesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    /**
     * Initialize the activity by loading and displaying country data based on the selected region.
     */
    fun init(){

        // Retrieve the selected continent/region from the intent
        region = intent.getStringExtra("continent")

        try {
            // Load countries' JSON data
            val jsonFile = loadCountriesByJson()
            countriesJSON = jsonFile.getJSONArray("Countries")

            // Loop through the JSON array to process each country's data
            for (i in 0 until countriesJSON.length()) {
                val currentRegion: String = countriesJSON.getJSONObject(i).getString("Region")

                // Check if the country belongs to the selected region
                if (currentRegion.equals(region, ignoreCase = true)) {

                    // Extract country details from the JSON object
                    val name : String = countriesJSON.getJSONObject(i).getString("Name")
                    val nativeName: String = countriesJSON.getJSONObject(i).getString("NativeName")
                    val alpha3code : String = countriesJSON.getJSONObject(i).getString("Alpha3Code")
                    val numericCode: String = countriesJSON.getJSONObject(i).getString("NumericCode")

                    val currencyName: String = countriesJSON.getJSONObject(i).getString("CurrencyName")
                    val currencySymbol: String = countriesJSON.getJSONObject(i).getString("CurrencySymbol")
                    val currency: String = currencyName + " (" + currencySymbol + ")"

                    val subRegion: String = countriesJSON.getJSONObject(i).getString("SubRegion")
                    val latitude: String = countriesJSON.getJSONObject(i).getString("Latitude")
                    val longitude: String = countriesJSON.getJSONObject(i).getString("Longitude")
                    val nativeLanguage: String = countriesJSON.getJSONObject(i).getString("NativeLanguage")
                    val area: String = countriesJSON.getJSONObject(i).getString("Area")
                    val alpha2code: String = countriesJSON.getJSONObject(i).getString("Alpha2Code")
                    val currencyCode: String = countriesJSON.getJSONObject(i).getString("CurrencyCode")

                    val urlImage: String = countriesJSON.getJSONObject(i).getString("FlagPng")

                    // Create a Country object with the extracted data
                    val country: Country = Country(name, nativeName, alpha3code, currency, urlImage, numericCode,subRegion,latitude,longitude,nativeLanguage,area,alpha2code,currencyCode)

                    // Add the country to the list of countries
                    countries.add(country)
                }
            }

            // Create and set up the RecyclerView adapter
            val c: CountriesAdapter = CountriesAdapter(countries, this)
            val r: RecyclerView = findViewById(R.id.RecyclerViewC)
            r.layoutManager = LinearLayoutManager(this)
            r.adapter = c

        } catch (e: JSONException) {
            e.printStackTrace() // Print the stack trace if there's an error parsing JSON
        }

        // Format the selected region text and set it in the TextView
        val formattedText = resources.getString(R.string.region_selected, region)
        binding.textView.text = formattedText

    }

    /**
     * A function that loads JSON data from an Android app's assets.
     *
     * @param assetName The name of the asset containing the JSON data.
     * @return The JSON data as a string.
     */
    fun loadJSONFromAsset(assetName: String): String {
        val json: String
        json = try {
            val inputStream = this.assets.open(assetName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            ""
        }
        return json
    }

    /**
     * A function that loads countries' data from a JSON asset and returns it as a JSONObject.
     *
     * @throws JSONException If there is an error parsing the JSON data.
     * @return A JSONObject containing the countries' data.
     */
    @Throws(JSONException::class)
    fun loadCountriesByJson(): JSONObject {
        return JSONObject(loadJSONFromAsset(COUNTRIES_FILE))
    }
}