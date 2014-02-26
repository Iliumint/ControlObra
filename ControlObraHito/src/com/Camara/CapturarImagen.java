package com.Camara;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.controlobrahito.R;

public class CapturarImagen extends Activity{
	
	static final int CAMERA_PIC_REQUEST = 2500;
	String tipo_formulario="";
	String cedula="";
	String hito;
	View viewGalleria; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camara_layout);
		
		Intent i =getIntent();
		String tipo_formularioI=i.getStringExtra("FORMULARIO");
		String cedulaI=i.getStringExtra("CEDULA");
		String hitoI=i.getStringExtra("HITO");
		tipo_formulario=tipo_formularioI;
		cedula=cedulaI;
		hito=hitoI;
		Log.e("CAMERA","Tipo FOrmulario: "+tipo_formularioI);
		Log.e("CAMERA","Cedula: "+cedula);
		Log.e("CAMERA","Hito: "+hito);
		
		TomarFoto();
		
	}
	
	public void TomarFoto()
	{			
		//Creamos la ruta donde se almacenaran las iamagenes dentro del dispositivo
		String ruta = Environment.getExternalStorageState()+File.separator+"GRODCO/images/";
		File rutafolder= new File (ruta);
	    if(!rutafolder.exists())//Si la ruta ya existe pasa No la sobreescribe
	    {
	    	rutafolder.mkdirs();
	    }   
	    
	  //Creamos la ruta por SECCION donde se almacenaran las iamagenes dentro del dispositivo
		String ruta2 = Environment.getExternalStorageDirectory()+ File.separator +  "GRODCO/images/"+tipo_formulario+"/";
		File rutfile= new File (ruta2);
		 if(!rutfile.exists())
		 {rutfile.mkdirs();}
		 
		 
		  //Creamos la ruta por Seccion/Dia donde se almacenaran las imagenes dentro del dispositivo
		String ruta3 = Environment.getExternalStorageDirectory()+ File.separator +  "GRODCO/images/"+tipo_formulario+"/"+obtenerFechaPhone()+"/";
		File rutfileDay= new File (ruta3);
		 if(!rutfileDay.exists())
		 {rutfileDay.mkdirs();}
	    
    
   	 	//Creamos el archivo que almacenara la imagen
		File rutaArchivo=new File("/"+ruta3+"/");
		rutaArchivo.mkdir();
		
		
		//COncatenamos la primera parte del nombre
		String concatenacionNombrePartePrimera=
				tipo_formulario
				+"__"+
			    cedula
				+"__"+
			    obtenerFechaPhone()
			    +"__"+
			    hito
			    +"__";
		
		
		//Filtramos por el contenido del nombre de la imagen
		FilenameFilter FiltroNOmbre= new FiltroImagenes("hito");
		
		//Vamos a contar el numero imagenes para poner un consecutivo
		File targetDirector = new File(ruta3); 
        File[] files = targetDirector.listFiles(); 
        int N=files.length;
		
		
		// ***Le ponemos nombre a la imagen de la forma:***
		// TIPO_FORMULARIO + CC + DIA + HITO + CONSECUTIVO
		//***
		File outputFile=new File(rutaArchivo,
				concatenacionNombrePartePrimera
				+
			    N
			    +"__"+
				".png");
		
		//Lanzamos la camara para capturar la imagen
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(outputFile));
		startActivityForResult(intent, CAMERA_PIC_REQUEST);		
	}
	
	
	private String obtenerFechaPhone()
	{
		Calendar cal=new GregorianCalendar();
		Date fecha=cal.getTime();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String formatteDate = df.format(fecha);	    
	    
	    return formatteDate;
	}
	
	private String obtenerHora()
	{
		Calendar c = Calendar.getInstance();
		String dia=c.getTime()+"";
		return dia;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {      	
        if (requestCode == CAMERA_PIC_REQUEST) {  
        	//Aqui debemos agregar la opcion para agregar las iamgenes a la galeria.
        	finish();
        }	      
    }
	
	
	public class FiltroImagenes implements FilenameFilter{
	    String cadenaText;
	    FiltroImagenes(String cadenaTexto){
	        this.cadenaText=cadenaTexto;
	    }
	    public boolean accept(File dir, String name){
	        return name.endsWith(cadenaText);
	    }
	}
	

}
