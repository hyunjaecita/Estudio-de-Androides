package com.example.finalmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lista extends AppCompatActivity {
    Button btnVOLVER, btnMENU;
    TextView txtNombre, txtDni, txtEmail, txtCumple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        txtNombre = findViewById(R.id.nombreciyo);
        txtDni = findViewById(R.id.dnisito);
        txtEmail = findViewById(R.id.emailsito);
        txtCumple = findViewById(R.id.cumplecito);

        DbUsers du = new DbUsers(Lista.this);
        Usuario user = du.datoUsuario(getIntent().getExtras().getString("dni"));

        txtNombre.setText(user.getNombre());
        txtDni.setText(user.getDni());
        txtEmail.setText(user.getEmail());
        txtCumple.setText(user.getCumple());

        btnVOLVER = findViewById(R.id.btnVolver);
        btnVOLVER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lista.this, MasLog.class);
                intent.putExtra("dni", getIntent().getExtras().getString("dni"));
                startActivity(intent);
            }
        });
        btnMENU = findViewById(R.id.btnMenusito2);
        btnMENU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lista.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}