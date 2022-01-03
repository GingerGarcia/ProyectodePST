package com.pst.proyectodepst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Activity_3 extends AppCompatActivity {
    private EditText etnombre,etcorreo,etusername,etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        etnombre = (EditText) findViewById(R.id.etPassword);
        etcorreo = (EditText) findViewById(R.id.etcorreo);
        etusername = (EditText) findViewById(R.id.etusernameregistro);
        etpassword = (EditText) findViewById(R.id.etpasswordregistro);
    }

}