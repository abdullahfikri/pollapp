package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vottingapp.R;

public class ProfilUser extends AppCompatActivity {
    TextView tv_email, tv_nik, tv_namalengkap, tv_statusvoting, tv_img;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);
        tv_email = findViewById(R.id.tv_email);
        tv_nik = findViewById(R.id.tv_nik);
        tv_namalengkap = findViewById(R.id.tv_namalengkap);
        tv_statusvoting = findViewById(R.id.tv_statusvoting);
        tv_img = findViewById(R.id.tv_img);
        Bundle bundleData = getIntent().getExtras();

        String imageProfileUrl = bundleData.getString("imgurl");
        int statusvotingint = Integer.parseInt(bundleData.getString("statusvoting"));

        String statusvoting;
        if (statusvotingint == 1) {
            statusvoting = "Sudah Voting";
        } else {
            statusvoting = "Belum Voting";
        }

        tv_email.setText(bundleData.getString("email"));
        tv_nik.setText(bundleData.getString("nik"));
        tv_namalengkap.setText(bundleData.getString("namalengkap"));
        tv_statusvoting.setText(statusvoting);
        tv_img.setText(imageProfileUrl);

        image = findViewById(R.id.image_profile);

        Glide.with(this).load(imageProfileUrl).into(image);
    }
}