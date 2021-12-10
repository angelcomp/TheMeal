package br.com.angelcomp.themeal.domain

import br.com.angelcomp.themeal.data.MealRepository
import br.com.angelcomp.themeal.domain.model.Category
import java.lang.Exception

class GetCategories(
    private val mealRepository: MealRepository
): GetCategoriesUseCase {
    override suspend fun invoke(): List<Category> = try {
        mealRepository.getCategories()
    } catch (e: Exception) {
        listOf()
    }
}

interface GetCategoriesUseCase{
    suspend fun invoke(): List<Category>
}