package uz.gita.food_delivery.presentation.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.food_delivery.R
import uz.gita.food_delivery.databinding.ScreenStartBinding

@AndroidEntryPoint
class StartScreen : Fragment(R.layout.screen_start) {
    private val binding by viewBinding(ScreenStartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("TTT", "StartScreen")
        binding.getStartedButton.setOnClickListener {
            findNavController().navigate(R.id.action_startScreen_to_loginScreen)
        }
    }
}