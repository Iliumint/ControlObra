package clases_estructuras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.util.Log;

public class EstrucRellenosObras {

	String Hito;
	int año;
	int mes;
	int dia;
	
	String Subcontratista;
	String TIPO_RELLENO;
	String TIPO_MATERIAL;
	String N_OBRA_DE_ARTE;
	String ABSCISA;
	
	double LONGITUD;
	double ANCHO;
	double ALTO;
	
	String VOLUMEN_APROXIMADO;
	String N_TOMA_DE_DENSIDAD;
	String OBSERVACIONES;

	
	public EstrucRellenosObras()
	{
		agregar_fecha();
	}
	
	public EstrucRellenosObras(String _hito, String _subcontratista, String _tipo_relleno, String _tipo_material, String _NObra_Arte, String _abscisa,
			double _longitud, double _ancho, double _alto, String _volumenAproximado, String _N_TomaDensidad, String _observaciones)
	{
		Hito=_hito;
		Subcontratista=_subcontratista;
		TIPO_RELLENO=_tipo_relleno;
		TIPO_MATERIAL=_tipo_material;
		N_OBRA_DE_ARTE=_NObra_Arte;
		ABSCISA=_abscisa;
		LONGITUD=_longitud;
		ANCHO=_ancho;
		ALTO=_alto;
		VOLUMEN_APROXIMADO=_volumenAproximado;
		N_TOMA_DE_DENSIDAD=_N_TomaDensidad;
		OBSERVACIONES=_observaciones;
		
		//Se agrega la fecha actual del dispositivo mas no la de que se encuentra almacenada en la base de datos.
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
//	Desde este punto inician los metodos set y get
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

	public String getTIPO_RELLENO() {
		return TIPO_RELLENO;
	}

	public void setTIPO_RELLENO(String tIPO_RELLENO) {
		TIPO_RELLENO = tIPO_RELLENO;
	}

	public String getTIPO_MATERIAL() {
		return TIPO_MATERIAL;
	}

	public void setTIPO_MATERIAL(String tIPO_MATERIAL) {
		TIPO_MATERIAL = tIPO_MATERIAL;
	}

	public String getN_OBRA_DE_ARTE() {
		return N_OBRA_DE_ARTE;
	}

	public void setN_OBRA_DE_ARTE(String n_OBRA_DE_ARTE) {
		N_OBRA_DE_ARTE = n_OBRA_DE_ARTE;
	}

	public String getABSCISA() {
		return ABSCISA;
	}

	public void setABSCISA(String aBSCISA) {
		ABSCISA = aBSCISA;
	}

	public double getLONGITUD() {
		return LONGITUD;
	}

	public void setLONGITUD(double lONGITUD) {
		LONGITUD = lONGITUD;
	}

	public double getANCHO() {
		return ANCHO;
	}

	public void setANCHO(double aNCHO) {
		ANCHO = aNCHO;
	}

	public double getALTO() {
		return ALTO;
	}

	public void setALTO(double aLTO) {
		ALTO = aLTO;
	}

	public String getVOLUMEN_APROXIMADO() {
		return VOLUMEN_APROXIMADO;
	}

	public void setVOLUMEN_APROXIMADO(String vOLUMEN_APROXIMADO) {
		VOLUMEN_APROXIMADO = vOLUMEN_APROXIMADO;
	}

	public String getN_TOMA_DE_DENSIDAD() {
		return N_TOMA_DE_DENSIDAD;
	}

	public void setN_TOMA_DE_DENSIDAD(String n_TOMA_DE_DENSIDAD) {
		N_TOMA_DE_DENSIDAD = n_TOMA_DE_DENSIDAD;
	}

	public String getOBSERVACIONES() {
		return OBSERVACIONES;
	}

	public void setOBSERVACIONES(String oBSERVACIONES) {
		OBSERVACIONES = oBSERVACIONES;
	}	
	
	
}
