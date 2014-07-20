package co.gov.fna.okeda.interfaces;

import org.json.JSONArray;

import java.util.List;

import co.gov.fna.okeda.modelo.entidades.Vivienda;

/**
 * Created by usuario on 2/07/14.
 */
public interface  IFactoryVivienda {

    List<Vivienda> getViviendasRest();
    void fillViviendas(JSONArray arreglo, String [] arrayPropertiesNames);
}
