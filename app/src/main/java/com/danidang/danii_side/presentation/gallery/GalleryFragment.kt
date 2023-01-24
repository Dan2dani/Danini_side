package com.danidang.danii_side.presentation.gallery

import android.os.Bundle
import android.view.View
import com.danidang.danii_side.R
import com.danidang.danii_side.databinding.FragmentGalleryBinding
import com.danidang.danii_side.util.binding.BindingFragment

class GalleryFragment : BindingFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        val adapter = GalleryAdapter(requireContext())
        binding.vpGalleryImage.adapter = adapter
    }
}