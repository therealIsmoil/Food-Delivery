package uz.gita.food_delivery.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.food_delivery.R
import uz.gita.food_delivery.databinding.ScreenMainBinding
import uz.gita.food_delivery.presentation.ui.adapter.MainPagesAdapter
import uz.gita.food_delivery.presentation.viewmodel.MainViewModel
import uz.gita.food_delivery.presentation.viewmodel.impl.MainViewModelImpl

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private lateinit var adapter: MainPagesAdapter
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.onClickHomeLiveData.observe(viewLifecycleOwner, onClickHomeObserver)
        viewModel.onClickSearchLiveData.observe(viewLifecycleOwner, onClickSearchObserver)
        viewModel.onClickMyCartLiveData.observe(viewLifecycleOwner, onClickMyCartObserver)
        viewModel.onClickProfileLiveData.observe(viewLifecycleOwner, onClickProfileObserver)

        adapter = MainPagesAdapter(childFragmentManager, lifecycle)
        binding.mainViewpager2.adapter = adapter
        binding.mainViewpager2.isUserInputEnabled = false
        binding.bottomNavigationView.apply {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.bottom_navigation_home -> {
                        viewModel.onClickHome()
                        true
                    }
                    R.id.bottom_navigation_search -> {
                        viewModel.onClickSearch()
                        true
                    }
                    R.id.bottom_navigation_my_cart -> {
                        viewModel.onClickMyCart()
                        true
                    }
                    else -> {
                        viewModel.onClickProfile()
                        true
                    }
                }
            }
        }
    }

    private val onClickHomeObserver = Observer<Unit> {
        binding.mainViewpager2.currentItem = 0
    }
    private val onClickSearchObserver = Observer<Unit> {
        binding.mainViewpager2.currentItem = 1
    }
    private val onClickMyCartObserver = Observer<Unit> {
        binding.mainViewpager2.currentItem = 2
    }
    private val onClickProfileObserver = Observer<Unit> {
        binding.mainViewpager2.currentItem = 3
    }
}