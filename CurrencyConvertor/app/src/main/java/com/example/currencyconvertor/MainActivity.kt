package com.example.currencyconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun convertCurrency(view: View){
        var currency = findViewById<EditText>(R.id.currencyText);
        var convert = currency.text.toString().toDouble() * 76.14;

        Toast.makeText(this,convert.toString(),Toast.LENGTH_SHORT).show();
    }
}
