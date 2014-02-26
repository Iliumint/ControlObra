package com.Galeria;

import java.io.File;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Métodos copiados de http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
 * para reescalar imágenes
 */


//Esta clase me pertmite trabajar con los bitmaps, estan los metodos para trabajarlos
//tanto en metodo int resources, como en Files SdCard
public abstract class BitmapUtilsFile 
{
	
	//Metodos para trabajar int, resources
	//*************************************************************************************
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        // Calculate ratios of height and width to requested height and width
        final int heightRatio = Math.round((float) height / (float) reqHeight);
        final int widthRatio = Math.round((float) width / (float) reqWidth);

        // Choose the smallest ratio as inSampleSize value, this will guarantee
        // a final image with both dimensions larger than or equal to the
        // requested height and width.
        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
    }

    return inSampleSize;
	}
	
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
	//*************************************************************************************
	
	
	//Metodos para trabajar con Files
	//*************************************************************************************
	 public static Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) 
	    {
	        Bitmap bm = null;
	        
	        // First decode with inJustDecodeBounds=true to check dimensions
	        final BitmapFactory.Options options = new BitmapFactory.Options();
	        options.inJustDecodeBounds = true;
	        BitmapFactory.decodeFile(path, options);
	        
	     // Calculate inSampleSize
	        options.inSampleSize = calculateInSampleSizeFile(options, reqWidth, reqHeight);
	        
	        // Decode bitmap with inSampleSize set
	        options.inJustDecodeBounds = false;
	        bm = BitmapFactory.decodeFile(path, options); 
	        return bm;  
	    }
	    
	    public static int calculateInSampleSizeFile(BitmapFactory.Options options, int reqWidth, int reqHeight)
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
	
}
