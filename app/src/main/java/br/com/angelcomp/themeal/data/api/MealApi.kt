package br.com.angelcomp.themeal.data.api

import br.com.angelcomp.network.BaseResponse
import br.com.angelcomp.themeal.data.model.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    @GET("categories.php")
    suspend fun getCategories(): Response<BaseResponse<CategoryResponse>>
}