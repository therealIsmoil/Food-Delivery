package uz.gita.food_delivery.domain.repository.impl

import com.google.firebase.firestore.FirebaseFirestore
import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.data.model.CategoriesData
import uz.gita.food_delivery.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl
@Inject constructor(
    private val fireStore: FirebaseFirestore
) : FoodRepository {

    override suspend fun getAdsData(
        success: (List<AdsData>) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        fireStore
            .collection("ads")
            .get()
            .addOnSuccessListener { querySnapshot ->
                val response = querySnapshot.map { queryDocumentSnapshot ->
                    queryDocumentSnapshot.toObject(AdsData::class.java)
                }
                success.invoke(response)
            }
            .addOnFailureListener {
                failure.invoke(it)
            }
    }

    override suspend fun getCategories(
        success: (List<CategoriesData>) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        fireStore
            .collection("categories")
            .get()
            .addOnSuccessListener { querySnapshot ->
                val response = querySnapshot.map { queryDocumentSnapshot ->
                    queryDocumentSnapshot.toObject(CategoriesData::class.java)
                }
                success.invoke(response)
            }
            .addOnFailureListener {
                failure.invoke(it)
            }
    }

}