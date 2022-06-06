package uz.gita.food_delivery.presentation.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.food_delivery.R
import uz.gita.food_delivery.databinding.ScreenLoginBinding
import uz.gita.food_delivery.presentation.ui.adapter.LoginScreenAdapter

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {
    private val binding by viewBinding(ScreenLoginBinding::bind)
    private lateinit var adapter: LoginScreenAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("TTT", "LoginScreen")
        adapter = LoginScreenAdapter(childFragmentManager, lifecycle)
        binding.loginScreenViewpager2.adapter = adapter

        binding.loginScreenTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(
            binding.loginScreenTabLayout,
            binding.loginScreenViewpager2
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = resources.getString(R.string.login_tabLayout)
                }
                else -> {
                    tab.text = resources.getString(R.string.sign_up_tabLayout)
                }
            }
        }.attach()

        binding.loginCard.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_mainScreen)
        }

    }
}