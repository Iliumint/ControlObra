package com.ClasesFormularios;


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
import com.ClasesEstructuras.EstrucClimaYPersonal;
import com.ControlDeObraHito.MainPrincipal;
import com.Galeria.ControladorGaleria;
import com.controlobrahito.R;

public class ClasClimaYPersonalEnObra extends Activity {

	
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
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.CLIMA_Y_PERSONAL);
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
	EstrucClimaYPersonal controlDatos;
	Context contexto=this;
	
	EditText edtHito, edtTemperaturaProm, edtHorasEnLLuvia, edtEstadoTerreno, edtSubcontratista, edtNumPersonas, edtFrente, edtObraArte,
			edtElemento, edtAbscisaFinal, edtAbscisaInicial, edtHoraInicioLab, edtHoraFinalLab, edtObsercaiones;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clas_clima_personal_obra);
		
		btnGuardar=(Button)findViewById(R.id.btnGuardar);
		btnGaleria=(Button)findViewById(R.id.btnGaleria);
		
		edtHito=(EditText)findViewById(R.id.edtClimaHito);
		edtTemperaturaProm=(EditText)findViewById(R.id.edtClimaTemperaturaPromedio);
		edtHorasEnLLuvia=(EditText)findViewById(R.id.edtClimaNHorasLluvia);
		edtEstadoTerreno=(EditText)findViewById(R.id.edtClimaEstadoTerreno);
		edtSubcontratista=(EditText)findViewById(R.id.edtClimaSubcontratistas);
		edtNumPersonas=(EditText)findViewById(R.id.edtClimaNPersona);
		edtFrente=(EditText)findViewById(R.id.edtClimaFrente);
		edtObraArte=(EditText)findViewById(R.id.edtClimaNObraArte);
		edtElemento=(EditText)findViewById(R.id.edtClimaElemento);
		edtAbscisaFinal=(EditText)findViewById(R.id.edtClimaAbscisaFinal);
		edtAbscisaInicial=(EditText)findViewById(R.id.edtClimaAbscisaInicial);
		edtHoraInicioLab=(EditText)findViewById(R.id.edtClimaHoraInicio);
		edtHoraFinalLab=(EditText)findViewById(R.id.edtClimaHoraFinal);
		edtObsercaiones=(EditText)findViewById(R.id.edtObservaciones);
		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				//Capturamos los datos del formulario
				capturarDatos();				
//				
				Activity myActivity=ClasClimaYPersonalEnObra.this;
            	ControladoInserciones.mensaje_confirmarAlmacenarClima(contexto, controlDatos, myActivity);          
			}
		});	
		
		
		btnGaleria.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				lanzarGaleria(ValoresFijos.CLIMA_Y_PERSONAL);
			}
		});
		
	}
	
	
	
	//Llena la estructura con la informacion del formuladrio
	public void capturarDatos()
	{
		//Creamos la estructura para manejar la informacion;
		//Los datos de la fecha se agregan directamente al invocar la clase
		controlDatos=new EstrucClimaYPersonal();
		
		controlDatos.setHito(edtHito.getText().toString());
		controlDatos.setTEMPERATURA_PROMEDIO(edtTemperaturaProm.getText().toString());
		controlDatos.setN_HORAS_LLUVIA_JORLAB(edtHorasEnLLuvia.getText().toString());
		controlDatos.setESTADO_TERRENO(edtEstadoTerreno.getText().toString());
		controlDatos.setSUBCONTRATISTA(edtSubcontratista.getText().toString());			
		controlDatos.setFRENTE(edtFrente.getText().toString());
		controlDatos.setN_OBRA_DE_ARTE(edtObraArte.getText().toString());
		controlDatos.setELEMENTO(edtElemento.getText().toString());
		controlDatos.setABSCISA_FINAL(edtAbscisaFinal.getText().toString());
		controlDatos.setABSCISA_INICIAL(edtAbscisaInicial.getText().toString());
		controlDatos.setHORA_INICIO_LABORES(edtHoraInicioLab.getText().toString());
		controlDatos.setHORA_FINAL_LABORES(edtHoraFinalLab.getText().toString());
		controlDatos.setOBSERVACIONES(edtObsercaiones.getText().toString());
		controlDatos.setID_Sesion(getIntent().getStringExtra("CEDULA"));
		
		try
		{
		String nper=edtNumPersonas.getText().toString();
		if(!nper.equals(""))
		{controlDatos.setN_PERSONAS(Integer.parseInt(nper));
		Log.e("N-PERSONAS-CLASS-CLIMA",""+Integer.parseInt(nper));}
		else{controlDatos.setN_PERSONAS(0);}
		}
		catch(Exception e)
		{
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
		getMenuInflater().inflate(R.menu.clas_clima_ypersonal_en_obra, menu);
		return true;
	}

}
