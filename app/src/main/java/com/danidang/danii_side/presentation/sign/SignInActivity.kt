package com.danidang.danii_side.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.danidang.danii_side.presentation.home.HomeActivity
import com.danidang.danii_side.R
import com.danidang.danii_side.databinding.ActivitySignInBinding
import com.danidang.danii_side.util.binding.BindingActivity

class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(DaniSharedPrefernces(this).isLogin)
            moveToHome()
        addListeners()
    }

    private fun addListeners() {
        binding.btnSignUp.setOnClickListener {
            moveToSignUp()
        }
        binding.btnSignIn.setOnClickListener {
            val id = intent.getStringExtra("id").toString()
            val pw = intent.getStringExtra("pw").toString()
            if (id == binding.etSignInId.text.toString() && pw == binding.etSignInPassword.text.toString()) {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_LONG).show()
                DaniSharedPrefernces(this).isLogin = true
                moveToHome()
            }
        }
    }

    private fun moveToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
        finish()
    }

    private fun moveToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}