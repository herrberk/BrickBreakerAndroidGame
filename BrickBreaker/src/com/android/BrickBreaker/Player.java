package com.android.BrickBreaker;

import com.android.BrickBreaker.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Player {

    private float x, y;

    private float height;
    private float width;

    private Bitmap bitmap;

    private boolean isAlive;
    private int remaininglives;
    
    public Player(Resources res) {
        bitmap = BitmapFactory.decodeResource(res, R.drawable.paddle);
        height = bitmap.getHeight();
        width = bitmap.getWidth();
        x = (GameView.width / 2) - (width / 2);
        y = GameView.height - 50;
        
        isAlive= true;
        remaininglives = 3;
    }
    
    public void doDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }

    public void animate(int orientation) {
    	if (orientation < 0) {
    		x=x-14;
    	}
    	else if (orientation > 0) {
    		x=x+14;
    	}
    	if (x < 0) {
    		x = 0;
    	}
    	if (x + width > GameView.width) {
    		x = GameView.width - width;
    	}
    		
    }
    
    public void loseOneLife() {
    	if (remaininglives-- == 1) {
    		gameOver();
    	}
        x = (GameView.width / 2) - (width / 2);
        y = GameView.height - 50;
    }

    public boolean isAlive() {
    	return isAlive;
    }

    public void gameOver() {
    	isAlive = false;
    }
    
    public int getRemainingLives() {
    	return remaininglives;
    }
    
    public float getWidth(){
    	return width;
    }
    
    public float level2(Resources res, Canvas canvas){
    	bitmap = BitmapFactory.decodeResource(res, R.drawable.paddle2);
    	canvas.drawBitmap(bitmap, x, y, null);
    	width = bitmap.getWidth();
    
        return width;
    }
    public float level3(Resources res, Canvas canvas){
    	bitmap = BitmapFactory.decodeResource(res, R.drawable.paddle3);
    	canvas.drawBitmap(bitmap, x, y, null);
    	width = bitmap.getWidth();
    
        return width;
    }
    public float level5(Resources res, Canvas canvas){
    	bitmap = BitmapFactory.decodeResource(res, R.drawable.paddle4);
    	canvas.drawBitmap(bitmap, x, y, null);
    	width = bitmap.getWidth();
    
        return width;
    }

    public float getHeight(){
    	return height;
    }

    public float getX() {
    	return x;
    }
    
    public float getY() {
    	return y;
    }

}
