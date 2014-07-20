package co.gov.fna.okeda.controladores;

import android.app.Activity;

import co.gov.fna.okeda.interfaces.impl.FactoryPuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.presentacion.actividades.PuntoAtencionActivity;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public class ControladorPuntoAtencion {

    private PuntoAtencionActivity activity;

    public ControladorPuntoAtencion(PuntoAtencionActivity acty) {
        this.activity = acty;
    }

    public PuntoAtencion findByDepartamento(String depto){
        FactoryPuntoAtencion aux = FactoryPuntoAtencion.getInstance();
        return null;
    }

    public void showPunto(){
        FactoryPuntoAtencion aux = FactoryPuntoAtencion.getInstance();
//        PuntoAtencion punto = aux.findByDepartamento("AMAZONAS").get(0);
//
//        activity.txt0.setText(punto.getTipoEntidad());
//        activity.txt1.setText(punto.getDepartamento());
//        activity.txt2.setText(punto.getMunicipio());
//        activity.txt3.setText(punto.getDireccion());
//        activity.txt4.setText(punto.getHorarioAtencion());
//        activity.txt5.setText(punto.getHorarioExtendido());
//        activity.txt6.setText(punto.getTipoServicioOfrecido());
//        activity.txt7.setText(punto.getCostoTransaccion());

    }
}
