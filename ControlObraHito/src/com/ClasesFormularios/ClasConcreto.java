package com.ClasesFormularios;


import com.BaseDeDatos.BasedeDatos;
import com.BaseDeDatos.ControladoInserciones;
import com.Camara.CapturarImagen;
import com.ClasesEstaticas.ValoresFijos;
import com.ClasesEstructuras.EstrucConcretos;
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

public class ClasConcreto extends Activity {

	
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
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.CONCRETO);
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
	
	Button btnGaleria;
	Button btnGuardar;
	EstrucConcretos controlDatos;
	Context contexto=this;
	
	EditText EdtHito, EdtSubcontratista, EdtTipoConcreto, EdtCantidad, EdtNObraArte, EdtElemento, EdtAbscisa,
	EdtCantidadCementoBultos, EdtCantidadArenaM3, EdtCantidadTrituradoM3, EdtNCilindrosPrueba, EdtObservaciones;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clas_concreto);
		
		
		
		EdtHito=(EditText)findViewById(R.id.edtHito);
		EdtSubcontratista=(EditText)findViewById(R.id.edtTemperaturaPromedio);
		EdtTipoConcreto=(EditText)findViewById(R.id.edtTipoConcreto);
		EdtCantidad=(EditText)findViewById(R.id.edtCantidadConcreto);
		EdtNObraArte=(EditText)findViewById(R.id.edtNObraArte);
		EdtElemento=(EditText)findViewById(R.id.edtElemento);
		EdtAbscisa=(EditText)findViewById(R.id.edtAbscisa);
		EdtCantidadCementoBultos=(EditText)findViewById(R.id.edtCantidadCementoBultos);
		EdtCantidadArenaM3=(EditText)findViewById(R.id.edtCantidadArena);
		EdtCantidadTrituradoM3=(EditText)findViewById(R.id.edtCantidadTriturado);
		EdtNCilindrosPrueba=(EditText)findViewById(R.id.edtNCilindroPrueba);
		EdtObservaciones=(EditText)findViewById(R.id.edtObservaciones);				
	
		
		btnGuardar=(Button)findViewById(R.id.btnGuardar);		
		btnGaleria=(Button)findViewById(R.id.btnGaleria);
	
		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {				
				//Capturamos los datos del formulario
				capturarDatos();				
//				
				Activity myActivity=ClasConcreto.this;
            	ControladoInserciones.mensaje_confirmarAlmacenarConc(contexto, controlDatos, myActivity);
			}
		});
		
		btnGaleria.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				lanzarGaleria(ValoresFijos.CONCRETO);
			}
		});
	}
	
	public void capturarDatos()
	{
//		Creamos la estructura para manejar la informacion;
//		Los datos de la fecha se agregan directamente al invocar la clase
		controlDatos=new EstrucConcretos();
		
		controlDatos.setHito(EdtHito.getText().toString());
		controlDatos.setSubcontratista(EdtSubcontratista.getText().toString());
		controlDatos.setTipoConcreto(EdtTipoConcreto.getText().toString());
		controlDatos.setCantidad(EdtCantidad.getText().toString());
		controlDatos.setN_ObraDeArte(EdtNObraArte.getText().toString());
		controlDatos.setElemento(EdtElemento.getText().toString());
		controlDatos.setAbscisa(EdtAbscisa.getText().toString());
		controlDatos.setCantidad_Cemento_Bultos(EdtCantidadCementoBultos.getText().toString());
		controlDatos.setCantidadArenaM3(EdtCantidadArenaM3.getText().toString());
		controlDatos.setCantidadTrituradoM3(EdtCantidadTrituradoM3.getText().toString());
		controlDatos.setN_CilindrosPrueba(EdtNCilindrosPrueba.getText().toString());			
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
		getMenuInflater().inflate(R.menu.clas_concreto, menu);
		return true;
	}

}
