package com.android.BrickBreaker;

import com.android.BrickBreaker.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Ball {
    private float x, y;
    
    private int speedX, speedY;
    
    public static int initSpeedX = 4;
    public static int initSpeedY = -4;
    
    private Bitmap bitmap;
    
    private boolean isMoving = false;
    
    public Ball(Resources res, int initX, int initY) {
        bitmap = BitmapFactory.decodeResource(res, R.drawable.top);
        x = initX;
        y = initY;
        speedX = initSpeedX;
        speedY = initSpeedY;
    }
    
    public void doDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }
    
    public void animate(long passedTime) {
       	x += speedX * (passedTime / 15f);
       	y += speedY * (passedTime / 15f);
       	hitPageBorder();
    }

    private void hitPageBorder() {
        if (x <= 0) {
            speedX = -speedX;
            x = 0;
        } else if (x + bitmap.getWidth() >= GameView.width) {
            speedX = -speedX;
            x = GameView.width - bitmap.getWidth();
        }

        if (y <= 0) {
            speedY = -speedY;
            y = 0;
        }
    }
    
    public int getSpeedX() {
    	return speedX;
    }

    public int getSpeedY() {
    	return speedY;
    }
    
    public float setSpeedX(int newSpeed) {
    	speedX = newSpeed;
    return speedX;
    }

    public float setSpeedY(int newSpeed) {
    	speedY = newSpeed;
    return speedY;
    }

    public float getX() {
    	return x;
    }
    
    public float getY() {
    	return y;
    }
    
    public void setX(float newX) {
    	x = newX;
    }
    
    public void setY(float newY) {
    	y = newY;
    }
    
    public int getWidth() {
    	return bitmap.getWidth();
    }

    public int getHeight() {
    	return bitmap.getHeight();
    }
    
    public void stop() {
    	isMoving = false;
    }

    public void start() {
    	isMoving = true;
    }
    
    public boolean isMovin() {
    	return isMoving;
    }
}
