package com.example.vottingapp.API;

import com.example.vottingapp.Model.hasilvoting.ResponseHasilVote;
import com.example.vottingapp.Model.login.ResponseLogin;
import com.example.vottingapp.Model.register.ResponseRegister;
import com.example.vottingapp.Model.viewkandidat.ResponseViewKandidat;
import com.example.vottingapp.Model.viewkandidatinfo.ResponseKandidatInfo;
import com.example.vottingapp.Model.voting.ResponseVoting;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface APIInterface {
    @FormUrlEncoded
    @POST("loginvote.php")
    Call<ResponseLogin> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @Multipart
    @POST("signupvote.php")
    Call<ResponseRegister> register(
            @Part("email") RequestBody email,
            @Part("password") RequestBody password,
            @Part("namalengkap") RequestBody namalengkap,
            @Part("nik") RequestBody nik,
            @Part("tempattinggal") RequestBody tempattinggal,
            @Part("nomorhp") RequestBody nomorhp,
            @Part MultipartBody.Part image
            );

    @GET("viewvote.php")
    Call<ResponseViewKandidat> viewKandidat();

    @FormUrlEncoded
    @POST("viewkandidatinfo.php")
    Call<ResponseKandidatInfo>  viewKandidatInfo(
            @Field("id_kandidat") String id
    );

    @FormUrlEncoded
    @POST("pemilih.php")
    Call<ResponseVoting> voting(
            @Field("id_kandidat") String id_kandidat,
            @Field("id_user") String id_user
    );

    @GET("gethasilpemilih.php")
    Call<ResponseHasilVote> viewHasilVoting();
}
