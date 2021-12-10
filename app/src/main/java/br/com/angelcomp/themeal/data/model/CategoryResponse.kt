package br.com.angelcomp.themeal.data.model

import br.com.angelcomp.themeal.domain.model.Category

data class CategoryResponse(
    val idCategory: String,
    val strName: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)

fun CategoryResponse.toCategory() = Category(
    id = this.idCategory,
    name = this.strName,
    thumb = this.strCategoryThumb,
    description = this.strCategoryDescription
)