package com.tugasakhir.zulfallah.aplikasiwisatajakarta;


import android.location.Location;
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

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StasiunKeretaApi extends Fragment {


    ArrayList<ModelStasiun> listItems = new ArrayList<>();
    RecyclerView mRecyclerView;

    String[] nama_stasiun = {
            "Stasiun Ancol",
            "Stasiun Angke",
            "Stasiun Bojong Indah",
            "Stasiun Buaran",
            "Stasiun Cakung",
            "Stasiun Cawang",
            "Stasiun Cikini",
            "Stasiun Cipinang",
            "Stasiun Duren Kalibata",
            "Stasiun Duri",
            "Stasiun Gambir",
            "Stasiun Gang Sentiong",
            "Stasiun Gondangdia",
            "Stasiun Grogol",
            "Stasiun Jakarta Gudang",
            "Stasiun Jakarta Kota",
            "Stasiun Jatinegara",
            "Stasiun Jayakarta",
            "Stasiun Juanda",
            "Stasiun Kalideres",
            "Stasiun Kampung Bandan",
            "Stasiun Karet",
            "Stasiun Kebayoran",
            "Stasiun Kemayoran",
            "Stasiun Klender",
            "Stasiun Klender Baru",
            "Stasiun Kramat",
            "Stasiun Lenteng Agung",
            "Stasiun Mangga Besar",
            "Stasiun Manggarai",
            "Stasiun Palmerah",
            "Stasiun Pasar Minggu",
            "Stasiun Pasar Minggu Baru",
            "Stasiun Pasar Senen",
            "Stasiun Pesing",
            "Stasiun Rajawali",
            "Stasiun Salemba",
            "Stasiun Sawah Besar",
            "Stasiun Rawa Buaya",
            "Stasiun Sudirman",
            "Stasiun Taman Kota",
            "Stasiun Tanahabang",
            "Stasiun Tanjung Barat",
            "Stasiun Tanjung Priok",
            "Stasiun Tebet",
            "Stasiun Universitas Pancasila",
            "Stasiun Pondok Jati",
            "Bekasi",
            "Kranji",
            "Cakung",
            "Klender Baru",
            "Buaran",
            "Klender",
            "Cipinang",
            "Manggarai",
            "Tebet",
            "Cawang",
            "Duren Kalibata",
            "Pasar Minggu Baru",
            "Pasar Minggu",
            "Tanjung Barat",
            "Lenteng Agung",
            "Universitas Pancasila",
            "Universitas Indonesia",
            "Pondok Cina",
            "Depok Baru",
            "Depok",
            "Citayam",
            "Bojong Gede",
            "Cilebut",
            "Bogor"
    };
    double[] latitude_stasiun = {
            -6.1280,
            -6.1444,
            -6.1602,
            -6.2163,
            -6.2193,
            -6.2427,
            -6.1986,
            -6.2141,
            -6.2553,
            -6.1559,
            -6.1767,
            -6.1859,
            -6.1861,
            -6.1620,
            -6.1346,
            -6.1376,
            -6.2153,
            -6.1413,
            -6.1673,
            -6.1661,
            -6.1329,
            -6.2009,
            -6.2372,
            -6.1623,
            -6.2133,
            -6.2176,
            -6.1938,
            -6.3306,
            -6.1498,
            -6.2099,
            -6.2074,
            -6.2838,
            -6.2628,
            -6.1750,
            -6.1612,
            -6.1450,
            -6.1937,
            -6.1607,
            -6.1627,
            -6.2024,
            -6.1585,
            -6.1858,
            -6.3079,
            -6.1107,
            -6.2261,
            -6.3389,
            -6.2091,
            -6.235714,
            -6.224312,
            -6.219287,
            -6.217625,
            -6.216309,
            -6.213294,
            -6.214099,
            -6.209985,
            -6.226081,
            -6.242681,
            -6.255369,
            -6.262752,
            -6.283708,
            -6.307826,
            -6.330651,
            -6.338589,
            -6.360694,
            -6.368823,
            -6.390956,
            -6.404786,
            -6.448522,
            -6.493006,
            -6.530486,
            -6.595575
    };
    double[] longitude_stasiun = {
            106.8451,
            106.8007,
            106.7363,
            106.9283,
            106.9522,
            106.8588,
            106.8413,
            106.8851,
            106.8550,
            106.8014,
            106.8307,
            106.8507,
            106.8327,
            106.7893,
            106.8196,
            106.8146,
            106.8702,
            106.8231,
            106.8305,
            106.7038,
            106.8283,
            106.8159,
            106.7825,
            106.8415,
            106.8991,
            106.9395,
            106.8565,
            106.8349,
            106.8270,
            106.8502,
            106.7976,
            106.8442,
            106.8518,
            106.8454,
            106.7715,
            106.8367,
            106.8490,
            106.8276,
            106.7236,
            106.8234,
            106.7561,
            106.8108,
            106.8388,
            106.8815,
            106.8583,
            106.8344,
            106.8623,
            107.003144,
            106.979485,
            106.952282,
            106.939593,
            106.928423,
            106.899247,
            106.885467,
            106.850720,
            106.858387,
            106.859161,
            106.855380,
            106.851838,
            106.844216,
            106.838828,
            106.834977,
            106.834393,
            106.831730,
            106.832187,
            106.821655,
            106.817258,
            106.802501,
            106.794895,
            106.800549,
            106.790408
    };
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
            holder.jarakkewisata.setText("Jarak ke Wisata : " + ((int) list.get(position).getJarak()+" km "));
            holder.waktukewisata.setText("Waktu Tempu ke Wisata : " + list.get(position).getWaktu()+" menit ");
            holder.saran_akses.setText("Disarankan Menggunakan Kendaraan : " + list.get(position).getNama_Akses_kendaraan());
            holder.coverImage.setTag(list.get(position).getImageResourceID());


        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView namaStasiun;
            TextView jarakkewisata;
            TextView waktukewisata;
            TextView saran_akses;
            ImageView coverImage;
            CardView cardView;


            public MyViewHolder(View v) {
                super(v);

                coverImage =  v.findViewById(R.id.coverImageView);
                namaStasiun =  v.findViewById(R.id.namaStasiun_halte);
                jarakkewisata =  v.findViewById(R.id.jarak_tempuh);
                waktukewisata = v.findViewById(R.id.waktu_ke_wisata);
                saran_akses = v.findViewById(R.id.saran_akses);
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
        Bundle bundle = this.getActivity().getIntent().getExtras();
        Double latitude_lokasi = bundle.getDouble("Latitude_tujuan");
        Double longitude_lokasi = bundle.getDouble("Longitude_tujuan");
        GPSTracker gpsTracker= new GPSTracker(this.getContext(),this.getActivity());
        final LatLng[] latLng_user = new LatLng[1];
        latLng_user[0] = new LatLng(gpsTracker.latitude,gpsTracker.longitude);
        for (int i = 0; i<nama_stasiun.length; i++) {
            float[] results = new float[1];

            ModelStasiun item = new ModelStasiun();

            Location.distanceBetween(latitude_lokasi, longitude_lokasi,
                    latitude_stasiun[i], longitude_stasiun[i], results);
            float distance=results[0];
            results = new float[1];
            Location.distanceBetween( latitude_stasiun[i], longitude_stasiun[i],
                    latLng_user[0].latitude, latLng_user[0].longitude, results);
            float kecepatan= 60;
            float distance_posisi_user=results[0];
            item.setNama(nama_stasiun[i]);
//            item.setJarak(((distance+distance_posisi_user)/1000));
            float distance_all=((distance+distance_posisi_user)/1000);
            System.out.println(distance_all);
            float waktu= distance_all/kecepatan;
            float waktu_per_menit= (int)waktu * 60 ;

            item.setJarak(distance_all);
            item.setWaktu(String.valueOf((int)waktu_per_menit));
            listItems.add(item);
        }


    }

}
