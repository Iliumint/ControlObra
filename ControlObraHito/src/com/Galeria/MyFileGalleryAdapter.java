package com.Galeria;

import java.io.File;

import com.controlobrahito.R;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyFileGalleryAdapter extends BaseAdapter{
	
		//Esta es la clase encargada de convertir y posicionar las imagenes para poder
		//trabajar con el adapter, llegan File y salen Bitmap
	
	
	 	Context context;
	    File[] imagenes;
	    int background;
	    //guardamos las imágenes reescaladas para mejorar el rendimiento ya que estas operaciones son costosas
	    //se usa SparseArray siguiendo la recomendación de Android Lint
	    SparseArray<Bitmap> imagenesEscaladas = new SparseArray<Bitmap>(7);
	     
	    public MyFileGalleryAdapter(Context context, File[] imagenes) 
	    {
	        super();
	        this.imagenes = imagenes;
	        this.context = context;
	         
	        //establecemos un marco para las imágenes (estilo por defecto proporcionado)
	        //por android y definido en /values/attr.xml 
	        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.Gallery1);
	        background = typedArray.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 1);
	        typedArray.recycle();
	    }
	 
	    @Override
	    public int getCount() 
	    {
	        return imagenes.length;
	    }
	 
	    @Override
	    public Object getItem(int position) 
	    { 
	        return position;
	    }
	 
	    @Override
	    public long getItemId(int position) 
	    {
	        return position;
	    }
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) 
	    {
	         ImageView imagen = new ImageView(context);
	 
	        //reescalamos la imagen para evitar "java.lang.OutOfMemory" en el caso de imágenes de gran resolución
	         //como es este ejemplo
	         if (imagenesEscaladas.get(position) == null)
	         {
	        	 //Bitmap bitmap = BitmapUtilsFile.decodeSampledBitmapFromResource(context.getResources(), imagenes[position], 120, 0);
	             Bitmap bitmap = BitmapUtilsFile.decodeSampledBitmapFromUri(imagenes[position].getPath(),320,320);
	             imagenesEscaladas.put(position, bitmap);            
	         }
	         imagen.setImageBitmap(imagenesEscaladas.get(position));
	         //se aplica el estilo
	         imagen.setBackgroundResource(background);
	          
	         return imagen;
	    }

}
