package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<Datum> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_kandidat);

        rvData = findViewById(R.id.rv_kandidat);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        retrieveData();



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
                Toast.makeText(ViewKandidatActivity.this, "Status: "+status+", pesan: "+ message, Toast.LENGTH_LONG).show();
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