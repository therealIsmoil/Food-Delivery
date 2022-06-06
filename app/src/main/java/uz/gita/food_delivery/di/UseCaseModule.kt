package uz.gita.food_delivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.food_delivery.domain.usecase.HomeScreenUseCase
import uz.gita.food_delivery.domain.usecase.impl.HomeScreenUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @[Binds Singleton]
    fun homeScreenUseCase(impl: HomeScreenUseCaseImpl): HomeScreenUseCase
}