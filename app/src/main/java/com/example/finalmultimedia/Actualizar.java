package com.example.finalmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Actualizar extends AppCompatActivity {
    Button btnActu, btnActu2, btnActu3, btnActu4, btnVOLVER, btnMENU;
    EditText txtNoUp, txtCuUp, txtEmUp, txtCoUp;
    DbUsers du;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        du = new DbUsers(Actualizar.this);

        btnVOLVER = findViewById(R.id.btnVolver);
        btnVOLVER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Actualizar.this, Login.class);
                startActivity(intent);
            }
        });

        btnMENU = findViewById(R.id.btnMenusito);
        btnMENU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Actualizar.this, Menu.class);
                startActivity(intent);
            }
        });
        txtNoUp =findViewById(R.id.txtNombreUp);
        txtCuUp = findViewById(R.id.txtCumpleUp);
        txtEmUp = findViewById(R.id.txtEmailUp);
        txtCoUp = findViewById(R.id.txtPassUp);
        btnActu = findViewById(R.id.btnUpdateNom);
        btnActu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNoUp.getText().toString().equals("")){
                    Toast.makeText(Actualizar.this, "NO SE HAN PODIDO GUARDAR LOS CAMBIOS", Toast.LENGTH_LONG).show();
                }else {
                    du.actualizacionNom(txtNoUp.getText().toString(), getIntent().getStringExtra("dni") );
                    Toast.makeText(Actualizar.this, "LOS CAMBIOS SE HAN GUARDADO EXITOSAMENTE", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnActu2 = findViewById(R.id.btnUpdateCum);
        btnActu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCuUp.getText().toString().equals("")){
                    Toast.makeText(Actualizar.this, "NO SE HAN PODIDO GUARDAR LOS CAMBIOS", Toast.LENGTH_LONG).show();
                }else {
                    du.actualizacionCum(txtCuUp.getText().toString(), getIntent().getStringExtra("dni") );
                    Toast.makeText(Actualizar.this, "LOS CAMBIOS SE HAN GUARDADO EXITOSAMENTE", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnActu3 = findViewById(R.id.btnUpdateEm);
        btnActu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtEmUp.getText().toString().equals("")){
                    Toast.makeText(Actualizar.this, "NO SE HAN PODIDO GUARDAR LOS CAMBIOS", Toast.LENGTH_LONG).show();
                }else {
                    du.actualizacionEm(txtEmUp.getText().toString(), getIntent().getStringExtra("dni") );
                    Toast.makeText(Actualizar.this, "LOS CAMBIOS SE HAN GUARDADO EXITOSAMENTE", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnActu4 = findViewById(R.id.btnUpdateCon);
        btnActu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCoUp.getText().toString().equals("")){
                    Toast.makeText(Actualizar.this, "NO SE HAN PODIDO GUARDAR LOS CAMBIOS", Toast.LENGTH_LONG).show();
                } else {
                    String dni = getIntent().getExtras().getString("dni");
                    du.actualizacionCon(txtCoUp.getText().toString(), dni );
                    Toast.makeText(Actualizar.this, "LOS CAMBIOS SE HAN GUARDADO EXITOSAMENTE", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}