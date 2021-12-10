package br.com.angelcomp.themeal.injection

import br.com.angelcomp.network.Service
import br.com.angelcomp.themeal.data.MealRepository
import br.com.angelcomp.themeal.data.MealRepositoryImpl
import br.com.angelcomp.themeal.data.api.MealApi
import br.com.angelcomp.themeal.domain.GetCategories
import br.com.angelcomp.themeal.domain.GetCategoriesUseCase
import br.com.angelcomp.themeal.presenter.MealViewModel
import org.koin.dsl.module

val mealServiceModule = module {
    single { Service().createService(MealApi::class.java) }

    single<MealRepository> { MealRepositoryImpl(get()) }

    single<GetCategoriesUseCase> { GetCategories(get()) }

    single { MealViewModel(get()) }
}