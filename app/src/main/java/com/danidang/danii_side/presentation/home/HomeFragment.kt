package com.danidang.danii_side.presentation.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.danidang.danii_side.R
import com.danidang.danii_side.databinding.FragmentHomeBinding
import com.danidang.danii_side.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setUser(requireActivity())
        addObservers()
    }

    private fun addObservers() {
        viewModel.name.observe(this){
            binding.tvHomeName.text = "이름: " + it
        }
        viewModel.mbti.observe(this){
            binding.tvHomeMbti.text = "mbti: " + it
        }
    }
}