package com.Mapas;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.controlobrahito.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class ClassLatitutLongitud extends FragmentActivity{

	GoogleMap MapaView;
	
	public void inicializarLAtLog()
	{				
		MapaView=((SupportMapFragment) getSupportFragmentManager()
				   .findFragmentById(R.id.mapINI)).getMap();
		MapaView.setMyLocationEnabled(true);
		capturarMyUbicacion(MapaView);	
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
	
}
