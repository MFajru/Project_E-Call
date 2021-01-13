package com.example.emergencycall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPolisi, btnRumahSakit, btnDamkar, btnLain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPolisi = (Button)findViewById(R.id.btn_polisi);
        btnPolisi.setOnClickListener(this);

        btnRumahSakit = (Button)findViewById(R.id.btn_rumahsakit);
        btnRumahSakit.setOnClickListener(this);

        btnDamkar = (Button)findViewById(R.id.btn_damkar);
        btnDamkar.setOnClickListener(this);

        btnLain = (Button)findViewById(R.id.btn_lain);
        btnLain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_polisi:
                Intent moveIntentPolisi = new Intent(MainActivity.this, ActivityPolisi.class);
                startActivity(moveIntentPolisi);
                break;

            case R.id.btn_rumahsakit:
                Intent moveIntentRumahSakit = new Intent(MainActivity.this, ActivityRumahSakit.class);
                startActivity(moveIntentRumahSakit);
                break;

            case R.id.btn_damkar:
                String nomorDamkar = "0721 252741";
                Intent dialIntentDamkar = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + nomorDamkar));
                startActivity(dialIntentDamkar);
                break;

            case R.id.btn_lain:
                Intent moveIntentLain = new Intent(MainActivity.this, ActivityLainLain.class);
                startActivity(moveIntentLain);
                break;
        }
    }
}