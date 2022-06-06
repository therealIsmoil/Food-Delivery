package uz.gita.food_delivery.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.data.model.CategoriesData

interface HomeScreenUseCase {
    fun getAdsData(): Flow<Result<List<AdsData>>>
    fun getCategories(): Flow<Result<List<CategoriesData>>>
}