package uz.gita.food_delivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.food_delivery.domain.repository.FoodRepository
import uz.gita.food_delivery.domain.repository.impl.FoodRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @[Binds Singleton]
    fun foodRepository(impl: FoodRepositoryImpl): FoodRepository
}