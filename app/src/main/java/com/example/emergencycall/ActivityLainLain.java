package com.example.emergencycall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActivityLainLain extends AppCompatActivity {
    private LainAdapter lainAdapter;
    private String[] dataNamaLain;
    private String[] dataNomorLain;
    private ArrayList<LainLain> lainLain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lainlain);
        ListView listViewLain = findViewById(R.id.list_lain);
        lainAdapter = new LainAdapter(this);
        listViewLain.setAdapter(lainAdapter);

        prepare();
        addItem();

        listViewLain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent dialPhoneLain = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + lainLain.get(i).getNomorLain()));
                startActivity(dialPhoneLain);
            }
        });
    }

    private void prepare() {
        dataNamaLain = getResources().getStringArray(R.array.data_namalain);
        dataNomorLain = getResources().getStringArray(R.array.data_nomorlain);
    }

    private void addItem() {
        lainLain = new ArrayList<>();
        for (int i = 0; i < dataNamaLain.length; i++) {
            LainLain lain = new LainLain();
            lain.setNamaLain(dataNamaLain[i]);
            lain.setNomorLain(dataNomorLain[i]);
            lainLain.add(lain);
        }
        lainAdapter.setLain(lainLain);
    }

}