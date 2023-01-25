package com.danidang.danii_side.presentation.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danidang.danii_side.presentation.sign.DaniSharedPrefernces

class HomeViewModel : ViewModel() {
    private val _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String>
        get() = _name
    private val _mbti: MutableLiveData<String> = MutableLiveData()
    val mbti: LiveData<String>
        get() = _mbti

    fun setUser(context: Context){
        _name.value = DaniSharedPrefernces(context).name
        _mbti.value = DaniSharedPrefernces(context).mbti
    }
}