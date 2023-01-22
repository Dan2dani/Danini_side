package com.danidang.danii_side.presentation.github

import androidx.annotation.DrawableRes

data class Repo(
    @DrawableRes val image: Int,
    val title: String,
    val author: String
)
