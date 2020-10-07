package com.example.notasandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notasandroid2.models.NotaModel;
import com.example.notasandroid2.operations.NotaOperations;
import com.google.android.material.snackbar.Snackbar;

import android.os.Bundle;

public class RegistroActivity extends AppCompatActivity {

    private NotaOperations notaOperations;
    private EditText et_nombre, et_titulo, et_contenido;
    private Button btn_guardar;
    private NotaModel model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final NotaOperations notaOperations = new NotaOperations(getApplicationContext());
        et_nombre = findViewById(R.id.et_nombre);
        et_titulo = findViewById(R.id.et_titulo);
        et_contenido = findViewById(R.id.et_contenido);
        btn_guardar = findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, titulo, contenido;
                nombre = et_nombre.getText().toString();
                titulo = et_titulo.getText().toString();
                contenido = et_contenido.getText().toString();


                model = new NotaModel(nombre, titulo, contenido);
                int a = notaOperations.insert(model);
                notaOperations.close();
                if (a > 0){
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Snackbar.make(v, "No se guardó", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}