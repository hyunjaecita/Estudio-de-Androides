package com.example.finalmultimedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Button btnMenu, btnLog, btnMAS;
    EditText txtCtr, txtDni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnMenu = findViewById(R.id.btnVolver);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Menu.class);
                startActivity(intent);
            }
        });
        txtDni = findViewById(R.id.txtDNI);
        txtCtr = findViewById(R.id.txtPassUp);
        btnLog = findViewById(R.id.btnUpdateNom);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtDni.getText().toString().equals("") && txtCtr.getText().toString().equals("")) {
                    Toast.makeText(Login.this, "NO SE HA PODIDO INICIAR SESION", Toast.LENGTH_LONG).show();
                } else if (!txtDni.getText().toString().equals("") && !txtCtr.getText().toString().equals("")) {
                    DbUsers db = new DbUsers(Login.this);
                    int existe = db.existe(txtDni.getText().toString(), txtCtr.getText().toString());
                    if (existe == 1) {
                        Toast.makeText(Login.this, "SESION INICIADA CORRECTAMENTE", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login.this, MasLog.class);
                        intent.putExtra("dni", txtDni.getText().toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "NO SE ENCUENTRA EL USUARIO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Login.this, "RELLENE TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}