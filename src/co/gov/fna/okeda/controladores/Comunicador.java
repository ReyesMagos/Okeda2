package co.gov.fna.okeda.controladores;

import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Usuario;

public class Comunicador {
	
	private static Usuario user;
	private static Entidades entidad;

	public static Usuario getUser() {
		return user;
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
