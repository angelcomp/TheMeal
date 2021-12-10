package br.com.angelcomp.themeal.data

import br.com.angelcomp.network.Output
import br.com.angelcomp.network.parseResponse
import br.com.angelcomp.themeal.data.api.MealApi
import br.com.angelcomp.themeal.data.model.toCategory
import br.com.angelcomp.themeal.domain.model.Category

class MealRepositoryImpl(
    private val service: MealApi
): MealRepository {
    override suspend fun getCategories(): List<Category> {
        val result = service.getCategories().parseResponse()

        return when(result) {
            is Output.Success -> {
                val categoryResponseList = result.value.categories

                categoryResponseList.map {
                    it.toCategory()
                }
            }
            is Output.Failure -> throw GetCategoryException()
        }
    }
}

interface MealRepository {
     suspend fun getCategories(): List<Category>
}

class GetCategoryException : Exception()