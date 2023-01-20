package com.danidang.danii_side

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignViewModel : ViewModel() {
    val emailInput = MutableLiveData<String>()
    val passwordInput = MutableLiveData<String>()

    fun isValidSign(): Boolean {
        if (emailInput.value.isNullOrBlank() || passwordInput.value.isNullOrBlank())
            return false
        return emailInput.value?.length!! in 6..10 && passwordInput.value?.length!! in 8..12
    }
}