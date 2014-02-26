package com.ControlDeObraHito;

import java.net.URL;

import com.BaseDeDatos.BasedeDatos;
import com.ClasesEstaticas.MensajeBuilDialog;
import com.ClasesEstaticas.URL_conexiones;
import com.ClasesEstaticas.ValoresFijos;
import com.ClasesEstructuras.Usuario;
import com.ConexionesWeb.MetodosParaConexion;
import com.ConexionesWeb.ServiceHandler;
import com.ConexionesWeb.MetodosParaConexion.hacerPeticionJSONUsuario;
import com.controlobrahito.ExampleChartsGoogle;
import com.controlobrahito.R;
import com.google.gson.Gson;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesion extends Activity {
	
	public MensajeBuilDialog MensajeCargando=new MensajeBuilDialog();			
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) 
		{
		case R.id.agregarUsuario:			
			agregarUsuario();
			return true;
			
		case R.id.traerUsuarios:			
			consultarUsuarioLogin();//Buscamos u USsr por ID en la web
			return true;
			
		case R.id.mensaje:			
			//MensajeBuilDialog.mensajeAnimadoCarga(this, "Boton de Prueba", "Mensaje de contenido de prueba", "Aceptar", "Salir");			
			MensajeCargando.mensajeCargando(contexto, "Enviando Datos", "Favor espere hasta que finalice el envío de la información");	
			ProgressDialog msnCargando=(ProgressDialog)MensajeCargando.getObjectView();
//			msnCargando.dismiss();
//			Log.e("PROGRESS-DIALOG","Eliminado");
			return true;
			
			
		case R.id.estadoServidor:			
			//boolean b=ServiceHandler.estadoServidor(URL_conexiones.ESTADO_SERVIDOR);//Buscamos u USsr por ID en la web
			//Log.e("ESTADO-SERVER",String.valueOf(b));
			return true;
			
		case R.id.googleCharts:			
			examplGoogleCharts();
			return true;
			
			
			
		default:
			break;
		}		
		
		return super.onOptionsItemSelected(item);		
	}
	
	
	EditText edtUser, edtPass;
	Button btnAcceder;
	final Context contexto=this;
	
	String ID_SESION=""; //Este ID se va a manejar para ayudar a controcal cada insercion
	String ID_PASS="";
	String RespuestaWeb=""; //Contiene el valor que manda el servidor como respuesta
	String estadoServidortx="false";
	
	//Inicio del Main()
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio_sesion_layout);
		
		edtUser=(EditText)findViewById(R.id.edtUser);
		edtPass=(EditText)findViewById(R.id.edtPass);
		btnAcceder=(Button)findViewById(R.id.btnLogin);
		new peticionEstadoServidor().execute("");
		
		btnAcceder.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				//Capturamos los valores del login
				String user=edtUser.getText().toString();
				String pass=edtPass.getText().toString();
				ID_SESION=user;
				ID_PASS=pass;
				//Log.e("LOGIN","User: "+user);Log.e("LOGIN","Pass: "+pass);
				

				/***********************
				 * Agregamos el encryptado 
				***********************/
				//String textoEncriptado=ValoresFijos.cryptMD5(pass);
				//Log.e("LOGIN","Texto Encriptado: "+textoEncriptado);	
				
				
				//Verificamos si se cuenta con conexion a internet YY verificamos que el servidro este disponible				
				if(ServiceHandler.isInternetAvailable(contexto)
//						&&estadoServidortx.equals("true")
						)					
				{
				verificarAcceso(user,pass);
				}
				//Si no se cuenta con coexion a internet revisa de manera local la base de datos
				else
				{
					boolean validaLocal=BasedeDatos.verificarAccesoLocal(user,pass);
					validarLogin(null, validaLocal);
				}
			}
		});
		
		
	}//Fin del Main()


	
	
	//Hacemos la peticion web para verificar el acceso
	private void verificarAcceso(String user, String pass)
	{				
		Gson gson=new Gson();
		Usuario u=new Usuario();
		u.setCedula(user);
		u.setContraseña(pass);
		String paqueteEnviarJson=gson.toJson(u);
		new verificarLoginAsyncTask().execute(paqueteEnviarJson);			
	}
	
	
	//Si la respuesta es "true" inicia sesion
	private void validarLogin(String respuetaWeb, boolean loginLocal)
	{
		try {
			if(respuetaWeb.equals("true"))			
			{
				//Agregamos el registro de inicio de sesion en la base de datos local
				BasedeDatos dataBase=new BasedeDatos();
				dataBase.INSERTAR_EN_USUARIOS(ID_SESION, ID_PASS);
				IniciarSesion(ID_SESION);
			}
			else{
				//Verificamos si el servidor esta caido o si los datos son correctos
				if(respuetaWeb.equals(ValoresFijos.SERVIDOR_DOWN))
				{
					mostrarMensajeFalloLogin(respuetaWeb);
				}else
				{
					mostrarMensajeFalloLogin("Usuario o Contraseña no validos");
				}
			}
		} catch (Exception e) {
			Log.e("IS-Validad Login:",e.toString());
		}
		
		if(respuetaWeb==(null))
		{
			if(loginLocal)
			{IniciarSesion(ID_SESION);}
			else
			{
				mostrarMensajeFalloLogin("Usuario o Contraseña no validos");
			}
		}
		
	}
	
	//Iniciamos Sesión- Vamos al menu principal
	private void IniciarSesion(String id)
	{
		Intent i=new Intent(this, MainPrincipal.class);
		i.putExtra("ID_SESION", id);
		startActivity(i);
	}
	
	
	//Lanzamos el formulario para crear una cuenta en la web
	private void crearCuentaUsuarioWeb()
	{
		Intent i=new Intent(this, CrearCuentaUsuario.class);		
		startActivity(i);
	}
	
	private void examplGoogleCharts()
	{
		Intent i=new Intent(this, ExampleChartsGoogle.class);		
		startActivity(i);
	}
	
	
	//Verificamos la existencia del usuario y traemos su info en un Json
	private void consultarUsuarioLogin()
	{
		new hacerPeticionJSONUsuario().execute("1");
		Log.e("CONSULTAR-USER-ID",RespuestaWeb);	
		
	}
	
	private void agregarUsuario()
	{
		//Lanzar nuevo activity para agregar un usuario
		crearCuentaUsuarioWeb();

		
		//generamos un paquete Json, este es de prueba
//		String paqueteEnviarJson=
//				"{"+
//				"\"idUser\":\"18\","+
//				"\"nomUser\":\"ceda\","+
//				"\"passUser\":\"pass\","+
//				"\"nombre\":\"iluminate\","+
//				"\"perfil\":\"dev\","+
//				"\"fechaIngresoSitema\":\"2014-2-4\","+
//				"\"fechaSalidaSistema\":\"\""+
//				"}";
//		
//		new MetodosParaConexion.enviarJSONUsuario().execute(paqueteEnviarJson);		
//		new enviarJSONUsuario().execute(paqueteEnviarJson);
	}
	
	
	//*****************************************************************************************************************
	
	public  class hacerPeticionJSONUsuario extends AsyncTask<String, Void, String[]> {
        @Override
        protected String[] doInBackground(String... arg) {
        	 ServiceHandler sh = new ServiceHandler();
        	
        	String[] json={sh.makeServiceCall(URL_conexiones.PEDIR_UN_USUARIO+arg[0], ServiceHandler.GET)};
        	return json;
        }
        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String[] result) {
        	if(result!=null)
			{
        	Log.e("PETICION-WEB-GET-USER",result[0]);
        	RespuestaWeb=result[0];
			}
        	else
        	{RespuestaWeb=ValoresFijos.SERVIDOR_DOWN;}
        }
    }
	
	//*****************************************************************************************************************
	
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
        	Log.e("PETICION-WEB-ENVIAR-JSONUSER",result);	
        	RespuestaWeb=result;
        }
    }
	
	//*****************************************************************************************************************
	
	public  class verificarLoginAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... packJson) {
        	 ServiceHandler sh = new ServiceHandler();
        	
        	String json=sh.makeServicePostJSON(URL_conexiones.VERIFICAR_LOGIN, packJson[0]);
        	return json;
        }
        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String result) {        	
        	Log.e("PETICION-WEB-VERIFICAR-LOGIN",result);        	
        	validarLogin(result, false);
        }
    }
	
	//*****************************************************************************************************************
	
	
	public class peticionEstadoServidor extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url_) {
        	boolean b = ServiceHandler.estadoServidor(URL_conexiones.ESTADO_SERVIDOR);
        	return String.valueOf(b);	        	
        }
        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String result) {   
        	estadoServidortx=result;
        	Log.e("ESTADO-SERVIDOR-SH-POST",estadoServidortx);
        }
    }
	
	
	//*****************************************************************************************************************
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio_sesion, menu);
		return true;
	}
	
	private void mostrarMensajeFalloLogin(String msn)
	{
		Toast.makeText(this, msn, Toast.LENGTH_LONG).show();
	}

}
