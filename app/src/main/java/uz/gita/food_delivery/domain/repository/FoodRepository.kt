package uz.gita.food_delivery.domain.repository

import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.data.model.CategoriesData

interface FoodRepository {
    suspend fun getAdsData(success: (List<AdsData>) -> Unit, failure: (Throwable) -> Unit)
    suspend fun getCategories(success: (List<CategoriesData>) -> Unit, failure: (Throwable) -> Unit)
}