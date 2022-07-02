package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button btnCerrar;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fbtnAgregar;
    private Alumno alumno;
    private int posicion = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aplicacion app = (Aplicacion) getApplication();
        recyclerView = (RecyclerView) findViewById(R.id.recId);
        recyclerView.setAdapter(app.getAdaptador());

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        fbtnAgregar = (FloatingActionButton) findViewById(R.id.agregarAlumno); 

        app.getAdaptador().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posicion = recyclerView.getChildAdapterPosition(v);
                String dato = app.getAlumnos().get(posicion).getNombre();
                Toast.makeText(MainActivity.this, "Se hizo click en " + dato, Toast.LENGTH_LONG).show();
            }
        });
        
        fbtnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Uno Nuevo", Toast.LENGTH_SHORT).show();
            }
        });

        btnCerrar = (Button)findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar App?");
                confirmar.setMessage("Se descartara toda la informacion. ");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nada
                    }
                }); confirmar.show();
            }
        });
    }
}