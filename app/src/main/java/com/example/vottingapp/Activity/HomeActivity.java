package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vottingapp.R;
import com.example.vottingapp.utils.SessionManager;

import java.util.HashMap;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    ImageButton btn_tersedia, btn_berita_satu, btn_berita_dua, btn_home, btn_hasil, btn_berita, btn_user;
    SessionManager sessionUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_home = findViewById(R.id.home_iv_home);
        btn_hasil = findViewById(R.id.home_iv_hasilvote);
        btn_berita = findViewById(R.id.home_iv_berita);
        btn_user = findViewById(R.id.home_iv_profil);
        initMenuButton();

        btn_tersedia = findViewById(R.id.home_iv_gubernur);
        sessionUser = new SessionManager(this);
        if (!sessionUser.isLogginIN()){
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            finish();
            return;
        }

        int statusvotingint = Integer.parseInt(Objects.requireNonNull(sessionUser.getUserDetail().get("statusVotting")));
        Toast.makeText(this, "status" + statusvotingint, Toast.LENGTH_SHORT).show();
        if (statusvotingint != 0) {
            btn_tersedia.setBackgroundResource(R.drawable.btn_tidaktersedia);
            btn_tersedia.setEnabled(false);
        }
        btn_tersedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ViewKandidatActivity.class);
                startActivity(intent);

            }
        });
    }
    private void initMenuButton() {


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MenuHasilVotingActivity.class);
                startActivity(intent);
            }
        });

        btn_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BeritaActivity.class);
                startActivity(intent);
            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
    }
}