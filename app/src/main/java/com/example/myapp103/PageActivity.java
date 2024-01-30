package com.example.myapp103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PageActivity extends AppCompatActivity {
    TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        mostrar = (TextView) findViewById(R.id.txtNombres2);
        Bundle extras = getIntent().getExtras();
        String nombresRec = extras.getString("keynombre");
        mostrar.setText(nombresRec);

    }
}