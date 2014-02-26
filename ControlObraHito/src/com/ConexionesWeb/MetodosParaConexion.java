package com.ConexionesWeb;

import android.os.AsyncTask;
import android.util.Log;

import com.ClasesEstaticas.URL_conexiones;

public class MetodosParaConexion {
	
		//1-Tipo de dato //Se usa void o puede ser URL
		//2-Variable para incrementar mientras se hace por lo general int
		//Void por que no estamos usando en doInprogress
		//3-Valor que devuelve el valor doInbackgroud
	
	
	//Creamos una variable String que nos retorne 
	public static String RespuestaWeb;
	public static String getRespuestaWeb() {return RespuestaWeb;}
	public static void setRespuestaWeb(String respuestaWeb) {RespuestaWeb = respuestaWeb;}

	
	
	 /* 
	 * **************************************************************************************************
	 *        CÓdigo para la tabla USUARIOS
	 * **************************************************************************************************
	 */



	public static class hacerPeticionJSONUsuario extends AsyncTask<String, Void, String[]> {

        @Override
        protected String[] doInBackground(String... arg) {
        	 ServiceHandler sh = new ServiceHandler();
        	
        	String[] json={sh.makeServiceCall(URL_conexiones.PEDIR_UN_USUARIO+arg[0], ServiceHandler.GET)};
        	return json;
        }
        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String[] result) {	        	
        	Log.e("PETICION-WEB",result[0]);
        	RespuestaWeb=result[0];
        }
    }
	
	
	public static class enviarJSONUsuario extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... packJson) {
        	 ServiceHandler sh = new ServiceHandler();
        	
        	String json=sh.makeServicePostJSON(URL_conexiones.INSERTAR_USUARIO, packJson[0]);
        	return json;
        }
        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String result) {        	
        	Log.e("PETICION-WEB",result);	
        	RespuestaWeb=result;
        }
    }


}
