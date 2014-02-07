package clases_eventos;

import camara.CapturarImagen;
import clases_estructuras.EstrucConcretos;
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

public class ClasConcreto extends Activity {

	
//Controlador de la opciones del menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.menu_camara:
			Intent i =new Intent(this, CapturarImagen.class);
			i.putExtra(MainPrincipal.TIPO_FORMULARIO, MainPrincipal.CONCRETO);
			startActivity(i);			
			break;						
			
		default:
			break;
		}				
		return super.onOptionsItemSelected(item);		
	}
	//Fin del controlador del menu
	
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clas_concreto, menu);
		return true;
	}

}
