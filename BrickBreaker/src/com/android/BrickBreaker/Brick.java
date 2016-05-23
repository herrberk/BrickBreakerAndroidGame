package com.android.BrickBreaker;

import com.android.BrickBreaker.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Contains all the necessary  information for a brick/ draws it onto the canvas.
 * @author Berk
 */
public class Brick {
    private float x, y;
    
    private static float height = 0;
    private static float width = 0;
    
    private boolean alive;
    
    private Bitmap bitmap;
    
    Brick(Resources res, int ilkX, int ilkY) {
    	    
        bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla);
    	
    	x = ilkX;
        y = ilkY;
        alive = true;
    }
    
    void doDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, new Rect((int)x, (int)y, (int)(x+width), (int)(y+height)), null);
    }
    
    void hit() {
    	alive = false;
    }

    boolean isAlive() {
    	return alive;
    }

    static void setWidth(float widths){
    	width = widths;
    }
    void setLevel(Resources res, int level){
    	    if (level==2)
        	bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla2);
        	else if (level==3)
            bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla3);
        	else if (level==4)
            bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla4);
        	else if (level==5)
            bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla5);
            			
    }
   static void setHeight(float heights){
    	height = heights;
    }
    
    static float getWidth(){
    	return width;
    }

    static float getHeight(){
    	return height;
    }

    float getX() {
    	return x;
    }
    
    float getY() {
    	return y;
    }
}
