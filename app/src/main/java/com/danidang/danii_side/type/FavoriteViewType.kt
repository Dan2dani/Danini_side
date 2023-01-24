package com.danidang.danii_side.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.danidang.danii_side.R

enum class FavoriteViewType(@DrawableRes val image: Int, @StringRes val title: Int) {
    FIRST(R.drawable.favorite1, R.string.favorite1_title),
    SECOND(R.drawable.favorite2, R.string.favorite2_title),
    THIRD(R.drawable.favorite3, R.string.favorite3_title)
}