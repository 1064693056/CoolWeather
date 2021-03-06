package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView view;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.view = (TextView) findViewById(R.id.abc);
        this.button=(Button)findViewById(R.id.btn);
        this.button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public  void onClick(View v){
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        String wweatherId = "CN101270104";
        String weatherUrl = "http://guolin.tech/api/weather?cityid=" + wweatherId + "&key=f2f20935bd70455b83730a9973dadf54";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        view.setText(responseText);

                    }});
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }
        });
    }}