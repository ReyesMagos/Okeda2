package co.gov.fna.okeda.persistence.dao.impl;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import co.gov.fna.okeda.persistence.dao.IViviendaDAO;
import co.gov.fna.okeda.persistencia.sqlite.AccessorSqliteOpenHelper;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public class ViviendaDAOImpl implements IViviendaDAO {

    private static final String TAG = ViviendaDAOImpl.class.getSimpleName();

    private static ViviendaDAOImpl instance = null;
    private AccessorSqliteOpenHelper accessorSqliteOpenHelper;

    private ViviendaDAOImpl (Context context){
        super();
        this.accessorSqliteOpenHelper = new AccessorSqliteOpenHelper(context);
    }

    public static synchronized ViviendaDAOImpl getInstance(Context context){
        if(instance == null){
            instance = new ViviendaDAOImpl(context);
        }
        return instance;
    }

    @Override
    public List<ContentValues> findAll() {
        return null;
    }

    @Override
    public ContentValues save(ContentValues viviendaContentValues) {
        return null;
    }

    @Override
    public ContentValues update(ContentValues viviendaContentValues) {
        return null;
    }
}
