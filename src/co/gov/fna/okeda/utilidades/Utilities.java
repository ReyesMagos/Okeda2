package co.gov.fna.okeda.utilidades;

import android.app.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.test.ActivityUnitTestCase;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by usuario on 19/07/14.
 */
 public class Utilities {

    private Context actividad;
    private ProgressDialog dialog;

    public Utilities(Activity actividad) {
        this.actividad = actividad;
    }

    public void showDialog(String titulo, String mensaje, Boolean isCancelable){
        dialog= new ProgressDialog(actividad);
        dialog.setTitle(titulo);
        dialog.setMessage(mensaje);
        dialog.setCancelable(isCancelable);
        dialog.show();

    }

    public  void showAlertMessage(String mensaje, String titulo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(actividad);

        builder.setTitle(titulo);

        builder.setMessage(mensaje).setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog dialog = builder.show();
        dialog.show();

    }

    public void cancellDialog(){
        dialog.dismiss();
    }
}

