package com.tugasakhir.zulfallah.aplikasiwisatajakarta;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StasiunKeretaApi extends Fragment {


    ArrayList<ModelStasiun> listItems = new ArrayList<>();
    RecyclerView mRecyclerView;
    String namaStasiun[] = {"Stasiun 1", "Stasiun 2","Stasiun 3", "Stasiun 4", "Stasiun 5"};
    String jarakkewisata[] = {"2 km", "6 km", "8 km", "10 km", "15 km"};
    String waktukewisata[] = {"3 menit", "20 menit", "30 menit", "45 menit", "1 Jam"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeList();

    }

    public StasiunKeretaApi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stasiun_kereta_api, container, false);

        mRecyclerView = view.findViewById(R.id.cardView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(getActivity());
        myLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (listItems.size() > 0 & mRecyclerView != null) {
            mRecyclerView.setAdapter(new MyAdapter(listItems));
        }

        mRecyclerView.setLayoutManager(myLinearLayoutManager);

        return view;

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


        public ArrayList<ModelStasiun> list;

        public MyAdapter(ArrayList<ModelStasiun> Data) {
            list = Data;

        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items_stasiun, parent,false);

            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.namaStasiun.setText(list.get(position).getNama());
            holder.jarakkewisata.setText("Jarak ke Wisata : " + list.get(position).getJarak());
            holder.waktukewisata.setText("Waktu Tempu ke Wisata : " + list.get(position).getWaktu());
            holder.coverImage.setTag(list.get(position).getImageResourceID());


        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView namaStasiun;
            TextView jarakkewisata;
            TextView waktukewisata;
            ImageView coverImage;
            CardView cardView;


            public MyViewHolder(View v) {
                super(v);

                coverImage =  v.findViewById(R.id.coverImageView);
                namaStasiun =  v.findViewById(R.id.namaStasiun_halte);
                jarakkewisata =  v.findViewById(R.id.jarak_tempuh);
                waktukewisata = v.findViewById(R.id.waktu_ke_wisata);
                cardView = v.findViewById(R.id.card_view);
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private void initializeList() {
        listItems.clear();

        for (int i = 0; i<5; i++) {
            ModelStasiun item = new ModelStasiun();
            item.setNama(namaStasiun[i]);
            item.setJarak(jarakkewisata[i]);
            item.setWaktu(waktukewisata[i]);
            listItems.add(item);
        }


    }

}
