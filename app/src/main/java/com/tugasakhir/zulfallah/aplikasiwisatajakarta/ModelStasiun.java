package com.tugasakhir.zulfallah.aplikasiwisatajakarta;

/**
 * Created by truenull on 08/10/17.
 */

public class ModelStasiun {
    String nama;
    String nama_Akses_kendaraan;
    double jarak;
    String waktu;
    int ImageResourceID;
    double latitude;
    double longitude;

    public String getNama_Akses_kendaraan() {
        return nama_Akses_kendaraan;
    }

    public void setNama_Akses_kendaraan(String nama_Akses_kendaraan) {
        this.nama_Akses_kendaraan = nama_Akses_kendaraan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }

    public int getImageResourceID() {
        return ImageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        ImageResourceID = imageResourceID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
