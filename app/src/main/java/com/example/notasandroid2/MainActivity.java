package com.example.notasandroid2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.notasandroid2.models.NotaModel;
import com.example.notasandroid2.operations.NotaOperations;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.example.notasandroid2.R.id.lv_contenido;
import static com.example.notasandroid2.R.id.view_offset_helper;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_nuevo;
    private NotaModel model;
    private NotaOperations operations;
    private ListView lv_contenido;
    private ArrayList<String> list;
    private ArrayList<String>listString;
    private ArrayAdapter<String>itemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        lv_contenido = findViewById(R.id.lv_contenido);
        String nombre = "nombre";
        String titulo ="Titulo de la nota";
        String contenido="Titulo de la nota que quiero guardar en la base de datos";
        operations = new NotaOperations(getApplicationContext());

        listString = operations.list();
        operations.close();

        model= new NotaModel(nombre, titulo, contenido);
        int r = operations.insert(model);
        if (r>0){
            Toast.makeText(this, "Guardada correctamente", Toast.LENGTH_LONG).show();
            //uno.setText(String.valueOf(r));
        }else{
            Toast.makeText(this, "No se guardado correctamente", Toast.LENGTH_LONG).show();
        }

        String consolidadoMostrar="";
        list =operations.list();

        for(int i=0; i <list.size(); i++){
            consolidadoMostrar += list.get(i) + "\n ---------------\n\n";
        }



        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listString);
        lv_contenido.setAdapter(itemsAdapter);


        lv_contenido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto =listString.get(position);
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
            }
        });


        fab_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
                startActivity(intent);
            }
        });



    }

}