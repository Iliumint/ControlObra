package com.Mapas;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

import com.controlobrahito.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class ClassMapas extends FragmentActivity {

	
	GoogleMap MapaView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapas_layout);
		
		MapaView=((SupportMapFragment) getSupportFragmentManager()
				   .findFragmentById(R.id.mapINI)).getMap();
		MapaView.setMyLocationEnabled(true);
		capturarMyUbicacion(MapaView);
		
		//Usamos el mapa de google para capturar la localizacion del dispositivo
		
		
	}

	
	
	
	 public LatLng capturarMyUbicacion(GoogleMap mapa) 
	    { 
		 LatLng coordenadas=null;
	        try { 
	            if(mapa.getMyLocation()!=null)               
	            { 
	                mapa.getMyLocation();
	                coordenadas=new LatLng(mapa.getMyLocation().getLatitude(), mapa.getMyLocation().getLongitude());                	                 
	                Log.e("COORDENADAS","Latitud: "+mapa.getMyLocation().getLatitude()+""); 
	                Log.e("COORDENADAS","Longitud: "+mapa.getMyLocation().getLongitude()+""); 
	                return coordenadas;
	            } 
	            else{Log.e("COORDENADAS","EL parametro es null");} 
		        } 
	        catch (Exception e) { 
		            Log.e("COORDENADAS","Error Capturando Coordenadas - "+e.toString());
		            return coordenadas;
		        }
	        return coordenadas;			
	    } 
	
	
	
// Del manu que se esta usando
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.class_mapas, menu);
		return true;
	}

}
