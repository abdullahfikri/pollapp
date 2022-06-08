package com.example.vottingapp.Model.login;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("namalengkap")
    @Expose
    private String namalengkap;
    @SerializedName("statusvoting")
    @Expose
    private String statusvoting;
    @SerializedName("tempattinggal")
    @Expose
    private String tempattinggal;
    @SerializedName("imgurl")
    @Expose
    private String imgurl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getStatusvoting() {
        return statusvoting;
    }

    public void setStatusvoting(String statusvoting) {
        this.statusvoting = statusvoting;
    }

    public String getTempattinggal() {
        return tempattinggal;
    }

    public void setTempattinggal(String tempattinggal) {
        this.tempattinggal = tempattinggal;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

}