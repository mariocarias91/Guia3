package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.example.guia3.MainActivity.mensaje;

public class Nombre extends AppCompatActivity {
    Button Procesar;
    EditText VNombre;
    ProgressBar Barra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        //asignamos los id a los nombres de las variables

        Procesar = findViewById(R.id.btnProcesar);
        Barra = findViewById(R.id.Barra);
        VNombre = findViewById(R.id.valorNombre);

        Procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (VNombre.getText().length()>0){
                    setProgressValue(0);
                }else{
                    validacion();
                }
            }
        });
    }

    private void setProgressValue(final int progress){
        Barra.setProgress(progress);
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(progress+20 == 100) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            //Codigo ha ejecuta al finalizar la carga
                            Intent Enviar = new Intent();
                            Enviar.putExtra(mensaje, VNombre.getText().toString());
                            setResult(RESULT_OK, Enviar);
                            finish();
                        }
                    });
                }
                setProgressValue(progress+20);
            }
        });
        thread.start();
    }
    public void validacion(){
        Toast.makeText(this, "No ha ingresado Nombre",Toast.LENGTH_SHORT).show();
    }
}
