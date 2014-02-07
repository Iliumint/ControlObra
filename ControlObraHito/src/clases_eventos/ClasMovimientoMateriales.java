package clases_eventos;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import camara.CapturarImagen;
import clases_estructuras.EstrucMoviemientoMateriales;

import com.controlobrahito.BasedeDatos;
import com.controlobrahito.ControladoInserciones;
import com.controlobrahito.MainPrincipal;
import com.controlobrahito.R;

public class ClasMovimientoMateriales extends Activity {

	
	//Controlador de la opciones del menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.menu_camara:
			Intent i =new Intent(this, CapturarImagen.class);
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.MOVIMIENTO_MATEIRALES);
			startActivity(i);			
			break;						
			
		default:
			break;
		}				
		return super.onOptionsItemSelected(item);		
	}
	//Fin del controlador del menu
	
	
	EditText EdtHito, EdtSubcontratista, EdtTipodeMaquina, EdtCodigodeMaquina, 	EdtPlacas, EdtNRecibo, EdtOrigen, EdtDestino, EdtTipoMaterial, 
			 EdtVolumenM3Suelto, EdtAbscisaInicial, EdtAbscisaFinal, EdtAncho, EdtArea, EdtEstadoMaterialAlFinalizarJornada, EdtObservaciones;
	
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
		
	
		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {	
				//Capturamos los datos del formulario
				capturarDatos();				
//				
				Activity myActivity=ClasMovimientoMateriales.this;
            	ControladoInserciones.mensaje_confirmarAlmacenar(contexto, controlDatos, myActivity);           				
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



