package co.gov.fna.modelo.entidades;

import android.graphics.Bitmap;

/**
 * Created by usuario on 19/07/14.
 */
public class OpcionesDashBoard {

    private Bitmap imagenOpcion;
    private String nombreOpcion;

    public OpcionesDashBoard(Bitmap imagenOpcion, String nombreOpcion) {
        this.imagenOpcion = imagenOpcion;
        this.nombreOpcion = nombreOpcion;
    }

    public Bitmap getImagenOpcion() {
        return imagenOpcion;
    }

    public void setImagenOpcion(Bitmap imagenOpcion) {
        this.imagenOpcion = imagenOpcion;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }
}
