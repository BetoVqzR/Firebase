package com.example.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtEdad;
    private Button btnEnviar;
    private Button btnEliminar;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad=findViewById(R.id.txtEdad);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnEliminar = findViewById(R.id.btnEliminar);
        db= FirebaseDatabase.getInstance().getReference();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre= txtNombre.getText().toString();
                String apellido=txtApellido.getText().toString();
                String edad=txtEdad.getText().toString();

                Map<String, Object>personMap = new HashMap<>();
                personMap.put("Nombre",nombre);
                personMap.put("Apellido", apellido);
                personMap.put("Edad", txtEdad.getText().toString());

                db.child("Usuarios").child("Persona").push().setValue(personMap);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.child("Usuarios").child("Persona").removeValue();
            }
        });



    }
}
