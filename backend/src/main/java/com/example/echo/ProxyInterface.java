package com.example.echo;

import java.util.ArrayList;

public interface ProxyInterface {
	public Mensaje registrarUsuario(String correo, String contrasenia);
	public ArrayList<Usuario> listarUsuarios();
	public Mensaje iniciarSesion(String correo, String contrasenia);
}
