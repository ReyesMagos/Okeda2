package co.gov.fna.okeda.controladores;

import java.util.List;

import android.R;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.interfaces.impl.FactoryUsuario;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Usuario;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.ComentariosActivity;
import co.gov.fna.okeda.utilidades.Utilities;

import com.google.android.gms.internal.fa;
import com.parse.ParseObject;

public class ControladorComentarios {
	private List<ParseObject> listaObjetos;
	private Utilities util;
	private ComentariosActivity activity;

	public ControladorComentarios(ComentariosActivity actividad) {
		this.activity = actividad;
		util = new Utilities(actividad);

	}

	public Utilities getUtil() {
		return util;
	}

	public void setUtil(Utilities util) {
		this.util = util;
	}

	public void createComent(String Puntuacion, String coment) {
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();

		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {
			FactoryUsuario factoryUsuario = FactoryUsuario.getInstance();
			Vivienda v = (Vivienda) e;
			Usuario u = factoryUsuario.getCurrentUserInActivity();
			ParseObject comentario = new ParseObject("Comentario");

			comentario.put("mensaje", coment);
			comentario.put("vivienda", v.getPartitionKey());
			comentario.put("user", u.getUser().getUsername());
			comentario.put("puntuacion", Puntuacion);
			comentario.saveInBackground();
			util.showAlertMessage("Comentario Enviado Correctamente", "Exito");
		}
	}

	public void showProgress() {
		util.showDialog("Alerta",
				"Por Favor Espere Mientras traemos los Comentarios", false);
	}

	public void cancelDialog() {
		util.cancellDialog();
	}

	public void MuestraComentarios() {
		String[] x = new String[listaObjetos.size()];
		int i = 0;
		for (ParseObject p : listaObjetos) {
			x[i] = p.getString("mensaje") + "; " + p.getString("user");
			i++;

		}
		Adapter ada = new ArrayAdapter<String>(activity,
				R.layout.simple_list_item_1, x);
		activity.getLv().setAdapter((ListAdapter) ada);

	}

	public List<ParseObject> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(List<ParseObject> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	public void getComentarios() {
		ParseServices parse = new ParseServices("Comentario", this);
		parse.execute();
	}
}
