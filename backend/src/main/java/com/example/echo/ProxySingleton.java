package com.example.echo;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class ProxySingleton implements ProxyInterface {

	private static ProxySingleton unicaInstancia;
	private FacadeSingleton facadeSingleton = FacadeSingleton.reemplazarConstructor();
	protected ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static ProxySingleton reemplazarConstructor() {
		if (ProxySingleton.unicaInstancia == null) {
			ProxySingleton.unicaInstancia = new ProxySingleton();
		}
		return ProxySingleton.unicaInstancia;
	}

	public Mensaje registrarUsuario(String correo, String contrasenia) {
		boolean usuarioRegistrado = false;
		for (Usuario u: usuarios) {
			if (u.getCorreo().equals(correo)) {
				usuarioRegistrado = true;
			}
		}
		Mensaje mensaje = new Mensaje();
		if (usuarioRegistrado) {
			mensaje.setMensaje("Error, el usuario ya se encuentra registrado.");
		} else {
			Usuario usuario = new Usuario();
			usuario.setCorreo(correo);
			usuario.setContrasenia(contrasenia);
			this.usuarios.add(usuario);
			mensaje.setMensaje("El usuario ha sido registrado exitósamente.");
		}
		return mensaje;
	}
	
	public ArrayList<Usuario> listarUsuarios() {
		return this.usuarios;
	}
	
	public Mensaje iniciarSesion(String correo, String contrasenia) {
		String token = "USUARIO_NO_VALIDO";
		for (Usuario u: usuarios) {
			if (u.getCorreo().equals(correo) && u.getContrasenia().equals(contrasenia)) {
				token = this.generarToken();
				this.facadeSingleton.guardarSesion(token);
			}
		}
		Mensaje mensaje = new Mensaje();
		mensaje.setMensaje(token);
		return mensaje;
	}

	private String generarToken() {
		SecureRandom random = new SecureRandom();
		String text = new BigInteger(130, random).toString(32);
		return text;
	}
}
