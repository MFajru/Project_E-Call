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


public class ActivityRumahSakit extends AppCompatActivity {
    private RsAdapter rsAdapter;
    private String[] dataNamaRs;
    private String[] dataNomorRs;
    private ArrayList<RumahSakit> rumahSakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah_sakit);
        ListView listViewRs = findViewById(R.id.list_rs);
        rsAdapter = new RsAdapter(this);
        listViewRs.setAdapter(rsAdapter);

        prepare();
        addItem();

        listViewRs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent dialPhoneRs = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + rumahSakit.get(i).getNomorRs()));
                startActivity(dialPhoneRs);
            }
        });
    }

    private void prepare() {
        dataNamaRs = getResources().getStringArray(R.array.data_namarumahsakit);
        dataNomorRs = getResources().getStringArray(R.array.data_nomorrumahsakit);
    }

    private void addItem() {
        rumahSakit = new ArrayList<>();
        for (int i = 0; i < dataNamaRs.length; i++) {
            RumahSakit rs = new RumahSakit();
            rs.setNamaRs(dataNamaRs[i]);
            rs.setNomorRs(dataNomorRs[i]);
            rumahSakit.add(rs);
        }
        rsAdapter.setRs(rumahSakit);
    }

}