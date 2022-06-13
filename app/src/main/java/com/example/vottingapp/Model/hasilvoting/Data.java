package com.example.vottingapp.Model.hasilvoting;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("paslon1")
    @Expose
    private Integer paslon1;
    @SerializedName("paslon2")
    @Expose
    private Integer paslon2;
    @SerializedName("paslon3")
    @Expose
    private Integer paslon3;
    @SerializedName("pemilih")
    @Expose
    private Integer pemilih;

    public Integer getPaslon1() {
        return paslon1;
    }

    public void setPaslon1(Integer paslon1) {
        this.paslon1 = paslon1;
    }

    public Integer getPaslon2() {
        return paslon2;
    }

    public void setPaslon2(Integer paslon2) {
        this.paslon2 = paslon2;
    }

    public Integer getPaslon3() {
        return paslon3;
    }

    public void setPaslon3(Integer paslon3) {
        this.paslon3 = paslon3;
    }

    public Integer getPemilih() {
        return pemilih;
    }

    public void setPemilih(Integer pemilih) {
        this.pemilih = pemilih;
    }

}