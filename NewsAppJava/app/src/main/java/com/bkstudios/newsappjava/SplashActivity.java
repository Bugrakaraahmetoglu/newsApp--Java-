package com.bkstudios.newsappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_DURATION = 3000; // 3 saniye


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Splash süresi dolduğunda yapılacak işlemler
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish(); // Bu aktiviteyi kapat
            }
        }, SPLASH_DISPLAY_DURATION);
    }
}