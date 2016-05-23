package com.android.BrickBreaker;

import com.android.BrickBreaker.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Brick {
    private float x, y;
    
    private static float height = 0;
    private static float width = 0;
    
    private boolean alive;
    
    private Bitmap bitmap;
    
    public Brick(Resources res, int ilkX, int ilkY) {
    	
    
        bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla);
    	
    	x = ilkX;
        y = ilkY;
        alive = true;
    }
    
   
    
    public void doDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, new Rect((int)x, (int)y, (int)(x+width), (int)(y+height)), null);
    }
    
    public void hit() {
    	alive = false;
    }

    public boolean isAlive() {
    	return alive;
    }

    public static void setWidth(float widths){
    	width = widths;
    }
    public void setLevel(Resources res, int level){
    	    if (level==2)
        	bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla2);
        	else if (level==3)
            bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla3);
        	else if (level==4)
            bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla4);
        	else if (level==5)
            bitmap = BitmapFactory.decodeResource(res, R.drawable.tugla5);
            			
    }
    public static void setHeight(float heights){
    	height = heights;
    }
    
    public static float getWidth(){
    	return width;
    }

    public static float getHeight(){
    	return height;
    }

    public float getX() {
    	return x;
    }
    
    public float getY() {
    	return y;
    }
}
