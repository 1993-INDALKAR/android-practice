package com.example.shadeimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var bartShading = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fade(view: View){

        val imageView = findViewById<ImageView>(R.id.imageView2);

        val imageView1 = findViewById<ImageView>(R.id.imageViewHomer);

        if (bartShading){

            imageView.animate().alpha(0F).duration = 2000;
            bartShading = false;
            imageView1.animate().alpha(1F).duration = 2000;

        }
        else{
            imageView.animate().alpha(1F).duration = 2000;
//            val imageView1 = findViewById<ImageView>(R.id.imageView2);
            bartShading = true;
            imageView1.animate().alpha(0F).duration = 2000;
        }
//    Log.i("Info","Image view is tapped");


    }

//    fun fadeHomer(view:View){
//        val imageView = findViewById<ImageView>(R.id.imageViewHomer);
//        imageView.animate().alpha(0F).duration = 2000;
//
//        val imageView1 = findViewById<ImageView>(R.id.imageView2);
//        imageView1.animate().alpha(1F).duration = 2000;
//    }
}
