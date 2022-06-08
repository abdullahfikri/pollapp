package com.example.vottingapp.API;

import com.example.vottingapp.Model.login.ResponseLogin;
import com.example.vottingapp.Model.register.ResponseRegister;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
            @Part MultipartBody.Part image
            );
}
