package co.gov.fna.okeda.presentacion.actividades;

import java.util.zip.Inflater;

import co.gov.fna.okeda.controladores.Comunicador;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Vivienda;

import com.example.usuario.tryww.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MapaActivity extends android.support.v4.app.FragmentActivity {

	private GoogleMap mapa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapitas);
		mapa=null;
		Entidades e = Comunicador.getEntidad();
		Double lat = 6.3243424;
		Double lon= -75.3123;
		iniciarMapa(mapa, new LatLng(lat, lon), R.id.fragment1);
		ubicarEnMapa(mapa, Comunicador.getEntidad(), 5);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapa_activty, menu);
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

	public void iniciarMapa(GoogleMap mapa, LatLng latlong, int fragmento) {
		mapa = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(fragmento)).getMap();

		CameraPosition posicion = new CameraPosition.Builder().target(latlong)
				.zoom(5).bearing(0).build();

		CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(posicion);
		mapa.animateCamera(camUpd);

	}

	public static void ubicarEnMapa(GoogleMap mapa, Entidades entidades,
			int size) {
		// double x3[] = devuelveLat(entidades.getCoordenadas());
		double lat;
		double lng;
		String nombre;
		String departamento;
		String municipio;

		if (entidades instanceof Vivienda) {
			Vivienda vivienda = (Vivienda) entidades;
			lat = vivienda.getUbicacion().getLatitud();
			lng = vivienda.getUbicacion().getLonguitud();
			nombre = vivienda.getNombreProyecto();
			departamento = vivienda.getDepartamento();
			municipio = vivienda.getMunicipioCiudad();
		} else {
			PuntoAtencion puntoAtencion = (PuntoAtencion) entidades;
			lat = puntoAtencion.getUbicacion().getLatitud();
			lng = puntoAtencion.getUbicacion().getLonguitud();
			nombre = puntoAtencion.getTipoEntidad();
			departamento = puntoAtencion.getDepartamento();
			municipio = puntoAtencion.getMunicipioCiudad();
		}

		LatLng latlong = new LatLng(lat, lng);
		// mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		CameraPosition posicion = new CameraPosition.Builder().target(latlong)
				.zoom(size).bearing(0).build();

		CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(posicion);
		mapa.animateCamera(camUpd);

		Marker n = mapa.addMarker(new MarkerOptions()
				.position(new LatLng(lat, lng))
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_RED))
				.title(nombre).snippet(departamento + "-" + municipio));

		// n.setIcon(BitmapDescriptorFactory.defaultMarker())

		n.showInfoWindow();

		mapa.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			@Override
			public void onInfoWindowClick(Marker marker) {

			}
		});

	}

	public void cleanMapa(GoogleMap map) {
		map.clear();
	}

}
