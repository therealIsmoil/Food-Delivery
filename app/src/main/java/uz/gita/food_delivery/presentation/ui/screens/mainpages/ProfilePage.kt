package uz.gita.food_delivery.presentation.ui.screens.mainpages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.food_delivery.R
import uz.gita.food_delivery.databinding.PageProfileBinding

@AndroidEntryPoint
class ProfilePage : Fragment(R.layout.page_profile) {
    private val binding by viewBinding(PageProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}