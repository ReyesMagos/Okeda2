package co.gov.fna.okeda.controladores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.usuario.tryww.R;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import co.gov.fna.okeda.interfaces.impl.FactoryPuntoAtencion;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.presentacion.actividades.LoginActitvity;
import co.gov.fna.okeda.presentacion.actividades.PuntoAtencionActivity;
import co.gov.fna.okeda.servicios.GetRestServices;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public class ControladorPuntoAtencion {
	
	private String[] urlSet;

    private PuntoAtencionActivity activity;

    public ControladorPuntoAtencion(PuntoAtencionActivity acty) {
        this.activity = acty;
        this.urlSet= acty.getResources().getStringArray(R.array.urlset);
    }

    public PuntoAtencion findByDepartamento(String depto){
        FactoryPuntoAtencion aux = FactoryPuntoAtencion.getInstance();
        return null;
    }

    public void showPunto(){
        FactoryPuntoAtencion aux = FactoryPuntoAtencion.getInstance();
        PuntoAtencion punto = aux.findByDepartamento("AMAZONAS").get(0);
        
        if(punto == null) return;

        this.activity.txt0.setText(punto.getTipoEntidad());
        this.activity.txt1.setText(punto.getDepartamento());
        this.activity.txt2.setText(punto.getMunicipio());
        this.activity.txt3.setText(punto.getDireccion());
        this.activity.txt4.setText(punto.getHorarioAtencion());
        this.activity.txt5.setText(punto.getHorarioExtendido());
        this.activity.txt6.setText(punto.getTipoServicioOfrecido());
        this.activity.txt7.setText(punto.getCostoTransaccion());

    }
    
    public void getRestFullServices(){
        GetRestServices services;
        services = new GetRestServices(getUrlSet()[1],getActivity());
        services.execute();
    }
    
    public String[] getUrlSet() {
        return urlSet;
    }
    
    public PuntoAtencionActivity getActivity() {
        return activity;
    }
    
    public void procesaRespuestaRestFul(JSONObject objeto){

		try {
			Log.d("Procesasa", "Entre a procesa");
			String[] puntosPropertysNames = activity.getResources()
					.getStringArray(R.array.puntosatencion_properties_names);
			JSONArray arregloJSON = objeto.getJSONArray("d");
			FactoryPuntoAtencion factory = FactoryPuntoAtencion.getInstance();
			factory.fillPuntoAtencion(arregloJSON, puntosPropertysNames);
			
			Toast.makeText(this.activity, "Consumi jSON", Toast.LENGTH_LONG).show();
			
		} catch (JSONException e) {

		}
        
    }
}
