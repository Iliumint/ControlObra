package com.ClasesEstructuras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ClasesEstaticas.ValoresFijos;

import android.util.Log;

public class EstrucConcretos {
	
	
	String Hito; 
	int año;
	int mes;
	int dia;
	String Subcontratista;
	String TipoConcreto;
	String Cantidad;
	String N_ObraDeArte;
	String Elemento;
	String Abscisa;
	String Cantidad_Cemento_Bultos;
	String CantidadArenaM3;
	String CantidadTrituradoM3;
	String N_CilindrosPrueba;
	String Observaciones;
	
	double Latitud_gps;
	double Longitud_gps;
	String ID_Sesion;
	String EstadoSincronizacion;
	
	public EstrucConcretos()
	{
		agregar_fecha();
		ID_Sesion=ValoresFijos.getID_FULL_SESION();
	}
	
	public EstrucConcretos(String _hito, String _subcontratista, String _tipoConcreto, String _cantidad, String _NObraArte, String _elemento,
			String _abscisa, String _cantidadCementoBultos, String _cantidadArenaM3, String _cantidadTrituradoM3, String _NCilindrosPrueba, String _observaciones,
			String _año, String _mes, String _dia, double _latitud_gps, double _longitud_gps, String _ID_Sesion, String _estadoSincronizacion)
	{
		Hito=_hito;
		Subcontratista=_subcontratista;
		TipoConcreto=_tipoConcreto;
		Cantidad=_cantidad;
		N_ObraDeArte=_NObraArte;
		Elemento=_elemento;
		Abscisa=_abscisa;
		Cantidad_Cemento_Bultos=_cantidadCementoBultos;
		CantidadArenaM3=_cantidadArenaM3;
		CantidadTrituradoM3=_cantidadTrituradoM3;
		N_CilindrosPrueba=_NCilindrosPrueba;
		
		año=Integer.parseInt(_año);
		mes=Integer.parseInt(_mes);
		dia=Integer.parseInt(_dia);
		
		Latitud_gps=_latitud_gps;
		Longitud_gps=_longitud_gps;
		ID_Sesion=_ID_Sesion;
		EstadoSincronizacion=_estadoSincronizacion;
	}

	private void agregar_fecha()
	{
		String fecha[] = obtenerFechaPhone();	
		
		try {
			año=Integer.parseInt(fecha[0]);
			mes=Integer.parseInt(fecha[1]);
			dia=Integer.parseInt(fecha[2]);
		} catch (NumberFormatException e) {
			año=0;
			mes=0;
			dia=0;
			Log.e("Error Fecha","No se pudo hacer la conversion de String a Intreger");
		}
	}
		
	private String[] obtenerFechaPhone()
	{
		Calendar cal=new GregorianCalendar();
		Date fecha=cal.getTime();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String formatteDate = df.format(fecha);	    
	    String[] subCadenas = formatteDate.split("-");
	    
	    return subCadenas;
	}
	
	
	
//	
//	Desde este pundo Inician los metodos Set y GET
//		
	public String getHito() {
		return Hito;
	}

	public void setHito(String hito) {
		Hito = hito;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getSubcontratista() {
		return Subcontratista;
	}

	public void setSubcontratista(String subcontratista) {
		Subcontratista = subcontratista;
	}

	public String getTipoConcreto() {
		return TipoConcreto;
	}

	public void setTipoConcreto(String tipoConcreto) {
		TipoConcreto = tipoConcreto;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public String getN_ObraDeArte() {
		return N_ObraDeArte;
	}

	public void setN_ObraDeArte(String n_ObraDeArte) {
		N_ObraDeArte = n_ObraDeArte;
	}

	public String getElemento() {
		return Elemento;
	}

	public void setElemento(String elemento) {
		Elemento = elemento;
	}

	public String getAbscisa() {
		return Abscisa;
	}

	public void setAbscisa(String abscisa) {
		Abscisa = abscisa;
	}

	public String getCantidad_Cemento_Bultos() {
		return Cantidad_Cemento_Bultos;
	}

	public void setCantidad_Cemento_Bultos(String cantidad_Cemento_Bultos) {
		Cantidad_Cemento_Bultos = cantidad_Cemento_Bultos;
	}

	public String getCantidadArenaM3() {
		return CantidadArenaM3;
	}

	public void setCantidadArenaM3(String cantidadArenaM3) {
		CantidadArenaM3 = cantidadArenaM3;
	}

	public String getCantidadTrituradoM3() {
		return CantidadTrituradoM3;
	}

	public void setCantidadTrituradoM3(String cantidadTrituradoM3) {
		CantidadTrituradoM3 = cantidadTrituradoM3;
	}

	public String getN_CilindrosPrueba() {
		return N_CilindrosPrueba;
	}

	public void setN_CilindrosPrueba(String n_CilindrosPrueba) {
		N_CilindrosPrueba = n_CilindrosPrueba;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public double getLatitud_gps() {
		return Latitud_gps;
	}

	public void setLatitud_gps(double latitud_gps) {
		Latitud_gps = latitud_gps;
	}

	public double getLongitud_gps() {
		return Longitud_gps;
	}

	public void setLongitud_gps(double longitud_gps) {
		Longitud_gps = longitud_gps;
	}

	public String getID_Sesion() {
		return ID_Sesion;
	}

	public void setID_Sesion(String iD_Sesion) {
		ID_Sesion = iD_Sesion;
	}

	public String getEstadoSincronizacion() {
		return EstadoSincronizacion;
	}

	public void setEstadoSincronizacion(String estadoSincronizacion) {
		EstadoSincronizacion = estadoSincronizacion;
	}	

}
