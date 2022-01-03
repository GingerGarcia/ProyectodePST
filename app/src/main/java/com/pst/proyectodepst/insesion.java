package com.pst.proyectodepst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class insesion extends AppCompatActivity {
    private EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insesion);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }
    public void login(View view){
        ConsultasSQL consulta = new ConsultasSQL();
        if (consulta.conectarMySQL()){
            try {
                consulta.login(etUsername.getText().toString(),etPassword.getText().toString());
            }catch (Exception e){
                e.printStackTrace();
            }
            }
    }
}