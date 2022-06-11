package com.example.vottingapp.Model.viewkandidatinfo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ResponseKandidatInfo {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data_kandidat")
    @Expose
    private DataKandidat dataKandidat;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataKandidat getDataKandidat() {
        return dataKandidat;
    }

    public void setDataKandidat(DataKandidat dataKandidat) {
        this.dataKandidat = dataKandidat;
    }

}