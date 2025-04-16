package com.example.weatherapp.screens

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.adapters.WeatherInfoAdapter
import com.example.weatherapp.databinding.ActivityDetailsScreenBinding
import com.example.weatherapp.helpers.MyRecyclerViewOnClickListener
import com.example.weatherapp.models.WeatherInfoModel

class DetailsScreen : AppCompatActivity() {
    private var selected = true
    private lateinit var binding: ActivityDetailsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var list = arrayListOf<WeatherInfoModel>(
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_1,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_2,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_3,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_4,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_5,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_6,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_3,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_4,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_5,
                R.string._19.toString()
            ),
            WeatherInfoModel(
                "12 Am",
                R.drawable.img_6,
                R.string._19.toString()
            ),
        )
        binding.underLine2.setBackgroundColor(Color.parseColor("#402867"))
        binding.underLine1.background =
            ContextCompat.getDrawable(this@DetailsScreen, R.drawable.gradient)

        binding.hourlyForecast.setOnClickListener() {
            binding.underLine2.setBackgroundColor(Color.parseColor("#402867"))
            binding.underLine1.background =
                ContextCompat.getDrawable(this@DetailsScreen, R.drawable.gradient)
        }
        binding.weeklyForecast.setOnClickListener() {
            binding.underLine1.setBackgroundColor(Color.parseColor("#402867"))
            binding.underLine2.background =
                ContextCompat.getDrawable(this@DetailsScreen, R.drawable.gradient)
        }

        var adapter = WeatherInfoAdapter(list)
        var layoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.listOfInfo.adapter = adapter
        binding.listOfInfo.layoutManager = layoutManager1
    }
}