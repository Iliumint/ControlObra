package com.controlobrahito;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;
import clases_estructuras.EstrucConcretos;
import clases_estructuras.EstrucInstalacionTuberias;
import clases_estructuras.EstrucMaquinaria;
import clases_estructuras.EstrucMoviemientoMateriales;

public class ControladoInserciones extends Activity{
	
	static Context contexto;
	static Activity MyActivity;	
	static EstrucMoviemientoMateriales controlDatosMovMat;
	static EstrucInstalacionTuberias controlDatosInsTub;
	static EstrucMaquinaria controlDatosMaq;
	static EstrucConcretos controlDatosCon;	
	
	static int Sobrecargado=0;//Indica en cual campo se inicio el metodo
	// 1 : Moviemiento Materiales	
	// 2 : Instalcion Tuberias
	// 3 : Maquinaria
	// 4 : Concreto
	// 5 : Rellenos de Obra de Arte
	// 6 : Clima y Personal en Obra
	
	
	//MOVIMIENTO MATERIALES
	//Lanza un mensaje de alerta donde se confirma si queremos almacenar los daros, si la 
	//respuesta en no o cancelar, da la oportunidad de modificar los datos
	static public void mensaje_confirmarAlmacenar(Context contextoN, EstrucMoviemientoMateriales controlDatosN, Activity activity)
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
			    	EjecutarAlmacenadoDeDatos();
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
			    	EjecutarAlmacenadoDeDatos();
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
			    	EjecutarAlmacenadoDeDatos();
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
			    	EjecutarAlmacenadoDeDatos();
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

	
	//Realiza todas las acciones de Almacenar los datos
	static public void EjecutarAlmacenadoDeDatos()
	{	
		//Hacemos la insercion de manera local los datos
		BasedeDatos ManejadorDataBase=new BasedeDatos();				
		boolean insercion=false;
		
		//Verificamos sobre que tabla estamos trabajando para realizar la inserción
		switch (Sobrecargado) {
		case 1:
			Log.e("Sobrecargado",Sobrecargado+"");
			insercion=ManejadorDataBase.INSERTAR_EN_MOVIMIENTO_MATERIALES(controlDatosMovMat);
			break;
		case 2:	
			Log.e("Sobrecargado",Sobrecargado+"");
			insercion=ManejadorDataBase.INSERTAR_EN_INSTALACION_TUBERIAS(controlDatosInsTub);			
			break;
		case 3:	
			Log.e("Sobrecargado",Sobrecargado+"");
			insercion=ManejadorDataBase.INSERTAR_EN_MAQUINARIA(controlDatosMaq);			
			break;
		case 4:			
			Log.e("Sobrecargado",Sobrecargado+"");
			insercion=ManejadorDataBase.INSERTAR_EN_CONCRETO(controlDatosCon);			
			break;
		case 5:	
			Log.e("Sobrecargado",Sobrecargado+"");
//			insercion=ManejadorDataBase.INSERTAR_EN_MOVIMIENTO_MATERIALES(controlDatosMovMat);			
			break;
		case 6:			
			Log.e("Sobrecargado",Sobrecargado+"");
//			insercion=ManejadorDataBase.INSERTAR_EN_MOVIMIENTO_MATERIALES(controlDatosMovMat);			
			break;

		default:
			break;
		}
		
		
		//Verificamos si almacenó la informacion en la base de datos local
		if(insercion)
		{
			//Cargamos y verificamos si se cargaron los datos en la web
			if(cargarWeb())
			{						
				mensaje_alertaConfirmacion();
			}	
			else
			{
				mensaje_alertaFallo();
			}			
		}
		else
		{
			mostrar_toast("No se pudo almacenar la información, por favor intentelo nuevamente pulsando en el botón \"Guardar y Enviar\"");
		}
	}
	
	//Metodo para hacer la sincronizacion web
	static public boolean cargarWeb()
	{
		return false;
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
				regresarAlMenuPrincipal();
			}  
		});  
        dialogo1.setNegativeButton("Salir", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
                regresarAlMenuPrincipal();
            }  
        });            
        dialogo1.show();        
	}
	
	//Si se almacenaron los datos en la base de datos local (insercion=true)
	//y si NO se hizo la sincronizacion web envia este mensaje
	static public  void mensaje_alertaFallo()
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle("Fallo en Sincronización con el Servidor");  
        dialogo1.setMessage("No se pudo comunicar con el servidor, la información se ha almacenado de manera local en el este dispositivo");            
        dialogo1.setCancelable(false);  
        dialogo1.setPositiveButton("Regresar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
            	dialogo1.dismiss();
            }  
        });  
        dialogo1.setNegativeButton("Salir", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
//                mensaje_confirmacion_regresarMenuPrincipal();
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
	
	
	static public void mostrar_toast(String msn)
	{
		Toast.makeText(contexto, msn, Toast.LENGTH_SHORT).show();
	}


}
