package com.tapperware.techera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreenActvity extends AppCompatActivity {

    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean pause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_actvity);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);

        Thread myThread = new Thread(){
            public void run(){
                try {
                    while(splashActive&&ms < splashTime){
                        if(!pause){
                            ms = ms + 10;
                            sleep(10);
                            progressBar.setProgress((int)ms);
                        }
                    }
                }catch (Exception e){
                }finally {
                    Intent pindah = new Intent(SplashScreenActvity.this, Start.class);
                    startActivity(pindah);
                    finish();
                }
            }
        };
        myThread.start();
    }
}
