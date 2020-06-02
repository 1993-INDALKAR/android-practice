package com.example.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    fun loginUser(view:View){

        var userName = findViewById<EditText>(R.id.userNameTextView);
        var password = findViewById<EditText>(R.id.passwordTextView);

        Log.i("Username",userName.text.toString());
        Log.i("Password",password.text.toString());

        Toast.makeText(this,"Hello from "+userName.text.toString(),Toast.LENGTH_SHORT).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
