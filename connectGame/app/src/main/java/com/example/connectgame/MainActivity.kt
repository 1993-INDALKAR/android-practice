package com.example.connectgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
//import android.widget.*
import androidx.gridlayout.widget.GridLayout;
import androidx.core.view.iterator

class MainActivity : AppCompatActivity() {
    //0:yellow, 1:red
    private var activePlayer = 0;
    private var gameState = arrayOf<Int>(2,2,2,2,2,2,2,2,2);
    private val winningPositions:Array<IntArray> = arrayOf(intArrayOf(0,1,2), intArrayOf(3,4,5),intArrayOf(6,7,8),intArrayOf(0,3,6),
        intArrayOf(1,4,7), intArrayOf(2,5,8),intArrayOf(0,4,8),intArrayOf(2,4,6));
    private var gameActive = true;

    fun dropIn(view: View){
        Log.i("Info","Image view clicked");



        val imageView: ImageView = view as ImageView;

        val tappedCounter = Integer.parseInt(imageView.tag.toString());

        if(gameState[tappedCounter] == 2 && gameActive) {


            gameState[tappedCounter] = activePlayer;


//        imageView.translationY(-1500F);



            if (activePlayer == 0) {
                imageView.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                imageView.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

//        imageView.animate().translationYBy(1500F).duration = 300;

            for (winningPosition in winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    var won = "";

                    gameActive = false;

                    if (activePlayer == 1) {
                        won = "Player 2 won the GAME."
                    } else {
                        won = "Player 1 won the GAME."
                    }

                    Toast.makeText(this, won, Toast.LENGTH_SHORT).show();
                    
                    val playAgainButton = findViewById<Button>(R.id.playAgainId);
                    val textView = findViewById<TextView>(R.id.textView);
                    
                    textView.text = won;
                    textView.visibility = View.VISIBLE;
                    playAgainButton.visibility = View.VISIBLE;
                }
            }


        }

    }

    fun playAgain(view:View){

        val playAgainButton = findViewById<Button>(R.id.playAgainId);
        val textView = findViewById<TextView>(R.id.textView);

        playAgainButton.visibility = View.INVISIBLE;
        textView.visibility = View.INVISIBLE;

        val gridLayouts = findViewById<GridLayout>(R.id.gridLayout1);
        val gridCount = gridLayouts.childCount;
        for(count in 0 until gridCount){
            val counter = gridLayouts.getChildAt(count) as ImageView;
            counter.setImageDrawable(null);
        }

        activePlayer = 0;
        gameState = arrayOf<Int>(2,2,2,2,2,2,2,2,2);
        gameActive = true;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}




private operator fun Float.invoke(fl: Float) {

}

