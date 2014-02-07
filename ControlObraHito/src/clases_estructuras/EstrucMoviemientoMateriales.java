package clases_estructuras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.util.Log;

public class EstrucMoviemientoMateriales {
	
	
	String Hito; 
	int año;
	int mes;
	int dia;
	String Subcontratista;
	String TipoMaquina;
	String CodigoMaquinaria;
	String Placas;
	String NRecibo;
	String Origen;
	String Destino;
	String TipoMaterial;
	String VolumenM3Suelto;
	String AbscisaInicial;
	String AbscisaFinal;
	String Ancho;
	String Area;
	String EstadoMaterialAlFinalizarJornada;
	String Observaciones;	
	

	public EstrucMoviemientoMateriales()
	{
		agregar_fecha();
	}
	
	public EstrucMoviemientoMateriales(String _hito, String _subcontratista, String _tipoMaquina, String _codigoMAquinaria, String _placas,
			String _NRecibo, String _origen, String _destino, String _tipoMaterial, String _volumenM3Suelto, String _abscisaInicial, String _abscisaFinal,
			String _ancho, String _area, String _EstadoMaterialFinalJornada, String _observaciones)
	{
		Hito=_hito;
		Subcontratista=_subcontratista;
		TipoMaquina=_tipoMaquina;
		CodigoMaquinaria=_codigoMAquinaria;
		Placas=_placas;
		NRecibo=_NRecibo;
		Origen=_origen;
		Destino=_destino;
		TipoMaterial=_tipoMaterial;
		VolumenM3Suelto=_volumenM3Suelto;
		AbscisaInicial=_abscisaInicial;
		AbscisaFinal=_abscisaFinal;
		Ancho=_ancho;
		Area=_area;
		EstadoMaterialAlFinalizarJornada=_EstadoMaterialFinalJornada;
		Observaciones=_observaciones;	
		
		agregar_fecha();
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
//	Desde aqui hasta abajo estan las clases de comunicacion get and set
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

	public String getTipoMaquina() {
		return TipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		TipoMaquina = tipoMaquina;
	}

	public String getCodigoMaquinaria() {
		return CodigoMaquinaria;
	}

	public void setCodigoMaquinaria(String codigoMaquinaria) {
		CodigoMaquinaria = codigoMaquinaria;
	}

	public String getPlacas() {
		return Placas;
	}

	public void setPlacas(String placas) {
		Placas = placas;
	}

	public String getNRecibo() {
		return NRecibo;
	}

	public void setNRecibo(String nRecibo) {
		NRecibo = nRecibo;
	}

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public String getTipoMaterial() {
		return TipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		TipoMaterial = tipoMaterial;
	}

	public String getVolumenM3Suelto() {
		return VolumenM3Suelto;
	}

	public void setVolumenM3Suelto(String volumenM3Suelto) {
		VolumenM3Suelto = volumenM3Suelto;
	}

	public String getAbscisaInicial() {
		return AbscisaInicial;
	}

	public void setAbscisaInicial(String abscisaInicial) {
		AbscisaInicial = abscisaInicial;
	}

	public String getAbscisaFinal() {
		return AbscisaFinal;
	}

	public void setAbscisaFinal(String abscisaFinal) {
		AbscisaFinal = abscisaFinal;
	}

	public String getAncho() {
		return Ancho;
	}

	public void setAncho(String ancho) {
		Ancho = ancho;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getEstadoMaterialAlFinalizarJornada() {
		return EstadoMaterialAlFinalizarJornada;
	}

	public void setEstadoMaterialAlFinalizarJornada(
			String estadoMaterialAlFinalizarJornada) {
		EstadoMaterialAlFinalizarJornada = estadoMaterialAlFinalizarJornada;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

}
