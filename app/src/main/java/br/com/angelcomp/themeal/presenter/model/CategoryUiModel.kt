package br.com.angelcomp.themeal.presenter.model

import br.com.angelcomp.themeal.domain.model.Category

class CategoryUiModel(
    val name: String,
    val thumb: String
)

fun Category.toUiModel() = CategoryUiModel(
    name = this.name,
    thumb = this.thumb
)
