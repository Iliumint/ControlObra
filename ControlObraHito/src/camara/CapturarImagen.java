package camara;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.controlobrahito.R;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.support.v4.app.FragmentActivity;

public class CapturarImagen extends Activity{
	
	static final int CAMERA_PIC_REQUEST = 2500;
	String tipo_formulario="";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camara_layout);
		
		Intent i =getIntent();
		String tipo_formularioI=i.getStringExtra("FORMULARIO");
		tipo_formulario=tipo_formularioI;
		Log.e("CAMERA",tipo_formularioI);
		
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
	    
    
   	 	//Creamos el archivo que almacenara la imagen
		File rutaArchivo=new File("/"+ruta2+"/");
		rutaArchivo.mkdir();
		
		// ***Le ponemos nombre a la imagen de la forma:***
		// TIPO_FORMULARIO al que pertenece- Fecha, hora,y formato PNG
		//***
		File outputFile=new File(rutaArchivo,
				tipo_formulario
				+" "+obtenerFechaPhone()+" "+obtenerHora()
				+".png");
		
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
        	finish();
        }	      
    }
	

}
