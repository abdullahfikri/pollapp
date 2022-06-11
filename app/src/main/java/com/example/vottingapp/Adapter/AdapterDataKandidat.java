package com.example.vottingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vottingapp.Activity.KandidatActivity;
import com.example.vottingapp.Model.viewkandidat.Datum;
import com.example.vottingapp.R;

import java.util.List;

public class AdapterDataKandidat extends RecyclerView.Adapter<AdapterDataKandidat.HolderData>{
    private Context ctx;
    private List<Datum> listKandidat;

    public AdapterDataKandidat(Context ctx, List<Datum> listKandidat) {
        this.ctx = ctx;
        this.listKandidat = listKandidat;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holderData = new HolderData(layout);
        return  holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        Datum dataModel = listKandidat.get(position);

        holder.tv_id.setText(dataModel.getId());
        holder.tv_cagub.setText(dataModel.getNamaCagub());
        holder.tv_wagub.setText(dataModel.getNamaWagub());
        holder.tv_nomor.setText(dataModel.getNomorUrut());
        Glide.with(ctx).load(dataModel.getImg()).into(holder.iv_kandidat);

        holder.kandidat_btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = holder.tv_id.getText().toString().trim();
                Intent intent = new Intent(ctx, KandidatActivity.class);
                intent.putExtra("id_kandidat", id);
                ctx.startActivity(intent);
            }
        });
        holder.kandidat_btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });



    }

    @Override
    public int getItemCount() {
        return listKandidat.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tv_id, tv_cagub, tv_wagub, tv_nomor;
        ImageView iv_kandidat;
        Button kandidat_btn_select, kandidat_btn_info;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            kandidat_btn_select = itemView.findViewById(R.id.kandidat_btn_select);
            kandidat_btn_info = itemView.findViewById(R.id.kandidat_btn_info);
            tv_id = itemView.findViewById(R.id.kandidat_tv_ID);
            tv_cagub = itemView.findViewById(R.id.kandidat_tv_cagub);
            tv_wagub = itemView.findViewById(R.id.kandidat_tv_wagub);
            tv_nomor = itemView.findViewById(R.id.kandidat_tv_nomor);
            iv_kandidat = itemView.findViewById(R.id.iv_kandidat);
        }
    }

}
