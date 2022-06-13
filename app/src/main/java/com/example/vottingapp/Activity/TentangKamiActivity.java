package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.vottingapp.R;

public class TentangKamiActivity extends AppCompatActivity {
    ImageButton btn_home, btn_hasil, btn_berita, btn_akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kami);

        btn_home = findViewById(R.id.tentang_ib_home);
        btn_hasil = findViewById(R.id.tentang_ib_hasil);
        btn_berita = findViewById(R.id.tentang_ib_berita);
        btn_akun = findViewById(R.id.tentang_ib_user);

        initButton();
    }

    private void initButton(){
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TentangKamiActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TentangKamiActivity.this, MenuHasilVotingActivity.class);
                startActivity(intent);
            }
        });

        btn_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TentangKamiActivity.this, BeritaActivity.class);
                startActivity(intent);
            }
        });

        btn_akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TentangKamiActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
    }
}