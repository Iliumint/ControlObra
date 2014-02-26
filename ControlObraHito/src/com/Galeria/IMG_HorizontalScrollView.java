package com.Galeria;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Gallery.LayoutParams;


public class IMG_HorizontalScrollView {
	
	
	public static void setTitulos2(String titulos2) {
		IMG_HorizontalScrollView.titulos2 = titulos2;
	}

	public static void setMygaller2(LinearLayout mygaller2) {
		IMG_HorizontalScrollView.mygaller2 = mygaller2;
	}

	public static void setPantalla_peque(boolean pantalla_peque) {
		IMG_HorizontalScrollView.pantalla_peque = pantalla_peque;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	public static void setDel(boolean del) {
		IMG_HorizontalScrollView.del = del;
	}

	public void setContexto_class(Context contexto_class) {
		this.contexto_class = contexto_class;
	}

	static Context contexto_class;	
	static boolean del=false;
	static List<String> mane=new ArrayList<String>();
	static int ID=0;
	static boolean pantalla_peque=false;	

	
	public static View insertPhoto(String path)
    {	
		//ajusta las imagenes al tamaño de la pantalla
		
		int parametros=100;
		if(pantalla_peque)
		{
			parametros=330;
		}
		else
		{
			parametros=500;
		}
		
        Bitmap bm = decodeSampledBitmapFromUri(path, 220, 220);//Se define los parametros de la imagen para su creacion
        
        LinearLayout layout = new LinearLayout(contexto_class);
        layout.setLayoutParams(new LayoutParams(parametros, parametros));//Parametros del layour
        layout.setGravity(Gravity.CENTER);
        
        ImageView imageView = new ImageView(contexto_class);
        imageView.setLayoutParams(new LayoutParams(parametros-20, parametros-20));//Parametros dela Image View
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bm);
        
        imageView.setId(ID);
        mane.add(path);        
        ID++;
        
        imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(del)
				{					
//					mostrar_TXT("Imagen N: "+arg0.getId());				
//					mostrar_TXT(mane.get(arg0.getId()));					
//					plantilla_eliminar_IMG(arg0);				
					
				}
			}
		});
        
        layout.addView(imageView);
        return layout;
     }
    
    public static Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) 
    {
        Bitmap bm = null;
        
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        
     // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options); 
        return bm;  
    }
    
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)
    {
   	     // Raw height and width of image
   	     final int height = options.outHeight;
   	     final int width = options.outWidth;
   	     int inSampleSize = 1;
   	        
   	     if (height > reqHeight || width > reqWidth) {
   	      if (width > height) {
   	       inSampleSize = Math.round((float)height / (float)reqHeight);   
   	      } else {
   	       inSampleSize = Math.round((float)width / (float)reqWidth);   
   	      }   
   	     }
   	     
   	     return inSampleSize;   
    }
    
    public static void mostrar_TXT(String name)
    {
    	Toast.makeText(contexto_class, name, Toast.LENGTH_SHORT).show();
    }
    
    public void inicializar_var()
    {
    	mane.clear();
    	ID=0;
    }
    
//    private static void plantilla_eliminar_IMG(final View w)
//    {    	
//    	final Dialog dialogo2=new Dialog(contexto_class);
//		dialogo2.setContentView(R.layout.plantilla_eliminarimagen);
//		dialogo2.setTitle("Eliminar Imagen");																		
//		
//		Button btnAcep=(Button)dialogo2.findViewById(R.id.btnSesionOK);
//		btnAcep.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {			
//
//				try
//				{
//				eliminar_IMG(mane.get(w.getId()));	
//				recargar_imagenes_dialog();
//				}
//				catch(Exception e)
//				{
//					mostrar_TXT("no se pudo eliminar el archivo: "
//							+mane.get(w.getId()));					
//				}
////				mostrar_TXT("no se pudo eliminar el archivo: ");
////				+mane.get(v.getId()));
//				dialogo2.dismiss();
//			}
//		});
//		
//		Button BTNcAN=(Button)dialogo2.findViewById(R.id.btnSesionCANCEL);
//		
//		BTNcAN.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {			
//				dialogo2.dismiss();
//			}
//		});
//		dialogo2.show();		
//		
//    }
    
    static public void eliminar_IMG(String selectedFilePath)
    {
    	File file = new File(selectedFilePath);
    	boolean deleted = file.delete();
    	if(deleted)
    	{mostrar_TXT("La imagen se eliminó satisfactoriamente");}
    }
    
    static String titulos2;
    static LinearLayout mygaller2=null;
    
    public static void recargar_imagenes_dialog()
	 {
		 try
			{
			mygaller2.removeAllViews();
			String ExternalStorageDirectoryPath = Environment
			        .getExternalStorageDirectory()
			        .getAbsolutePath();
			String direccion=titulos2;
//			Direccion de donde se encuentra el paquete con las imagenes
			String targetPath = ExternalStorageDirectoryPath + "/MyPriDB/"+direccion+"/";
//			Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
	        File targetDirector = new File(targetPath);	        
	        File[] files = targetDirector.listFiles();	        
	        for (File file : files){
	        	mygaller2.addView(insertPhoto(file.getAbsolutePath()));
	        }
			}
	        catch (Exception e) {
	        	mostrar_TXT("No se encontraron Imagenes");
			}
	 }
}
