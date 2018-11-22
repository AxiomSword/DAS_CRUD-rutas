package com.example.echo;

import java.util.ArrayList;
import java.util.Date;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

/**
 * The Echo API which Endpoints will be exposing.
 */
// [START echo_api_annotation]
@Api(
    name = "rutas",
    version = "v1",
    namespace =
    @ApiNamespace(
        ownerDomain = "echo.example.com",
        ownerName = "echo.example.com",
        packagePath = ""
    ),
    // [START_EXCLUDE]
    issuers = {
        @ApiIssuer(
            name = "firebase",
            issuer = "https://securetoken.google.com/YOUR-PROJECT-ID",
            jwksUri =
                "https://www.googleapis.com/service_accounts/v1/metadata/x509/securetoken@system"
                    + ".gserviceaccount.com"
        )
    }
// [END_EXCLUDE]
)
// [END echo_api_annotation]

public class Endpoints {
	ProxySingleton proxy = ProxySingleton.reemplazarConstructor();
	FacadeSingleton facade = FacadeSingleton.reemplazarConstructor();
	
	// Registrar usuario
	@ApiMethod(name = "registrarUsuario")
	public Mensaje registrarUsuario(@Named("correo") String correo, @Named("contrasenia") String contrasenia) {
		return proxy.registrarUsuario(correo, contrasenia);
	}
	
	// Listar usuarios
	@ApiMethod(name = "listarUsuarios")
	public ArrayList<Usuario> listarUsuarios() {
		return proxy.listarUsuarios();
	}
	
	// Iniciar sesión
	@ApiMethod(name = "iniciarSesion")
	public Mensaje iniciarSesion(@Named("correo") String correo, @Named("contrasenia") String contrasenia) {
		return proxy.iniciarSesion(correo, contrasenia);
	}

	// Registrar ruta
	@ApiMethod(name = "registrarRuta")
	public Mensaje registrarRuta(
		@Named("sesion") String sesion,
		@Named("placaVehiculo") String placaVehiculo,
		@Named("numeroPuestos") int numeroPuestos,
		@Named("puntoSalida") String puntoSalida,
		@Named("puntoDestino") String puntoDestino,
		@Named("horaInicio") Date horaInicio,
		@Named("horaSalida") Date horaSalida,
		@Named("costoPersona") float costoPersona,
		Polyline polyline
	) {
		return this.facade.registrarRuta(sesion, placaVehiculo, numeroPuestos, puntoSalida, puntoDestino, horaInicio, horaSalida, costoPersona, polyline);
	}
	
	// Buscar rutas
	@ApiMethod(name = "buscarRutas")
	public ArrayList<Ruta> buscarRutas(@Named("sesion") String sesion, @Named("puntoSalida") String puntoSalida, @Named("puntoDestino") String puntoDestino) {
		return this.facade.buscarRutas(sesion, puntoSalida, puntoDestino);
	}
	
	// Eliminar ruta
	@ApiMethod(name = "eliminarRuta")
	public Mensaje eliminarRuta(@Named("sesion") String sesion, @Named("idRuta") int idRuta) {
		return this.facade.eliminarRuta(sesion, idRuta);
	}
	
	// Actualizar ruta
	@ApiMethod(name = "actualizarRuta")
	public Mensaje actualizarRuta(
		@Named("sesion") String sesion,
		@Named("idRuta") int idRuta,
		@Named("numeroPuestos") int numeroPuestos,
		@Named("placaVehiculo") String placaVehiculo,
		@Named("horaInicio") Date horaInicio,
		@Named("horaSalida") Date horaSalida,
		@Named("costoPersona") float costoPersona
	) {
		return this.facade.actualizarRuta(sesion, idRuta, numeroPuestos, placaVehiculo, horaInicio, horaSalida, costoPersona);
	}
	
	// Listar rutas
	@ApiMethod(name = "listarRutas")
	public ArrayList<Ruta> listarRutas(@Named("sesion") String sesion) {
		return this.facade.listarRutas(sesion);
	}
	
	// Listar rutas por conductor
	@ApiMethod(name = "listarRutasPorConductor")
	public ArrayList<Ruta> listarRutasPorConductor(@Named("sesion") String sesion, @Named("correo") String correo) {
		return this.facade.listarRutasPorConductor(sesion, correo);
	}
}
