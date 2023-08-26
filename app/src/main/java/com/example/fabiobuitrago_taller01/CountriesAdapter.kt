package com.example.fabiobuitrago_taller01

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 *  Coded by: Fabio Luis Buitrago Ochoa
 */

/**
 * An adapter to provide data to the RecyclerView in the CountriesListActivity.
 *
 * @param countries The list of countries to be displayed in the RecyclerView.
 * @param context The context of the activity using this adapter.
 */
class CountriesAdapter(private val countries: List<Country>, private val context: Context) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    /**
     * Create a new ViewHolder instance when RecyclerView needs a new item view.
     *
     * @param parent The parent ViewGroup into which the new View will be added.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.country_card, parent, false)
        return ViewHolder(view)
    }

    /**
     * Bind data to the views within a ViewHolder.
     *
     * @param holder The ViewHolder to which data should be bound.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(countries[position])
    }

    /**
     * Get the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the adapter.
     */
    override fun getItemCount(): Int {
        return countries.size
    }

    /**
     * A ViewHolder class to hold and manage the views for individual items in the RecyclerView.
     *
     * @param itemView The view representing a single item in the RecyclerView.
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // References to views within the itemView
        private var nameCountry: TextView = itemView.findViewById(R.id.nameCountry)
        private var nativeNamenameCountry: TextView = itemView.findViewById(R.id.nativenameCountry)
        private var codeCountry: TextView = itemView.findViewById(R.id.codeCountry)
        private var currency: TextView = itemView.findViewById(R.id.currency)
        private var flag: ImageView = itemView.findViewById(R.id.iconImageView)

        private var fabButton: FloatingActionButton = itemView.findViewById(R.id.fButton)
        private var cardView: CardView = itemView.findViewById(R.id.cvCountry)
        private var numericCode: String = ""

        init {
            // Set up click listeners for the card view and floating action button

            // When the card view is clicked, open the CountryDetailActivity with the selected country's data
            cardView.setOnClickListener{
                val country = countries[adapterPosition]
                val intent = Intent(context, CountryDetailActivity::class.java)
                intent.putExtra("selected_country", country)
                context.startActivity(intent)
            }

            // When the floating action button is clicked, open the dialer with the selected country's numeric code
            fabButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$numericCode")
                itemView.context.startActivity(intent)
            }
        }

        /**
         * Bind data to the views within the ViewHolder.
         *
         * @param country The country object containing data to be displayed.
         */
        fun bindData(country: Country) {

            // Populate the views with data from the country object
            nameCountry.text = country.name
            nativeNamenameCountry.text = country.nativeName
            codeCountry.text = country.code
            currency.text = country.currency
            numericCode = country.numericCode

            // Load and display the country's flag image using Glide library
            Glide.with(context).load(country.urlImage).into(flag);
        }
    }
}