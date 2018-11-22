package com.das.rutas.das_crud_rutas;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RutasService {
    @POST("registrarUsuario/{correo}/{contrasenia}")
    Call<Mensaje> registrarUsuario(@Path("correo") String correo, @Path("contrasenia") String contrasenia);
}
