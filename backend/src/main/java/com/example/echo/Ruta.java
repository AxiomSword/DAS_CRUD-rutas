package com.example.echo;

import java.util.ArrayList;
import java.util.Date;

public class Ruta {
	private int idRuta;
	private String placaVehiculo;
	private int numeroPuestos;
	private String puntoSalida;
	private String puntoEntrada;
	private Date horaInicio;
	private Date horaSalida;
	private float costoPersona;
	private Polyline polyline;

	public int getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public int getNumeroPuestos() {
		return numeroPuestos;
	}

	public void setNumeroPuestos(int numeroPuestos) {
		this.numeroPuestos = numeroPuestos;
	}

	public String getPuntoSalida() {
		return puntoSalida;
	}

	public void setPuntoSalida(String puntoSalida) {
		this.puntoSalida = puntoSalida;
	}

	public String getPuntoEntrada() {
		return puntoEntrada;
	}

	public void setPuntoEntrada(String puntoEntrada) {
		this.puntoEntrada = puntoEntrada;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public float getCostoPersona() {
		return costoPersona;
	}

	public void setCostoPersona(float costoPersona) {
		this.costoPersona = costoPersona;
	}

	public Polyline getPolyline() {
		return polyline;
	}

	public void setPolyline(Polyline polyline) {
		this.polyline = polyline;
	}
}
