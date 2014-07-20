package co.gov.fna.okeda.controladores;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.util.Log;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Usuario;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.LoginActitvity;
import co.gov.fna.okeda.presentacion.actividades.Dashboard.DashBoard;
import co.gov.fna.okeda.process.impl.ViviendaProcessImpl;
import co.gov.fna.okeda.servicios.GetRestServices;
import co.gov.fna.okeda.utilidades.Utilities;

import com.example.usuario.tryww.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by usuario on 18/07/14.
 */
public class ControladorLoginActivity {

	private boolean isGoingForViviendasSet;
	private LoginActitvity activity;
	private String[] urlSet;
	private Usuario usuario;
	private ViviendaProcessImpl viviendaProcessImpl;

	public ControladorLoginActivity(LoginActitvity actividad) {
		this.activity = actividad;
		this.urlSet = actividad.getResources().getStringArray(R.array.urlset);

	}

	public void procesaRespuestaRestFul(JSONObject objeto) {
		if (isGoingForViviendasSet) {
			try {
				String[] viviendaPropertysNames = activity.getResources()
						.getStringArray(R.array.viviendas_properties_names);
				JSONArray arregloJSON = objeto.getJSONArray("d");
				FactoryVivienda factory = FactoryVivienda.getInstance();
				factory.fillViviendas(arregloJSON, viviendaPropertysNames);
				this.saveViviendaIntoDatabase(factory.getListaViviendas());
				this.activity.changeToActivy(DashBoard.class);
			} catch (JSONException e) {

			}
		}

		// }else{
		// try{
		// String[] puntosPropertysNames =
		// activity.getResources().getStringArray(R.array.puntosatencion_properties_names);
		// JSONArray arregloJSON = objeto.getJSONArray("d");
		// FactoryPuntoAtencion factory = FactoryPuntoAtencion.getInstance();
		// factory.fillPuntoAtencion(arregloJSON, puntosPropertysNames);
		// }catch(JSONException e){
		//
		// }
		// }
	}

	public void changeToActivy(Class a) {
		Intent i = new Intent(activity, a);
		activity.startActivity(i);
	}

	public void showMessage(String title, String menssage) {
		Utilities util = new Utilities(activity);
		util.showAlertMessage(title, menssage);
	}

	public void singUp(String userName, String password, String email,
			String mobile) {
		final Utilities utilidades = new Utilities(activity);
		utilidades.showDialog("Alerta", "Registrando  Espere por Favor", false);
		ParseUser user = new ParseUser();
		user.setUsername(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.put("mobile", mobile);

		user.signUpInBackground(new SignUpCallback() {
			public void done(ParseException e) {
				if (e == null) {
					utilidades.cancellDialog();
					utilidades.showAlertMessage("Registro Exitoso", "Exito");

				} else {
					// Sign up didn't succeed. Look at the ParseException
					// to figure out what went wrong
					Log.i("error", e.getMessage());
					utilidades.showAlertMessage("Error verifique sus datos",
							"Error");
				}
			}
		});

	}

	public void loggin(String user, String pass) {
		final Utilities utilidades = new Utilities(activity);
		utilidades.showDialog("Alerta", "iniciando Session Espere por Favor",
				false);

		ParseUser.logInInBackground(user, pass, new LogInCallback() {

			public void done(ParseUser user, ParseException e) {

				if (user != null) {
					// Hooray! The user is logged in
					utilidades.cancellDialog();
					usuario = new Usuario(user);
					Comunicador.setUser(usuario);
					utilidades.showAlertMessage("Inicio Exitoso", "Exito");
					setGoingForViviendasSet(true);
					getRestFullServices();

				} else {
					utilidades.showAlertMessage("Error verifique sus datos",
							"Error");
					
				}
				utilidades.cancellDialog();
			}
		});

	}

	public void getRestFullServices() {
		GetRestServices services;
		if (isGoingForViviendasSet) {
			services = new GetRestServices(getUrlSet()[0], getActivity());
		} else {
			services = new GetRestServices(getUrlSet()[1], getActivity());
		}
		this.isGoingForViviendasSet = true;
		services.execute();

	}

	public boolean isGoingForViviendasSet() {
		return isGoingForViviendasSet;
	}

	public void setGoingForViviendasSet(boolean isGoingForViviendasSet) {
		this.isGoingForViviendasSet = isGoingForViviendasSet;
	}

	public LoginActitvity getActivity() {
		return activity;
	}

	public void setActivity(LoginActitvity activity) {
		this.activity = activity;
	}

	public String[] getUrlSet() {
		return urlSet;
	}

	public void setUrlSet(String[] urlSet) {
		this.urlSet = urlSet;
	}

	public void saveViviendaIntoDatabase(List<Entidades> entidadesList) {
		this.viviendaProcessImpl = new ViviendaProcessImpl(getActivity()
				.getApplicationContext());
		Vivienda vivienda;

		for (int i = 0; i < entidadesList.size(); i++) {
			vivienda = (Vivienda) entidadesList.get(i);
			try {
				this.viviendaProcessImpl.saveVivienda(vivienda);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
