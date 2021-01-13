package com.example.emergencycall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RsAdapter extends BaseAdapter {
    private Context contextRs;
    private ArrayList<RumahSakit> rumahSakit = new ArrayList<>();

    public void setRs(ArrayList<RumahSakit> Rs) {
        this.rumahSakit = Rs;
    }

    public RsAdapter(Context contextRs) {
        this.contextRs = contextRs;
    }

    @Override
    public int getCount() {
        return rumahSakit.size();
    }

    @Override
    public Object getItem(int i) {
        return rumahSakit.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewRs, ViewGroup viewGroupRs) {
        View itemViewRs = viewRs;
        if (itemViewRs == null){
            itemViewRs = LayoutInflater.from(contextRs).inflate(R.layout.item_rs, viewGroupRs, false);
        }
        ViewHolderRs viewHolderRs = new ViewHolderRs(itemViewRs);

        RumahSakit rs = (RumahSakit) getItem(i);
        viewHolderRs.bind(rs);
        return itemViewRs;
    }

    private class ViewHolderRs {
        private TextView txtNamaRs;
        private TextView txtNomorRs;

        public ViewHolderRs(View viewRs) {
            txtNamaRs = viewRs.findViewById(R.id.nama_rs);
            txtNomorRs = viewRs.findViewById(R.id.nomor_rs);
        }

        void bind (RumahSakit rs) {
            txtNamaRs.setText(rs.getNamaRs());
            txtNomorRs.setText(rs.getNomorRs());
        }
    }
}
