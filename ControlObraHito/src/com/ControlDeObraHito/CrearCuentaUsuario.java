package com.ControlDeObraHito;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ClasesEstaticas.URL_conexiones;
import com.ClasesEstructuras.Usuario;
import com.ConexionesWeb.ServiceHandler;
import com.controlobrahito.R;
import com.controlobrahito.R.id;
import com.controlobrahito.R.layout;
import com.controlobrahito.R.menu;
import com.google.gson.Gson;

public class CrearCuentaUsuario extends Activity {

	
	Button btnAgregarUsuario;
	EditText edtNombre, edtCedula, edtPass, edtPerfil;
	
	Usuario usuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crear_cuenta_usuario);
		
		btnAgregarUsuario=(Button)findViewById(R.id.btnAddUser);
		
		edtNombre=(EditText)findViewById(R.id.edtCuentaNombre);
		edtCedula=(EditText)findViewById(R.id.edtCuentaCedula);
		edtPass=(EditText)findViewById(R.id.edtCuentaContrasena);
		edtPerfil=(EditText)findViewById(R.id.edtCuentaPerfil);
		
		usuario=new Usuario();
		
		
		btnAgregarUsuario.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {								
				capturarTextosPantalla();
				
//				String paqueteEnviarJson=
//				"{"+
//				"\"idUser\":\"14\","+
//				"\"nomUser\":\"ceda\","+
//				"\"passUser\":\"pass\","+
//				"\"nombre\":\"iluminate\","+
//				"\"perfil\":\"dev\","+
//				"\"fechaIngresoSitema\":\"2014-2-4\","+
//				"\"fechaSalidaSistema\":\"\""+
//				"}";
				
				
				Gson gson=new Gson();
				String packJson=gson.toJson(usuario);
				Log.e("JSON-USER",packJson);
				new enviarJSONUsuario().execute(packJson);
			}
		});
		
	}
	
	private void capturarTextosPantalla()
	{
		
		usuario.setNombre(edtNombre.getText().toString());
		usuario.setCedula(edtCedula.getText().toString());
		usuario.setContraseña(edtPass.getText().toString());
		usuario.setPerfil(edtPerfil.getText().toString());
	}

	
	
	public  class enviarJSONUsuario extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... packJson) {
        	 ServiceHandler sh = new ServiceHandler();
        	
        	String json=sh.makeServicePostJSON(URL_conexiones.INSERTAR_USUARIO, packJson[0]);
        	return json;
        }
        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String result) {        	
        	Log.e("ENVIAR-JSONUSER-INSERT",result);    
        	if(result.equals("true"))
        	{
        		finish();
        	}
        	else{mostrarMensajeFallo("No se pudo agregar este usuario");}
        }
    }
	
	private void mostrarMensajeFallo(String msn)
	{
		Toast.makeText(this, msn, Toast.LENGTH_LONG).show();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crear_cuenta_usuario, menu);
		return true;
	}

}
