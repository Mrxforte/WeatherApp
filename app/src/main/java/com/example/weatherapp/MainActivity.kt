package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.example.weatherapp.adapters.WeatherInfoAdapter
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.models.WeatherInfoModel
import com.example.weatherapp.screens.DetailsScreen
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    var currentState: Boolean = false
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadUI()
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

    private fun loadUI() {
        binding.fab2.setOnClickListener {
            var intent = Intent(this, DetailsScreen::class.java)
            startActivity(intent)
        }
        binding.leftMenu.setOnClickListener() {
            currentState = true
            if (currentState) {
                binding.bottomSheet.visibility = View.GONE
                currentState = false
            } else {
                binding.bottomSheet.visibility = View.VISIBLE

            }
        }
        binding.currentWeatherInfo.setOnClickListener(){
            var intent = Intent(this, DetailsScreen::class.java)
            startActivity(intent)
        }
        var adapter = WeatherInfoAdapter(list)
        var layoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = layoutManager1

        binding.rightMenu.setOnClickListener() {
            currentState != false
            if (currentState) {
                binding.bottomSheet.visibility = View.GONE
                currentState = false
            } else {
                binding.bottomSheet.visibility = View.VISIBLE

            }
        }
    }


}
