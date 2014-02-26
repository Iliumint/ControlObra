package com.BaseDeDatos;


import java.util.ArrayList;

import com.ClasesEstaticas.MensajeBuilDialog;
import com.ClasesEstaticas.URL_conexiones;
import com.ClasesEstaticas.ValoresFijos;
import com.ClasesEstructuras.EstrucClimaYPersonal;
import com.ClasesEstructuras.EstrucConcretos;
import com.ClasesEstructuras.EstrucInstalacionTuberias;
import com.ClasesEstructuras.EstrucMaquinaria;
import com.ClasesEstructuras.EstrucMoviemientoMateriales;
import com.ClasesEstructuras.EstrucRellenosObras;
import com.ConexionesWeb.ServiceHandler;
import com.GSon.ControladorGSon;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ControladoInserciones extends Activity{
	
	static Context contexto;
	static Activity MyActivity;
	static boolean ISinsercionLocal=false;
	static String ISinsercionWebGlobal="false";
	static public MensajeBuilDialog MensajeCargando=new MensajeBuilDialog();	
	
	
	static EstrucMoviemientoMateriales controlDatosMovMat;
	static EstrucInstalacionTuberias controlDatosInsTub;
	static EstrucMaquinaria controlDatosMaq;
	static EstrucConcretos controlDatosCon;
	static EstrucRellenosObras controlDatosRell;
	static EstrucClimaYPersonal controlDatosClima;	
	
	static int Sobrecargado=0;//Indica en cual campo se inicio el metodo
	// 1 : Moviemiento Materiales	
	// 2 : Instalcion Tuberias
	// 3 : Maquinaria
	// 4 : Concreto
	// 5 : Rellenos de Obra de Arte
	// 6 : Clima y Personal en Obra
	
	
	//*****************************************************************************	
	//	
	//Dentro de esta clase se controla la inserción a la base de datos local y 
	//Tambien se hce la peticion para enviar el paquete JSON al webservices	
	//	
	//*****************************************************************************	
	
	//MOVIMIENTO MATERIALES
	//Lanza un mensaje de alerta donde se confirma si queremos almacenar los daros, si la 
	//respuesta en no o cancelar, da la oportunidad de modificar los datos
	static public void mensaje_confirmarAlmacenarMovMat(Context contextoN, EstrucMoviemientoMateriales controlDatosN, Activity activity)
	{		
		Log.e("Sobrecargado","Ingresa al Mov Mat");
		contexto=contextoN;
		MyActivity=activity;
		controlDatosMovMat=controlDatosN;
		
		try {
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
			dialogo1.setTitle("Mensaje de Confirmación");  
			dialogo1.setMessage("¿Desea agregar este registro?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) { 
			    	Sobrecargado=1;
			    	mensajeDobleConfirmacion();
			    }  
			});  
			dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) {                 
			        dialogo1.dismiss();
			    }  
			});            
			dialogo1.show();
		} catch (Exception e) {
			Log.e("Sobrecargado","Error alerta Mov Mat");
			e.printStackTrace();
		}
	}
	
	//INSTALACION DE TUBERIAS
	//Lanza un mensaje de alerta donde se confirma si queremos almacenar los daros, si la 
	//respuesta en no o cancelar, da la oportunidad de modificar los datos
	static public void mensaje_confirmarAlmacenarIntTub(Context contextoN, EstrucInstalacionTuberias controlDatosN, Activity activity)
	{	
		Log.e("Sobrecargado","Ingresa al Int Tub");
		contexto=contextoN;
		MyActivity=activity;
		controlDatosInsTub=controlDatosN;
		
		try {
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
			dialogo1.setTitle("Mensaje de Confirmación");  
			dialogo1.setMessage("¿Desea agregar este registro?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) { 
			    	Sobrecargado=2;
			    	mensajeDobleConfirmacion();
			    }  
			});  
			dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) {                 
			        dialogo1.dismiss();
			    }  
			});            
			dialogo1.show();
		} catch (Exception e) {
			Log.e("Sobrecargado","Error en Int Tub");
			Log.e("Sobrecargado",e.toString()+"");
			e.printStackTrace();
		}
	}

	
	//MAQUINARIA
	//Lanza un mensaje de alerta donde se confirma si queremos almacenar los daros, si la 
	//respuesta en no o cancelar, da la oportunidad de modificar los datos
	static public void mensaje_confirmarAlmacenarMaq(Context contextoN, EstrucMaquinaria controlDatosN, Activity activity)
	{	
		Log.e("Sobrecargado","Ingresa al Maq");
		contexto=contextoN;
		MyActivity=activity;
		controlDatosMaq=controlDatosN;
		
		try {
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
			dialogo1.setTitle("Mensaje de Confirmación");  
			dialogo1.setMessage("¿Desea agregar este registro?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) { 
			    	Sobrecargado=3;
			    	mensajeDobleConfirmacion();
			    }  
			});  
			dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) {                 
			        dialogo1.dismiss();
			    }  
			});            
			dialogo1.show();
		} catch (Exception e) {
			Log.e("Sobrecargado","Error alerta Maquina");
			e.printStackTrace();
		}
	}

	//CONCRETO
	//Lanza un mensaje de alerta donde se confirma si queremos almacenar los daros, si la 
	//respuesta en no o cancelar, da la oportunidad de modificar los datos
	static public void mensaje_confirmarAlmacenarConc(Context contextoN, EstrucConcretos controlDatosN, Activity activity)
	{		
		Log.e("Sobrecargado","Ingresa al Con");
		contexto=contextoN;
		MyActivity=activity;
		controlDatosCon=controlDatosN;
		
		try {
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
			dialogo1.setTitle("Mensaje de Confirmación");  
			dialogo1.setMessage("¿Desea agregar este registro?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) { 
			    	Sobrecargado=4;
			    	mensajeDobleConfirmacion();
			    }  
			});  
			dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) {                 
			        dialogo1.dismiss();
			    }  
			});            
			dialogo1.show();
		} catch (Exception e) {
			 Log.e("Sobrecargado","Error alerta Concreto");
			e.printStackTrace();
		}
	}
	
	//Relleno de Obras
	//Lanza un mensaje de alerta donde se confirma si queremos almacenar los daros, si la 
	//respuesta en no o cancelar, da la oportunidad de modificar los datos
	static public void mensaje_confirmarAlmacenarRelleno(Context contextoN, EstrucRellenosObras controlDatosN, Activity activity)
	{		
		Log.e("Sobrecargado","Ingresa al Relle");
		contexto=contextoN;
		MyActivity=activity;
		controlDatosRell=controlDatosN;
		
		try {
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
			dialogo1.setTitle("Mensaje de Confirmación");  
			dialogo1.setMessage("¿Desea agregar este registro?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) { 
			    	Sobrecargado=5;
			    	mensajeDobleConfirmacion();
			    }  
			});  
			dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) {                 
			        dialogo1.dismiss();
			    }  
			});            
			dialogo1.show();
		} catch (Exception e) {
			 Log.e("Sobrecargado","Error alerta Relleno");
			e.printStackTrace();
		}
	}
	
	
	//Clima y Personal
	//Lanza un mensaje de alerta donde se confirma si queremos almacenar los daros, si la 
	//respuesta en no o cancelar, da la oportunidad de modificar los datos
	static public void mensaje_confirmarAlmacenarClima(Context contextoN, EstrucClimaYPersonal controlDatosN, Activity activity)
	{		
		Log.e("Sobrecargado","Ingresa al Relle");
		contexto=contextoN;
		MyActivity=activity;
		controlDatosClima=controlDatosN;
		
		try {
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
			dialogo1.setTitle("Mensaje de Confirmación");  
			dialogo1.setMessage("¿Desea agregar este registro?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) { 
			    	Sobrecargado=6;
			    	mensajeDobleConfirmacion();
			    }  
			});  
			dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
			    public void onClick(DialogInterface dialogo1, int id) {                 
			        dialogo1.dismiss();
			    }  
			});            
			dialogo1.show();
		} catch (Exception e) {
			 Log.e("Sobrecargado","Error alerta Clima");
			e.printStackTrace();
		}
	}

	
//	
//	//Realiza todas las acciones de Almacenar los datos
//	static public void EjecutarAlmacenadoDeDatos()
//	{	
//		//Hacemos la insercion de manera local los datos
//		BasedeDatos ManejadorDataBase=new BasedeDatos();				
//		boolean ISinsercionLocal=false;
//		String ISinsercionWeb="false";
//		Object controlDatosGeneral=null;
//		//Verificamos sobre que tabla estamos trabajando para realizar la inserción en la Base de Dato
//		//Tambien convertimos el paquete el Gson
//		
//		try {
//			switch (Sobrecargado) {
//			case 1:
//				Log.e("Sobrecargado",Sobrecargado+"");
//				controlDatosGeneral=controlDatosMovMat;		
//				ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);			
//				controlDatosMovMat.setEstadoSincronizacion(ISinsercionWeb);
//				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_MOVIMIENTO_MATERIALES(controlDatosMovMat);
//				
//				
//					
//				break;
//			case 2:	
//				Log.e("Sobrecargado",Sobrecargado+"");
//				controlDatosGeneral=controlDatosInsTub;
//				ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
//				controlDatosInsTub.setEstadoSincronizacion(ISinsercionWeb);
//				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_INSTALACION_TUBERIAS(controlDatosInsTub);
//
//				
//				
//				break;
//			case 3:	
//				Log.e("Sobrecargado",Sobrecargado+"");
//				controlDatosGeneral=controlDatosMaq;
//				ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
//				controlDatosMaq.setEstadoSincronizacion(ISinsercionWeb);
//				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_MAQUINARIA(controlDatosMaq);
//				
//				
//				
//				break;
//			case 4:			
//				Log.e("Sobrecargado",Sobrecargado+"");
//				controlDatosGeneral=controlDatosCon;
//				ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
//				controlDatosCon.setEstadoSincronizacion(ISinsercionWeb);
//				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_CONCRETO(controlDatosCon);
//
//				
//				
//				break;
//			case 5:	
//				Log.e("Sobrecargado",Sobrecargado+"");
//				controlDatosGeneral=controlDatosRell;
//				ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
//				controlDatosRell.setEstadoSincronizacion(ISinsercionWeb);
//				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_RELLENO_OBRAS(controlDatosRell);
//
//				
//				
//				break;
//			case 6:			
//				Log.e("Sobrecargado",Sobrecargado+"");
//				controlDatosGeneral=controlDatosClima;
//				ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
//				controlDatosClima.setEstadoSincronizacion(ISinsercionWeb);
//				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_CLIMA_Y_PERSONAL(controlDatosClima);
//
//				
//				
//				break;
//
//			default:
//				break;
//			}
//		} catch (Exception e) {
//			Log.e("ALMACENADO",e.toString());
//		}
//		
//		
//		
//		
////		//IMPORTANTE
////		//Verificamos si almacenó la informacion en la base de datos local
////		if(ISinsercionWeb.)
////		{
////			//Cargamos y verificamos si se cargaron los datos en la web
////			if(cargarWeb(controlDatosGeneral, Sobrecargado))
////			{						
////				mensaje_alertaConfirmacion();
////			}	
////			else
////			{
////				mensaje_alertaFalloWEB();
////			}			
////		}
////		else
////		{
////			mostrar_toast("No se pudo almacenar la información, por favor intentelo nuevamente pulsando en el botón \"Guardar y Enviar\"");
////		}
//		
//		
//	}//**** FIN almacenar DATOS
//	
	
	//Clase encargada de enviar la peticion a la web
	public static class enviarFormularioWeb extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... packJson) {        	       	
        	 
        	String ISinsercionWeb="false";
        	Object controlDatosGeneral=null;
        				
        	
    	 	try {
				switch (Sobrecargado) {
				case 1:
					controlDatosGeneral=controlDatosMovMat;		
					ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
					break;
				case 2:
					controlDatosGeneral=controlDatosInsTub;
					ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);		
					break;
				case 3:
					controlDatosGeneral=controlDatosMaq;
					ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);					
					break;
				case 4:
					controlDatosGeneral=controlDatosCon;
					ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
					break;
				case 5:
					controlDatosGeneral=controlDatosRell;
					ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
					break;
				case 6:
					controlDatosGeneral=controlDatosClima;
					ISinsercionWeb=enviarInsercionWeb(controlDatosGeneral, Sobrecargado);
					break;

				default:
					break;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.e("ALMACENADO-Asytacks",e.toString());
			}
        	 
        	 
        	return ISinsercionWeb;
        }
        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String ISinsercionWeb) { 
        	
        
    		//Hacemos la insercion de manera local los datos
    		BasedeDatos ManejadorDataBase=new BasedeDatos();			    		
    		ISinsercionWebGlobal=ISinsercionWeb;
    		Object controlDatosGeneral=null;
    		//Verificamos sobre que tabla estamos trabajando para realizar la inserción en la Base de Dato
    		//Tambien convertimos el paquete el Gson
        	
        	try {
    			switch (Sobrecargado) {
    			case 1:
    				Log.e("Sobrecargado",Sobrecargado+"");
    				controlDatosMovMat.setEstadoSincronizacion(ISinsercionWeb);
    				Log.e("ESTADo_SINCRO","Valor: "+ISinsercionWeb+" -ControlEstructura:"+controlDatosMovMat.getEstadoSincronizacion());
    				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_MOVIMIENTO_MATERIALES(controlDatosMovMat);   				    				    					
    				break;
    				
    			case 2:	
    				Log.e("Sobrecargado",Sobrecargado+"");
    				controlDatosInsTub.setEstadoSincronizacion(ISinsercionWeb);
    				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_INSTALACION_TUBERIAS(controlDatosInsTub);    				    				
    				break;
    				
    			case 3:	
    				Log.e("Sobrecargado",Sobrecargado+"");
    				controlDatosMaq.setEstadoSincronizacion(ISinsercionWeb);
    				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_MAQUINARIA(controlDatosMaq);
    				break;
    				
    			case 4:			
    				Log.e("Sobrecargado",Sobrecargado+"");
    				controlDatosCon.setEstadoSincronizacion(ISinsercionWeb);
    				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_CONCRETO(controlDatosCon);    				
    				break;
    				
    			case 5:	
    				Log.e("Sobrecargado",Sobrecargado+"");
    				controlDatosRell.setEstadoSincronizacion(ISinsercionWeb);
    				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_RELLENO_OBRAS(controlDatosRell);
    				break;
    				
    			case 6:			
    				Log.e("Sobrecargado",Sobrecargado+"");
    				controlDatosClima.setEstadoSincronizacion(ISinsercionWeb);
    				ISinsercionLocal=ManejadorDataBase.INSERTAR_EN_CLIMA_Y_PERSONAL(controlDatosClima);    				    				
    				break;

    			default:
    				break;
    			}
    			
    			
    			//finalizamos mensaje de espera
    			ProgressDialog msnCargando=(ProgressDialog)MensajeCargando.getObjectView();
    			msnCargando.dismiss();
    			
    			//Mensaje de como se vieron la inserciones
    			mensajePostExecute();
    			
    			
    			
        	} catch (Exception e) {
    			Log.e("ALMACENADO",e.toString());
    		}
        	
        }
    }
	
	
	public static void mensajePostExecute()
	{
		Log.e("MENSAJES",ISinsercionWebGlobal);
		MensajeBuilDialog.mensajeSencillo(contexto, "Mensaje respuesta del Servidor", ISinsercionWebGlobal, "aceptar", "cacelar");
	//IMPORTANTE
	//Verificamos si almacenó la informacion en el Servidor
	if(ISinsercionWebGlobal.equals("true"))
	{	
		//Cargamos y verificamos si se cargaron los datos locales
		if(ISinsercionLocal)
		{mensaje_alertaConfirmacion();}	
		//else
		//{mostrar_toast("No se pudo almacenar la información en la base de, por favor intentelo nuevamente pulsando en el botón \"Guardar y Enviar\"");}			
	}
	else
		{
		if(ISinsercionLocal)
		{mensaje_alertaFalloWEB();}
		else{mostrar_toast("No se pudo almacenar la información, por favor intentelo nuevamente pulsando en el botón \"Guardar y Enviar\"");}
		}
	}
	
	
	//Metodo que conoce la url al que debe enviar el apquete Json para hacer la sincronizacion web
	static public String enviarInsercionWeb(Object controlDatosGen, int tipoMetodo)
	{
		String respuestaWeb="false";
		if(controlDatosGen!=null)
		{
    	//Generamos el paquete Json de lo que se va cargar al Web Services
    	String paqueteJson=ControladorGSon.convertirEstructuraToJson(controlDatosGen);
    	Log.e("GSON","Paquete Gson a enviar: "+paqueteJson);
    	ServiceHandler handler=new ServiceHandler();
    	
    	Log.e("TIPO-METODO",tipoMetodo+"");
    	switch (tipoMetodo) {
		case ValoresFijos._MOVIMIENTO_MATEIRALES:
			respuestaWeb=handler.makeServicePostJSON(URL_conexiones.INSERTAR_REGISTRO_MOVMAT, paqueteJson);
			break;
		case ValoresFijos._INSTALACION_TUBERIA:
			respuestaWeb=handler.makeServicePostJSON(URL_conexiones.INSERTAR_REGISTRO_INSTUB, paqueteJson);
			break;
		case ValoresFijos._MAQUINARIA:
			respuestaWeb=handler.makeServicePostJSON(URL_conexiones.INSERTAR_REGISTRO_MAQUINARIA, paqueteJson);
			break;
		case ValoresFijos._CONCRETO:
			respuestaWeb=handler.makeServicePostJSON(URL_conexiones.INSERTAR_REGISTRO_CONCRETO, paqueteJson);
			break;
		case ValoresFijos._RELLENO_OBRA_ARTE:
			respuestaWeb=handler.makeServicePostJSON(URL_conexiones.INSERTAR_REGISTRO_RELLENOS, paqueteJson);
			break;
		case ValoresFijos._CLIMA_Y_PERSONAL:
			respuestaWeb=handler.makeServicePostJSON(URL_conexiones.INSERTAR_REGISTRO_CLIMA, paqueteJson);
			break;	

		default:
			break;
		}    	
    	
    	
    	return respuestaWeb;
		}
		else{return "false";}   	
		
	}
	
	
	//Regresa al menu principal
	static public  void regresarAlMenuPrincipal()
	{
		MyActivity.finish();
	}
	
	
	//Si se almacenraon los datos en la base de datos local (insercion=true)
	//y si se hizo la sincronizacion web envia este mensaje (sincronizacion=true)
	static public  void mensaje_alertaConfirmacion()
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle("Sicronización Exitosa");  
        dialogo1.setMessage("Los datos fueron cargados en el servidor");            
        dialogo1.setCancelable(false);  
		dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				dialogo1.dismiss();
				regresarAlMenuPrincipal();
			}  
		});  
        dialogo1.setNegativeButton("Salir", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
            	dialogo1.dismiss();
                regresarAlMenuPrincipal();
            }  
        });            
        dialogo1.show();        
	}
	
	
	//Si se almacenaron los datos en la base de datos local (insercion=true)
	//y si NO se hizo la sincronizacion web envia este mensaje
	static public  void mensaje_alertaFalloWEB()
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle("Fallo en Sincronización con el Servidor");  
        dialogo1.setMessage("No se pudo comunicar con el servidor, la información se ha almacenado de manera local en el este dispositivo");            
        dialogo1.setCancelable(false);  
        dialogo1.setPositiveButton("Regresar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) { 
            	dialogo1.dismiss();
            	regresarAlMenuPrincipal();
            }  
        });  
        dialogo1.setNegativeButton("Salir", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
//                mensaje_confirmacion_regresarMenuPrincipal();
            	dialogo1.dismiss();
            	regresarAlMenuPrincipal();
            }  
        });            
        dialogo1.show();        
	}
	
	
	//Lanza un mensaje para regresar al menu principal
	static public void mensaje_confirmacion_regresarMenuPrincipal()
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle("Mensaje de Confirmación");  
        dialogo1.setMessage("Esta seguro que desea regresar al menú pricipal");            
        dialogo1.setCancelable(false);  
        dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
            	dialogo1.dismiss();
            	regresarAlMenuPrincipal();
            }  
        });  
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {                 
                dialogo1.dismiss();
            }  
        });            
        dialogo1.show(); 
	}	
	
	
	
	//Mensaje de DOble confirmacion
	static public void mensajeDobleConfirmacion()
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle("Confirmación");  
        dialogo1.setMessage("Una vez efectuada la transacción no se podra revertir");            
        dialogo1.setCancelable(false);  
		dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				//EjecutarAlmacenadoDeDatos();
				//Lanzamos el mensaje de espera
				dialogo1.dismiss();
	        	MensajeCargando.mensajeCargando(contexto, "Enviando Datos", "Favor espere hasta que finalice el envío de la información");
				new enviarFormularioWeb().execute("");
			}  
		});  
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
                dialogo1.dismiss();
            }  
        });            
        dialogo1.show();        
	}
	
	
	//MEnsaje Toast
	static public void mostrar_toast(String msn)
	{
		Toast.makeText(contexto, msn, Toast.LENGTH_SHORT).show();
	}
	
	

}
