package com.ClasesEstaticas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.Camara.CapturarImagen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;

public class ValoresFijos{
	
	public static final String URL_VerificarAcceso="http://servicedatosabiertoscolombia.cloudapp.net/v1/Ministerio_de_Salud/enosfinal?$format=json";
	public static String ID_FULL_SESION="";	


	//Utiles para rutas de Imagenes
	static public final String MOVIMIENTO_MATEIRALES="MovMat";
	static public final String INSTALACION_TUBERIA="InsTub";
	static public final String CONCRETO="Contr";
	static public final String MAQUINARIA="Maq";
	static public final String RELLENO_OBRA_ARTE="RellObra";
	static public final String CLIMA_Y_PERSONAL="ClimaPer";
	
	
	//Equivalente de las clases en numeros
	static public final int _MOVIMIENTO_MATEIRALES=1;
	static public final int _INSTALACION_TUBERIA=2;
	static public final int _MAQUINARIA=3;
	static public final int _CONCRETO=4;	
	static public final int _RELLENO_OBRA_ARTE=5;
	static public final int _CLIMA_Y_PERSONAL=6;
	
	
	static public final String SERVIDOR_DOWN="El servidor no esta disponible";
	static public final String PAQUETE="TIPO_PAQUETE";//Se usa en la galeria
	static public final String ID_GALERIA="ID_GALERIA";//Se usa en la galeria
	

	//Algoritmo de Encryptación
	public static String cryptMD5(String textoPlano)
	{
	    try
	    {
	       final char[] HEXADECIMALES = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
	 
	       MessageDigest msgdgt = MessageDigest.getInstance("MD5");
	       byte[] bytes = msgdgt.digest(textoPlano.getBytes());
	       StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
	       for (int i = 0; i < bytes.length; i++)
	       {
	           int low = (int)(bytes[i] & 0x0f);
	           int high = (int)((bytes[i] & 0xf0) >> 4);
	           strCryptMD5.append(HEXADECIMALES[high]);
	           strCryptMD5.append(HEXADECIMALES[low]);
	       }
	       return strCryptMD5.toString();
	    } catch (NoSuchAlgorithmException e) {
	       return null;
	    }
	}	
	

	//Metodos Get Y Set
	public static String getID_FULL_SESION() {
		return ID_FULL_SESION;
	}
	public static void setID_FULL_SESION(String iD_FULL_SESION) {
		ID_FULL_SESION = iD_FULL_SESION;
	}
}

