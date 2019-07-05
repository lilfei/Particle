package com.example.particle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.particle.R;

public class MainActivity extends Activity implements View.OnClickListener {

    Button BtnParticles;
    Button BtnParticleRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnParticles = findViewById(R.id.btn_particles);
        BtnParticles.setOnClickListener(this);
        BtnParticleRound = findViewById(R.id.btn_particle_round);
        BtnParticleRound.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_particles: {
                onParticlesActivity();
            }
            break;
            case R.id.btn_particle_round: {
                onParticleRoundActivity();
            }
            break;
        }
    }

    private void onParticlesActivity() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ParticlesActivity.class);
        startActivity(intent);
    }

    private void onParticleRoundActivity() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ParticleRoundActivity.class);
        startActivity(intent);
    }
}