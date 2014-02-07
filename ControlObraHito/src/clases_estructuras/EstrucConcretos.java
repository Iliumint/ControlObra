package clases_estructuras;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.util.Log;

public class EstrucConcretos {
	
	
	String Hito; 
	int a�o;
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
	
	public EstrucConcretos()
	{agregar_fecha();}
	
	public EstrucConcretos(String _hito, String _subcontratista, String _tipoConcreto, String _cantidad, String _NObraArte, String _elemento,
			String _abscisa, String _cantidadCementoBultos, String _cantidadArenaM3, String _cantidadTrituradoM3, String _NCilindrosPrueba, String _observaciones)
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
		
		agregar_fecha();
	}

	private void agregar_fecha()
	{
		String fecha[] = obtenerFechaPhone();	
		
		try {
			a�o=Integer.parseInt(fecha[0]);
			mes=Integer.parseInt(fecha[1]);
			dia=Integer.parseInt(fecha[2]);
		} catch (NumberFormatException e) {
			a�o=0;
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

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
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

}
