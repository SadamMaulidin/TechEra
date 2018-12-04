package com.tapperware.techera;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewOverseas extends AppCompatActivity {

    @BindView(R.id.my_recyler_view_overseas)
    RecyclerView myRecylerViewOverseas;

    String[] techName, techDetail;
    int[] techPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_overseas);
        ButterKnife.bind(this);

        techName = getResources().getStringArray(R.array.overseas);
        techDetail = getResources().getStringArray(R.array.overseas_detail);
        techPic = new int[]{R.drawable.smartshoe,R.drawable.ai,R.drawable.drone,R.drawable.smarthome,R.drawable.humanoid};

        AdapterOverseas adapter = new AdapterOverseas(this, techPic, techDetail,techName);

        myRecylerViewOverseas.setHasFixedSize(true);
        myRecylerViewOverseas.setLayoutManager(new LinearLayoutManager(this));
        myRecylerViewOverseas.setAdapter(adapter);
    }
}
