package com.example.vottingapp.Model.viewkandidatinfo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DataKandidat {

    @SerializedName("id_kandidat")
    @Expose
    private String idKandidat;
    @SerializedName("nama_cagub")
    @Expose
    private String namaCagub;
    @SerializedName("ttl_cagub")
    @Expose
    private String ttlCagub;
    @SerializedName("pendidikan_cagub")
    @Expose
    private String pendidikanCagub;
    @SerializedName("bio_cagub")
    @Expose
    private String bioCagub;
    @SerializedName("img_cagub")
    @Expose
    private String imgCagub;
    @SerializedName("nama_wagub")
    @Expose
    private String namaWagub;
    @SerializedName("ttl_wagub")
    @Expose
    private String ttlWagub;
    @SerializedName("pendidikan_wagub")
    @Expose
    private String pendidikanWagub;
    @SerializedName("bio_wagub")
    @Expose
    private String bioWagub;
    @SerializedName("img_wagub")
    @Expose
    private String imgWagub;

    public String getIdKandidat() {
        return idKandidat;
    }

    public void setIdKandidat(String idKandidat) {
        this.idKandidat = idKandidat;
    }

    public String getNamaCagub() {
        return namaCagub;
    }

    public void setNamaCagub(String namaCagub) {
        this.namaCagub = namaCagub;
    }

    public String getTtlCagub() {
        return ttlCagub;
    }

    public void setTtlCagub(String ttlCagub) {
        this.ttlCagub = ttlCagub;
    }

    public String getPendidikanCagub() {
        return pendidikanCagub;
    }

    public void setPendidikanCagub(String pendidikanCagub) {
        this.pendidikanCagub = pendidikanCagub;
    }

    public String getBioCagub() {
        return bioCagub;
    }

    public void setBioCagub(String bioCagub) {
        this.bioCagub = bioCagub;
    }

    public String getImgCagub() {
        return imgCagub;
    }

    public void setImgCagub(String imgCagub) {
        this.imgCagub = imgCagub;
    }

    public String getNamaWagub() {
        return namaWagub;
    }

    public void setNamaWagub(String namaWagub) {
        this.namaWagub = namaWagub;
    }

    public String getTtlWagub() {
        return ttlWagub;
    }

    public void setTtlWagub(String ttlWagub) {
        this.ttlWagub = ttlWagub;
    }

    public String getPendidikanWagub() {
        return pendidikanWagub;
    }

    public void setPendidikanWagub(String pendidikanWagub) {
        this.pendidikanWagub = pendidikanWagub;
    }

    public String getBioWagub() {
        return bioWagub;
    }

    public void setBioWagub(String bioWagub) {
        this.bioWagub = bioWagub;
    }

    public String getImgWagub() {
        return imgWagub;
    }

    public void setImgWagub(String imgWagub) {
        this.imgWagub = imgWagub;
    }

}