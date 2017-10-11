package com.tugasakhir.zulfallah.aplikasiwisatajakarta;

/**
 * Created by truenull on 08/10/17.
 */

public class ModelStasiun {
    String nama;
    String jarak;
    String waktu;
    int ImageResourceID;
    double latitude;
    double longitude;

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

    public String getJarak() {
        return jarak;
    }

    public void setJarak(String jarak) {
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
