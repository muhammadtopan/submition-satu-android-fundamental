package com.fano.administrasiinfrastrukturjaringan.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataKd implements Parcelable {
    private int gambarKd;
    private String kd;
    private String judulKd;
    private String pdfKd;

    public DataKd() {
    }

    protected DataKd(Parcel in) {
        gambarKd = in.readInt();
        kd = in.readString();
        judulKd = in.readString();
        pdfKd = in.readString();
    }

    public static final Creator<DataKd> CREATOR = new Creator<DataKd>() {
        @Override
        public DataKd createFromParcel(Parcel in) {
            return new DataKd(in);
        }

        @Override
        public DataKd[] newArray(int size) {
            return new DataKd[size];
        }
    };

    public int getGambarKd() {
        return gambarKd;
    }

    public void setGambarKd(int gambarKd) {
        this.gambarKd = gambarKd;
    }

    public String getKd() {
        return kd;
    }

    public void setKd(String kd) {
        this.kd = kd;
    }

    public String getJudulKd() {
        return judulKd;
    }

    public void setJudulKd(String judulKd) {
        this.judulKd = judulKd;
    }

    public String getPdfKd() {
        return pdfKd;
    }

    public void setPdfKd(String pdfKd) {
        this.pdfKd = pdfKd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(gambarKd);
        dest.writeString(kd);
        dest.writeString(judulKd);
        dest.writeString(pdfKd);
    }
}
