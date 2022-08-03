package com.example.thingspeak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean processing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        TextView tvMsg  = findViewById(R.id.tvMsg);
        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.thingspeak.com/update?api_key=PSG2DVWZ0T0E2N6R&field1=2000";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                tvMsg.setText("Response is: " + response.substring(0,response.length()));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvMsg.setText("That didn't work!");
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });

        logData(20);

    }

    protected void logData(int t) {
        final long interval = t * 1000;
        ArrayList<Long> time = new ArrayList<>();
        ArrayList<Integer> dist = new ArrayList<>();

        while (true) {
            Long now = System.currentTimeMillis();
            // remove old data
            for (int i=0; i<time.size(); i++) {
                if (time.get(i) + t*1000 < now) {
                    time.remove(i);
                    dist.remove(i);
                }
            }

            // add new data
            time.add(now);
            dist.add((int) (Math.random() * 202));

            // find out if is it always too close
            boolean close = true;
            for (int i=0; i<time.size(); i++) {
                if (dist.get(i) > 200) {
                    close = false;
                }
            }
            System.out.println(close);
        }


        /*
        long lastLogged = System.currentTimeMillis();
        while (processing) {
            if (System.currentTimeMillis() - lastLogged > interval) {
                lastLogged = System.currentTimeMillis();
                // log To Database;


            }
            // do rest of processing
        }

         */
    }
}