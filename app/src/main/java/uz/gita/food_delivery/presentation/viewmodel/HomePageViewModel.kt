package uz.gita.food_delivery.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.data.model.CategoriesData

interface HomePageViewModel {
    val loadAdsLiveData: LiveData<List<AdsData>>
    val changeAdsLiveData: LiveData<Int>
    val loadCategoriesLiveData: LiveData<List<CategoriesData>>
}