package com.example.images

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun nextImgChange(view: View){
        var imageView = findViewById<ImageView>(R.id.imageView);
        imageView.setImageResource(R.drawable.husky1);
    }
}
