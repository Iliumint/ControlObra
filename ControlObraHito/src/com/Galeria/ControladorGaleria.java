package com.Galeria;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.Camara.CapturarImagen;
import com.ClasesEstaticas.MensajeBuilDialog;
import com.ClasesEstaticas.ValoresFijos;
import com.ControlDeObraHito.MainPrincipal;
import com.controlobrahito.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ControladorGaleria extends Activity {

	
//	Inicio de las Opciones del menú
//	**	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.menu_camara:				
			Intent i =new Intent(this, CapturarImagen.class);
			i.putExtra("FORMULARIO", tipoFormulario);
			i.putExtra("CEDULA", cedula);
			i.putExtra("HITO", hito);
			startActivity(i);	
			break;				

		default:
			break;
		}		
		
		return super.onOptionsItemSelected(item);		
	}	
//	Fin de las opciones del menu
//	**
	
	
	//Cuando regresa de la camra regarga nuevamente la galeria
	@Override
	protected void onResume() {

		controlRefrescado++;
		if(controlRefrescado>1)
		{
			//refrescarGaleria(); //EL metodo de refrescar galeria no funciono del todo bien, hay qeu revisar el notifiBaseAdapter()
			refrescarActivity();
		}		
		super.onResume();
	}

	@Override
	protected void onPostResume() {		
		super.onPostResume();
	}




	@SuppressWarnings("deprecation")
	Gallery wdGaleria;
	ImageView ViewImagenSeleccionada;
	Context contexto=this;
	String tipoFormulario="";
	String nombreArchivosImagenes;
	int controlRefrescado=0;
	MyFileGalleryAdapter adaptadorGaleria;
	
	String cedula="";
	String hito="";
	

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.galeria_layout);		
		
		Intent intDato=getIntent();
		tipoFormulario=intDato.getStringExtra(ValoresFijos.ID_GALERIA);
		cedula=intDato.getStringExtra("CEDULA");
		hito=intDato.getStringExtra("HITO");
		
		
		//Armamos el nombre base de los archivos
		nombreArchivosImagenes=
				tipoFormulario
				+"__"+
				cedula
				+"__"+
				obtenerFechaPhone()
				+"__"+
				hito;
				
				
		
		
		wdGaleria=(Gallery)findViewById(R.id.gallery1);
		ViewImagenSeleccionada=(ImageView)findViewById(R.id.imageView1);		
						
		//El paqueteImagenes contiene la ruta de los tipos de formulario qeu se usaron		
		String ExternalStorageDirectoryPath = Environment.getExternalStorageDirectory().getAbsolutePath();		
		
//		Direccion de donde se encuentra el paquete con las imagenes
		String targetPath = ExternalStorageDirectoryPath + "/GRODCO/images/"+tipoFormulario+"/"+obtenerFechaPhone();
//		Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);	        
        final File[] archivosImagenes = targetDirector.listFiles();
        
		//cargamos imagenes desde Files[]
        if(archivosImagenes!=null)
        {
        adaptadorGaleria=new MyFileGalleryAdapter(this, archivosImagenes);
        wdGaleria.setAdapter(adaptadorGaleria);
        }
        else{
        	MensajeBuilDialog.mensajeSencillo(this, "Imagenes no disponibles", "No se encuentran imagenes disponibles, puede agregar alguna si asi lo desea.","Aceptar","Cancelar");
        }
		
        
		//Agregamos la imagen al ImageView cuando se toca el gallery redimencionamos la imagen
		wdGaleria.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView parent, View v, int position, long id) 
			{				
				//Agregamos la imagen al ImageView
		        ViewImagenSeleccionada.setImageBitmap
		        (
		        	//Concertimos en Bitmap desde Files[]
		        	BitmapUtilsFile.decodeSampledBitmapFromUri
		        	(archivosImagenes[position].getPath(), 200, 300)		        			        	
		        );		        
			}

		});				
	}
	
	
	


	//No se pudo implementar este metodo,  devido a que no se sabe manejar el notifyDataSetChanged();
	private void refrescarGaleria()
	{	
		//El paqueteImagenes contiene la ruta de los tipos de formulario qeu se usaron		
		String ExternalStorageDirectoryPath = Environment.getExternalStorageDirectory().getAbsolutePath();			
//		Direccion de donde se encuentra el paquete con las imagenes
		String targetPath = ExternalStorageDirectoryPath + "/GRODCO/images/"+tipoFormulario+"/"+obtenerFechaPhone();
//		Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);	        
        final File[] archivosImagenes = targetDirector.listFiles();
        
        //Quitamos todas las vista antiguas        
        adaptadorGaleria=new MyFileGalleryAdapter(this, archivosImagenes);
        adaptadorGaleria.notifyDataSetChanged();
        
        //wdGaleria.setAdapter(adaptadorGaleria);                
		//cargamos imagenes desde Files[]
        //wdGaleria.setAdapter(new MyFileGalleryAdapter(this, archivosImagenes));
	}
	
	//Cerramos y volvemos a cargar la actividad para refrescar la galeria
	private void refrescarActivity()
	{
		finish();
		startActivity(getIntent());
	}
	
	
	private String obtenerFechaPhone()
	{
		Calendar cal=new GregorianCalendar();
		Date fecha=cal.getTime();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String formatteDate = df.format(fecha);	    
	    
	    return formatteDate;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_galeria, menu);
		return true;
	}
	
	

}
