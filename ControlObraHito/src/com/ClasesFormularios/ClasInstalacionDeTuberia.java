package com.ClasesFormularios;


import com.BaseDeDatos.BasedeDatos;
import com.BaseDeDatos.ControladoInserciones;
import com.Camara.CapturarImagen;
import com.ClasesEstaticas.ValoresFijos;
import com.ClasesEstructuras.EstrucInstalacionTuberias;
import com.ClasesEstructuras.EstrucMoviemientoMateriales;
import com.ControlDeObraHito.MainPrincipal;
import com.Galeria.ControladorGaleria;
import com.controlobrahito.R;
import com.controlobrahito.R.layout;
import com.controlobrahito.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClasInstalacionDeTuberia extends Activity {

	
//Controlador de la opciones del menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.menu_camara:
			if(!EdtHito.getText().toString().equals(""))
			{
			Intent i =new Intent(this, CapturarImagen.class);
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.INSTALACION_TUBERIA);
			i.putExtra("CEDULA", getIntent().getStringExtra("CEDULA"));
			i.putExtra("HITO", EdtHito.getText().toString());
			startActivity(i);
			}
			else
			{
				mostrarMensaje("Es necesario agregar el hito para poder tomar una foto");
			}	
			break;						
			
		default:
			break;
		}				
		return super.onOptionsItemSelected(item);		
	}
	//Fin del controlador del menu
	
	EditText EdtHito, EdtSubcontratista, EdtDiametroTuberiaInstalada, EdtCantidadTuberia, EdtAbscisaEncole, EdtAbscisaDescole, EdtNObraArte, EdtNTuberias, 
			EdtPendientePorcent, EdtNCeldas, EdtEstadoTuberia, EdtObservaciones;

	Button btnGaleria;
	Button btnGuardar;
	EstrucInstalacionTuberias controlDatos;
	Context contexto=this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clas_instalacion_de_tuberia);
		
		
		
		EdtHito=(EditText)findViewById(R.id.edtHito);
		EdtSubcontratista=(EditText)findViewById(R.id.edtTemperaturaPromedio);
		EdtDiametroTuberiaInstalada=(EditText)findViewById(R.id.edtDescripcionMaquia);
		EdtCantidadTuberia=(EditText)findViewById(R.id.edtCantidadTuberia);
		EdtAbscisaEncole=(EditText)findViewById(R.id.edtAbscisaEncole);
		EdtAbscisaDescole=(EditText)findViewById(R.id.edtAbscisaDescole);
		EdtNObraArte=(EditText)findViewById(R.id.edtNObraArte);
		EdtNTuberias=(EditText)findViewById(R.id.edtNTuberias);
		EdtPendientePorcent=(EditText)findViewById(R.id.edtPendientePorcet);
		EdtNCeldas=(EditText)findViewById(R.id.edtNCeldas);
		EdtEstadoTuberia=(EditText)findViewById(R.id.edtEstadoTuberias);
		EdtObservaciones=(EditText)findViewById(R.id.edtObservaciones);
		
		btnGuardar=(Button)findViewById(R.id.btnGuardar);
		btnGaleria=(Button)findViewById(R.id.btnGaleria);
		
	
		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				//Capturamos los datos del formulario
				capturarDatos();				
//				
				Activity myActivity=ClasInstalacionDeTuberia.this;
            	ControladoInserciones.mensaje_confirmarAlmacenarIntTub(contexto, controlDatos, myActivity);
			}
		});
		
		btnGaleria.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				lanzarGaleria(ValoresFijos.INSTALACION_TUBERIA);
			}
		});
		
	}
	
	
	public void capturarDatos()
	{
//		Creamos la estructura para manejar la informacion;
//		Los datos de la fecha se agregan directamente al invocar la clase
		controlDatos=new EstrucInstalacionTuberias();
		
		controlDatos.setHito(EdtHito.getText().toString());
		controlDatos.setSubcontratista(EdtSubcontratista.getText().toString());
		controlDatos.setDiametroTuberiaInstalada(EdtDiametroTuberiaInstalada.getText().toString());
		controlDatos.setCantidadTuberia(EdtCantidadTuberia.getText().toString());
		controlDatos.setAbscisaEncole(EdtAbscisaEncole.getText().toString());
		controlDatos.setAbscisaDesloque(EdtAbscisaDescole.getText().toString());
		controlDatos.setN_ObraArte(EdtNObraArte.getText().toString());
		controlDatos.setN_Tuberias(EdtNTuberias.getText().toString());		
		controlDatos.setPendiente_porcent(EdtPendientePorcent.getText().toString());
		controlDatos.setN_Celdas(EdtNCeldas.getText().toString());
		controlDatos.setEstadoTuberia(EdtEstadoTuberia.getText().toString());		
		controlDatos.setObservaciones(EdtObservaciones.getText().toString());
		controlDatos.setID_Sesion(getIntent().getStringExtra("CEDULA"));
	}
	
	//Abrimos la galeria
	private void lanzarGaleria(String identificadorImagenen)
	{	
		Intent i=new Intent(this, ControladorGaleria.class);
		i.putExtra("ID_GALERIA", identificadorImagenen);
		i.putExtra("CEDULA", getIntent().getStringExtra("CEDULA"));
		i.putExtra("HITO", EdtHito.getText().toString());
		startActivity(i);
	}
	
	
	private void mostrarMensaje(String msn)
	{
		Toast.makeText(this, msn, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clas_instalacion_de_tuberia, menu);
		return true;
	}

}
