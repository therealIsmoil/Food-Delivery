package uz.gita.food_delivery.presentation.viewmodel

import androidx.lifecycle.LiveData

interface MainViewModel {
    val onClickHomeLiveData: LiveData<Unit>
    val onClickSearchLiveData: LiveData<Unit>
    val onClickMyCartLiveData: LiveData<Unit>
    val onClickProfileLiveData: LiveData<Unit>

    fun onClickHome()
    fun onClickSearch()
    fun onClickMyCart()
    fun onClickProfile()
}