package com.ClasesFormularios;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.BaseDeDatos.ControladoInserciones;
import com.Camara.CapturarImagen;
import com.ClasesEstaticas.ValoresFijos;
import com.ClasesEstructuras.EstrucMoviemientoMateriales;
import com.ControlDeObraHito.MainPrincipal;
import com.GSon.ControladorGSon;
import com.Galeria.ControladorGaleria;
import com.controlobrahito.R;

public class ClasMovimientoMateriales extends Activity {

	
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
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.MOVIMIENTO_MATEIRALES);
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
	
	
	EditText EdtHito, EdtSubcontratista, EdtTipodeMaquina, EdtCodigodeMaquina, 	EdtPlacas, EdtNRecibo, EdtOrigen, EdtDestino, EdtTipoMaterial, 
			 EdtVolumenM3Suelto, EdtAbscisaInicial, EdtAbscisaFinal, EdtAncho, EdtArea, EdtEstadoMaterialAlFinalizarJornada, EdtObservaciones;
	
	Button btnGaleria;
	Button btnGuardar;
	EstrucMoviemientoMateriales controlDatos;
	boolean insersion=false;
	Context contexto=this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clas_movimiento_materiales);
		
		
		EdtHito=(EditText)findViewById(R.id.edtHito);
		EdtSubcontratista=(EditText)findViewById(R.id.edtTemperaturaPromedio);
		EdtTipodeMaquina=(EditText)findViewById(R.id.edtTipoMaquinaria);
		EdtCodigodeMaquina=(EditText)findViewById(R.id.edtCodigoMaquinaria);
		EdtPlacas=(EditText)findViewById(R.id.edtPlacas);
		EdtNRecibo=(EditText)findViewById(R.id.edtNRecibo);
		EdtOrigen=(EditText)findViewById(R.id.edtOrigen);
		EdtDestino=(EditText)findViewById(R.id.edtDestino);
		EdtTipoMaterial=(EditText)findViewById(R.id.edtTipoMaterial);
		EdtVolumenM3Suelto=(EditText)findViewById(R.id.edtVolumenE3Suelto);
		EdtAbscisaInicial=(EditText)findViewById(R.id.edtAbscisaInicial);
		EdtAbscisaFinal=(EditText)findViewById(R.id.edtAbscisaFinal);
		EdtAncho=(EditText)findViewById(R.id.edtAncho);
		EdtArea=(EditText)findViewById(R.id.edtArea);
		EdtEstadoMaterialAlFinalizarJornada=(EditText)findViewById(R.id.edtEstadodelMaterialAlFinalizar);
		EdtObservaciones=(EditText)findViewById(R.id.edtObservaciones);		
		
		btnGuardar=(Button)findViewById(R.id.btnGuardar);
		btnGaleria=(Button)findViewById(R.id.btnGaleria);
		
	
		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {	
				//Capturamos los datos del formulario
				capturarDatos();				
//				
				//Enviamos los datos a la clase que ocntrola las inserciones a la bas de datos
				Activity myActivity=ClasMovimientoMateriales.this;
            	ControladoInserciones.mensaje_confirmarAlmacenarMovMat(contexto, controlDatos, myActivity);            	

			}
		});
		
		btnGaleria.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				lanzarGaleria(ValoresFijos.MOVIMIENTO_MATEIRALES);
			}
		});
		
	}//Fin del main

	
	
	//Llena la estructura con la informacion del formuladrio
	public void capturarDatos()
	{
		//Creamos la estructura para manejar la informacion;
		//Los datos de la fecha se agregan directamente al invocar la clase
		controlDatos=new EstrucMoviemientoMateriales();
		
		controlDatos.setHito(EdtHito.getText().toString());
		controlDatos.setSubcontratista(EdtSubcontratista.getText().toString());
		controlDatos.setTipoMaquina(EdtTipodeMaquina.getText().toString());
		controlDatos.setCodigoMaquinaria(EdtCodigodeMaquina.getText().toString());
		controlDatos.setPlacas(EdtPlacas.getText().toString());
		controlDatos.setNRecibo(EdtNRecibo.getText().toString());
		controlDatos.setOrigen(EdtOrigen.getText().toString());
		controlDatos.setDestino(EdtDestino.getText().toString());
		controlDatos.setTipoMaterial(EdtTipoMaterial.getText().toString());
		controlDatos.setVolumenM3Suelto(EdtVolumenM3Suelto.getText().toString());
		controlDatos.setAbscisaInicial(EdtAbscisaInicial.getText().toString());
		controlDatos.setAbscisaFinal(EdtAbscisaFinal.getText().toString());
		controlDatos.setAncho(EdtAncho.getText().toString());
		controlDatos.setArea(EdtArea.getText().toString());
		controlDatos.setEstadoMaterialAlFinalizarJornada(EdtEstadoMaterialAlFinalizarJornada.getText().toString());
		controlDatos.setObservaciones(EdtObservaciones.getText().toString());
		controlDatos.setID_Sesion(getIntent().getStringExtra("CEDULA"));
	}
	
	//Limpia los campos del formuarios
	private void limpiarCampos()
	{
		EdtHito.setText("");
		EdtSubcontratista.setText("");
		EdtTipodeMaquina.setText("");
		EdtCodigodeMaquina.setText("");
		EdtPlacas.setText("");
		EdtNRecibo.setText("");
		EdtOrigen.setText("");
		EdtDestino.setText("");
		EdtTipoMaterial.setText("");
		EdtVolumenM3Suelto.setText("");
		EdtAbscisaInicial.setText("");
		EdtAbscisaFinal.setText("");
		EdtAncho.setText("");
		EdtArea.setText("");
		EdtEstadoMaterialAlFinalizarJornada.setText("");
		EdtObservaciones.setText("");
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
		getMenuInflater().inflate(R.menu.clas_movimiento_materiales, menu);		
		return true;
	}
	
	private void mostrar_toast(String msn)
	{
		Toast.makeText(this, msn, Toast.LENGTH_SHORT).show();
	}

}

//**************************
//Comentarios fuera del app
//**************************


////Por objeto de prueba voy a pasar un valor Json para convertir a estructura Arrays<?>
//ArrayList<EstrucMoviemientoMateriales>ListasdeEstructura=
//(ArrayList<EstrucMoviemientoMateriales>)ControladorGSon.convertirJSonToArray(paqueteJson, ValoresFijos._MOVIMIENTO_MATEIRALES);
//for(int i=0;i<ListasdeEstructura.size();i++)
//{
//	Log.e("BTN-MOVMAT",ListasdeEstructura.get(i).getHito().toString());
//	Log.e("BTN-MOVMAT",ListasdeEstructura.get(i).getObservaciones().toString());
//}


