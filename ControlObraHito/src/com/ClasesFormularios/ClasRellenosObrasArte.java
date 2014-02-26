package com.ClasesFormularios;


import com.BaseDeDatos.ControladoInserciones;
import com.Camara.CapturarImagen;
import com.ClasesEstaticas.ValoresFijos;
import com.ClasesEstructuras.EstrucClimaYPersonal;
import com.ClasesEstructuras.EstrucMaquinaria;
import com.ClasesEstructuras.EstrucMoviemientoMateriales;
import com.ClasesEstructuras.EstrucRellenosObras;
import com.ControlDeObraHito.MainPrincipal;
import com.Galeria.ControladorGaleria;
import com.controlobrahito.R;
import com.controlobrahito.R.layout;
import com.controlobrahito.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClasRellenosObrasArte extends Activity {

//Controlador de la opciones del menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.menu_camara:
			
			if(!edtHito.getText().toString().equals(""))
			{
			Intent i =new Intent(this, CapturarImagen.class);
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.RELLENO_OBRA_ARTE);
			i.putExtra("CEDULA", getIntent().getStringExtra("CEDULA"));
			i.putExtra("HITO", edtHito.getText().toString());
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
	EstrucRellenosObras controlDatos;
	Context contexto=this;
	
	EditText edtHito, edtSubcontratista, edtTipoRelleno, edtTipoMaterial, edtNumObraArte, edtAbscisa, edtLongitud,
			edtAlto, edtAncho, edtVolumenAprox, edtNTomaDensidad, edtObsercaiones;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clas_rellenos_obras_arte);
		
				
		btnGuardar=(Button)findViewById(R.id.btnGuardar);
		btnGaleria=(Button)findViewById(R.id.btnGaleria);
		
		
		edtHito=(EditText)findViewById(R.id.edtHito);
		edtSubcontratista=(EditText)findViewById(R.id.edtSubcontratrista);
		edtTipoRelleno=(EditText)findViewById(R.id.edtTipoRelleno);
		edtTipoMaterial=(EditText)findViewById(R.id.edtTipoMaterial);
		edtNumObraArte=(EditText)findViewById(R.id.edtNObraArte);
		edtAbscisa=(EditText)findViewById(R.id.edtAbscisa);
		edtLongitud=(EditText)findViewById(R.id.edtLongitud);
		edtAlto=(EditText)findViewById(R.id.edtAlto);
		edtAncho=(EditText)findViewById(R.id.edtAncho);
		edtVolumenAprox=(EditText)findViewById(R.id.edtVolumenAproximado);
		edtNTomaDensidad=(EditText)findViewById(R.id.edtNTomaDensidad);
		edtObsercaiones=(EditText)findViewById(R.id.edtObservaciones);
		
		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {	
				//Capturamos los datos del formulario
				capturarDatos();				
//				
				Activity myActivity=ClasRellenosObrasArte.this;
            	ControladoInserciones.mensaje_confirmarAlmacenarRelleno(contexto, controlDatos, myActivity);           				
			}
		});		
		
		btnGaleria.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				lanzarGaleria(ValoresFijos.RELLENO_OBRA_ARTE);
			}
		});
	}

	
	
	//Llena la estructura con la informacion del formuladrio
	public void capturarDatos()
	{
		//Creamos la estructura para manejar la informacion;
		//Los datos de la fecha se agregan directamente al invocar la clase
		controlDatos=new EstrucRellenosObras();
		
		controlDatos.setHito(edtHito.getText().toString());
		controlDatos.setSubcontratista(edtSubcontratista.getText().toString());
		controlDatos.setTIPO_RELLENO(edtTipoRelleno.getText().toString());
		controlDatos.setTIPO_MATERIAL(edtTipoMaterial.getText().toString());
		controlDatos.setN_OBRA_DE_ARTE(edtNumObraArte.getText().toString());
		controlDatos.setABSCISA(edtAbscisa.getText().toString());		
		controlDatos.setVOLUMEN_APROXIMADO(edtVolumenAprox.getText().toString());
		controlDatos.setN_TOMA_DE_DENSIDAD(edtNTomaDensidad.getText().toString());
		controlDatos.setOBSERVACIONES(edtObsercaiones.getText().toString());
		controlDatos.setID_Sesion(getIntent().getStringExtra("CEDULA"));

		try {
			String l,al,an;
			l=edtLongitud.getText().toString();
			al=edtAlto.getText().toString();
			an=edtAncho.getText().toString();
			Log.e("Longitud-CLASS-RELLENO",""+Double.parseDouble(l));
			Log.e("Ancho-CLASS-RELLENO",""+Double.parseDouble(al));
			Log.e("Alto-CLASS-RELLENO",""+Double.parseDouble(an));
			
			if(!l.equals(""))
			{controlDatos.setLONGITUD(Double.parseDouble(l));}
			else{controlDatos.setLONGITUD(0);}
			
			if(!al.equals(""))
			{controlDatos.setALTO(Double.parseDouble(al));}
			else{controlDatos.setALTO(0);}
			
			if(!an.equals(""))
			{controlDatos.setANCHO(Double.parseDouble(an));}
			else{controlDatos.setANCHO(0);}	
			
		} catch (Exception e) {
			mostrarMensaje("Favor verifique los datos de longitud, alto y ancho sean correctos");
		}
		
	
	}
	
	//Abrimos la galeria
	private void lanzarGaleria(String identificadorImagenen)
	{	
		Intent i=new Intent(this, ControladorGaleria.class);
		i.putExtra("ID_GALERIA", identificadorImagenen);
		i.putExtra("CEDULA", getIntent().getStringExtra("CEDULA"));
		i.putExtra("HITO", edtHito.getText().toString());
		startActivity(i);
	}
	
	private void mostrarMensaje(String msn)
	{
		Toast.makeText(this, msn, Toast.LENGTH_LONG).show();
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clas_rellenos_obras_arte, menu);
		return true;
	}

}
