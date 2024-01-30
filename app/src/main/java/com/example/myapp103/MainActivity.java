package com.example.myapp103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombres,apellidos,telefono, edad, correo;
    Button btnproceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombres = (EditText) findViewById(R.id.txtNombres);
        apellidos = (EditText) findViewById(R.id.txtApellidos);
        edad = (EditText) findViewById(R.id.txtEdad);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        correo = (EditText) findViewById(R.id.txtCorreo);

        btnproceso = (Button) findViewById(R.id.btnProcesar);

        btnproceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String nombres2 = nombres.getText().toString();

                //              if (nombres2.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), nombres.getText().toString(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent(MainActivity.this, PageActivity.class);
//                    intent.putExtra("keynombre",nombres2);
//                   startActivity(intent);
//                A
//                }
                    AddPerson();
            }
        });
    }

    private void AddPerson() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.DBName,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());
        valores.put(Transacciones.telefono, telefono.getText().toString());

        Long resultado = db.insert(Transacciones.TablePersonas, Transacciones.id, valores);
        Toast.makeText(getApplication(),"Registro ingresado correctamente" + resultado.toString(),
                Toast.LENGHT_LONG).show();
        db.close();
    }
}