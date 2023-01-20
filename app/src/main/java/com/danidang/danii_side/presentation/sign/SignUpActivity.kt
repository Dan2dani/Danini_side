package com.danidang.danii_side.presentation.sign

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.danidang.danii_side.R
import com.danidang.danii_side.databinding.ActivitySignUpBinding
import com.danidang.danii_side.util.binding.BindingActivity

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val viewModel: SignViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        addListeners()
    }

    private fun addListeners() {
        binding.btnSignUp.setOnClickListener {
            moveToSignIn()
            with(DaniSharedPrefernces(this)) {
                name = binding.etSignUpId.text.toString()
                mbti = binding.etSignUpMbti.text.toString()
            }
        }
    }

    private fun moveToSignIn() {
        val intent = Intent(this, SignInActivity::class.java)
        with(binding) {
            intent.putExtra("id", etSignUpId.text.toString())
            intent.putExtra("pw", etSignUpPw.text.toString())
        }
        startActivity(intent)
        finish()
    }
}