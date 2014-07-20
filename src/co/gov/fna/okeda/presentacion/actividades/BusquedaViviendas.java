package co.gov.fna.okeda.presentacion.actividades;

import java.util.ArrayList;
import java.util.List;

import co.gov.fna.okeda.controladores.ControladorBusquedaVivienda;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.Entidades;

import com.example.usuario.tryww.R;
import com.example.usuario.tryww.R.id;
import com.example.usuario.tryww.R.layout;
import com.example.usuario.tryww.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Build;

public class BusquedaViviendas extends Activity {
	
	private Spinner spDepartamento;
	private Spinner spCiudad;
	private Spinner spEstrato;
	private Spinner spEstadoObra;
	private EditText txtPrecioDesde;
	private EditText txtPrecioHasta;
	private ControladorBusquedaVivienda controlador;
	private List<Entidades>listaViviendasEncontradas;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_busqueda_viviendas);
			initComponents();
			controlador= new ControladorBusquedaVivienda(this);
			controlador.setListToSpinner();
		
	}
	
	public void initComponents(){
		spDepartamento = (Spinner)findViewById(R.id.spDepartamento);
		spCiudad= (Spinner)findViewById(R.id.spCiudad);
		spEstrato= (Spinner)findViewById(R.id.spEstrato);
		spEstadoObra= (Spinner)findViewById(R.id.spEstadoObra);
		txtPrecioDesde= (EditText)findViewById(R.id.txtPrecioDesde);
		txtPrecioHasta=(EditText)findViewById(R.id.txtPrecioHasta);
	
		
	}
	
	public void searchByDepartamento(String departamento){
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for(Entidades e: factoryVivienda.getListaViviendas()){
			if(e.getDepartamento().equals(departamento))
			listaViviendasEncontradas.add(e);
		}
		
	}
	
	public void searchByDepartamentoCiudad(String Departamento, String ciudad){
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for(Entidades e: factoryVivienda.getListaViviendas()){
			if(e.getDepartamento().equals(Departamento)&&e.getMunicipioCiudad().equals(ciudad))
			listaViviendasEncontradas.add(e);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.busqueda_viviendas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public Spinner getSpDepartamento() {
		return spDepartamento;
	}

	public void setSpDepartamento(Spinner spDepartamento) {
		this.spDepartamento = spDepartamento;
	}

	public Spinner getSpCiudad() {
		return spCiudad;
	}

	public void setSpCiudad(Spinner spCiudad) {
		this.spCiudad = spCiudad;
	}

	public Spinner getSpEstrato() {
		return spEstrato;
	}

	public void setSpEstrato(Spinner spEstrato) {
		this.spEstrato = spEstrato;
	}

	public Spinner getSpEstadoObra() {
		return spEstadoObra;
	}

	public void setSpEstadoObra(Spinner spEstadoObra) {
		this.spEstadoObra = spEstadoObra;
	}

	public EditText getTxtPrecioDesde() {
		return txtPrecioDesde;
	}

	public void setTxtPrecioDesde(EditText txtPrecioDesde) {
		this.txtPrecioDesde = txtPrecioDesde;
	}

	public EditText getTxtPrecioHasta() {
		return txtPrecioHasta;
	}

	public void setTxtPrecioHasta(EditText txtPrecioHasta) {
		this.txtPrecioHasta = txtPrecioHasta;
	}

		
	

}
