package camara;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;



import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends FragmentActivity {


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sws++;
		if(sws==2)
		{
			try
			{
			finish();
			}
			catch(Exception e)
			{}
//			Toast.makeText(this, "Se genero el codigo ON RESUME con "+sws, Toast.LENGTH_SHORT).show();
		}
//	
	}

	int sws=0;
	Bitmap foton;
	String dirM;
//	ImageView image;
//	Button lanzarCAM;
//	private static final int CAMERA_PIC_REQUEST = 1338;
	private static final int CAMERA_PIC_REQUEST = 2500;
	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		//Pasamos el parametro desde otra actividad
//		Intent i =getIntent();
//		dirM=i.getStringExtra("DIR");				
//		Toast.makeText(this, dirM, Toast.LENGTH_SHORT).show();
		sws=0;
		
		
		//Creamos un archivo en la direccion "dirM"
		String dirM = "";
		File targetDirector = new File(dirM);
   	 	File[] files = targetDirector.listFiles();
   	 	int N=files.length;   	 	
   	 	boolean f=true;
   	 	
   	 	for(int k=0;k<files.length;k++)
   	 	{
   	 		if((N+".png").equals(files[k].getName()))
   	 		{
   	 			Log.e("Nombre Igual",files[k].getName().toString());
	 			Log.e("N:",N+"");
   	 			N++;
   	 		}
   	 		else
   	 		{
   	 			Log.e("Nombre Diferente",files[k].getName().toString());
   	 			Log.e("N:",N+"");
   	 		}
   	 	}
//		Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
//		startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);    
		File ruta1=new File("/"+dirM+"/");
		ruta1.mkdir();
		File outputFile=new File(ruta1,N+".png");
//		FileOutputStream fos=new FileOutputStream(outputFile);
		
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(outputFile));
		startActivityForResult(intent, CAMERA_PIC_REQUEST);	
		intent.removeExtra(MediaStore.EXTRA_VIDEO_QUALITY);
		intent.removeExtra(MediaStore.EXTRA_OUTPUT);
//  		cameraIntent.putExtra("theme", -1);
    	
		
	}	
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	    	
	        if (requestCode == CAMERA_PIC_REQUEST) {          	
	        	 // Para guardar la foto en la SD
	        	try
	            {
//	        		 foton = (Bitmap)data.getExtras().get("data");      		                 		
////	        		 image = (ImageView)findViewById(R.id.imageView2); 
////		        	 image.setImageBitmap(foton);
//		        	 almacenar_foto_local(foton,dirM);
	            }
	            catch (Exception ex)
	            {
	                Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
	            }
	        }	      
	    }

	public void almacenar_foto_local(Bitmap foto, String dir)
	    {
		   	 File targetDirector = new File(dir);
		   	 File[] files = targetDirector.listFiles();
		   	 int N=files.length;		   	 
//	    	 File sdcard = Environment.getExternalStorageDirectory();
//			 File ruta2=new File(sdcard.getAbsolutePath() + File.separator+ "MyPriDB" + File.separator + "FOTOS_personas/"+nombre+".png");
	    	 File ruta2=new File("/"+dir+"/"+N+".png");
			 try
			 {
			 ruta2.createNewFile();
			 OutputStream os = new FileOutputStream(ruta2);        	     
//		     foto.compress(Bitmap.CompressFormat.PNG,100,os);	
			 foto.compress(Bitmap.CompressFormat.PNG, 100, os);
			 os.flush();
		     os.close();
//		     mostrar_mensaje("Imagen guardada Correctamente con el nombre de "+nombre);
			 }
			 catch(Exception e)
			 {
				 Log.e("Ficheros","Error al escribir fichero a tarjeta SD");
			 }
	    }
}
