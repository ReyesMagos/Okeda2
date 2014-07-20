package co.gov.fna.okeda.controladores;

import java.util.ArrayList;
import java.util.List;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import co.gov.fna.okeda.presentacion.actividades.Dashboard.DashBoard;
import co.gov.fna.okeda.presentacion.actividades.Dashboard.util.OpcionesDashBoard;
import co.gov.fna.okeda.presentacion.actividades.adaptadores.CustomAdapter;

import com.example.usuario.tryww.R;

/**
 * Created by usuario on 19/07/14.
 */
public class ControladorDashBoard {

    private DashBoard activity;

    public ControladorDashBoard(DashBoard activity) {
        this.activity = activity;
    }

       public void createGrid(){
           List<OpcionesDashBoard> listaOpcionesDashBoard= new ArrayList<OpcionesDashBoard>();
           OpcionesDashBoard opcionesDashBoard= new OpcionesDashBoard
                   (BitmapFactory.decodeResource(activity.getResources(), R.drawable.house),"Busqueda Viviendas");
           listaOpcionesDashBoard.add(opcionesDashBoard);
            opcionesDashBoard= new OpcionesDashBoard
                   (BitmapFactory.decodeResource(activity.getResources(), R.drawable.house),"Busqueda Credito");
           listaOpcionesDashBoard.add(opcionesDashBoard);
            opcionesDashBoard= new OpcionesDashBoard
                   (BitmapFactory.decodeResource(activity.getResources(), R.drawable.house),"Simulador Crediticio");
           listaOpcionesDashBoard.add(opcionesDashBoard);
            opcionesDashBoard= new OpcionesDashBoard
                   (BitmapFactory.decodeResource(activity.getResources(), R.drawable.house),"Juego");
           listaOpcionesDashBoard.add(opcionesDashBoard);
           CustomAdapter c = new CustomAdapter(activity.getApplicationContext(), listaOpcionesDashBoard);
            activity.getGridOpciones().setAdapter(c);
            activity.getGridOpciones().setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					if(arg2==0){
						activity.openBusquedaViviendas();
					}
					// TODO Auto-generated method stub
					
				}
			});

       }

    public DashBoard getActivity() {
        return activity;
    }

    public void setActivity(DashBoard activity) {
        this.activity = activity;
    }
}
