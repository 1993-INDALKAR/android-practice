package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    DownloadTask task;
    TextView weather;
    TextView temp;
    TextView desc;

    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url = null;
            try {
                url = new URL(urls[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.connect();

                InputStream is = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);
                int data = reader.read();

                while(data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Log.i("JSON",s);
            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("weather");
                JSONArray arr = new JSONArray(weatherInfo);

                for(int i =0;i<arr.length();i++){
                    JSONObject jsonPart = arr.getJSONObject(i);
                    weather.setText(jsonPart.getString("main"));
                    desc.setText(jsonPart.getString("description"));
                    Log.i("Main",jsonPart.getString("main"));
                    Log.i("Description",jsonPart.getString("description"));
                }

                String main = jsonObject.getString("main");
                 arr = new JSONArray(main);

                for(int i =0;i<arr.length();i++){
                    JSONObject jsonPart = arr.getJSONObject(i);
                    temp.setText(jsonPart.getString("temp"));
                    Log.i("Temp",jsonPart.getString("temp"));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = new DownloadTask();
        weather = findViewById(R.id.weather);
        temp = findViewById(R.id.temp);
        desc = findViewById(R.id.desc);

    }

    public void getWeather(View view){
        TextView city = findViewById(R.id.editText);
//        task.execute("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=439d4b804bc8187953eb36d2a8c26a02");
        String url = "api.openweathermap.org/data/2.5/weather?q=" + city +"&appid=439d4b804bc8187953eb36d2a8c26a02";
        task.execute(url);


    }
}
