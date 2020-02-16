package ie.wit.weightmates.models

interface CalorieStore {
    fun findAll() : List<CalorieModel>
    fun findById(id: Long) : CalorieModel?
    fun create(calorie: CalorieModel)
    //fun update(calorie: CalorieModel)
    //fun delete(calorie: CalorieModel)
}