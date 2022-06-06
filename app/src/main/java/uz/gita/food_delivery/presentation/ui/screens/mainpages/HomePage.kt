package uz.gita.food_delivery.presentation.ui.screens.mainpages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.food_delivery.R
import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.data.model.CategoriesData
import uz.gita.food_delivery.databinding.PageHomeBinding
import uz.gita.food_delivery.presentation.ui.adapter.AdsAdapter
import uz.gita.food_delivery.presentation.ui.adapter.CategoryAdapter
import uz.gita.food_delivery.presentation.viewmodel.HomePageViewModel
import uz.gita.food_delivery.presentation.viewmodel.impl.HomePageViewModelImpl

@AndroidEntryPoint
class HomePage : Fragment(R.layout.page_home) {
    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomePageViewModel by viewModels<HomePageViewModelImpl>()
    private val adsAdapter = AdsAdapter()
    private val categoryAdapter = CategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadAdsLiveData.observe(viewLifecycleOwner, loadAdsObserver)
        viewModel.changeAdsLiveData.observe(viewLifecycleOwner, changeAdsObserver)
        viewModel.loadCategoriesLiveData.observe(viewLifecycleOwner, loadCategoriesObserver)

        binding.pageHomeViewpagerAds.adapter = adsAdapter
        binding.pageHomeCategoryRecycler.adapter = categoryAdapter
    }

    private val loadAdsObserver = Observer<List<AdsData>> {
        adsAdapter.submitList(it)

    }
    private val changeAdsObserver = Observer<Int> {
        binding.pageHomeViewpagerAds.currentItem = it
    }
    private val loadCategoriesObserver = Observer<List<CategoriesData>> {
        categoryAdapter.submitList(it)
    }
}