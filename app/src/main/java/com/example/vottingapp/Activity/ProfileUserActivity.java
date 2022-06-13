package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vottingapp.R;
import com.example.vottingapp.utils.SessionManager;

import java.util.HashMap;

public class ProfileUserActivity extends AppCompatActivity {
    ImageView profile_image;
    ImageButton btn_logout;
    TextView userName, userEmail, userNik, userTempatTinggal, userTelepon, userStatus, userTentangKami;
    ImageButton btn_home, btn_hasil, btn_berita, btn_akun;
    SessionManager sessionUser;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);
        sessionUser = new SessionManager(this);

        profile_image = findViewById(R.id.profile_iv_image);
        userName = findViewById(R.id.profile_tv_user);
        userEmail = findViewById(R.id.profile_tv_email);
        userNik = findViewById(R.id.profile_tv_nik);
        userTempatTinggal = findViewById(R.id.profile_tv_tempattinggal);
        userTelepon = findViewById(R.id.profile_tv_nomorhp);
        userStatus = findViewById(R.id.profile_tv_status);
        userTentangKami = findViewById(R.id.profile_tv_about);

        // BUTTON MENU
        btn_home = findViewById(R.id.user_ib_home);
        btn_hasil = findViewById(R.id.user_ib_hasil);
        btn_berita = findViewById(R.id.user_ib_berita);
        btn_akun = findViewById(R.id.user_ib_user);

        btn_logout = findViewById(R.id.profile_ib_logout);


        HashMap<String, String> user = sessionUser.getUserDetail();

        int statusVottingInteger = Integer.parseInt(user.get("statusVotting"));
        String statusvoting;
        if (statusVottingInteger == 1) {
            statusvoting = "Sudah Voting";
            userStatus.setTextColor(Color.GREEN);
        } else {
            statusvoting = "Belum Voting";
            userStatus.setTextColor(Color.RED);
        }
        String profileImageUrl = user.get("imageUrl");
        userEmail.setText(user.get("email"));
        userName.setText(user.get("namaLengkap"));
        userNik.setText(user.get("nik"));
        userTempatTinggal.setText(user.get("tempatTinggal"));
        userTelepon.setText(user.get("noHP"));
        userStatus.setText(statusvoting);

        Glide.with(this).load(profileImageUrl).into(profile_image);
        initButton();
    }
    private void initButton(){
        userTentangKami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileUserActivity.this, TentangKamiActivity.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionUser.logoutUser();
                Intent intent = new Intent(ProfileUserActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();


            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileUserActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileUserActivity.this, MenuHasilVotingActivity.class);
                startActivity(intent);
            }
        });

        btn_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileUserActivity.this, BeritaActivity.class);
                startActivity(intent);
            }
        });

        btn_akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileUserActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
    }
}