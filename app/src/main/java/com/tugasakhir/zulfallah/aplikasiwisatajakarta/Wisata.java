package com.tugasakhir.zulfallah.aplikasiwisatajakarta;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
public class Wisata extends Fragment {

    ArrayList<ModelWisata> listItems = new ArrayList<>();
    RecyclerView mRecyclerView;
    String namaWisata[] = {"Dunia Fantasi", "Kebun Binatang Ragunan","Museum Fatahillah", "Monumen Nasional", "Taman Mini Indonesia Indah"};
    String haribuka[] = {"Senin-Minggu & Libur Nasional", "Selasa-Minggu", "Selasa-Minggu", "Senin-Minggu", "Senin-Minggu"};
    String jambuka[] = {"10:00 - 20:00", "06:00 - 16:00", "09:00 - 15:00", "09:00-16:00", "07:00 - 22:00"};
    double latitude[] = {-6.123741,-6.312382, -6.134256, -6.175254, -6.302444};
    double longitude[] = {106.831909, 106.820577, 106.813123, 106.827582,106.895258};
    int Images[] = {R.mipmap.dufan, R.mipmap.ragunan, R.mipmap.fatahillah, R.mipmap.monas2, R.mipmap.tmii};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeList();

    }


    public Wisata() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wisata, container, false);
        mRecyclerView = view.findViewById(R.id.cardView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(getActivity());
        myLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (listItems.size() > 0 & mRecyclerView != null) {
            mRecyclerView.setAdapter(new MyAdapter(listItems));
        }

        mRecyclerView.setLayoutManager(myLinearLayoutManager);

        ImageView imageView = view.findViewById(R.id.iv_back_listwisata);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Menu();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container,fragment);
                ft.commit();
            }
        });

        return view;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


        public ArrayList<ModelWisata> list;

        public MyAdapter(ArrayList<ModelWisata> Data) {
            list = Data;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items, parent,false);

            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.namaWisata.setText(list.get(position).getNama());
            holder.tanggalBuka.setText(list.get(position).getTanggal());
            holder.waktuBuka.setText(list.get(position).getJam());
            holder.koordinat.setText(list.get(position).getLatitude()+"," + list.get(position).getLongitude());
            holder.coverImage.setImageResource(list.get(position).getImageResourceID());
            holder.coverImage.setTag(list.get(position).getImageResourceID());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), ListKendaraan.class);
                    startActivity(intent);
                }
            });


        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView namaWisata;
            TextView tanggalBuka;
            TextView waktuBuka;
            TextView koordinat;
            ImageView coverImage;
            CardView cardView;


            public MyViewHolder(View v) {
                super(v);

                coverImage =  v.findViewById(R.id.coverImageView);
                namaWisata =  v.findViewById(R.id.namaWisata);
                tanggalBuka =  v.findViewById(R.id.tgl_buka);
                waktuBuka = v.findViewById(R.id.waktu_buka);
                koordinat = v.findViewById(R.id.koordinat);
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
            ModelWisata item = new ModelWisata();
            item.setNama(namaWisata[i]);
            item.setTanggal(haribuka[i]);
            item.setJam(jambuka[i]);
            item.setLatitude(latitude[i]);
            item.setLongitude(longitude[i]);
            item.setImageResourceID(Images[i]);
            listItems.add(item);
        }
    }
}
