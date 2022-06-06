package uz.gita.food_delivery.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.data.model.CategoriesData
import uz.gita.food_delivery.domain.usecase.HomeScreenUseCase
import uz.gita.food_delivery.presentation.viewmodel.HomePageViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModelImpl
@Inject constructor(
    private val useCase: HomeScreenUseCase
) : ViewModel(), HomePageViewModel {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    override val loadAdsLiveData = MutableLiveData<List<AdsData>>()
    override val changeAdsLiveData = MutableLiveData<Int>()
    override val loadCategoriesLiveData = MutableLiveData<List<CategoriesData>>()

    init {
        loadAdsData()
        changeAds()
        loadCategories()
    }

    private fun loadAdsData() {
        useCase.getAdsData().onEach { resultList ->
            resultList.onSuccess {
                loadAdsLiveData.value = it
            }
            resultList.onFailure {
            }
        }.launchIn(viewModelScope)
    }

    private fun changeAds() {
        var i = 0
        scope.launch {
            while (true) {
                i++
                delay(1800)
                changeAdsLiveData.postValue(i)
                if (i == 5) {
                    i = 1
                }

            }
        }
    }

    private fun loadCategories() {
        useCase.getCategories().onEach { resultList ->
            resultList.onSuccess {
                loadCategoriesLiveData.value = it
            }
            resultList.onFailure {

            }
        }.launchIn(viewModelScope)
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

}