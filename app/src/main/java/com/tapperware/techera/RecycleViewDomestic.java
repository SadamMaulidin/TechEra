package com.tapperware.techera;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewDomestic extends AppCompatActivity {

    @BindView(R.id.my_recyler_view)
    RecyclerView recyleDomestic;

    String[] namaTech,detailTech;
    int[] fotoTech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_domestic);
        ButterKnife.bind(this);

        namaTech = getResources().getStringArray(R.array.domestic);
        detailTech = getResources().getStringArray(R.array.domestic_detail);
        fotoTech = new int[]{R.drawable.panser_anoa,R.drawable.four_g,R.drawable.chipset,R.drawable.wakatobi,R.drawable.axioo};

        AdapterActivity adapter = new AdapterActivity(this, fotoTech, namaTech, detailTech);

        recyleDomestic.setHasFixedSize(true);
        recyleDomestic.setLayoutManager(new LinearLayoutManager(this));
        recyleDomestic.setAdapter(adapter);
    }
}
