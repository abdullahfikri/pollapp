package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vottingapp.API.APIInterface;
import com.example.vottingapp.API.RetrofitServer;
import com.example.vottingapp.Model.viewkandidatinfo.DataKandidat;
import com.example.vottingapp.Model.viewkandidatinfo.ResponseKandidatInfo;
import com.example.vottingapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KandidatActivity extends AppCompatActivity {
    ImageView iv_cagub, iv_wagub;
    TextView tv_namacagub, tv_namawagub, tv_ttlcagub, tv_ttlwagub, tv_pendidikancagub, tv_pendidikanwagub, tv_biocagub, tv_biowagub;

    APIInterface apiKandidat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandidat);
        iv_cagub = findViewById(R.id.infokandidat_iv_cagub);
        iv_wagub = findViewById(R.id.infokandidat_iv_wagub);

        // Cagub section
        tv_namacagub = findViewById(R.id.infokandidat_tv_cagubnama);
        tv_ttlcagub = findViewById(R.id.infokandidat_tv_cagubttl);
        tv_pendidikancagub = findViewById(R.id.infokandidat_tv_cagubpendidikan);
        tv_biocagub = findViewById(R.id.infokandidat_tv_cagubbio);

        // Wagub Section
        tv_namawagub = findViewById(R.id.infokandidat_tv_wagubnama);
        tv_ttlwagub = findViewById(R.id.infokandidat_tv_wagubttl);
        tv_pendidikanwagub = findViewById(R.id.infokandidat_tv_wagubpendidikan);
        tv_biowagub = findViewById(R.id.infokandidat_tv_wagubbio);

        // Mengambil data extras;
        Bundle bundleData = getIntent().getExtras();
        String id_kandidat = bundleData.getString("id_kandidat");

        apiKandidat = RetrofitServer.connectRetrofit().create(APIInterface.class);

        getDataKandidat(id_kandidat);

    }

    private void getDataKandidat(String id_kandidat) {
        apiKandidat.viewKandidatInfo(id_kandidat).enqueue(new Callback<ResponseKandidatInfo>() {
            @Override
            public void onResponse(Call<ResponseKandidatInfo> call, Response<ResponseKandidatInfo> response) {
                ResponseKandidatInfo responseBody = response.body();
                String message = responseBody.getMessage();
                String status = responseBody.getStatus();

                DataKandidat dataKandidat = responseBody.getDataKandidat();

                if (status.trim().equals("success")){
                    // cagub section
                    tv_namacagub.setText(dataKandidat.getNamaCagub());
                    tv_ttlcagub.setText(dataKandidat.getTtlCagub());
                    tv_pendidikancagub.setText(dataKandidat.getPendidikanCagub());
                    tv_biocagub.setText(dataKandidat.getBioCagub());
                    Glide.with(KandidatActivity.this).load(dataKandidat.getImgCagub()).into(iv_cagub);

                    // wagub section
                    tv_namawagub.setText(dataKandidat.getNamaWagub());
                    tv_ttlwagub.setText(dataKandidat.getTtlWagub());
                    tv_pendidikanwagub.setText(dataKandidat.getPendidikanWagub());
                    tv_biowagub.setText(dataKandidat.getBioWagub());
                    Glide.with(KandidatActivity.this).load(dataKandidat.getImgWagub()).into(iv_wagub);
                } else {
                    Toast.makeText(KandidatActivity.this, "Message: "+responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseKandidatInfo> call, Throwable t) {
                Toast.makeText(KandidatActivity.this, "Error : "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}