package com.example.locationtrackingapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.locationtrackingapplication.databinding.AdapterLocationListItemBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class LocationListAdapter(val mContext: Context, var locations: List<Locations>) :
    RecyclerView.Adapter<LocationListAdapter.MyViewHolder>() {

    private lateinit var binding: AdapterLocationListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = AdapterLocationListItemBinding.inflate(LayoutInflater.from(mContext), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
    }


    override fun getItemCount(): Int {
        return locations.size
    }

    inner class MyViewHolder(binding: AdapterLocationListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photos: Locations) {
            binding.tvNumber.text = photos.id.toString()

            binding.tvLatitude.text = roundOffDecimal(photos.latitude).toString()
            binding.tvLongitude.text = roundOffDecimal(photos.longitude).toString()

            val date = photos.date.split(" ")
            binding.tvDate.text = date[0]
            binding.tvTime.text = date[1]
        }


    }

    fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.FLOOR
        return df.format(number).toDouble()
    }


}