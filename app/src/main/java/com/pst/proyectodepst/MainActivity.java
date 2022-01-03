package com.pst.proyectodepst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Metodo del botón Start
    public void start(View view){
        Intent siguiente = new Intent(this,insesion.class);
        startActivity(siguiente);
    }
}