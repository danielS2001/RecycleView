package com.example.recycleview;

import android.app.Application;
import android.util.Log;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class Aplicacion extends Application {
    public static ArrayList<Alumno> alumnos;
    private MiAdaptador adaptador;

    public ArrayList<Alumno> getAlumnos() { return alumnos; }

    public MiAdaptador getAdaptador() { return adaptador; }

    @Override
    public void onCreate() {
        super.onCreate();
        alumnos = Alumno.llenarAlumnos();
        adaptador = new MiAdaptador(alumnos, this);
        Log.d("", "onCreate: tamaño array list " + alumnos.size());
    }
}
