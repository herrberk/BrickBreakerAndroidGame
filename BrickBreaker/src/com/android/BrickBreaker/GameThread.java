package com.android.BrickBreaker;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    private GameView mainScreen;
    private SurfaceHolder surfaceHolder;
    private boolean runStatus = false;
    private long startTime;
    private long passedTime=0;
    public GameThread(GameView screen) {
        mainScreen = screen;
        surfaceHolder = mainScreen.getHolder();
    }
    
    @Override
    public void run() {
        Canvas canvas = null;
        
        while (runStatus) {
        	
        	
            startTime = System.currentTimeMillis();
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
          
                mainScreen.animate(passedTime,canvas);
                mainScreen.doDraw(canvas);
                passedTime = System.currentTimeMillis() - startTime;
                surfaceHolder.unlockCanvasAndPost(canvas);

               }
         }
    }

    public void setRunStatus(boolean newRunStatus) {
        runStatus = newRunStatus;
    }
    
}
