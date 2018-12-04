package com.tapperware.techera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDomesticInfo;
    private Button btnOverseasInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolBar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolBar);

        btnDomesticInfo = (Button)findViewById(R.id.domestic);
        btnDomesticInfo.setOnClickListener(MainActivity.this);
        btnOverseasInfo = (Button)findViewById(R.id.overseas);
        btnOverseasInfo.setOnClickListener(MainActivity.this);
    }

    //ctrl+o
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent pindah;
        switch (item.getItemId()){
            case R.id.about:
                pindah = new Intent(this, About.class);
                startActivity(pindah);
                break;
            case  R.id.profile:
                pindah = new Intent(this, Profile.class);
                startActivity(pindah);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.domestic:
                Intent domestic = new Intent(this, RecycleViewDomestic.class);
                startActivity(domestic);
                break;
            case R.id.overseas:
                Intent overseas = new Intent(this, RecycleViewOverseas.class);
                startActivity(overseas);
                break;
        }
    }
}
