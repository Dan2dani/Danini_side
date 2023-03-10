package com.danidang.danii_side.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.danidang.danii_side.R
import com.danidang.danii_side.databinding.ActivityHomeBinding
import com.danidang.danii_side.presentation.gallery.GalleryFragment
import com.danidang.danii_side.util.binding.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeFragment(HomeFragment())
        binding.bnvHome.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> changeFragment(HomeFragment())
                    R.id.menu_gallery -> changeFragment(GalleryFragment())
                    R.id.menu_search -> changeFragment(SearchFragment())
                }
                true
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.home_container, fragment)
            .commit()
    }
}