package com.ClasesEstructuras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ClasesEstaticas.ValoresFijos;

import android.util.Log;

public class EstrucInstalacionTuberias {
	
	
	
	String Hito; 
	int año;
	int mes;
	int dia;
	String Subcontratista;
	String DiametroTuberiaInstalada;
	String CantidadTuberia;
	String AbscisaEncole;
	String AbscisaDesloque;
	String N_ObraArte;
	String N_Tuberias;
	String Pendiente_porcent;
	String N_Celdas;
	String EstadoTuberia;
	String Observaciones;
	
	double Latitud_gps;
	double Longitud_gps;
	String ID_Sesion;
	String EstadoSincronizacion;
	
	public EstrucInstalacionTuberias()
	{
		agregar_fecha();
		ID_Sesion=ValoresFijos.getID_FULL_SESION();
	}
	
	public EstrucInstalacionTuberias(String _hito, String _subcontratista, String _diametroTuberiaInst, String _cantidadTuberia, String _abscisaEncole,
			String _abscisaDesloque, String _nObraArte, String _nTuberias, String _pendientePorsentaje, String _nCeldas, String _estadoTuberia, String _obsercaiones,
			String _año, String _mes, String _dia, double _latitud_gps, double _longitud_gps, String _ID_Sesion, String _estadoSincronizacion)
	{
		Hito=_hito;
		Subcontratista=_subcontratista;
		DiametroTuberiaInstalada=_diametroTuberiaInst;
		CantidadTuberia=_cantidadTuberia;
		AbscisaEncole=_abscisaEncole;
		AbscisaDesloque=_abscisaDesloque;
		N_ObraArte=_nObraArte;
		N_Tuberias=_nTuberias;
		Pendiente_porcent=_pendientePorsentaje;
		N_Celdas=_nCeldas;
		EstadoTuberia=_estadoTuberia;
		Observaciones=_obsercaiones;

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
//	Desde este pundo empiezan los metodos set y get de las variables
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

	public String getDiametroTuberiaInstalada() {
		return DiametroTuberiaInstalada;
	}

	public void setDiametroTuberiaInstalada(String diametroTuberiaInstalada) {
		DiametroTuberiaInstalada = diametroTuberiaInstalada;
	}

	public String getCantidadTuberia() {
		return CantidadTuberia;
	}

	public void setCantidadTuberia(String cantidadTuberia) {
		CantidadTuberia = cantidadTuberia;
	}

	public String getAbscisaEncole() {
		return AbscisaEncole;
	}

	public void setAbscisaEncole(String abscisaEncole) {
		AbscisaEncole = abscisaEncole;
	}

	public String getAbscisaDesloque() {
		return AbscisaDesloque;
	}

	public void setAbscisaDesloque(String abscisaDesloque) {
		AbscisaDesloque = abscisaDesloque;
	}

	public String getN_ObraArte() {
		return N_ObraArte;
	}

	public void setN_ObraArte(String n_ObraArte) {
		N_ObraArte = n_ObraArte;
	}

	public String getN_Tuberias() {
		return N_Tuberias;
	}

	public void setN_Tuberias(String n_Tuberias) {
		N_Tuberias = n_Tuberias;
	}

	public String getPendiente_porcent() {
		return Pendiente_porcent;
	}

	public void setPendiente_porcent(String pendiente_porcent) {
		Pendiente_porcent = pendiente_porcent;
	}

	public String getN_Celdas() {
		return N_Celdas;
	}

	public void setN_Celdas(String n_Celdas) {
		N_Celdas = n_Celdas;
	}

	public String getEstadoTuberia() {
		return EstadoTuberia;
	}

	public void setEstadoTuberia(String estadoTuberia) {
		EstadoTuberia = estadoTuberia;
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
