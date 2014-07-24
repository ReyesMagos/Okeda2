package com.example.usuario.tryww;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class CreditoActivity extends Activity {

	private EditText editTextEntidad;
	private Credito credito;
	private ListView listView;

	private String entidad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credito);
		createComponents();
	}

	public void createComponents() {
		editTextEntidad = (EditText) super.findViewById(R.id.txtEntidad);
		

		this.listView = (ListView) super.findViewById(R.id.listView1);
	}

	public void buscar(View view) {
		entidad = editTextEntidad.getText().toString().toLowerCase().trim();
		if (this.entidad.equals("")) {
			Toast.makeText(super.getApplicationContext(),
					"Por favor ingrese una entidad", Toast.LENGTH_LONG).show();
			return;
		}
		this.credito = new Credito();
		credito.setValorCredito();
		ArrayAdapter<String> arrayAdapterCredito = new ArrayAdapter<String>(
				super.getApplicationContext(),
				android.R.layout.simple_list_item_1, credito.getValorCredito());
		this.listView.setAdapter(arrayAdapterCredito);
	}
	
	public void comennzarActividad(){
		Intent intent = new Intent(this, CreditoActivity.class);
		startActivity(intent);
	}

}
