package co.gov.fna.okeda.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import co.gov.fna.okeda.controladores.ControladorComentarios;

import com.example.usuario.tryww.R;

public class ComentariosActivity extends Activity {
	private ControladorComentarios controlador;
	private EditText txtComentario;
	private EditText txtPuntuacion;
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentarios);
		controlador = new ControladorComentarios(this);
		txtComentario = (EditText) findViewById(R.id.txtComentario);
		txtPuntuacion = (EditText) findViewById(R.id.txtPuntuacion);
		lv = (ListView) findViewById(R.id.listView1);
		controlador.getComentarios();
	}

	public void comentar(View v) {
		controlador.createComent(txtPuntuacion.getText().toString(),
				txtComentario.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comentarios, menu);
		return true;
	}

	public ControladorComentarios getControlador() {
		return controlador;
	}

	public void setControlador(ControladorComentarios controlador) {
		this.controlador = controlador;
	}

	public EditText getTxtComentario() {
		return txtComentario;
	}

	public void setTxtComentario(EditText txtComentario) {
		this.txtComentario = txtComentario;
	}

	public EditText getTxtPuntuacion() {
		return txtPuntuacion;
	}

	public void setTxtPuntuacion(EditText txtPuntuacion) {
		this.txtPuntuacion = txtPuntuacion;
	}

	public ListView getLv() {
		return lv;
	}

	public void setLv(ListView lv) {
		this.lv = lv;
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

}
