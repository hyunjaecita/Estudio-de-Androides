package com.example.finalmultimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasLog extends AppCompatActivity {
    Button btnBo, btnUp, btnLi, btnMENU, btnVOLVER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_log);


        btnVOLVER = findViewById(R.id.btnVolver);
        btnVOLVER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasLog.this, Login.class);
                startActivity(intent);
            }
        });

        btnMENU = findViewById(R.id.btnMenusito);
        btnMENU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasLog.this, Menu.class);
                startActivity(intent);
            }
        });

        btnBo = findViewById(R.id.btnBorrar);
        btnBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsers du = new DbUsers(MasLog.this);
                du.borrar(getIntent().getExtras().getString("dni"));
                Intent intent = new Intent(MasLog.this, Login.class);
                startActivity(intent);
            }
        });

        btnUp = findViewById(R.id.btnActualizar);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasLog.this, Actualizar.class);
                intent.putExtra("dni", getIntent().getExtras().getString("dni"));
                startActivity(intent);
            }
        });

        btnLi = findViewById(R.id.btnLista);
        btnLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasLog.this, Lista.class);
                intent.putExtra("dni", getIntent().getExtras().getString("dni"));
                startActivity(intent);
            }
        });
    }

}