package uz.gita.food_delivery.presentation.ui.screens.authpages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.food_delivery.R
import uz.gita.food_delivery.databinding.PageSignInBinding

@AndroidEntryPoint
class SignInPage : Fragment(R.layout.page_sign_in) {
    private val binding by viewBinding(PageSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}