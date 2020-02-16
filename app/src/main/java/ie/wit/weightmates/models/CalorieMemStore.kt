package ie.wit.weightmates.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class CalorieMemStore : CalorieStore {

    val calories = ArrayList<CalorieModel>()

    override fun findAll(): List<CalorieModel> {
        return calories
    }

    override fun findById(id:Long) : CalorieModel? {
        val foundCalorie: CalorieModel? = calories.find { it.id == id }
        return foundCalorie
    }

    override fun create(calorie: CalorieModel) {
        calorie.id = getId()
        calories.add(calorie)
        logAll()
    }

    fun logAll() {
        Log.v("Calorie","** Calories List **")
        calories.forEach { Log.v("Calorie","${it}") }
    }
}