package co.gov.fna.okeda.interfaces.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.gov.fna.okeda.interfaces.IFactoryPuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Ubicacion;

/**
 * Created by admin on 19/07/2014.
 */
public class FactoryPuntoAtencion implements IFactoryPuntoAtencion {

    private static FactoryPuntoAtencion instance;
    private List<PuntoAtencion> listaPuntosV;

    public FactoryPuntoAtencion() {
    }

    public static FactoryPuntoAtencion getInstance() {
        if (instance == null) {
            instance = new FactoryPuntoAtencion();
        }
        return instance;
    }

    @Override
    public List<PuntoAtencion> getPuntoAtencionRest() {
        return listaPuntosV;
    }

    @Override
    public void fillPuntoAtencion(JSONArray arreglo, String[] arrayPropertiesNames) {

        if (arreglo == null || arreglo.length() == 0) {
            return;
        }

        listaPuntosV = new ArrayList<PuntoAtencion>();
        JSONObject object;
        try {
            for (int i = 0; i < arreglo.length(); i++){
                object = arreglo.getJSONObject(i);
                PuntoAtencion p = new PuntoAtencion();
                int j = 0;

                p.setCedulaCodigoBarras(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setCostoTransaccion(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setDepartamento(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setDireccion(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setHorarioAtencion(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setHorarioExtendido(object.getString(arrayPropertiesNames[j]));
                j++;

                //Inicia ubicacion
                Double x = Double.parseDouble(object.getString(arrayPropertiesNames[j]));
                j++;
                Double y = Double.parseDouble(object.getString(arrayPropertiesNames[j]));
                j++;
                Ubicacion u = new Ubicacion(x, y);
                p.setUbicacion(u);
                //termina ubicacion

                p.setMunicipio(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setNumero(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setTipoEntidad(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setTipoServicioOfrecido(object.getString(arrayPropertiesNames[j]));
                j++;

                listaPuntosV.add(p);
            }
        }catch (JSONException e) {
            return;
        }

    }

    public List<PuntoAtencion> findByDepartamento(String depto){
        List<PuntoAtencion> retorno = new ArrayList<PuntoAtencion>();
        for (int i = 0; i < this.listaPuntosV.size(); i++) {
            PuntoAtencion aux = this.listaPuntosV.get(i);

            if (aux.getDepartamento().equals(depto)){
                retorno.add(aux);
            }
        }
        if (retorno.isEmpty()){
            return null;
        }else{
            return retorno;
        }

    }

    public List<PuntoAtencion> findByDepartamentoAndMunicipio(String depto, String muni){
        List<PuntoAtencion> retorno = new ArrayList<PuntoAtencion>();
        for (int i = 0; i < this.listaPuntosV.size(); i++) {
            PuntoAtencion aux = this.listaPuntosV.get(i);

            if (aux.getDepartamento().equals(depto)){
                if (aux.getMunicipio().equals(muni)){
                    retorno.add(aux);
                }
            }
        }
        if (retorno.isEmpty()){
            return null;
        }else{
            return retorno;
        }
    }
    public List<PuntoAtencion> findByTipo(String tipo){
        List<PuntoAtencion> retorno = new ArrayList<PuntoAtencion>();
        for (int i = 0; i < this.listaPuntosV.size(); i++) {
            PuntoAtencion aux = this.listaPuntosV.get(i);

            if (aux.getTipoEntidad().equals(tipo)){
                retorno.add(aux);
            }
        }
        if (retorno.isEmpty()){
            return null;
        }else{
            return retorno;
        }
    }

    public List<PuntoAtencion> findByHorarioAtencion(String hora){
        List<PuntoAtencion> retorno = new ArrayList<PuntoAtencion>();
        for (int i = 0; i < this.listaPuntosV.size(); i++) {
            PuntoAtencion aux = this.listaPuntosV.get(i);

            if (aux.getHorarioAtencion().equals(hora)){
                retorno.add(aux);
            }
        }
        if (retorno.isEmpty()){
            return null;
        }else{
            return retorno;
        }
    }

    public List<PuntoAtencion> findByCosto(String costo){
        List<PuntoAtencion> retorno = new ArrayList<PuntoAtencion>();
        for (int i = 0; i < this.listaPuntosV.size(); i++) {
            PuntoAtencion aux = this.listaPuntosV.get(i);

            if (aux.getCostoTransaccion().equals(costo)){
                retorno.add(aux);
            }
        }
        if (retorno.isEmpty()){
            return null;
        }else{
            return retorno;
        }
    }
}
