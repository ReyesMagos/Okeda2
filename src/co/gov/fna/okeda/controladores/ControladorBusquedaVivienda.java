package co.gov.fna.okeda.controladores;

import java.util.List;

import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.presentacion.actividades.BusquedaViviendas;
import co.gov.fna.okeda.utilidades.Utilities;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class ControladorBusquedaVivienda {
	
	private BusquedaViviendas activity;
	private  ArrayAdapter<String> adaptador;
	

	public ControladorBusquedaVivienda(BusquedaViviendas activity) {
		super();
		this.activity = activity;
	}
	
	public void setListToSpinner(){
		FactoryVivienda factoryVivienda= FactoryVivienda.getInstance();
		Utilities utilities = new Utilities(activity);
		
		List<String> listaString= utilities.getDepartments(factoryVivienda.getListaViviendas());
		String[] Array = new String[listaString.size()];
		Array =  listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, Array);
		this.activity.getSpDepartamento().setAdapter(adaptador);
		
		listaString= utilities.getCiudadesOrMunicipios(factoryVivienda.getListaViviendas());
		Array = new String[listaString.size()];
		Array =  listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, Array);
		this.activity.getSpCiudad().setAdapter(adaptador);
		
		listaString= utilities.getEstadoObra(factoryVivienda.getListaViviendas());
		Array = new String[listaString.size()];
		Array =  listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, Array);
		this.activity.getSpEstadoObra().setAdapter(adaptador);
		
		Array = new String[6];
		for (int i = 0; i < Array.length; i++) {
			Array[i]=Integer.toString(i+1);
		}
		adaptador = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, Array);
		this.activity.getSpEstrato().setAdapter(adaptador);
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(BusquedaViviendas activity) {
		this.activity = activity;
	}
	
	

}
