package com.das.rutas.das_crud_rutas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Registrar usuario
        Button btnRegistrarUsuario = (Button) findViewById(R.id.btnRegistrarUsuario);
        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegistrarUsuario.class);
                startActivity(intent);
            }
        });

        // Iniciar sesión
        Button btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), IniciarSesion.class);
                startActivity(intent);
            }
        });

        // Registrar ruta
        Button btnRegistrarRuta = (Button) findViewById(R.id.btnRegistrarRuta);
        btnRegistrarRuta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegistrarRuta.class);
                startActivity(intent);
            }
        });

        // Listar rutas
        Button btnListarRutas = (Button) findViewById(R.id.btnListarRutas);
        btnListarRutas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListarRutas.class);
                startActivity(intent);
            }
        });

        // Eliminar ruta
        Button btnEliminarRuta = (Button) findViewById(R.id.btnEliminarRuta);
        btnEliminarRuta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EliminarRuta.class);
                startActivity(intent);
            }
        });

        // Actualizar ruta
        Button btnActualizarRuta = (Button) findViewById(R.id.btnActualizarRuta);
        btnActualizarRuta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActualizarRuta.class);
                startActivity(intent);
            }
        });
    }
}
