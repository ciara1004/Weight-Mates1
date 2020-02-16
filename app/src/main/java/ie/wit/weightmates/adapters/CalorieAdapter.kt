package ie.wit.weightmates.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.weightmates.models.CalorieModel
import ie.wit.weightmates.R
import kotlinx.android.synthetic.main.card_calorie.view.*

class CalorieAdapter constructor(private var calories: List<CalorieModel>)
    : RecyclerView.Adapter<CalorieAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.card_calorie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val calorie = calories[holder.adapterPosition]
        holder.bind(calorie)
    }

    override fun getItemCount(): Int = calories.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(calorie: CalorieModel) {
            itemView.calorieamount.text = calorie.amount.toString()
            itemView.caloriemethod.text = calorie.caloriemethod
            itemView.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}