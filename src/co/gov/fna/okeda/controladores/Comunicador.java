package co.gov.fna.okeda.controladores;

import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Usuario;
import co.gov.fna.okeda.modelo.entidades.Vivienda;

public class Comunicador {
	
	private static Usuario user;
	private static Entidades entidad;
	private static Vivienda v;

	public static Usuario getUser() {
		return user;
	}

	public static Vivienda getV() {
		return v;
	}

	public static void setV(Vivienda v) {
		Comunicador.v = v;
	}

	public static void setUser(Usuario user) {
		Comunicador.user = user;
	}

	public static Entidades getEntidad() {
		return entidad;
	}

	public static void setEntidad(Entidades entidad) {
		Comunicador.entidad = entidad;
	}
	
	
	


}
