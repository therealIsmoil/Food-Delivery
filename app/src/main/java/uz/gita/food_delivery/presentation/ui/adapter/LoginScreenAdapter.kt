package uz.gita.food_delivery.presentation.ui.adapter


import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.food_delivery.presentation.ui.screens.authpages.SignInPage
import uz.gita.food_delivery.presentation.ui.screens.authpages.SignUpPage

class LoginScreenAdapter(fr: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fr, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        Log.d("TTT", "createFragment")
        return when (position) {
            0 -> SignInPage()
            else -> SignUpPage()
        }
    }
}