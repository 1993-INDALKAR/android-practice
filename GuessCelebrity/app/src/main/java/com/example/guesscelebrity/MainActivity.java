package com.example.guesscelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> celebUrls = new ArrayList<>();
    ArrayList<String> celebNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadContend task = new DownloadContend();
        String result = null;

        try {
            result = task.execute("https://svenskainfluencers.nu/kandisar/").get();
            Log.i("Result","result will print of web page");
            System.out.println(result);
            String[] splitResult = result.split("<div class=\"entry-content\">");

            Pattern p = Pattern.compile("img src=\"(.*?)\"");
            Matcher m = p.matcher(splitResult[1]);

            while(m.find()){
                Log.i("Info","While loop execution");
                System.out.print(m);  
            }

            p = Pattern.compile("alt=\"(.*?)\"");
            m = p.matcher(splitResult[1]);

            while(m.find()){
                Log.i("Info","While loop execution");
                System.out.print(m.group(1));
            }


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public class DownloadContend extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
                String result = "";
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);
                int data = reader.read();

                while(data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
