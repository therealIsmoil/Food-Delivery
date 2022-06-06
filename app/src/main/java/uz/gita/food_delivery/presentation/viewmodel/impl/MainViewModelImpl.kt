package uz.gita.food_delivery.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.food_delivery.presentation.viewmodel.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(): ViewModel(), MainViewModel {
    override val onClickHomeLiveData = MutableLiveData<Unit>()
    override val onClickSearchLiveData = MutableLiveData<Unit>()
    override val onClickMyCartLiveData = MutableLiveData<Unit>()
    override val onClickProfileLiveData = MutableLiveData<Unit>()

    override fun onClickHome() {
        onClickHomeLiveData.value = Unit
    }

    override fun onClickSearch() {
        onClickSearchLiveData.value = Unit
    }

    override fun onClickMyCart() {
        onClickMyCartLiveData.value = Unit
    }

    override fun onClickProfile() {
        onClickProfileLiveData.value = Unit
    }
}