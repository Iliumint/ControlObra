package com.BaseDeDatos;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;

import com.ClasesEstructuras.EstrucClimaYPersonal;
import com.ClasesEstructuras.EstrucConcretos;
import com.ClasesEstructuras.EstrucInstalacionTuberias;
import com.ClasesEstructuras.EstrucMaquinaria;
import com.ClasesEstructuras.EstrucMoviemientoMateriales;
import com.ClasesEstructuras.EstrucRellenosObras;


import android.app.TabActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

public class BasedeDatos {
	
	
	
	final String TABLA_MOVIMIENTO_MATERIALES="MOVIMIENTO_MATERIALES";
	final String TABLA_INSTALACION_TUBERIAS="INSTALACION_TUBERIAS";
	final String TABLA_MAQUINARIA="MAQUINARIA";
	final String TABLA_CONCRETOS="CONCRETO";
	final String TABLA_RELLENOS_OBRAS="RELLENO_OBRAS";
	final String TABLA_CLIMA_Y_PERSONAL="CLIMA_Y_PERSONAL";
	
	final String TABLA_USUARIOS="USUARIOS";
	
	
	public static SQLiteDatabase ConectarConDataBase()
	{
		String DATABASE_NAME = "control_obra.sqlite";		
		File sdcard = Environment.getExternalStorageDirectory();
		String dbfile = sdcard.getAbsolutePath() + File.separator+ "GRODCO" + File.separator + DATABASE_NAME;
		SQLiteDatabase db=SQLiteDatabase.openDatabase(dbfile, null,SQLiteDatabase.OPEN_READWRITE);
		return db;
	}		

	
	public boolean INSERTAR_EN_MOVIMIENTO_MATERIALES(EstrucMoviemientoMateriales event)
	{
		/***
		 * Se preparan usan los campos de la base de datos en la tabla MOVIMIENTO_MATERIALES
		 * y se agrega la informacion de la estructura que contiene toda la informacion que se incluyo en el formulario
		 */
		SQLiteDatabase db=ConectarConDataBase();		
		ContentValues ins=new ContentValues();		
		

		Log.e("TABLA",TABLA_MOVIMIENTO_MATERIALES);
		ins.put("HITO", event.getHito());
		ins.put("AÑO", event.getAño());
		ins.put("MES", event.getMes());
		ins.put("DIA", event.getDia());
		ins.put("SUBCONTRATISTA", event.getSubcontratista());
		ins.put("TIPO_DE_MAQUINA", event.getTipoMaquina());
		ins.put("CODIGO_DE_MAQUINARIA", event.getCodigoMaquinaria());
		ins.put("PLACAS", event.getPlacas());
		ins.put("N_RECIBO", event.getNRecibo());
		ins.put("ORIGEN", event.getOrigen());
		ins.put("DESTINO", event.getDestino());
		ins.put("TIPO_MATERIAL", event.getTipoMaterial());
		ins.put("VOLUMEN_M3_SUELTO", event.getVolumenM3Suelto());		
		ins.put("ABSCISA_INICIAL", event.getAbscisaInicial());
		ins.put("ABSCISA_FINAL", event.getAbscisaFinal());
		ins.put("ANCHO", event.getAncho());
		ins.put("AREA", event.getArea());
		ins.put("ESTADO_DE_MATERIAL", event.getEstadoMaterialAlFinalizarJornada());
		ins.put("OBSERVACIONES", event.getObservaciones());
		ins.put("OBSERVACIONES", event.getObservaciones());
		
		ins.put("LATITUD_GPS", event.getLatitud_gps());
		ins.put("LONGITUD_GPS", event.getLongitud_gps());
		ins.put("ID_SESION", event.getID_Sesion());
		ins.put("ESTADO_SINCRONIZADO", event.getEstadoSincronizacion());

		Log.e("TABLA",TABLA_MOVIMIENTO_MATERIALES);
		Log.e("HITO",event.getHito());
		Log.e("AÑO", event.getAño()+"");
		Log.e("MES", event.getMes()+"");
		Log.e("DIA", event.getDia()+"");
		Log.e("SUBCONTRATISTA", event.getSubcontratista());
		Log.e("TIPO_DE_MAQUINA", event.getTipoMaquina());
		Log.e("CODIGO_DE_MAQUINARIA", event.getCodigoMaquinaria());
		Log.e("PLACAS", event.getPlacas());
		Log.e("N_RECIBO", event.getNRecibo());
		Log.e("ORIGEN", event.getOrigen());
		Log.e("DESTINO", event.getDestino());
		Log.e("TIPO_MATERIAL", event.getTipoMaterial());
		Log.e("VOLUMEN_M3_SUELTO", event.getVolumenM3Suelto());		
		Log.e("ABSCISA_INICIAL", event.getAbscisaInicial());
		Log.e("ABSCISA_FINAL", event.getAbscisaFinal());
		Log.e("ANCHO", event.getAncho());
		Log.e("AREA", event.getArea());
		Log.e("ESTADO_DE_MATERIAL", event.getEstadoMaterialAlFinalizarJornada());
		Log.e("OBSERVACIONES", event.getObservaciones());
		Log.e("LATITUD_GPS", event.getLatitud_gps()+"");
		Log.e("LONGITUD_GPS", event.getLongitud_gps()+"");
		Log.e("ID_SESION", event.getID_Sesion());
		Log.e("ESTADO_SINCRONIZADO", event.getEstadoSincronizacion());
		Log.e("","");
		
		try
		{
		db.insert(TABLA_MOVIMIENTO_MATERIALES, null, ins);
		db.close();		
		Log.e("INSERCION-LOCAL","Se hizo la insercion Correctamente");
		return true;
		}
		catch(Exception e)
		{
			Log.e("NO INSERT "+TABLA_MOVIMIENTO_MATERIALES,e.toString());
			return false;
		}
		finally{db.close();}
	}	
	
	
	
	public boolean INSERTAR_EN_INSTALACION_TUBERIAS(EstrucInstalacionTuberias event)
	{
		/***
		 * Se preparan usan los campos de la base de datos en la tabla INSTALACION_TUBERIAS
		 * y se agrega la informacion de la estructura que contiene toda la informacion que se incluyo en el formulario
		 */
		SQLiteDatabase db=ConectarConDataBase();		
		ContentValues ins=new ContentValues();

		ins.put("HITO", event.getHito());
		ins.put("AÑO", event.getAño());
		ins.put("MES", event.getMes());
		ins.put("DIA", event.getDia());
		ins.put("SUBCONTRATISTA", event.getSubcontratista());
		ins.put("DIAMETRO_TUBERIA_INSTALADA", event.getDiametroTuberiaInstalada());
		ins.put("CANTIDAD_TUBERIA", event.getCantidadTuberia());
		ins.put("ABSCISA_ENCOLE", event.getAbscisaEncole());
		ins.put("ABSCISA_DESCOLE", event.getAbscisaDesloque());
		ins.put("N_DE_OBRA_DE_ARTE", event.getN_ObraArte());
		ins.put("N_TUBERIAS", event.getN_Tuberias());
		ins.put("PENDIENTE_PORC", event.getPendiente_porcent());
		ins.put("N_CELDAS", event.getN_Celdas());		
		ins.put("ESTADO_TUBERIA", event.getEstadoTuberia());		
		ins.put("OBSERVACIONES", event.getObservaciones());
		
		ins.put("LATITUD_GPS", event.getLatitud_gps());
		ins.put("LONGITUD_GPS", event.getLongitud_gps());
		ins.put("ID_SESION", event.getID_Sesion());
		ins.put("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		
		
		Log.e("TABLA",TABLA_INSTALACION_TUBERIAS);
		Log.e("HITO", event.getHito());
		Log.e("AÑO", event.getAño()+"");
		Log.e("MES", event.getMes()+"");
		Log.e("DIA", event.getDia()+"");
		Log.e("SUBCONTRATISTA", event.getSubcontratista());
		Log.e("DIAMETRO_TUBERIA_INSTALADA", event.getDiametroTuberiaInstalada());
		Log.e("CANTIDAD_TUBERIA", event.getCantidadTuberia());
		Log.e("ABSCISA_ENCOLE", event.getAbscisaEncole());
		Log.e("ABSCISA_DESCOLE", event.getAbscisaDesloque());
		Log.e("N_DE_OBRA_DE_ARTE", event.getN_ObraArte());
		Log.e("N_TUBERIAS", event.getN_Tuberias());
		Log.e("PENDIENTE_PORC", event.getPendiente_porcent());
		Log.e("N_CELDAS", event.getN_Celdas());		
		Log.e("ESTADO_TUBERIA", event.getEstadoTuberia());		
		Log.e("OBSERVACIONES", event.getObservaciones());
		Log.e("LATITUD_GPS", event.getLatitud_gps()+"");
		Log.e("LONGITUD_GPS", event.getLongitud_gps()+"");
		Log.e("ID_SESION", event.getID_Sesion());
		Log.e("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		Log.e("","");

		
		try
		{
		db.insert(TABLA_INSTALACION_TUBERIAS, null, ins);
		db.close();
		Log.e("INSERCION-LOCAL","Se hizo la insercion Correctamente");
		return true;
		}
		catch(Exception e)
		{
			Log.e("NO INSERT "+TABLA_INSTALACION_TUBERIAS,e.toString());
			return false;
		}
		finally{db.close();}
	}	

	
	public boolean INSERTAR_EN_MAQUINARIA(EstrucMaquinaria event)
	{
		/***
		 * Se preparan usan los campos de la base de datos en la tabla INSTALACION_TUBERIAS
		 * y se agrega la informacion de la estructura que contiene toda la informacion que se incluyo en el formulario
		 */
		SQLiteDatabase db=ConectarConDataBase();		
		ContentValues ins=new ContentValues();

		ins.put("HITO", event.getHito());
		ins.put("AÑO", event.getAño());
		ins.put("MES", event.getMes());
		ins.put("DIA", event.getDia());
		ins.put("SUBCONTRATISTA", event.getSubcontratista());
		ins.put("DESCRIPCION_MAQUINARIA", event.getDescripcionMaquinaria());
		ins.put("CODIGO_MAQUINA", event.getCodigoDeMaquina());
		ins.put("N_RECIBO", event.getN_Recibo());
		ins.put("UNIDAD_DE_MEDIDA", event.getUnidadDeMedida());
		ins.put("CANTIDAD", event.getCantidad());
		ins.put("ABSCISA_TRABAJO_INICIAL", event.getAbscisaTrabajoInicial());
		ins.put("ABSCISA_TRABAJO_FINAL", event.getAbscisaTrabajoFinal());
		ins.put("ACTIVIDAD_REALIZADA", event.getActividadRealizada());
		ins.put("OBSERVACIONES", event.getObservaciones());
		
		ins.put("LATITUD_GPS", event.getLatitud_gps());
		ins.put("LONGITUD_GPS", event.getLongitud_gps());
		ins.put("ID_SESION", event.getID_Sesion());
		ins.put("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		
		
		Log.e("TABLA",TABLA_MAQUINARIA);
		Log.e("HITO", event.getHito());
		Log.e("AÑO", event.getAño()+"");
		Log.e("MES", event.getMes()+"");
		Log.e("DIA", event.getDia()+"");
		Log.e("SUBCONTRATISTA", event.getSubcontratista());
		Log.e("DESCRIPCION_MAQUINARIA", event.getDescripcionMaquinaria());
		Log.e("CODIGO_MAQUINA", event.getCodigoDeMaquina());
		Log.e("N_RECIBO", event.getN_Recibo());
		Log.e("UNIDAD_DE_MEDIDA", event.getUnidadDeMedida());
		Log.e("CANTIDAD", event.getCantidad());
		Log.e("ABSCISA_TRABAJO_INICIAL", event.getAbscisaTrabajoInicial());
		Log.e("ABSCISA_TRABAJO_FINAL", event.getAbscisaTrabajoFinal());
		Log.e("ACTIVIDAD_REALIZADA", event.getActividadRealizada());
		Log.e("OBSERVACIONES", event.getObservaciones());
		Log.e("LATITUD_GPS", event.getLatitud_gps()+"");
		Log.e("LONGITUD_GPS", event.getLongitud_gps()+"");
		Log.e("ID_SESION", event.getID_Sesion());
		Log.e("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		Log.e("","");
		
		try
		{
		db.insert(TABLA_MAQUINARIA, null, ins);
		db.close();
		Log.e("INSERCION-LOCAL","Se hizo la insercion Correctamente");
		return true;
		}
		catch(Exception e)
		{
			Log.e("NO INSERT "+TABLA_MAQUINARIA,e.toString());
			return false;
		}
		finally{db.close();}
	}	
	
	
	
	public boolean INSERTAR_EN_CONCRETO(EstrucConcretos event)
	{
		/***
		 * Se preparan usan los campos de la base de datos en la tabla INSTALACION_TUBERIAS
		 * y se agrega la informacion de la estructura que contiene toda la informacion que se incluyo en el formulario
		 */
		SQLiteDatabase db=ConectarConDataBase();		
		ContentValues ins=new ContentValues();

		ins.put("HITO", event.getHito());
		ins.put("AÑO", event.getAño());
		ins.put("MES", event.getMes());
		ins.put("DIA", event.getDia());
		ins.put("SUBCONTRATISTA", event.getSubcontratista());
		ins.put("TIPO_CONTRATO", event.getTipoConcreto());
		ins.put("CANTIDAD", event.getCantidad());
		ins.put("N_OBRA", event.getN_ObraDeArte());
		ins.put("ELEMENTO", event.getElemento());
		ins.put("ABSCISA", event.getAbscisa());
		ins.put("CANTIDAD_CEMENTO_BULTOS", event.getCantidad_Cemento_Bultos());
		ins.put("CANTIDAD_ARENA_M3", event.getCantidadArenaM3());
		ins.put("CANTIDAD_TRITURADO_M3", event.getCantidadTrituradoM3());
		ins.put("N_CILINDROS_PRUEBA", event.getN_CilindrosPrueba());		
		ins.put("OBSERVACIONES", event.getObservaciones());
		
		ins.put("LATITUD_GPS", event.getLatitud_gps());
		ins.put("LONGITUD_GPS", event.getLongitud_gps());
		ins.put("ID_SESION", event.getID_Sesion());
		ins.put("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		
		
		Log.e("TABLA",TABLA_CONCRETOS);
		Log.e("HITO", event.getHito());
		Log.e("AÑO", event.getAño()+"");
		Log.e("MES", event.getMes()+"");
		Log.e("DIA", event.getDia()+"");
		Log.e("SUBCONTRATISTA", event.getSubcontratista());
		Log.e("TIPO_CONTRATO", event.getTipoConcreto());
		Log.e("CANTIDAD", event.getCantidad());
		Log.e("N_OBRA", event.getN_ObraDeArte());
		Log.e("ELEMENTO", event.getElemento());
		Log.e("ABSCISA", event.getAbscisa());
		Log.e("CANTIDAD_CEMENTO_BULTOS", event.getCantidad_Cemento_Bultos());
		Log.e("CANTIDAD_ARENA_M3", event.getCantidadArenaM3());
		Log.e("CANTIDAD_TRITURADO_M3", event.getCantidadTrituradoM3());
		Log.e("N_CILINDROS_PRUEBA", event.getN_CilindrosPrueba());		
		Log.e("OBSERVACIONES", event.getObservaciones());
		Log.e("LATITUD_GPS", event.getLatitud_gps()+"");
		Log.e("LONGITUD_GPS", event.getLongitud_gps()+"");
		Log.e("ID_SESION", event.getID_Sesion());
		Log.e("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		Log.e("","");
		
		
		try
		{
		db.insert(TABLA_CONCRETOS, null, ins);
		db.close();
		Log.e("INSERCION-LOCAL","Se hizo la insercion Correctamente");
		return true;
		}
		catch(Exception e)
		{
			Log.e("NO INSERT "+TABLA_CONCRETOS,e.toString());
			return false;
		}
		finally{db.close();}
	}	
	
	
	
	public boolean INSERTAR_EN_RELLENO_OBRAS(EstrucRellenosObras event)
	{
		/***
		 * Se preparan usan los campos de la base de datos en la tabla INSTALACION_TUBERIAS
		 * y se agrega la informacion de la estructura que contiene toda la informacion que se incluyo en el formulario
		 */
		SQLiteDatabase db=ConectarConDataBase();		
		ContentValues ins=new ContentValues();

		ins.put("HITO", event.getHito());
		ins.put("AÑO", event.getAño());
		ins.put("MES", event.getMes());
		ins.put("DIA", event.getDia());
		ins.put("SUBCONTRATISTA", event.getSubcontratista());
		ins.put("TIPO_RELLENO", event.getTIPO_RELLENO());
		ins.put("TIPO_MATERIAL", event.getTIPO_MATERIAL());
		ins.put("N_OBRA_DE_ARTE", event.getN_OBRA_DE_ARTE());
		ins.put("ABSCISA", event.getABSCISA());
		ins.put("LONGITUD", event.getLONGITUD()+"");
		ins.put("ANCHO", event.getANCHO()+"");
		ins.put("ALTO", event.getALTO()+"");
		ins.put("VOLUMEN_APROXIMADO", event.getVOLUMEN_APROXIMADO());
		ins.put("N_TOMA_DE_DENSIDAD", event.getN_TOMA_DE_DENSIDAD());		
		ins.put("OBSERVACIONES", event.getOBSERVACIONES());
		
		ins.put("LATITUD_GPS", event.getLatitud_gps());
		ins.put("LONGITUD_GPS", event.getLongitud_gps());
		ins.put("ID_SESION", event.getID_Sesion());
		ins.put("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		
		
		Log.e("TABLA",TABLA_RELLENOS_OBRAS);
		Log.e("HITO", event.getHito());
		Log.e("AÑO", event.getAño()+"");
		Log.e("MES", event.getMes()+"");
		Log.e("DIA", event.getDia()+"");
		Log.e("SUBCONTRATISTA", event.getSubcontratista());
		Log.e("TIPO_RELLENO", event.getTIPO_RELLENO());
		Log.e("TIPO_MATERIAL", event.getTIPO_MATERIAL());
		Log.e("N_OBRA_DE_ARTE", event.getN_OBRA_DE_ARTE());
		Log.e("ABSCISA", event.getABSCISA());
		Log.e("LONGITUD", event.getLONGITUD()+"");
		Log.e("ANCHO", event.getANCHO()+"");
		Log.e("ALTO", event.getALTO()+"");
		Log.e("VOLUMEN_APROXIMADO", event.getVOLUMEN_APROXIMADO());
		Log.e("N_TOMA_DE_DENSIDAD", event.getN_TOMA_DE_DENSIDAD());		
		Log.e("OBSERVACIONES", event.getOBSERVACIONES());
		Log.e("LATITUD_GPS", event.getLatitud_gps()+"");
		Log.e("LONGITUD_GPS", event.getLongitud_gps()+"");
		Log.e("ID_SESION", event.getID_Sesion());
		Log.e("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		Log.e("","");
		
		
		try
		{
		db.insert(TABLA_RELLENOS_OBRAS, null, ins);
		db.close();
		Log.e("INSERCION-LOCAL","Se hizo la insercion Correctamente");
		return true;
		}
		catch(Exception e)
		{
			Log.e("NO INSERT "+TABLA_RELLENOS_OBRAS,e.toString());
			return false;
		}
		finally{db.close();}
	}
	
	
	public boolean INSERTAR_EN_CLIMA_Y_PERSONAL(EstrucClimaYPersonal event)
	{
		/***
		 * Se preparan usan los campos de la base de datos en la tabla INSTALACION_TUBERIAS
		 * y se agrega la informacion de la estructura que contiene toda la informacion que se incluyo en el formulario
		 */
		SQLiteDatabase db=ConectarConDataBase();		
		ContentValues ins=new ContentValues();

		ins.put("HITO", event.getHito());
		ins.put("AÑO", event.getAño());
		ins.put("MES", event.getMes());
		ins.put("DIA", event.getDia());
		ins.put("TEMPERATURA_PROMEDIO", event.getTEMPERATURA_PROMEDIO());
		ins.put("N_HORAS_LLUVIA_JORLAB", event.getN_HORAS_LLUVIA_JORLAB());
		ins.put("ESTADO_TERRENO", event.getESTADO_TERRENO());
		ins.put("SUBCONTRATISTA", event.getSUBCONTRATISTA());
		ins.put("N_PERSONAS", event.getN_PERSONAS());
		ins.put("FRENTE", event.getFRENTE());
		ins.put("N_OBRA_DE_ARTE", event.getN_OBRA_DE_ARTE());
		ins.put("ELEMENTO", event.getELEMENTO());
		ins.put("ABSCISA_INICIAL", event.getABSCISA_INICIAL());
		ins.put("ABSCISA_FINAL", event.getABSCISA_FINAL());
		ins.put("HORA_INICIO_LABORES", event.getHORA_INICIO_LABORES());
		ins.put("HORA_FINAL_LABORES", event.getHORA_FINAL_LABORES());
		ins.put("OBSERVACIONES", event.getOBSERVACIONES());

		ins.put("LATITUD_GPS", event.getLatitud_gps());
		ins.put("LONGITUD_GPS", event.getLongitud_gps());
		ins.put("ID_SESION", event.getID_Sesion());
		ins.put("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		
		
		Log.e("TABLA",TABLA_CLIMA_Y_PERSONAL);
		Log.e("HITO", event.getHito());
		Log.e("AÑO", event.getAño()+"");
		Log.e("MES", event.getMes()+"");
		Log.e("DIA", event.getDia()+"");
		Log.e("TEMPERATURA_PROMEDIO", event.getTEMPERATURA_PROMEDIO());
		Log.e("N_HORAS_LLUVIA_JORLAB", event.getN_HORAS_LLUVIA_JORLAB());
		Log.e("ESTADO_TERRENO", event.getESTADO_TERRENO());
		Log.e("SUBCONTRATISTA", event.getSUBCONTRATISTA());
		Log.e("N_PERSONAS", event.getN_PERSONAS()+"");
		Log.e("FRENTE", event.getFRENTE());
		Log.e("N_OBRA_DE_ARTE", event.getN_OBRA_DE_ARTE());
		Log.e("ELEMENTO", event.getELEMENTO());
		Log.e("ABSCISA_INICIAL", event.getABSCISA_INICIAL());
		Log.e("ABSCISA_FINAL", event.getABSCISA_FINAL());
		Log.e("HORA_INICIO_LABORES", event.getHORA_INICIO_LABORES());
		Log.e("HORA_FINAL_LABORES", event.getHORA_FINAL_LABORES());
		Log.e("OBSERVACIONES", event.getOBSERVACIONES());
		Log.e("LATITUD_GPS", event.getLatitud_gps()+"");
		Log.e("LONGITUD_GPS", event.getLongitud_gps()+"");
		Log.e("ID_SESION", event.getID_Sesion());
		Log.e("ESTADO_SINCRONIZACION", event.getEstadoSincronizacion());
		Log.e("","");
		
		
		try
		{
		db.insert(TABLA_CLIMA_Y_PERSONAL, null, ins);
		db.close();
		Log.e("INSERCION-LOCAL","Se hizo la insercion Correctamente");
		return true;
		}
		catch(Exception e)
		{
			Log.e("NO INSERT "+TABLA_CLIMA_Y_PERSONAL,e.toString());
			return false;
		}
		finally{db.close();}
	}
	
	
	public boolean INSERTAR_EN_USUARIOS(String user, String pass)
	{
		/***
		 * Se preparan usan los campos de la base de datos en la tabla INSTALACION_TUBERIAS
		 * y se agrega la informacion de la estructura que contiene toda la informacion que se incluyo en el formulario
		 */
		SQLiteDatabase db=ConectarConDataBase();		
		ContentValues ins=new ContentValues();
		try
		{
			ins.put("user", user);
			ins.put("pass", pass);
			
			db.insert(TABLA_USUARIOS, null, ins);
			db.close();
			Log.e("INSERCION-USER","Se hizo la insercion Correctamente");
		return true;
		}
		catch(Exception e)
		{
			Log.e("NO-INSERT-"+TABLA_USUARIOS,e.toString());
			return false;
		}
		finally{db.close();}
	}

//	
//	De este pundo en adelante el espacio y codigo es para consultas
//		
	
	public static boolean verificarAccesoLocal(String userio, String passed)
	{
		boolean login=false;
		SQLiteDatabase db=ConectarConDataBase();
    	Cursor c=db.rawQuery("Select * from USUARIOS where user='"+userio+"' and pass='"+passed+"'",null);
    	//Log.e(userio,passed);
    	if(c.moveToFirst())
    	{
    		do{
    			login=true;
    		}
    		while(c.moveToNext());
    	}
		db.close();
		Log.e("BD-Accesos Local:",String.valueOf(login));
		return login;		
	}

	
	public ArrayList<EstrucMoviemientoMateriales> CONSULTAR_MOVIMIENTO_MATERIALES()
    {  	
		ArrayList<EstrucMoviemientoMateriales> lista_Eventos=new ArrayList<EstrucMoviemientoMateriales>();
		SQLiteDatabase db=ConectarConDataBase();
    	Cursor c=db.rawQuery("Select * from reporte_sivigia",null);
    	
    	if (c.moveToFirst()) 
    	{    		    			
    	     do {
//    	    	lista_Eventos.add(new EstrucMoviemientoMateriales(
//    	    			c.getString(1),//nom_gru
//    	    			c.getString(2),//nom_subgru
//    	    			c.getString(3),//nom_even
//    	    			c.getString(4),//descrip
//    	    			c.getString(5),//cas sosp
//    	    			c.getString(6),//caso proba
//    	    			c.getString(7),//caso confr
//    	    			c.getString(8),//tiempo notif
//    	    			c.getString(9),//ficha notif
//    	    			c.getString(10),//diag dif
//    	    			c.getString(11),//apoyo lab
//    	    			c.getString(12),//otro apoyo
//    	    			c.getString(13),//acc ind
//    	    			c.getString(14),//acc colec
//    	    			c.getString(15) //link
//    	    			));
    	    	
    	     } while(c.moveToNext());    			    		    		
    	}
    	return lista_Eventos;
    }		

	

	//Elimina TOdos los registro de la tabla que ingrese
	public static void LIMPIAR_TABLA(String NombreTabla)
	{
		SQLiteDatabase db2=ConectarConDataBase();
    	Cursor c=db2.rawQuery("Delete from "+NombreTabla,null);
    	if (c.moveToFirst()) 
    	{    		   
    		try
    		{
    	     do {   	    			    
    	    	
    	     } while(c.moveToNext());
    	     Log.e("Limpiando","Se ha limpiado la tabla");
    		}
    		catch (Exception e) {
    			Log.e("Error Limpiando DataBase",e.toString());
			}	    		
    	}
	}	
	

	
//// Algo de Codigo Util para cuando se quieran hacer consultas a la BD 
//	public boolean buscar_evento(String eventName)
//	{
//		boolean busqueda=false;
//		SQLiteDatabase db=ConectarConDataBase();
//		ArrayList<String> al = new ArrayList<String>();
////		+"like "+"'%"+nom+"%'"
//		Cursor cursor = db.rawQuery("SELECT DISTINCT nombre_evento FROM reporte_sivigia WHERE nombre_evento" , null);
//		 if (cursor.moveToFirst()) 
//		 {do
//	      { if(eventName.equals(cursor.getString(0)));
//		 	{busqueda=true;}
//	      } while (cursor.moveToNext());
//	     }
//		 
//		return busqueda;
//	}
////  Cursor c=db2.rawQuery("Select Distinct * from informacion_sivigila where dom_inf='"+gener+"'",null);		

}
