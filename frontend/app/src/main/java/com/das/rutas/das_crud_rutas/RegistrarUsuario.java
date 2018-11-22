package com.das.rutas.das_crud_rutas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        Button btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String correo = ((EditText) findViewById(R.id.correo)).getText().toString();
                String contrasenia = ((EditText) findViewById(R.id.contrasenia)).getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://das-crud-rutas.appspot.com/_ah/api/rutas/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RutasService service = retrofit.create(RutasService.class);

                Call<Mensaje> mensaje = service.registrarUsuario(correo, contrasenia);
                mensaje.enqueue(new Callback<Mensaje>() {
                    @Override
                    public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                        if(response.isSuccessful()) {
                            Mensaje mensaje2 = response.body();
                            Toast.makeText(getApplicationContext(), mensaje2.getMensaje(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), response.errorBody().toString(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Mensaje> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }
}
