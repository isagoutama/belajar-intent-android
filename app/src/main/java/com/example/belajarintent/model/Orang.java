package com.example.belajarintent.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Orang implements Parcelable {
    private String nama;
    private int umur;
    private String kota;



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeInt(this.umur);
        dest.writeString(this.kota);
    }

    public Orang() {
    }

    protected Orang(Parcel in) {
        this.nama = in.readString();
        this.umur = in.readInt();
        this.kota = in.readString();
    }

    public static final Parcelable.Creator<Orang> CREATOR = new Parcelable.Creator<Orang>() {
        @Override
        public Orang createFromParcel(Parcel source) {
            return new Orang(source);
        }

        @Override
        public Orang[] newArray(int size) {
            return new Orang[size];
        }
    };
}
