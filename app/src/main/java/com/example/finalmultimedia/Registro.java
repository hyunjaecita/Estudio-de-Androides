package com.example.finalmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    Button btnReg, btnMenu;
    EditText txtNom, txtDni, txtCum, txtEm, txtCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnMenu = findViewById(R.id.btnVolver);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registro.this,  Menu.class);
                startActivity(intent);
            }
        });
        txtNom = findViewById(R.id.txtNombreUp);
        txtDni = findViewById(R.id.txtDNI);
        txtCum = findViewById(R.id.txtCumpleUp);
        txtEm = findViewById(R.id.txtEmailUp);
        txtCon = findViewById(R.id.txtPassUp);
        btnReg = findViewById(R.id.btnUpdateNom);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNom.getText().toString().equals("") && txtDni.getText().toString().equals("") && txtCum.getText().toString().equals("") && txtEm.getText().toString().equals("") && txtCon.getText().toString().equals("")) {
                    Toast.makeText(Registro.this, "NO SE HA PODIDO GUARDAR EL USUARIO", Toast.LENGTH_LONG).show();
                } else if (!txtNom.getText().toString().equals("") && !txtDni.getText().toString().equals("") && !txtCum.getText().toString().equals("") && !txtEm.getText().toString().equals("") && !txtCon.getText().toString().equals("")) {
                    DbUsers du = new DbUsers(Registro.this);
                    du.insUser(txtNom.getText().toString(),txtCon.getText().toString(), txtDni.getText().toString(), txtEm.getText().toString(),txtCum.getText().toString());
                    Toast.makeText(Registro.this, "EL USUARIO HA SIDO REGISTRADO CON EXITO", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registro.this,  Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Registro.this, "RELLENE TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}