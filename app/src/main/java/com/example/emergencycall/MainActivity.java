package com.example.emergencycall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPolisi, btnRumahSakit, btnDamkar, btnLain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DarkMode.getInstance().isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.darkMode:
                DarkMode.getInstance().setIsNightModeEnabled(true);
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
                break;

            case R.id.lightMode:
                DarkMode.getInstance().setIsNightModeEnabled(false);
                intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
                break;
        }
        return true;
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