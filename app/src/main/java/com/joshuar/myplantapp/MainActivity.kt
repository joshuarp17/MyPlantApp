package com.joshuar.myplantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var imageViewPlant: ImageView
    private lateinit var buttonFertilize: Button
    private lateinit var buttonWater: Button
    private lateinit var buttonSun: Button

    class myPlant(var myPlant: String){

    }

    private var health = 100
    private var water = 100
    private var sunlight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewPlant = findViewById(R.id.imageViewPlant)

        //buttons
        val buttonFertilize = findViewById<Button>(R.id.buttonFertilize)
        val buttonWater = findViewById<Button>(R.id.buttonWater)
        val buttonSun = findViewById<Button>(R.id.buttonSun)

        updateUI()

        buttonFertilize.setOnClickListener {
            fertilizePlant()
            updateUI()
            imageViewPlant.setImageResource(R.drawable.plant_fertilize)
        }

        buttonWater.setOnClickListener {
            waterPlant()
            updateUI()
            imageViewPlant.setImageResource(R.drawable.plant_water)
        }

        buttonSun.setOnClickListener {
            putPlantInSun()
            updateUI()
            imageViewPlant.setImageResource(R.drawable.plant_sun)
        }
    }

    //Fertilising the plant
    private fun fertilizePlant() {
        health += 10
        if (health > 100) health = 100
        sunlight += 5
        water -= 5
    }

    //Putting the plant in sunlight
    private fun putPlantInSun() {
        sunlight += 10
        if (sunlight > 100) sunlight = 100
        health -= 5
        if (health > 100) health = 100
        water -= 5
        if (water < 0) water = 0
    }

    //Watering the plant
    private fun waterPlant() {
        water = 100
        sunlight -= 5
        if (sunlight < 0) sunlight = 0
    }

        private fun updateUI() {
            val waterTextView = findViewById<TextView>(R.id.waterTextView)
            val sunlightTextView = findViewById<TextView>(R.id.sunlightTextView)
            val healthTextView = findViewById<TextView>(R.id.healthTextView)

            waterTextView.text ="Watering: $water"
            sunlightTextView.text ="Sunlight: $sunlight"
            healthTextView.text ="Fertilize: $health"
        }        }


