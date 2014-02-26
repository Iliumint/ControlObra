package com.ControlDeObraHito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

import com.ClasesFormularios.ClasClimaYPersonalEnObra;
import com.ClasesFormularios.ClasConcreto;
import com.ClasesFormularios.ClasInstalacionDeTuberia;
import com.ClasesFormularios.ClasMaquinaria;
import com.ClasesFormularios.ClasMovimientoMateriales;
import com.ClasesFormularios.ClasRellenosObrasArte;
import com.Galeria.ControladorGaleria;
import com.Mapas.ClassMapas;
import com.controlobrahito.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainPrincipal extends Activity {
	
	
//	Inicio de las Opciones del menú
//	**	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.reinstalarDataBase:	
			
			String ruta = Environment.getExternalStorageDirectory()+ File.separator +  "GRODCO/";
			File rutfile= new File (ruta);
			 if(!rutfile.exists())
			 {rutfile.mkdirs();}
		    String archivo = "control_obra.sqlite"; //nOMBRE DE LA bASE DE dATOS  		    
			reinstalarFichero(ruta, archivo);
			break;	
			
		case R.id.mostrarMapa:
			lanzar_ClassMapa();			
			break;
			
		default:
			break;
		}		
		
		return super.onOptionsItemSelected(item);		
	}	
//	Fin de las opciones del menu
//	**
	
	
	ImageView ImgBtnMovimientoMateriales, ImgbtnInstalacionTUberia, ImgbtnConcreto, ImgbtnMaquinaria, ImgbtnRellenosObrasArte, ImgbtnClimayPersonalEnObra;
	static public final String TIPO_FORMULARIO="FORMULARIO";
	
	static public final String MOVIMIENTO_MATEIRALES="MovMat";
	static public final String INSTALACION_TUBERIA="InsTub";
	static public final String CONCRETO="Contr";
	static public final String MAQUINARIA="Maq";
	static public final String RELLENO_OBRA_ARTE="RellObra";
	static public final String CLIMA_Y_PERSONAL="ClimaPer";
	
	public String ID_SESION="";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_principal);
        //Inicio del Main
        
        ImgBtnMovimientoMateriales=(ImageView)findViewById(R.id.imgbtnMovimientoMateriales);
        ImgbtnInstalacionTUberia=(ImageView)findViewById(R.id.imgbtnInstalacionTuberia);
        ImgbtnConcreto=(ImageView)findViewById(R.id.imgbtnConcreto);
        ImgbtnMaquinaria=(ImageView)findViewById(R.id.imgbtnMaquinaria);
        ImgbtnRellenosObrasArte=(ImageView)findViewById(R.id.imgbtnRellenosObradeArte);
        ImgbtnClimayPersonalEnObra=(ImageView)findViewById(R.id.imgbtnClimayPersonalObra);
        
        //Optenemos el ID de sesion que necesitamos para todos los servicios del app
        Intent inten=getIntent();
        ID_SESION=inten.getExtras().getString("ID_SESION");
        Log.e("LOGIN","ID: "+ID_SESION);        
        
        
        //Metodos onclik
        ImgBtnMovimientoMateriales.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {			
				mostrar_toast("Movimientos Materiales");
				lanzar_ClasMovimientoMateriales();
			}
		});
        
        ImgbtnInstalacionTUberia.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {			
			mostrar_toast("Instalacion de Tuberias");	
			lanzar_ClasInstalacionTuberia();
			}
		});
        
        ImgbtnConcreto.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {			
				mostrar_toast("Concreto");
				lanzar_ClasConcreto();
			}
		});
        
        ImgbtnMaquinaria.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {			
			mostrar_toast("Maquinaria");	
			lanzar_ClasMaquinaria();
			}
		});
        
        ImgbtnRellenosObrasArte.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {			
				mostrar_toast("Rellenos Obras en Arte");
				lanzar_RellenosObrasDeArte();
			}
		});
        
        ImgbtnClimayPersonalEnObra.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {			
				mostrar_toast("Clima y Personal en Obra");
				lanzar_ClassClimaPersonalEnObra();
			}
		});
        
        
    } //Cierre del MAIN


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_principal, menu);
        return true;
    }
    
    
//    
//  Las siguientes clases lanzan las actividades correspondientes a cada formulario.
//   INICIO LZ
//    
	private void lanzar_ClasMovimientoMateriales()
	{	
		Intent i=new Intent(this, ClasMovimientoMateriales.class);	
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void lanzar_ClasInstalacionTuberia()
	{	
		Intent i=new Intent(this, ClasInstalacionDeTuberia.class);
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void lanzar_ClasConcreto()
	{	
		Intent i=new Intent(this, ClasConcreto.class);
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void lanzar_ClasMaquinaria()
	{	
		Intent i=new Intent(this, ClasMaquinaria.class);
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void lanzar_RellenosObrasDeArte()
	{	
		Intent i=new Intent(this, ClasRellenosObrasArte.class);
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void lanzar_ClassClimaPersonalEnObra()
	{	
		Intent i=new Intent(this, ClasClimaYPersonalEnObra.class);		
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void lanzar_ClassMapa()
	{	
		Intent i=new Intent(this, ClassMapas.class);		
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void lanzar_ClassGalleria()
	{	
		Intent i=new Intent(this, ControladorGaleria.class);	
		i.putExtra("CEDULA", ID_SESION);
		startActivity(i);
	}
	
	private void mostrar_toast(String msn)
	{
		Toast.makeText(this, msn, Toast.LENGTH_SHORT).show();
	}	
	
//	
//	FIN LZ
//		
	private void reinstalarFichero(String ruta, String archivo)
	{
		 File archivoDB = new File(ruta + archivo);
		    
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
			        Log.e("REINSTALACION db","Base de datos creada reinstalada");
			    } 
			    catch (FileNotFoundException e) 
			    {
				        Log.e("ERROR", "Archivo no encontrado, " + e.toString());
			    }
			    catch (IOException e) 
			    {
				        Log.e("ERROR", "Error al reinstalar la Base de Datos " + e.toString());
				}		    
	}	
    
}
