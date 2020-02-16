package ie.wit.weightmates.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ie.wit.weightmates.R
import ie.wit.weightmates.main.CalorieApp
import ie.wit.weightmates.models.CalorieModel
import kotlinx.android.synthetic.main.fragment_calorie.view.*
import org.jetbrains.anko.toast


class CalorieFragment : Fragment() {

    lateinit var app: CalorieApp
    var totalCalories = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as CalorieApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_calorie, container, false)
        activity?.title = getString(R.string.action_calorie)

        root.progressBar.max = 10000
        root.amountPicker.minValue = 1
        root.amountPicker.maxValue = 3000

        root.amountPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            //Display the newly selected number to paymentAmount
            root.calorieAmount.setText("$newVal")
        }
        setButtonListener(root)
        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CalorieFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    fun setButtonListener( layout: View) {
        layout.countButton.setOnClickListener {
            val amount = if (layout.calorieAmount.text.isNotEmpty())
                layout.calorieAmount.text.toString().toInt() else layout.amountPicker.value
            if(totalCalories >= layout.progressBar.max)
                activity?.toast("Calorie Amount Exceeded!")
            else {
                val caloriemethod = if(layout.calorieCount.checkedRadioButtonId == R.id.Cal) "Cal" else "KCal"
                totalCalories += amount
                layout.totalFinal.text = "$totalCalories"
                layout.progressBar.progress = totalCalories
                app.caloriesStore.create(CalorieModel(caloriemethod = caloriemethod,amount = amount))
            }
        }
    }
}

