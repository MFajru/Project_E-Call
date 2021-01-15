package com.example.emergencycall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        };
        thread.start();

//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }
//        }, 3000);  //3000 = 3 detik
    }
}