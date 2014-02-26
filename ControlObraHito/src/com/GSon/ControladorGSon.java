package com.GSon;

import java.util.ArrayList;

import android.util.Log;

import com.ClasesEstaticas.ValoresFijos;
import com.ClasesEstructuras.EstrucClimaYPersonal;
import com.ClasesEstructuras.EstrucConcretos;
import com.ClasesEstructuras.EstrucInstalacionTuberias;
import com.ClasesEstructuras.EstrucMaquinaria;
import com.ClasesEstructuras.EstrucMoviemientoMateriales;
import com.ClasesEstructuras.EstrucRellenosObras;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class ControladorGSon {
	
	//Esta clase necesita las tres(3) librerias de GSON
	static public String convertirEstructuraToJson(Object Estructura)
	{
		//convertimos la lista de alumnos a formato JSON
		Gson gson=new Gson();
		String PaqueteJSON = gson.toJson(Estructura);
		
		//imprimimos en consola el texto con formato JSON
		Log.e("GSON","Texto en Formato JSON: \n"+PaqueteJSON);
	
	
	return PaqueteJSON;
	}
	
	
	//agregamos el paquete Json y adicional a eso pasamos el parametro de la estructura contenido en ValoresFijos
	static public ArrayList<?> convertirJSonToArray(String paqueteJson, int TipoEstructura)
	{	
		Gson gson=new Gson();
		ArrayList<?> listaDeEstructuras;
		
		//Es importante poner los corchetes debido a que se estan manejando Arrays Gson, tener presente al momento de hacer pruebas
		paqueteJson="["+paqueteJson+"]";
		
		//Convertimos cada estructura del paquete Json al tipo de estructura que maneja el App			
		switch (TipoEstructura) {
		case ValoresFijos._MOVIMIENTO_MATEIRALES:
			Log.e("GSON","\nJSON A JAVA MOV-MAT");
			ArrayList<EstrucMoviemientoMateriales> listaEstructurasMovMat=gson.fromJson(paqueteJson, new TypeToken<ArrayList<EstrucMoviemientoMateriales>>(){}.getType());			
			listaDeEstructuras=listaEstructurasMovMat;
			break;
			
		case ValoresFijos._INSTALACION_TUBERIA:
			Log.e("GSON","\nJSON A JAVA INT-TUB");
			ArrayList<EstrucInstalacionTuberias> listaEstructurasTuberia=gson.fromJson(paqueteJson, new TypeToken<ArrayList<EstrucInstalacionTuberias>>(){}.getType());			
			listaDeEstructuras=listaEstructurasTuberia;
			break;
			
		case ValoresFijos._CONCRETO:
			Log.e("GSON","\nJSON A JAVA CONCRE");
			ArrayList<EstrucConcretos> listaEstructurasConcreto=gson.fromJson(paqueteJson, new TypeToken<ArrayList<EstrucConcretos>>(){}.getType());			
			listaDeEstructuras=listaEstructurasConcreto;
			break;
			
		case ValoresFijos._MAQUINARIA:
			Log.e("GSON","\nJSON A JAVA MAQ");
			ArrayList<EstrucMaquinaria> listaEstructurasMaquinaria=gson.fromJson(paqueteJson, new TypeToken<ArrayList<EstrucMaquinaria>>(){}.getType());			
			listaDeEstructuras=listaEstructurasMaquinaria;
			break;
			
		case ValoresFijos._RELLENO_OBRA_ARTE:
			Log.e("GSON","\nJSON A JAVA RELLENO");
			ArrayList<EstrucRellenosObras> listaEstructurasRellenosObras=gson.fromJson(paqueteJson, new TypeToken<ArrayList<EstrucRellenosObras>>(){}.getType());			
			listaDeEstructuras=listaEstructurasRellenosObras;
			break;
			
		case ValoresFijos._CLIMA_Y_PERSONAL:
			Log.e("GSON","\nJSON A JAVA CLIMA");
			ArrayList<EstrucClimaYPersonal> listaEstructurasClimaYPersonal=gson.fromJson(paqueteJson, new TypeToken<ArrayList<EstrucClimaYPersonal>>(){}.getType());			
			listaDeEstructuras=listaEstructurasClimaYPersonal;
			break;			

		default:
			listaDeEstructuras=null;
			break;
		}
		
		return listaDeEstructuras;		
		
	}
	
	

}
