package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vottingapp.API.APIInterface;
import com.example.vottingapp.API.RetrofitServer;
import com.example.vottingapp.Model.hasilvoting.Data;
import com.example.vottingapp.Model.hasilvoting.ResponseHasilVote;
import com.example.vottingapp.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HasilVoting extends AppCompatActivity {
    private ImageButton iv_home, iv_hasil, iv_berita, iv_user;
    APIInterface apiHasilVoting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_voting);
        apiHasilVoting = RetrofitServer.connectRetrofit().create(APIInterface.class);
        getDataHasilVote();
        initMenuButton();
    }

    private void getDataHasilVote(){
        apiHasilVoting.viewHasilVoting().enqueue(new Callback<ResponseHasilVote>() {
            PieChart pieChart;
            @Override
            public void onResponse(Call<ResponseHasilVote> call, Response<ResponseHasilVote> response) {
                pieChart = findViewById(R.id.pc_hasilvote);
                ResponseHasilVote responseBody = response.body();

                Data dataHasilVote = responseBody.getData();
                float paslon1 = dataHasilVote.getPaslon1();
                float paslon2 = dataHasilVote.getPaslon2();
                float paslon3 = dataHasilVote.getPaslon3();
                float pemilih = dataHasilVote.getPemilih();

                float persentasePaslonSatu = Math.round((paslon1 / pemilih) * 100);
                float persentasePaslonDua = Math.round((paslon2 / pemilih) * 100);
                float persentasePaslonTiga = Math.round((paslon3 / pemilih) * 100);
                setupPieChart();
                loadPieChartData(persentasePaslonSatu, persentasePaslonDua, persentasePaslonTiga);


            }

            @Override
            public void onFailure(Call<ResponseHasilVote> call, Throwable t) {
                Toast.makeText(HasilVoting.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }

            private void setupPieChart(){
                pieChart.setDrawHoleEnabled(true);
                pieChart.setUsePercentValues(true);
                pieChart.setEntryLabelTextSize(15);
                pieChart.setEntryLabelColor(Color.WHITE);
                pieChart.setCenterText("Hasil Sementara");
                pieChart.setCenterTextSize(25);
                pieChart.animateXY(3000, 3000);
                pieChart.getDescription().setEnabled(false);

                Legend i = pieChart.getLegend();
                i.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//                i.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
                i.setOrientation(Legend.LegendOrientation.VERTICAL);
                i.setTextSize(12);
                i.setYOffset(20);
                i.setTextColor(Color.BLACK);
                i.setDrawInside(false);
                i.setEnabled(true);
            }
            private void loadPieChartData(float paslon1, float paslon2, float paslon3) {
                ArrayList<PieEntry> pieEntries = new ArrayList<>();
                pieEntries.add(new PieEntry(paslon1, "Handika & Sari"));
                pieEntries.add(new PieEntry(paslon2, "Alif & Egi"));
                pieEntries.add(new PieEntry(paslon3, "Fikri & Fajri"));

                ArrayList<Integer> colors = new ArrayList<>();
                for (int color : ColorTemplate.MATERIAL_COLORS) {
                    colors.add(color);
                }

                for (int color : ColorTemplate.VORDIPLOM_COLORS) {
                    colors.add(color);
                }

                PieDataSet dataSet = new PieDataSet(pieEntries, "Pasangan Calon Gubernur & Wakil Gubernur");
                dataSet.setColors(colors);
                PieData data = new PieData(dataSet);

                data.setDrawValues(true);
                data.setValueFormatter(new PercentFormatter(pieChart));
                data.setValueTextSize(12f);
                data.setValueTextColor(Color.WHITE);
                pieChart.setData(data);
                pieChart.invalidate();

            }
        });
    }

    private void initMenuButton(){
        iv_home = findViewById(R.id.hasilvote_iv_home);
        iv_hasil = findViewById(R.id.hasilvote_iv_hasil);
        iv_berita = findViewById(R.id.hasilvote_iv_berita);
        iv_user = findViewById(R.id.hasilvote_iv_user);

        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilVoting.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        iv_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilVoting.this, MenuHasilVotingActivity.class);
                startActivity(intent);
            }
        });

        iv_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilVoting.this, BeritaActivity.class);
                startActivity(intent);
            }
        });

        iv_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilVoting.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
    }
}