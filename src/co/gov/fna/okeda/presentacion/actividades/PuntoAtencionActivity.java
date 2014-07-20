package co.gov.fna.okeda.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.usuario.tryww.R;

import co.gov.fna.okeda.controladores.ControladorPuntoAtencion;

public class PuntoAtencionActivity extends Activity {
	private ControladorPuntoAtencion controlador;

	public TextView txt0;
	public TextView txt1;
	public TextView txt2;
	public TextView txt3;
	public TextView txt4;
	public TextView txt5;
	public TextView txt6;
	public TextView txt7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_punto_atencion);
		createComponents();
		controlador = new ControladorPuntoAtencion(this);
		controlador.getRestFullServices();

		
	}

	public void createComponents() {
		this.txt0 = (TextView) findViewById(R.id.textView0);
		this.txt1 = (TextView) findViewById(R.id.textView);
		this.txt2 = (TextView) findViewById(R.id.textView2);
		this.txt3 = (TextView) findViewById(R.id.textView3);
		this.txt4 = (TextView) findViewById(R.id.textView4);
		this.txt5 = (TextView) findViewById(R.id.textView5);
		this.txt6 = (TextView) findViewById(R.id.textView6);
		this.txt7 = (TextView) findViewById(R.id.textView7);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dash_board, menu);
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

	public void showPunto(View view) {
		controlador.showPunto();
		
	}
	
	public void getServices(View v){
		Log.d("C PuntoAten", "Entre a services");
		controlador.getRestFullServices();
	}
}
