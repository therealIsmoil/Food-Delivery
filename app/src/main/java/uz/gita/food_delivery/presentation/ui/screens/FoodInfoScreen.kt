package uz.gita.food_delivery.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.food_delivery.R
import uz.gita.food_delivery.databinding.ScreenFoodInfoBinding

@AndroidEntryPoint
class FoodInfoScreen : Fragment(R.layout.screen_food_info) {
    private val binding by viewBinding(ScreenFoodInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}