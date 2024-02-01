package com.example.myapp103;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;
import Models.Personas;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listpersonas;
    ArrayList<Personas> lista;
    ArrayList<String> Arreglo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.DBName,null,1);
        listpersonas = (ListView) findViewById(R.id.listpersonas);


        obtenerInfo();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Arreglo);
        listpersonas.setAdapter(adp);

    }

    private void obtenerInfo() {

        SQLiteDatabase db =  conexion.getReadableDatabase();
        Personas person;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectAllPersonas,null);


        while (cursor.moveToNext()){
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setTelefono(cursor.getInt(4));
            person.setCorreo(cursor.getString(5));
            lista.add(person);

        }
        cursor.close();

        fillData();

    }

    private void fillData() {
        Arreglo = new ArrayList<String>();
        for (int i=0; i < lista.size(); i ++){

          Arreglo.add(lista.get(i).getId() + " - " +
                        lista.get(i).getNombres() + " - " +
                        lista.get(i).getApellidos());
        }
    }
}