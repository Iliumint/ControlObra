package com.ClasesEstaticas;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.ProgressBar;

import com.BaseDeDatos.ControladoInserciones.enviarFormularioWeb;

public class MensajeBuilDialog{

	/**
	 * Construyendo Mensaje Sencillo, muestra un BuilDialog sencillo
	 * @contexto Contexto en el cual se esta trabajando
	 * @Titulo tiutlo del BuilDialog
	 * @mensajeContenido El mensaje que ira dentro del BuilDialog
	 * @msnBtnConfirmar Mensaje en el Bonton Confirmar
	 * @msnBtnCancelar Mensaje en el boton candela.. Ej:Cancelar, Salir --Ejecuta dialog.dismiss()
	 **/
	static public void mensajeSencillo(Context contexto, String Titulo, String mensajeContenido, String msnBtnCofirmar, String msnBtnCancelar)
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle(Titulo);  
        dialogo1.setMessage(mensajeContenido);            
        dialogo1.setCancelable(false);  
		dialogo1.setPositiveButton(msnBtnCofirmar, new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				//EjecutarAlmacenadoDeDatos();
				new enviarFormularioWeb().execute("");
			}  
		});  
        dialogo1.setNegativeButton(msnBtnCancelar, new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
                dialogo1.dismiss();
            }  
        });            
        dialogo1.show();        
	}	

	
	/**
	 * Construyendo Mensaje de retorno, muestra un BuilDialog sencillo y al finalizar retrocede una actividad
	 * @contexto Contexto en el cual se esta trabajando
	 * @Titulo tiutlo del BuilDialog
	 * @mensajeContenido El mensaje que ira dentro del BuilDialog
	 * @msnBtnConfirmar Mensaje en el Bonton Confirmar
	 * @msnBtnCancelar Mensaje en el boton candela.. Ej:Cancelar, Salir --Ejecuta Activity finish()
	 **/
	static public void mensajeRetorno(Context contexto, String Titulo, String mensajeContenido, String msnBtnCofirmar, String msnBtnCancelar, final Activity MyActividad)
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle(Titulo);  
        dialogo1.setMessage(mensajeContenido);            
        dialogo1.setCancelable(false);  
		dialogo1.setPositiveButton(msnBtnCofirmar, new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				//EjecutarAlmacenadoDeDatos();
				new enviarFormularioWeb().execute("");
			}  
		});  
        dialogo1.setNegativeButton(msnBtnCancelar, new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
                MyActividad.finish();
            }  
        });            
        dialogo1.show();        
	}	

	
	
	/**
	 * Construyendo Mensaje Animado Carga, muestra un BuilDialog sencillo
	 * @contexto Contexto en el cual se esta trabajando
	 * @Titulo tiutlo del BuilDialog
	 * @mensajeContenido El mensaje que ira dentro del BuilDialog
	 * @msnBtnConfirmar Mensaje en el Bonton Confirmar
	 * @msnBtnCancelar Mensaje en el boton candela.. Ej:Cancelar, Salir --Ejecuta dialog.dismiss()
	 **/
	static public void mensajeAnimadoCarga(Context contexto, String Titulo, String mensajeContenido, String msnBtnCofirmar, String msnBtnCancelar)
	{
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(contexto);  
        dialogo1.setTitle(Titulo);  
        dialogo1.setMessage(mensajeContenido);
        
        ProgressBar cargandoView=new ProgressBar(contexto);
        
        dialogo1.setView(cargandoView);
        dialogo1.setCancelable(false);  
		dialogo1.setPositiveButton(msnBtnCofirmar, new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) { 
				dialogo1.dismiss();				
			}  
		});  
        dialogo1.setNegativeButton(msnBtnCancelar, new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {  
                dialogo1.dismiss();
            }  
        });            
        dialogo1.show();        
	}	
	
	
	
	
	/**
	 * Metodos para controlar el mensaje de carga de datos
	 **/
	public Object objectView;	
	public Object getObjectView() {return objectView;}
	public void setObjectView(Object objectView) {this.objectView = objectView;}


	public void mensajeCargando(Context contexto, String Titulo, String mensajeContenido)
	{
		ProgressDialog dialogo1 = new ProgressDialog(contexto);  
        dialogo1.setTitle(Titulo);  
        dialogo1.setMessage(mensajeContenido);                     
        
        dialogo1.setCancelable(false); 		            
        dialogo1.show();
        Log.e("PROGRESS-DIALOG","Creado");
        objectView=dialogo1;
	}
	

}
