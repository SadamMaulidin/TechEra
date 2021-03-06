package com.tapperware.techera;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterOverseas extends RecyclerView.Adapter<AdapterOverseas.ViewHolder> {
    Context context;
    String[] namaTechno,detailTechno;
    int[] fotoTechno;

    public AdapterOverseas(Context context,int[] fotoTechno, String[] namaTechno, String[] detailTechno) {
        this.context = context;
        this.detailTechno = detailTechno;
        this.fotoTechno = fotoTechno;
        this.namaTechno = namaTechno;
    }

    @NonNull
    @Override
    public AdapterOverseas.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_tech, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOverseas.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaTechno[i]);
        Glide.with(context).load(fotoTechno[i]).into(viewHolder.imgLogo);

        //TODO membuat onclicklistener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailTech.class);
                pindah.putExtra("tn", namaTechno[i]);
                pindah.putExtra("td", detailTechno[i]);
                pindah.putExtra("tf", fotoTechno[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fotoTechno.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);
        }
    }
}