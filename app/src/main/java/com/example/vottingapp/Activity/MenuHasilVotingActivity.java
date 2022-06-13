package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.vottingapp.R;

public class MenuHasilVotingActivity extends AppCompatActivity {
    ImageButton iv_hasilvote, btn_home, btn_hasil, btn_berita, btn_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hasil_voting);

        btn_home = findViewById(R.id.menuvote_ib_home);
        btn_hasil = findViewById(R.id.menuvote_ib_hasil);
        btn_berita = findViewById(R.id.menuvote_ib_berita);
        btn_user = findViewById(R.id.menuvote_ib_user);
        initMenuButton();


        iv_hasilvote = findViewById(R.id.hasilvote_iv_tersedia);

        iv_hasilvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuHasilVotingActivity.this, HasilVoting.class);
                startActivity(intent);
            }
        });

    }

    private void initMenuButton() {


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuHasilVotingActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuHasilVotingActivity.this, MenuHasilVotingActivity.class);
                startActivity(intent);
            }
        });

        btn_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuHasilVotingActivity.this, BeritaActivity.class);
                startActivity(intent);
            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuHasilVotingActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
    }
}