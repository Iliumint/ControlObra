package com.ControlDeObraHito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

import com.controlobrahito.R;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SaludoInicial extends Activity {

	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	Context contexto=this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.saludo_inicial);
	
		//Creamos el directorio que se usara para almacer la BD
		//Preparamos la Base de Datos Interna
		
		copiar_dbV3();
		
		
		// Clase en la que est� el c�digo a ejecutar 
	     TimerTask timerTask = new TimerTask() 
	     { 
	         public void run()  
	         { 
	             // Aqu� el c�digo que queremos ejecutar. 
	        	 Log.e("APLication","Lanzar Aplication: ");
	        	 Lanzar_Inicio();
	        	 Log.e("APLication","LANZADO ");
	         } 
	     };	     

	      // Aqu� se pone en marcha el timer cada segundo. 
	     Timer timer = new Timer(); 
	     // Dentro de 0 milisegundos av�same cada 1000 milisegundos
	     timer.schedule(timerTask, 3700);
//	     timer.scheduleAtFixedRate(timerTask, 0, 3000);
		
		
	}

	public void Lanzar_Inicio()
	{
		Intent i=new Intent(this, InicioSesion.class);	
		startActivity(i);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.saludo_inicial, menu);
//		return true;
//	}
	
	public void copiar_dbV3()
	{
		String ruta = Environment.getExternalStorageDirectory()+ File.separator +  "GRODCO/";
		File rutfile= new File (ruta);
		 if(!rutfile.exists())
		 {rutfile.mkdirs();}
	    String archivo = "control_obra.sqlite"; //nOMBRE DE LA bASE DE dATOS    
	    copiar_fichero(ruta, archivo);
	    
//	    reinstalarFichero(ruta, archivo);
	}
	
	
	private void copiar_fichero(String ruta, String archivo)
	{
		 File archivoDB = new File(ruta + archivo);

		    if (!archivoDB.exists()) 
		    {
		    	Log.e("EXIST", "No exite, entonces entra");
			    try 
			    {
			        InputStream IS = getApplicationContext().getAssets().open(archivo);
			        OutputStream OS = new FileOutputStream(archivoDB);
			        byte[] buffer = new byte[1024];
			        int length = 0;
			        while ((length = IS.read(buffer))>0){
			            OS.write(buffer, 0, length);
			        }
			        OS.flush();
			        OS.close();
			        IS.close();
			        Log.e("LISTO","Base de datos creada");
			    } 
			    catch (FileNotFoundException e) 
			    {
				        Log.e("ERROR", "Archivo no encontrado, " + e.toString());
			    }
			    catch (IOException e) 
			    {
				        Log.e("ERROR", "Error al copiar la Base de Datos, " + e.toString());
				}
		    }
	}		
}
