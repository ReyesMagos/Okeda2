package co.gov.fna.okeda.controladores;

import java.util.ArrayList;
import java.util.List;

import android.R;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.interfaces.impl.FactoryUsuario;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Usuario;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.ComentariosActivity;
import co.gov.fna.okeda.utilidades.Utilities;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class ControladorComentarios {
	private List<ParseObject> listaObjetos;
	private Utilities util;
	private ComentariosActivity activity;
	private List<String> listaComentarios;

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

	public void createComent(final String Puntuacion, final String coment) {
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();

		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {
			final Vivienda v = (Vivienda) e;
			ParseQuery<ParseObject> query = ParseQuery.getQuery("vivienda");
			query.whereEqualTo("partitionKey", v.getPartitionKey());
			query.findInBackground(new FindCallback<ParseObject>() {
				public void done(List<ParseObject> scoreList, ParseException e) {
					if (e == null) {
						if (!scoreList.isEmpty())
							saveComent(scoreList.get(0), coment, Puntuacion, v);
						else
							saveComent(new ParseObject("vivienda"), coment,
									Puntuacion, v);
					} else {

					}
				}
			});

		}
	}

	public void saveComent(final ParseObject vivienda, final String coment,
			final String Puntuacion, final Vivienda v) {

		FactoryUsuario factoryUsuario = FactoryUsuario.getInstance();

		final Usuario u = factoryUsuario.getCurrentUserInActivity();

		SaveCallback comentarioSavedCallBack = new SaveCallback() {

			@Override
			public void done(ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null)
					updatePromComentarios(v);
			}
		};

		final SaveCallback viviendaSavedCallback = new SaveCallback() {

			@Override
			public void done(ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null) {
					ParseObject comentario = new ParseObject("Comentario");
					comentario.put("mensaje", coment);
					comentario.put("vivienda", vivienda);
					comentario.put("usuario", u.getUser());
					comentario.put("puntuacion", Puntuacion);
					comentario.saveInBackground();
					util.showAlertMessage("Comentario Enviado Correctamente",
							"Exito");
				}

			}
		};

		vivienda.put("id", v.getPartitionKey());
		vivienda.increment("numeroVisitas");
		vivienda.increment("numeroComentarios");
		vivienda.saveInBackground(viviendaSavedCallback);

	}

	public void updatePromComentarios(Vivienda v) {

	}

	public void showProgress() {
		util.showDialog("Alerta",
				"Por Favor Espere Mientras traemos los Comentarios", false);
	}

	public void cancelDialog() {
		util.cancellDialog();
	}

	public void MuestraComentarios() {
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {
			final Vivienda v = (Vivienda) e;
			ParseObject vivi;
			String[] x = new String[listaObjetos.size()];
			int i = 0;
			for (final ParseObject p : listaObjetos) {
				p.getParseObject("vivienda").fetchIfNeededInBackground(
						new GetCallback<ParseObject>() {

							@Override
							public void done(ParseObject vivienda,
									ParseException arg1) {
								// TODO Auto-generated method stub
								if (vivienda != null) {
									String partitionKey = vivienda
											.getString("id");
									if (partitionKey != null) {
										if (partitionKey.equals(v
												.getPartitionKey())) {
											addToViviendaList(p
													.getString("mensaje"));

										}
									}
								}
							}
						});
				/*
				 * / if (vivi != null) { String partitionKey =
				 * vivi.getString("id"); if (partitionKey != null) { if
				 * 
				 * 
				 * } /
				 */

			}

		}

	}

	public void addToViviendaList(String p) {
		if (listaComentarios == null) {
			listaComentarios = new ArrayList<String>();
		}
		listaComentarios.add(p);
		showComentList();

	}

	public void showComentList() {
		String x[] = new String[listaComentarios.size()];
		int i = 0;
		for (String s : listaComentarios) {
			x[i] = s;
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
