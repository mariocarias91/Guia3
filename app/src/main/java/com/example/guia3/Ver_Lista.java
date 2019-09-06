package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.example.guia3.MainActivity.valores;

public class Ver_Lista extends AppCompatActivity {
    ListView Listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__lista);
        Listado = findViewById(R.id.Listado);
        ArrayAdapter<String> AdaptadorListado = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        AdaptadorListado.addAll(valores);
        Listado.setAdapter(AdaptadorListado);
        AdaptadorListado.notifyDataSetChanged();

    }
}
