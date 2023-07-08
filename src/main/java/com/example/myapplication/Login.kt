package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.email.editText?.text.toString(),
            binding.password.editText?.text.toString()).addOnCompleteListener {
                if (it.isSuccessful)
                {
                    Toast.makeText(this,"User Created !!!",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"User Not Created !!!",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}