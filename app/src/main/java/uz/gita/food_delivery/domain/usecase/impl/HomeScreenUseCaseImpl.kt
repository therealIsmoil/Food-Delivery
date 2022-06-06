package uz.gita.food_delivery.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.data.model.CategoriesData
import uz.gita.food_delivery.domain.repository.FoodRepository
import uz.gita.food_delivery.domain.usecase.HomeScreenUseCase
import javax.inject.Inject

class HomeScreenUseCaseImpl @Inject constructor(private val repository: FoodRepository) :
    HomeScreenUseCase {

    override fun getAdsData() = callbackFlow<Result<List<AdsData>>> {
        withContext(Dispatchers.Default) {
            repository.getAdsData({
                trySendBlocking(Result.success(it))
            }, {
                trySendBlocking(Result.failure(it))
            })
        }

        awaitClose {}
    }.flowOn(Dispatchers.IO)

    override fun getCategories() = callbackFlow<Result<List<CategoriesData>>> {
        withContext(Dispatchers.Default) {
            repository.getCategories({
                trySendBlocking(Result.success(it))
            }, {
                trySendBlocking(Result.failure(it))
            })
        }

        awaitClose {}
    }.flowOn(Dispatchers.IO)
}