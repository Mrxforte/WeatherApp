package com.example.weatherapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.WeatherInfoItemBinding
import com.example.weatherapp.models.WeatherInfoModel

class WeatherInfoAdapter(val list: List<WeatherInfoModel>) :

    RecyclerView.Adapter<WeatherInfoAdapter.MyViewHolder>() {
    private var selectedPosition = -1

    inner class MyViewHolder(var binding: WeatherInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener() {
                var myItem = when (adapterPosition) {
                    selectedPosition -> {
                        itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.bg)

                    }

                    else -> {
                        itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.bg2)
                    }
                }

                val previousSelected = selectedPosition
                selectedPosition = adapterPosition

                // Update previous selection
                if (previousSelected != -1) {
                    notifyItemChanged(previousSelected)
                }

                // Update new selection
                notifyItemChanged(selectedPosition)
            }
        }


        fun bind(time: String, img: Int, degree: String) {
            binding.time.text = time
            binding.img.setImageResource(img)
            binding.degree.text = degree
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            WeatherInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var time = list[position].time
        var img = list[position].img
        var degree = list[position].degree

    }
}