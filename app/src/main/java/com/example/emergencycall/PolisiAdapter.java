package com.example.emergencycall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PolisiAdapter extends BaseAdapter {
    private Context contextPolisi;
    private ArrayList<Polisi> polisi = new ArrayList<>();

    public void setPol(ArrayList<Polisi> polisi) {
        this.polisi = polisi;
    }

    public PolisiAdapter(Context contextPolisi) {
        this.contextPolisi = contextPolisi;
    }

    @Override
    public int getCount() {
        return polisi.size();
    }

    @Override
    public Object getItem(int i) {
        return polisi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewPolisi, ViewGroup viewGroupPolisi) {
        View itemViewPolisi = viewPolisi;
        if (itemViewPolisi == null){
            itemViewPolisi = LayoutInflater.from(contextPolisi).inflate(R.layout.item_polisi, viewGroupPolisi, false);
        }
        ViewHolderPolisi viewHolderPolisi = new ViewHolderPolisi(itemViewPolisi);

        Polisi pol = (Polisi) getItem(i);
        viewHolderPolisi.bind(pol);
        return itemViewPolisi;
    }

    private class ViewHolderPolisi {
        private TextView txtNamaPolisi;
        private TextView txtNomorPolisi;

        public ViewHolderPolisi(View viewPolisi) {
            txtNamaPolisi = viewPolisi.findViewById(R.id.nama_polisi);
            txtNomorPolisi = viewPolisi.findViewById(R.id.nomor_polisi);
        }

        void bind (Polisi pol) {
            txtNamaPolisi.setText(pol.getNamaPolisi());
            txtNomorPolisi.setText(pol.getNomorPolisi());
        }
    }
}
