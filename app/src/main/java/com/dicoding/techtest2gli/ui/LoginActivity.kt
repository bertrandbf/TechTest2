package com.dicoding.techtest2gli.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.dicoding.techtest2gli.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playAnimation()

        binding.btnLogin.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            Handler().postDelayed({
                loginValidation()
            }, 1500)
        }
    }

    private fun playAnimation(){
        ObjectAnimator.ofFloat(binding.logoGLI, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val tvUsername = ObjectAnimator.ofFloat(binding.layoutUsername, View.ALPHA, 1f).setDuration(1000)
        val tvPassword = ObjectAnimator.ofFloat(binding.layoutPassword, View.ALPHA, 1f).setDuration(1000)
        val btnLogin = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(1000)

        AnimatorSet().apply {
            playSequentially(tvUsername, tvPassword, btnLogin)
            start()
        }
    }

    private fun loginValidation(){
        binding.progressBar.visibility = View.GONE
        val inputUsername = binding.edUsername.text.toString()
        val inputPassword = binding.edPassword.text.toString()

        if (inputUsername.isNotEmpty() && inputPassword.isNotEmpty()) {
            if (inputUsername == "alfagift-admin" && inputPassword == "asdf") {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show()
        }
    }
}