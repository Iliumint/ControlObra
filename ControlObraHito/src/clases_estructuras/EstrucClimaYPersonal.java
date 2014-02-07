package clases_estructuras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.util.Log;

public class EstrucClimaYPersonal {
	
	String Hito;
	int año;
	int mes;
	int dia;
	
	String TEMPERATURA_PROMEDIO;
	String N_HORAS_LLUVIA_JORLAB;
	String ESTADO_TERRENO;
	String SUBCONTRATISTA;
	int N_PERSONAS;
	String FRENTE;
	String N_OBRA_DE_ARTE;
	String ELEMENTO;
	String ABSCISA_INICIAL;
	String ABSCISA_FINAL;
	String HORA_INICIO_LABORES;
	String HORA_FINAL_LABORES;
	String OBSERVACIONES;
	
	public EstrucClimaYPersonal()
	{
		agregar_fecha();
	}
	
	public EstrucClimaYPersonal(String _hito, String _temperaturaPromedio, String _NHoras_Lluvia, String _estadTerreno, String _subcontratista, int _NPeronsa,
			String _frente, String _NObra_DeArte, String _elemento, String _abscisaInicial, String _abscisaFinal, String _horaInicioLabores, String _horaFinalLabores, String _observaciones)
	{
		Hito=_hito;
		TEMPERATURA_PROMEDIO=_temperaturaPromedio;
		N_HORAS_LLUVIA_JORLAB=_NHoras_Lluvia;
		ESTADO_TERRENO=_estadTerreno;
		SUBCONTRATISTA=_subcontratista;
		N_PERSONAS=_NPeronsa;
		FRENTE=_frente;
		N_OBRA_DE_ARTE=_NObra_DeArte;
		ELEMENTO=_elemento;
		ABSCISA_INICIAL=_abscisaInicial;
		ABSCISA_FINAL=_abscisaFinal;
		HORA_INICIO_LABORES=_horaInicioLabores;
		HORA_FINAL_LABORES=_horaFinalLabores;
		OBSERVACIONES=_observaciones;
		
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
//	Desde este punto se generan las metodos set y get;
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

	public String getTEMPERATURA_PROMEDIO() {
		return TEMPERATURA_PROMEDIO;
	}

	public void setTEMPERATURA_PROMEDIO(String tEMPERATURA_PROMEDIO) {
		TEMPERATURA_PROMEDIO = tEMPERATURA_PROMEDIO;
	}

	public String getN_HORAS_LLUVIA_JORLAB() {
		return N_HORAS_LLUVIA_JORLAB;
	}

	public void setN_HORAS_LLUVIA_JORLAB(String n_HORAS_LLUVIA_JORLAB) {
		N_HORAS_LLUVIA_JORLAB = n_HORAS_LLUVIA_JORLAB;
	}

	public String getESTADO_TERRENO() {
		return ESTADO_TERRENO;
	}

	public void setESTADO_TERRENO(String eSTADO_TERRENO) {
		ESTADO_TERRENO = eSTADO_TERRENO;
	}

	public String getSUBCONTRATISTA() {
		return SUBCONTRATISTA;
	}

	public void setSUBCONTRATISTA(String sUBCONTRATISTA) {
		SUBCONTRATISTA = sUBCONTRATISTA;
	}

	public int getN_PERSONAS() {
		return N_PERSONAS;
	}

	public void setN_PERSONAS(int n_PERSONAS) {
		N_PERSONAS = n_PERSONAS;
	}

	public String getFRENTE() {
		return FRENTE;
	}

	public void setFRENTE(String fRENTE) {
		FRENTE = fRENTE;
	}

	public String getN_OBRA_DE_ARTE() {
		return N_OBRA_DE_ARTE;
	}

	public void setN_OBRA_DE_ARTE(String n_OBRA_DE_ARTE) {
		N_OBRA_DE_ARTE = n_OBRA_DE_ARTE;
	}

	public String getELEMENTO() {
		return ELEMENTO;
	}

	public void setELEMENTO(String eLEMENTO) {
		ELEMENTO = eLEMENTO;
	}

	public String getABSCISA_INICIAL() {
		return ABSCISA_INICIAL;
	}

	public void setABSCISA_INICIAL(String aBSCISA_INICIAL) {
		ABSCISA_INICIAL = aBSCISA_INICIAL;
	}

	public String getABSCISA_FINAL() {
		return ABSCISA_FINAL;
	}

	public void setABSCISA_FINAL(String aBSCISA_FINAL) {
		ABSCISA_FINAL = aBSCISA_FINAL;
	}

	public String getHORA_INICIO_LABORES() {
		return HORA_INICIO_LABORES;
	}

	public void setHORA_INICIO_LABORES(String hORA_INICIO_LABORES) {
		HORA_INICIO_LABORES = hORA_INICIO_LABORES;
	}

	public String getHORA_FINAL_LABORES() {
		return HORA_FINAL_LABORES;
	}

	public void setHORA_FINAL_LABORES(String hORA_FINAL_LABORES) {
		HORA_FINAL_LABORES = hORA_FINAL_LABORES;
	}

	public String getOBSERVACIONES() {
		return OBSERVACIONES;
	}

	public void setOBSERVACIONES(String oBSERVACIONES) {
		OBSERVACIONES = oBSERVACIONES;
	}

	
}
