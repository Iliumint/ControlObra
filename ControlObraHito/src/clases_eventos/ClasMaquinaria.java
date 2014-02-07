package clases_eventos;

import camara.CapturarImagen;
import clases_estructuras.EstrucMaquinaria;
import clases_estructuras.EstrucMoviemientoMateriales;

import com.controlobrahito.BasedeDatos;
import com.controlobrahito.ControladoInserciones;
import com.controlobrahito.MainPrincipal;
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

public class ClasMaquinaria extends Activity {

	
//Controlador de la opciones del menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.menu_camara:
			Intent i =new Intent(this, CapturarImagen.class);
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.MAQUINARIA);
			startActivity(i);			
			break;						
			
		default:
			break;
		}				
		return super.onOptionsItemSelected(item);		
	}
	//Fin del controlador del menu
	
	Button btnGuardar;
	EstrucMaquinaria controlDatos;
	Context contexto=this;
	
	EditText EdtHito, EdtDescripcionMaquin, EdtSubcontratista, EdtCodigoMaquia, EdtN_Recibo, EdtUnidadMedida, 
			EdtCantidad, EdtAbscisaTrabajoInicial, EdtAbscisaTrabajoFinal, EdtActividadRealizada, EdtObservaciones;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clas_maquinaria);
		
		
		EdtHito=(EditText)findViewById(R.id.edtHito);
		EdtDescripcionMaquin=(EditText)findViewById(R.id.edtDescripcionMaquia);
		EdtSubcontratista=(EditText)findViewById(R.id.edtTemperaturaPromedio);
		EdtCodigoMaquia=(EditText)findViewById(R.id.edtCodicoMaquina);
		EdtN_Recibo=(EditText)findViewById(R.id.edtNRecibo);
		EdtUnidadMedida=(EditText)findViewById(R.id.edtUnidadMedida);
		EdtCantidad=(EditText)findViewById(R.id.edtCantidad);
		EdtAbscisaTrabajoInicial=(EditText)findViewById(R.id.edtAbscisaTrabajoInicial);
		EdtAbscisaTrabajoFinal=(EditText)findViewById(R.id.edtAbscisaTrabajoFinal);
		EdtActividadRealizada=(EditText)findViewById(R.id.edtActividadRealizada);
		EdtObservaciones=(EditText)findViewById(R.id.edtObservaciones);
		
		
		btnGuardar=(Button)findViewById(R.id.btnGuardar);			
		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {					
				//Capturamos los datos del formulario
				capturarDatos();				
//				
				Activity myActivity=ClasMaquinaria.this;
            	ControladoInserciones.mensaje_confirmarAlmacenarMaq(contexto, controlDatos, myActivity);
			}
		});
	}

	public void capturarDatos()
	{
//		Creamos la estructura para manejar la informacion;
//		Los datos de la fecha se agregan directamente al invocar la clase
		controlDatos=new EstrucMaquinaria();
		
		controlDatos.setHito(EdtHito.getText().toString());
		controlDatos.setSubcontratista(EdtSubcontratista.getText().toString());
		controlDatos.setDescripcionMaquinaria(EdtDescripcionMaquin.getText().toString());
		controlDatos.setCodigoDeMaquina(EdtCodigoMaquia.getText().toString());
		controlDatos.setN_Recibo(EdtN_Recibo.getText().toString());
		controlDatos.setUnidadMedida(EdtUnidadMedida.getText().toString());
		controlDatos.setCantidad(EdtCantidad.getText().toString());
		controlDatos.setAbscisaTrabajoInicial(EdtAbscisaTrabajoInicial.getText().toString());
		controlDatos.setAbscisaTrabajoFinal(EdtAbscisaTrabajoFinal.getText().toString());
		controlDatos.setActividadRealizada(EdtActividadRealizada.getText().toString());
		controlDatos.setObservaciones(EdtObservaciones.getText().toString());
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clas_maquinaria, menu);
		return true;
	}

}
