package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnLista;
    Button btnNombre;
    Button btnDatos;
    public static String mensaje="vacio";
    public static ArrayList<String> valores = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLista = findViewById(R.id.btnLista);
        btnNombre = findViewById(R.id.btnNombre);
        btnDatos = findViewById(R.id.btnDatos);
        btnDatos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Datos.class);
                startActivityForResult(i, 0);
            }
        });
        btnNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View f) {
                Intent i = new Intent(f.getContext(), Nombre.class);
                startActivityForResult(i,  0);
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View g) {
                Intent i = new Intent(g.getContext(), Ver_Lista.class);
                startActivityForResult(i,  0);
            }
        });

    }
    //toast
    public void onActivityResult(int RequestCode, int ResultCode, Intent datos) {
        super.onActivityResult(RequestCode, ResultCode, datos);
        if (ResultCode == RESULT_OK){
            valores.add(datos.getStringExtra(mensaje));
            mostrartoast(1);}
    }

        public void mostrartoast(int v){
            if (v==1) {
                Toast.makeText(this, "Nombre guardado correctamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Ocurrio un problema", Toast.LENGTH_SHORT).show();
            }
        }
}
