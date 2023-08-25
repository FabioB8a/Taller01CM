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
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class CountriesAdapter(private val countries: List<Country>, private val context: Context) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.country_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var nameCountry: TextView = itemView.findViewById(R.id.nameCountry)
        private var nativeNamenameCountry: TextView = itemView.findViewById(R.id.nativenameCountry)
        private var codeCountry: TextView = itemView.findViewById(R.id.codeCountry)
        private var currency: TextView = itemView.findViewById(R.id.currency)
        private var flag: ImageView = itemView.findViewById(R.id.iconImageView)

        private var fabButton: FloatingActionButton = itemView.findViewById(R.id.fButton)
        private var cardView: CardView = itemView.findViewById(R.id.cvCountry)
        private var numericCode: String = ""

        init {

            cardView.setOnClickListener{
                // Aquí se hace el intent para Activity details country
                // enviar el objeto json, si no, el string equivalente
                val country = countries[adapterPosition]
                val intent = Intent(context, CountryDetailActivity::class.java)
                intent.putExtra("selected_country", country)
                context.startActivity(intent)
            }

            fabButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$numericCode")
                itemView.context.startActivity(intent)
            }
        }

        fun bindData(country: Country) {

            nameCountry.text = country.name
            nativeNamenameCountry.text = country.nativeName
            codeCountry.text = country.code
            currency.text = country.currency
            numericCode = country.numericCode

            Glide.with(context).load(country.urlImage).into(flag);
        }
    }
}