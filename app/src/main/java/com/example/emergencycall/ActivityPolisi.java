package com.example.emergencycall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityPolisi extends AppCompatActivity {
    private PolisiAdapter polisiAdapter;
    private String[] dataNamaPolisi;
    private String[] dataNomorPolisi;
    private ArrayList<Polisi> polisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polisi);
        ListView listViewPolisi = findViewById(R.id.list_polisi);
        polisiAdapter = new PolisiAdapter(this);
        listViewPolisi.setAdapter(polisiAdapter);

        prepare();
        addItem();

        listViewPolisi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent dialPhonePolisi = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + polisi.get(i).getNomorPolisi()));
                startActivity(dialPhonePolisi);
            }
        });
    }

    private void prepare() {
        dataNamaPolisi = getResources().getStringArray(R.array.data_namapolisi);
        dataNomorPolisi = getResources().getStringArray(R.array.data_nomorpolisi);
    }

    private void addItem() {
        polisi = new ArrayList<>();
        for (int i = 0; i < dataNamaPolisi.length; i++) {
            Polisi pol = new Polisi();
            pol.setNamaPolisi(dataNamaPolisi[i]);
            pol.setNomorPolisi(dataNomorPolisi[i]);
            polisi.add(pol);
        }
        polisiAdapter.setPol(polisi);
    }
}