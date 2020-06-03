package com.example.downloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    public void downLoadImage(View view) throws ExecutionException, InterruptedException {
        Log.i("Button","Downloading image");
        ImageDownload task = new ImageDownload();
        Bitmap myImage;

        myImage = task.execute("https://thenypost.files.wordpress.com/2016/09/tv_simpsons_homer1-1a.jpg?quality=80&strip=all&strip=all").get();

        imageView.setImageBitmap(myImage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

    }

    public class ImageDownload extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.connect();

                InputStream io = urlConnection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(io);

                return myBitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
