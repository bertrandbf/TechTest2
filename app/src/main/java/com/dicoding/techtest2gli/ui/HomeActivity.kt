package com.dicoding.techtest2gli.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.techtest2gli.R
import com.dicoding.techtest2gli.StudentAdapter
import com.dicoding.techtest2gli.databinding.ActivityHomeBinding
import com.dicoding.techtest2gli.model.StudentData

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvStudent
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter(StudentData.dummyStudent)
        recyclerView.adapter = adapter

        binding.ivLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this@HomeActivity)
            val alert = builder.create()
            builder
                .setTitle(getString(R.string.logout))
                .setMessage(getString(R.string.logoutDesc))
                .setPositiveButton(getString(R.string.logoutCancel)){_, _ ->
                    alert.cancel()
                }
                .setNegativeButton(getString(R.string.yes)){_, _ ->
                    logout()
                }
                .show()
        }
    }

    private fun logout(){
        Toast.makeText(this, R.string.logoutSuccess, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}