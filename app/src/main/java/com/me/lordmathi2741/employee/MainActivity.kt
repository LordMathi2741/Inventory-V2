package com.me.lordmathi2741.employee

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSignUp = findViewById<Button>(R.id.btSignUp)
        val btnSignIn = findViewById<Button>(R.id.btSignIn)
        btnSignUp.setOnClickListener {
            redirectToSignUpActivity(it)
        }
        btnSignIn.setOnClickListener {
            redirectToInventoryActivity(it)
        }
    }

    private fun redirectToSignUpActivity(view: View){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun redirectToInventoryActivity(view: View){
        val intent = Intent(this, InventoryActivity::class.java)
        startActivity(intent)
    }
}