package com.example.emergencycall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LainAdapter extends BaseAdapter {
    private Context contextLain;
    private ArrayList<LainLain> lainLain = new ArrayList<>();

    public void setLain(ArrayList<LainLain> lainLain) {
        this.lainLain = lainLain;
    }

    public LainAdapter(Context contextLain) {
        this.contextLain = contextLain;
    }

    @Override
    public int getCount() {
        return lainLain.size();
    }

    @Override
    public Object getItem(int i) {
        return lainLain.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewLain, ViewGroup viewGroupLain) {
        View itemViewLain = viewLain;
        if (itemViewLain == null){
            itemViewLain = LayoutInflater.from(contextLain).inflate(R.layout.item_lain, viewGroupLain, false);
        }
        ViewHolderLain viewHolderLain = new ViewHolderLain(itemViewLain);

        LainLain lain = (LainLain) getItem(i);
        viewHolderLain.bind(lain);
        return itemViewLain;
    }

    private class ViewHolderLain {
        private TextView txtNamaLain;
        private TextView txtNomorLain;

        public ViewHolderLain(View viewLain) {
            txtNamaLain = viewLain.findViewById(R.id.nama_lain);
            txtNomorLain = viewLain.findViewById(R.id.nomor_lain);
        }

        void bind (LainLain lain) {
            txtNamaLain.setText(lain.getNamaLain());
            txtNomorLain.setText(lain.getNomorLain());
        }
    }
}
