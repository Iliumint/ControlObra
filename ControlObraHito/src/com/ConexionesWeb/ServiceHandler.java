package com.ConexionesWeb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.ClasesEstaticas.URL_conexiones;
import com.ClasesEstaticas.ValoresFijos;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;


public class ServiceHandler {


	
		static public Context contexto;
		static String response = null;
	    public final static int GET = 1;
	    public final static int POST = 2;
	 
	    public ServiceHandler() {	 
	    }
	 
	    
  //********************************************************************************************************
  //********************************************************************************************************
	    
	    /**
	     * Making service call
	     * @url - url to make request
	     * @method - http request method
	     * */
	    public String makeServiceCall(String url, int method) {
	        return this.makeServiceCall(url, method, null);
	    }
	 
	    /**
	     * Making service call
	     * @url - url to make request
	     * @method - http request method
	     * @params - http request params
	     * */
	    public String makeServiceCall(String url, int method,
	            List<NameValuePair> params) {
	    	
	    	response="false";
	        try {
	            // http client
	            DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpEntity httpEntity = null;
	            HttpResponse httpResponse = null;
	             
	            // Checking http request method type
	            if (method == POST) {
	                HttpPost httpPost = new HttpPost(url);
	                // adding post params
	                if (params != null) {
	                    httpPost.setEntity(new UrlEncodedFormEntity(params));
	                }
	 
	                httpResponse = httpClient.execute(httpPost);
	 
	            } else if (method == GET) {
	                // appending params to url
	                if (params != null) {
	                    String paramString = URLEncodedUtils
	                            .format(params, "utf-8");
	                    url += "?" + paramString;
	                }
	                HttpGet httpGet = new HttpGet(url);
	 
	                httpResponse = httpClient.execute(httpGet);
	 
	            }
	            httpEntity = httpResponse.getEntity();
	            response = EntityUtils.toString(httpEntity);
	 
	        } catch (UnsupportedEncodingException e) {
	            Log.e("GET UnsuportEncodig",e.toString()+"");
	        } catch (ClientProtocolException e) {
	        	Log.e("GET Client Protocol",e.toString()+"");
	        } catch (IOException e) {
	        	Log.e("GET IOException",e.toString()+"");
	        }
	         
	        return response;
	 
	    }
	    
	//********************************************************************************************************
	//********************************************************************************************************
	    
	    /**
	     * Making service callPostJSON
	     * @URL_ - url to make request
	     * @packJson - paquete con el codigo Json
	     * Me retorna el StatucCode
	     * */
	    public String makeServicePostJSON(String URL_, String packJson) 
	    {
	    	String respuestaWeb="SIN PROGRAMAR";
	    	
	    	try {	    		
	    		
	    		DefaultHttpClient httpClient = new DefaultHttpClient();
	    		HttpResponse httpResponse;
	    			            
	    		//Pasamos la ruta y el tipo de contenido qeu vamos a enviar //Encabezado
	    		HttpPost httpPost = new HttpPost(URL_);
	    		httpPost.setHeader("content-type", "application/json");	    		
	    		
	    		//Creamos el objeto a enviar y le damos formato utf-8
	            StringEntity entity = new StringEntity(packJson,HTTP.UTF_8);           	            	    		

                if (packJson != null) {
                	 httpPost.setEntity(entity);
                }

                
                //****************************************************************************
                //Aqui deberia ir la revision al estado del servidor.
                
                //Capturamos la respuesta del servidor
                httpResponse = httpClient.execute(httpPost);
                
                
                //getStatusLine --> se debe importar la libreria http, no la commons
                //HttpStatus --> se debe importar la libreria http, no la commons
                StatusLine statusLine = httpResponse.getStatusLine();
 		        int statusCode = statusLine.getStatusCode();
 		        
 		        Log.e("HttpStatus.SC_OK","StatusLine: "+statusLine.getStatusCode());
 		        Log.e("HttpStatus.SC_OK","StatusCode: "+statusCode);
 		        Log.e("HttpStatus.SC_OK",HttpStatus.SC_OK+"\n");
 		        
 		        //**
 		        //**Por alguna Razon no funcion al estatus CODE		        
 		        //**
 		        //Verificamos si el servidro esta activo
 		        if( statusLine.getStatusCode() == HttpStatus.SC_OK)
 		        {	
 		        	//Interpretamos la respuesta del servidor y las convertirmoa String
 	                respuestaWeb = EntityUtils.toString(httpResponse.getEntity());		
 		        }
 		        else
 		        {
 		        	respuestaWeb=ValoresFijos.SERVIDOR_DOWN;
 		        } 		        
 		        
// 		        respuestaWeb = EntityUtils.toString(httpResponse.getEntity());	
 		        
				Log.e("Respueta ExecuteMethod: ",respuestaWeb+"");
				return respuestaWeb;
			} catch (UnsupportedEncodingException e) {
				Log.e("ERROR-SERVICE-POST-Encoding-PJ",e.toString());
				return "false";
			} catch (HttpException e) {
				Log.e("ERROR-SERVICE-POST-Http-PJ",e.toString());
				return "false";
			} catch (IOException e) {
				Log.e("ERROR-SERVICE-POST-IOExcep-PJ",e.toString());
				return "false";
			}
	    }
	    
	    
   //********************************************************************************************************
   //********************************************************************************************************
	    
	    /**
	     * Making service callPostJSON
	     * @URL_ - url de verificacion 
	     * Me retorna el StatucCode
	     * */
	    public static boolean estadoServidor(String URL_)
	    {	    		    	
			DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpResponse httpResponse=null;
    			            
    		//Pasamos la ruta y el tipo de contenido qeu vamos a enviar //Encabezado
    		HttpPost httpPost = new HttpPost(URL_);
    		httpPost.setHeader("content-type", "application/json");	    		
    		
    		//Creamos el objeto a enviar y le damos formato utf-8
    		try
    		{
            StringEntity entity = new StringEntity("{\"\",\"\"}",HTTP.UTF_8);
            httpPost.setEntity(entity);
            Log.e("ESTADO-SERVIDOR","Verificando Estado del Servidor P1");
            httpResponse = httpClient.execute(httpPost);
            Log.e("ESTADO-SERVIDOR","Verificando Estado del Servidor P2");
            StatusLine statusLine = httpResponse.getStatusLine();		    
		    if( statusLine.getStatusCode() == HttpStatus.SC_OK)
	        {
		    	Log.e("ESTADO-SERVIDOR-SH","El servidor esta activo");
		    	return true;
	        }
		    else {
		    	Log.e("ESTADO-SERVIDOR-SH",ValoresFijos.SERVIDOR_DOWN);
				return false;
			}
    		}catch(Exception ex)
    		{
    			Log.e("ESTADO-SERVIDOR",ex.toString());
    			return false;
    		}
		        
	    }
	    
	    
	   static public String estadoServidortx="";
	    
	  //*****************************************************************************************************************
		
		static public String getEstadoServidor() {return estadoServidortx;}
		static public void setEstadoServidor(String estadoServidor) {estadoServidortx = estadoServidor;}
//
//		public static class peticionEstadoServidor extends AsyncTask<String, Void, String> {
//	        @Override
//	        protected String doInBackground(String... url_) {
//	        	boolean b = estadoServidor(URL_conexiones.ESTADO_SERVIDOR);
//	        	return String.valueOf(b);	        	
//	        }
//	        /**
//	         * Uses the logging framework to display the output of the fetch
//	         * operation in the log fragment.
//	         */
//	        @Override
//	        protected void onPostExecute(String result) {   
//	        	estadoServidortx=result;
//	        }
//	    }
		
		//*****************************************************************************************************************
	    
	    
  //********************************************************************************************************
  //********************************************************************************************************
	    
	    /**
	     * Making service call
	     * @URL_ - url to make request
	     * @packJson - paquete con el codigo Json
	     * Me retorna la respuesta del servidor
	     * */
	    public String makeServicePostStatusCode(String URL_, String packJson) 
	    {
	    	try {
				HttpClient httpClient =new HttpClient();
				StringRequestEntity requestEntity = new StringRequestEntity(
				    packJson,
				    "application/json",
				    "UTF-8");

				PostMethod postMethod = new PostMethod(URL_);
				postMethod.setRequestEntity(requestEntity);

				int statusCode = httpClient.executeMethod(postMethod);								
				  
				  
				Log.e("Respueta ExecuteMethod",statusCode+"");
				return "SIN PROGRAMAR POR STATUS CODE";
			} catch (UnsupportedEncodingException e) {
				Log.e("ERROR-SERVICE-POST-Encoding-SC",e.toString());
				return "false";
			} catch (HttpException e) {
				Log.e("ERROR-SERVICE-POST-Http-SC",e.toString());
				return "false";
			} catch (IOException e) {
				Log.e("ERROR-SERVICE-POST-IOExcep-SC",e.toString());
				return "false";
			}
	    }
	    
	    
	    //********************************************************************************************************
	    //   Verificamos que tenga conexion a Internet
	    //********************************************************************************************************   	    
	    
	    
	    public static Context getContexto() {return contexto;}
		public static void setContexto(Context contexto) {ServiceHandler.contexto = contexto;}


		public static boolean isInternetAvailable(Context context) {
            boolean haveConnectedWifi = false;
            boolean haveConnectedMobile = false;
            boolean connectionavailable = false;
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo[] netInfo = cm.getAllNetworkInfo();
            NetworkInfo informationabtnet = cm.getActiveNetworkInfo();
            for (NetworkInfo ni : netInfo) {
                try {
                    if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                        if (ni.isConnected()) haveConnectedWifi = true; //Log.e("Type-Conection",ni.getTypeName());
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                        if (ni.isConnected()) haveConnectedMobile = true;//Log.e("Type-Conection",ni.getTypeName());
                    if (informationabtnet.isAvailable()
                        && informationabtnet.isConnected())
                        connectionavailable = true;//Log.e("Internet","Esta Conectado a Internet");
                    Log.i("ConnectionAvailable", "" + connectionavailable);
                } catch (Exception ex) {
//                 Log.e("Catch Internet","Inside utils catch clause , exception is" + ex.toString());
                    ex.printStackTrace();
                }
            }
            return haveConnectedWifi || haveConnectedMobile;
        }

}
