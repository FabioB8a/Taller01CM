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

class CountriesListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding

    companion object {
        private const val COUNTRIES_FILE = "paises.json"
    }

    private val countries: MutableList<Country> = mutableListOf()
    private var region: String? = ""
    lateinit var countriesJSON: JSONArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountriesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    fun init(){

        region = intent.getStringExtra("continent")

        try {
            val jsonFile = loadCountriesByJson()
            countriesJSON = jsonFile.getJSONArray("Countries")
            for (i in 0 until countriesJSON.length()) {
                val currentRegion: String = countriesJSON.getJSONObject(i).getString("Region")
                if (currentRegion.equals(region, ignoreCase = true)) {
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
                    val country: Country = Country(name, nativeName, alpha3code, currency, urlImage, numericCode,subRegion,latitude,longitude,nativeLanguage,area,alpha2code,currencyCode)
                    countries.add(country)
                }
            }

            val c: CountriesAdapter = CountriesAdapter(countries, this)
            val r: RecyclerView = findViewById(R.id.RecyclerViewC)
            r.layoutManager = LinearLayoutManager(this)
            r.adapter = c

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val formattedText = resources.getString(R.string.region_selected, region)
        binding.textView.text = formattedText

    }

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

    @Throws(JSONException::class)
    fun loadCountriesByJson(): JSONObject {
        return JSONObject(loadJSONFromAsset(COUNTRIES_FILE))
    }
}