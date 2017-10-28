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
public class TransJakarta extends Fragment {

    ArrayList<ModelStasiun> listItems = new ArrayList<>();
    RecyclerView mRecyclerView;

    String[] nama_stasiun = {
            "PGC",
            "BKN",
            "CAWANG-UKI",
            "BNN",
            "Cawang Otista",
            "Gelanggang Remaja",
            "Bidara Cina",
            "Kebon Pala",
            "Slamet Riyadi",
            "Tegalan",
            "Matraman 1",
            "Salemba Carolus",
            "Salemba UI",
            "Kramat Sentiong NU",
            "Pal Putih",
            "Budi Utomo",
            "Pasar Baru Timur",
            "Jembatan Merah",
            "Mangga Dua Square",
            "Pademangan",
            "Ancol",
            "Pasar Jatinegara",
            "Jatinegara Rs. Premier",
            "Kampung Melayu"
    };
    double[] latitude_stasiun = {
            -6.262454,
            -6.257816,
            -6.249639,
            -6.245900,
            -6.231830,
            -6.234411,
            -6.229800,
            -6.212873,
            -6.208446,
            -6.202929,
            -6.199963,
            -6.196825,
            -6.193353,
            -6.187842,
            -6.184559,
            -6.166055,
            -6.162343,
            -6.146712,
            -6.136911,
            -6.133740,
            -6.127496,
            -6.215731,
            -6.221423,
            -6.224627
    };
    double[] longitude_stasiun = {
            106.866353,
            106.869950,
            106.873704,
            106.871795,
            106.868437,
            106.867621,
            106.867306,
            106.861184,
            106.859244,
            106.857121,
            106.854473,
            106.851149,
            106.848876,
            106.845863,
            106.843991,
            106.838883,
            106.838140,
            106.834275,
            106.832400,
            106.831657,
            106.830411,
            106.866304,
            106.868070,
            106.866834
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeList();

    }


    public TransJakarta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trans_jakarta, container, false);

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
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items_stasiun, parent,false);

            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.namaHalte.setText(list.get(position).getNama());
            holder.jarakkewisata.setText("Jarak ke Wisata : " + ((int) list.get(position).getJarak()+" km "));
            holder.waktukewisata.setText("Waktu Tempu ke Wisata : " + list.get(position).getWaktu()+" menit ");
            holder.saran_akses.setText("Disarankan Menggunakan Kendaraan : " + list.get(position).getNama_Akses_kendaraan());
            holder.coverImage.setTag(list.get(position).getImageResourceID());


        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView namaHalte;
            TextView jarakkewisata;
            TextView waktukewisata;
            TextView saran_akses;
            ImageView coverImage;
            CardView cardView;


            public MyViewHolder(View v) {
                super(v);

                coverImage =  v.findViewById(R.id.coverImageView);
                namaHalte =  v.findViewById(R.id.namaStasiun_halte);
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
            float kecepatan= 80;
            float distance_posisi_user=results[0];
            item.setNama(nama_stasiun[i]);
//            item.setJarak(((distance+distance_posisi_user)/1000));
            float distance_all=((distance+distance_posisi_user)/1000);
            System.out.println(distance_all);
            float waktu= distance_all/kecepatan;
            float waktu_per_menit= Math.round(waktu * 60) ;

            item.setJarak(distance_all);
            item.setWaktu(String.valueOf((int)waktu_per_menit));
            if(distance_all>3.0){
                item.setNama_Akses_kendaraan("Ojek Online");
            }else{
                item.setNama_Akses_kendaraan("Berjalan Kaki");
            }
            listItems.add(item);
        }

    }

}
