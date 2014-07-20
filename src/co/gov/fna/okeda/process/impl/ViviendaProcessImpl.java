package co.gov.fna.okeda.process.impl;

import java.security.PublicKey;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;

import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.persistence.dao.impl.ViviendaDAOImpl;
import co.gov.fna.okeda.persistence.sqlite.contract.ViviendaContract;
import co.gov.fna.okeda.process.IViviendaProcess;

public class ViviendaProcessImpl implements IViviendaProcess {

	private ViviendaDAOImpl viviendaDAOImpl;
	
	public ViviendaProcessImpl (Context context){
		super();
		this.viviendaDAOImpl = ViviendaDAOImpl.getInstance(context)
;	}

	@Override
	public Vivienda saveVivienda(Vivienda vivienda) {	
		

		return ((this.viviendaDAOImpl.save(this
				.convertViviendaToContentValues(vivienda)) != null) ? vivienda
				: null);
	}

	@Override
	public Vivienda updateVivienda(Vivienda vivienda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vivienda> findAllViviendas() {
		// TODO Auto-generated method stub
		return null;
	}

	private ContentValues convertViviendaToContentValues(Vivienda vivienda) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(ViviendaContract.Column.PARTITION_KEY,
				vivienda.getPartitionKey());
		contentValues.put(ViviendaContract.Column.ACABADOS,
				vivienda.getAcabado());
		contentValues.put(ViviendaContract.Column.APLICA_SUBSIDIO,
				vivienda.getAplicaSubsidio());
		contentValues.put(ViviendaContract.Column.AREA_DESDE,
				vivienda.getAreaDesde());
		contentValues.put(ViviendaContract.Column.AREA_HASTA,
				vivienda.getAreHasta());
		contentValues.put(ViviendaContract.Column.BARRIO, vivienda.getBarrio());
		contentValues.put(
				ViviendaContract.Column.CANTIDADDE_INMUEBLES_DISPONIBLES,
				vivienda.getCantidadDeInmueblesDisponibles());
		contentValues.put(ViviendaContract.Column.CARACTERISTICAS_PROYECTO,
				vivienda.getCaracteristicasProyecto());
		contentValues.put(ViviendaContract.Column.CIUDAD, vivienda.getCiudad());
		contentValues.put(ViviendaContract.Column.CLASE_DE_VIVIENDA,
				vivienda.getClaseDEVivienda());
		contentValues.put(ViviendaContract.Column.CREDITO_FNA,
				vivienda.getCreditoFna());
		contentValues.put(ViviendaContract.Column.CUOTA_INICIAL,
				vivienda.getCuotaInicial());
		contentValues.put(ViviendaContract.Column.CUOTA_MENSUAL,
				vivienda.getCuotaMensual());
		contentValues.put(ViviendaContract.Column.DEPARTAMENTO,
				vivienda.getDepartamento());
		contentValues.put(ViviendaContract.Column.DIA_DE_ATENCION_DESDE,
				vivienda.getDiaDeAtencionDesde());
		contentValues.put(ViviendaContract.Column.DIA_DE_ATENCION_HASTA,
				vivienda.getDiaDeAtencionHasta());
		contentValues.put(ViviendaContract.Column.DIRECCION_PROYECTO,
				vivienda.getDireccionProyecto());
		contentValues.put(ViviendaContract.Column.DIRECCION_SALA_DE_VENTAS,
				vivienda.getDireccionSalaDeVentas());
		contentValues.put(
				ViviendaContract.Column.DIRECCION_SEDE_PRINCIPAL_CONSTRUCTORA,
				vivienda.getDireccionSedePrincipalConstructora());
		contentValues.put(ViviendaContract.Column.EMAIL_CONSTRUCTORA,
				vivienda.getEmailConstructora());
		contentValues.put(ViviendaContract.Column.ESTADO_OBRA,
				vivienda.getEstadoObra());
		contentValues.put(ViviendaContract.Column.FECHA_DE_ENTREGA,
				vivienda.getFechaDeEntrega());
		contentValues.put(ViviendaContract.Column.HORA_DE_ATENCION_HASTA,
				vivienda.getHoraDeAtencionHasta());
		contentValues.put(ViviendaContract.Column.HORARIO_DE_ATENCION_DESDE,
				vivienda.getHoraDeAtencionDesde());
		contentValues.put(ViviendaContract.Column.IMAGEN_PRINCIPAL, vivienda
				.getUrlImagenes().get(0));
		contentValues.put(ViviendaContract.Column.IMAGEN1, vivienda
				.getUrlImagenes().get(1));
		contentValues.put(ViviendaContract.Column.IMAGEN2, vivienda
				.getUrlImagenes().get(2));
		contentValues.put(ViviendaContract.Column.IMAGEN3, vivienda
				.getUrlImagenes().get(3));
		contentValues.put(ViviendaContract.Column.IMAGEN4, vivienda
				.getUrlImagenes().get(4));
		contentValues.put(ViviendaContract.Column.IMAGEN5, vivienda
				.getUrlImagenes().get(5));
		contentValues.put(ViviendaContract.Column.LATITUD, vivienda
				.getUbicacion().getLatitud());
		contentValues.put(ViviendaContract.Column.LONGITUD, vivienda
				.getUbicacion().getLonguitud());
		contentValues.put(ViviendaContract.Column.LOCALIDAD_O_ZONA,
				vivienda.getLocalidadoZona());
		contentValues.put(ViviendaContract.Column.NIT_CONSTRUCTORA,
				vivienda.getNitConstructora());
		contentValues.put(ViviendaContract.Column.NOMBRE_CONSTRUCTORA,
				vivienda.getNombreConstructora());
		contentValues.put(ViviendaContract.Column.NOMBRE_CONTACTO_CONSTRUCTORA,
				vivienda.getNombreContactoConstructora());
		contentValues.put(
				ViviendaContract.Column.NOMBRE_CONTACTO_SALA_DE_VENTA,
				vivienda.getNombreContatoSalaDeVentas());
		contentValues.put(ViviendaContract.Column.NOMBRE_PROYECTO,
				vivienda.getNombreProyecto());
		contentValues
				.put(ViviendaContract.Column.NOMBRE_REPRESENTANTE_LEGAL_CONSTRUCTORA,
						vivienda.getNombreRepresentanteLegalConstructora());
		contentValues.put(ViviendaContract.Column.PRECIO_DESDE,
				vivienda.getPrecioDesde());
		contentValues.put(ViviendaContract.Column.PRECIO_HASTA,
				vivienda.getPrecioHasta());
		contentValues.put(
				ViviendaContract.Column.TELEFONO_CELULAR_SALA_DE_VENTAS,
				vivienda.getTelefonoCelularSalaDeVentas());
		contentValues.put(
				ViviendaContract.Column.TELEFONO_CONTACTO_CONSTRUCTORA,
				vivienda.getTelefonoContactContructora());
		contentValues.put(ViviendaContract.Column.TELEFONO_FIJO_SALA_DE_VENTAS,
				vivienda.getTelefonoFijoSalaDeVentas());
		contentValues.put(ViviendaContract.Column.VALOR_INMUBLE,
				vivienda.getValorInmueble());

		return (contentValues);

	}

}
