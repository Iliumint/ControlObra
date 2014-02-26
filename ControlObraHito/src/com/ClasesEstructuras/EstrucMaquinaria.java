package com.ClasesEstructuras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ClasesEstaticas.ValoresFijos;

import android.util.Log;

public class EstrucMaquinaria {

	String Hito; 
	int año;
	int mes;
	int dia;
	String DescripcionMaquinaria;
	String Subcontratista;
	String CodigoDeMaquina;
	String N_Recibo;
	String UnidadDeMedida;
	String Cantidad;
	String AbscisaTrabajoInicial;
	String AbscisaTrabajoFinal;
	String ActividadRealizada;
	String Observaciones;
	
	double Latitud_gps;
	double Longitud_gps;
	String ID_Sesion;
	String EstadoSincronizacion;
	
	public EstrucMaquinaria()
	{
		agregar_fecha();
		ID_Sesion=ValoresFijos.getID_FULL_SESION();
	}
	
	public EstrucMaquinaria(String _hito, String _descripcionMaquinaria, String _subcontratista, String _codigoMaquina, String _N_recibo,
			String _unidadMedica, String _cantidad, String _abscisaTrabajoInicial, String _abscisaTrabajoFinal, String _actividadRealizada, String _observaciones,
			String _año, String _mes, String _dia, double _latitud_gps, double _longitud_gps, String _ID_Sesion, String _estadoSincronizacion)
	{
		Hito=_hito;
		DescripcionMaquinaria=_descripcionMaquinaria;
		Subcontratista=_subcontratista;
		CodigoDeMaquina=_codigoMaquina;
		N_Recibo=_N_recibo;
		UnidadDeMedida=_unidadMedica;
		Cantidad=_cantidad;
		AbscisaTrabajoInicial=_abscisaTrabajoInicial;
		AbscisaTrabajoFinal=_abscisaTrabajoFinal;
		ActividadRealizada=_actividadRealizada;
		Observaciones=_observaciones;
		
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
//	Desde este punto se agregan los metodos get y set
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

	public String getDescripcionMaquinaria() {
		return DescripcionMaquinaria;
	}

	public void setDescripcionMaquinaria(String descripcionMaquinaria) {
		DescripcionMaquinaria = descripcionMaquinaria;
	}

	public String getSubcontratista() {
		return Subcontratista;
	}

	public void setSubcontratista(String subcontratista) {
		Subcontratista = subcontratista;
	}

	public String getCodigoDeMaquina() {
		return CodigoDeMaquina;
	}

	public void setCodigoDeMaquina(String codigoDeMaquina) {
		CodigoDeMaquina = codigoDeMaquina;
	}

	public String getN_Recibo() {
		return N_Recibo;
	}

	public void setN_Recibo(String n_Recibo) {
		N_Recibo = n_Recibo;
	}

	public String getUnidadDeMedida() {
		return UnidadDeMedida;
	}

	public void setUnidadDeMedida(String unidadDeMedida) {
		UnidadDeMedida = unidadDeMedida;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public String getAbscisaTrabajoInicial() {
		return AbscisaTrabajoInicial;
	}

	public void setAbscisaTrabajoInicial(String abscisaTrabajoInicial) {
		AbscisaTrabajoInicial = abscisaTrabajoInicial;
	}

	public String getAbscisaTrabajoFinal() {
		return AbscisaTrabajoFinal;
	}

	public void setAbscisaTrabajoFinal(String abscisaTrabajoFinal) {
		AbscisaTrabajoFinal = abscisaTrabajoFinal;
	}

	public String getActividadRealizada() {
		return ActividadRealizada;
	}

	public void setActividadRealizada(String actividadRealizada) {
		ActividadRealizada = actividadRealizada;
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
