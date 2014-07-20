package co.gov.fna.okeda.persistence.dao;


import android.content.ContentValues;

import java.util.List;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public interface IViviendaDAO {

    public List<ContentValues> findAll();

    public ContentValues save (ContentValues viviendaContentValues);

    public ContentValues update (ContentValues viviendaContentValues);

}
