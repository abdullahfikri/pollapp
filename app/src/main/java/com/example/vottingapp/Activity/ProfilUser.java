package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vottingapp.R;
import com.example.vottingapp.utils.SessionManager;

import java.util.HashMap;
import java.util.Objects;

public class ProfilUser extends AppCompatActivity {
    TextView tv_email, tv_nik, tv_namalengkap, tv_statusvoting, tv_img;
    ImageView image;
    String id;
    SessionManager sessionUser;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USER = "userId";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String NIK = "nik";
    public static final String NAMA_LENGKAP = "namaLengkap";
    public static final String NOMOR_HP = "noHP";
    public static final String STATUS_VOTTING = "statusVotting";
    public static final String TEMPAT_TINGGAL = "tempatTinggal";
    public static final String IMG_URL = "imageUrl";

    public String getId() {
        return id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);
        sessionUser = new SessionManager(this);
        tv_email = findViewById(R.id.tv_email);
        tv_nik = findViewById(R.id.tv_nik);
        tv_namalengkap = findViewById(R.id.tv_namalengkap);
        tv_statusvoting = findViewById(R.id.tv_statusvoting);
        tv_img = findViewById(R.id.tv_img);
        image = findViewById(R.id.image_profile);

        HashMap<String, String> user = sessionUser.getUserDetail();

        int statusvotingint = Integer.parseInt(Objects.requireNonNull(user.get(STATUS_VOTTING)));

        String statusvoting;
        if (statusvotingint == 1) {
            statusvoting = "Sudah Voting";
        } else {
            statusvoting = "Belum Voting";
        }
        String imageProfileUrl = user.get(IMG_URL);

        tv_email.setText(user.get(EMAIL));
        tv_nik.setText(user.get(NIK));
        tv_namalengkap.setText(user.get(NAMA_LENGKAP));
        tv_statusvoting.setText(statusvoting);


        Glide.with(this).load(imageProfileUrl).into(image);
    }
}