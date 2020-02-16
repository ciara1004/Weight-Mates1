package ie.wit.weightmates.main

import android.app.Application
import android.util.Log
import ie.wit.weightmates.models.CalorieMemStore
import ie.wit.weightmates.models.CalorieStore


class CalorieApp : Application() {

    lateinit var caloriesStore: CalorieStore

    override fun onCreate() {
        super.onCreate()
        caloriesStore = CalorieMemStore()
        Log.v("Calorie","Weight Mates App started")
    }
}