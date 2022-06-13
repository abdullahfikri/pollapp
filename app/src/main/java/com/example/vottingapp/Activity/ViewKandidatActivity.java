package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vottingapp.API.APIInterface;
import com.example.vottingapp.API.RetrofitServer;
import com.example.vottingapp.Adapter.AdapterDataKandidat;
import com.example.vottingapp.Model.viewkandidat.Datum;
import com.example.vottingapp.Model.viewkandidat.ResponseViewKandidat;
import com.example.vottingapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewKandidatActivity extends AppCompatActivity {
    ImageButton btn_home, btn_hasil, btn_berita, btn_user;
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<Datum> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_kandidat);

        btn_home = findViewById(R.id.viewkandidat_ib_home);
        btn_hasil = findViewById(R.id.viewkandidat_ib_hasil);
        btn_berita = findViewById(R.id.viewkandidat_ib_hasil);
        btn_user = findViewById(R.id.viewkandidat_ib_user);


        rvData = findViewById(R.id.rv_kandidat);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        retrieveData();


        initButton();
    }

    private void initButton(){
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewKandidatActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewKandidatActivity.this, MenuHasilVotingActivity.class);
                startActivity(intent);
            }
        });

        btn_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewKandidatActivity.this, BeritaActivity.class);
                startActivity(intent);
            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewKandidatActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
    }

    public void retrieveData(){
        APIInterface apiInterface = RetrofitServer.connectRetrofit().create(APIInterface.class);
        Call<ResponseViewKandidat> tampilData = apiInterface.viewKandidat();

        tampilData.enqueue(new Callback<ResponseViewKandidat>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<ResponseViewKandidat> call, Response<ResponseViewKandidat> response) {
                String status, message;
                status = response.body().getStatus();
                message = response.body().getMessage();
//                Toast.makeText(ViewKandidatActivity.this, "Status: "+status+", pesan: "+ message, Toast.LENGTH_LONG).show();
                listData = response.body().getData();
                adData = new AdapterDataKandidat(ViewKandidatActivity.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseViewKandidat> call, Throwable t) {
                Toast.makeText(ViewKandidatActivity.this, "Error" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}