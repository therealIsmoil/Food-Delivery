package uz.gita.food_delivery.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.food_delivery.presentation.ui.screens.mainpages.HomePage
import uz.gita.food_delivery.presentation.ui.screens.mainpages.MyCartPage
import uz.gita.food_delivery.presentation.ui.screens.mainpages.ProfilePage
import uz.gita.food_delivery.presentation.ui.screens.mainpages.SearchPage

class MainPagesAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomePage()
            1 -> SearchPage()
            2 -> MyCartPage()
            else -> ProfilePage()
        }
    }
}