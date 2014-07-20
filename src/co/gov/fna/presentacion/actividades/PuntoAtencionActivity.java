package co.gov.fna.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.usuario.tryww.R;

import co.gov.fna.controladores.ControladorPuntoAtencion;

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
		createComponents();
		controlador = new ControladorPuntoAtencion(this);
		setContentView(R.layout.activity_punto_atencion);
	}

	public void createComponents() {
		txt0 = (TextView) findViewById(R.id.textView0);
		txt1 = (TextView) findViewById(R.id.textView);
		txt2 = (TextView) findViewById(R.id.textView2);
		txt3 = (TextView) findViewById(R.id.textView3);
		txt4 = (TextView) findViewById(R.id.textView4);
		txt5 = (TextView) findViewById(R.id.textView5);
		txt6 = (TextView) findViewById(R.id.textView6);
		txt7 = (TextView) findViewById(R.id.textView7);
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
}
