package ie.wit.weightmates.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CalorieModel(var id: Long = 0,
                        val caloriemethod: String = "N/A",
                        val amount: Int = 0) : Parcelable

