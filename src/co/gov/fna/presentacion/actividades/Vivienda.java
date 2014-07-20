package co.gov.fna.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;

import com.example.usuario.tryww.R;

import co.gov.fna.dao.impl.ViviendaDAOImpl;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public class Vivienda extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ViviendaDAOImpl viviendaDAO = ViviendaDAOImpl.getInstance(super.getApplicationContext());
    }
}
