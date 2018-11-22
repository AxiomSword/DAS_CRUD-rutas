package com.example.echo;

import java.util.ArrayList;
import java.util.Date;

public class FacadeSingleton {
	private static FacadeSingleton unicaInstancia;
	private ArrayList<Ruta> rutas = new ArrayList<>();
	private ArrayList<String> sesiones = new ArrayList<>();
	private int maxIdRuta = 0;

	public static FacadeSingleton reemplazarConstructor() {
		if (FacadeSingleton.unicaInstancia == null) {
			FacadeSingleton.unicaInstancia = new FacadeSingleton();
		}
		return FacadeSingleton.unicaInstancia;
	}

	public void guardarSesion(String sesion) {
		this.sesiones.add(sesion);
	}
	
	public Mensaje registrarRuta(
		String sesion,
		String placaVehiculo,
		int numeroPuestos,
		String puntoSalida,
		String puntoDestino,
		Date horaInicio,
		Date horaSalida,
		float costoPersona,
		Polyline polyline
	) {
		Mensaje mensaje = new Mensaje();
		if (!this.esSesionValida(sesion)) {
			mensaje.setMensaje("Error, sesión no válida.");
			return mensaje;
		}
		int idRuta = this.maxIdRuta++;
		Ruta ruta = new Ruta();
		ruta.setIdRuta(idRuta);
		ruta.setPlacaVehiculo(placaVehiculo);
		ruta.setNumeroPuestos(numeroPuestos);
		ruta.setPuntoSalida(puntoSalida);
		ruta.setPuntoEntrada(puntoDestino);
		ruta.setHoraInicio(horaInicio);
		ruta.setHoraSalida(horaSalida);
		ruta.setCostoPersona(costoPersona);
		ruta.setPolyline(polyline);
		this.rutas.add(ruta);
		mensaje.setMensaje("La ruta ha sido registrada exitósamente.");
		return mensaje;
	}
	
	public ArrayList<Ruta> buscarRutas(String sesion, String puntoSalida, String puntoDestino) {
		// TERMINAR
		if (!this.esSesionValida(sesion)) {
			return new ArrayList<Ruta>();
		}
		return this.rutas;
	}
	
	public Mensaje eliminarRuta(String sesion, int idRuta) {
		Mensaje mensaje = new Mensaje();
		if (!this.esSesionValida(sesion)) {
			mensaje.setMensaje("Error, sesión no válida.");
			return mensaje;
		}
		for (Ruta r: rutas) {
			if (r.getIdRuta() == idRuta) {
				this.rutas.remove(r);
				mensaje.setMensaje("La ruta ha sido eliminada exitósamente.");
				return mensaje;
			}
		}
		mensaje.setMensaje("No se ha encontrado ninguna ruta con ese id.");
		return mensaje;
	}
	
	public Mensaje actualizarRuta(
		String sesion,
		int idRuta,
		int numeroPuestos,
		String placaVehiculo,
		Date horaInicio,
		Date horaSalida,
		float costoPersona
	) {
		Mensaje mensaje = new Mensaje();
		if (!this.esSesionValida(sesion)) {
			mensaje.setMensaje("Error, sesión no válida.");
			return mensaje;
		}
		for (Ruta r: rutas) {
			if (r.getIdRuta() == idRuta) {
				r.setNumeroPuestos(numeroPuestos);
				r.setPlacaVehiculo(placaVehiculo);
				r.setHoraInicio(horaInicio);
				r.setHoraSalida(horaSalida);
				r.setCostoPersona(costoPersona);
				mensaje.setMensaje("La ruta ha sido actualizada exitósamente.");
				return mensaje;
			}
		}
		mensaje.setMensaje("No se ha encontrado ninguna ruta con ese id.");
		return mensaje;
	}
	
	// TERMINAR
	public ArrayList<Ruta>listarRutas(String sesion) {
		if (!this.esSesionValida(sesion)) {
			return new ArrayList<Ruta>();
		}
		return this.rutas;
	}
	
	// TERMINAR
	public ArrayList<Ruta> listarRutasPorConductor(String sesion, String correo) {
		return new ArrayList<Ruta>();
	}
	
	private boolean esSesionValida(String sesion) {
		return this.sesiones.contains(sesion);
	}
}
