package com.example.vottingapp.Model.viewkandidat;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_cagub")
    @Expose
    private String namaCagub;
    @SerializedName("nama_wagub")
    @Expose
    private String namaWagub;
    @SerializedName("nomor_urut")
    @Expose
    private String nomorUrut;
    @SerializedName("img")
    @Expose
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaCagub() {
        return namaCagub;
    }

    public void setNamaCagub(String namaCagub) {
        this.namaCagub = namaCagub;
    }

    public String getNamaWagub() {
        return namaWagub;
    }

    public void setNamaWagub(String namaWagub) {
        this.namaWagub = namaWagub;
    }

    public String getNomorUrut() {
        return nomorUrut;
    }

    public void setNomorUrut(String nomorUrut) {
        this.nomorUrut = nomorUrut;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}