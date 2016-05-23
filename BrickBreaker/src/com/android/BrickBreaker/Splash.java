package com.android.BrickBreaker;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import android.graphics.drawable.AnimationDrawable;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class Splash extends Activity {

	MediaPlayer myPlayer;
	ImageButton imageButton;
	ImageButton startButton;
	ImageButton selectButton;
	ImageButton exitButton;
	private int clicked=0;
	private static int SELECT_IMAGE = 1;
	
	@Override
	protected void onCreate(Bundle multimediacourse) {
		// TODO Auto-generated method stub
		super.onCreate(multimediacourse);
		// Keep the Device Screen ON
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	    // Make Activity FullScreen    
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
	
		// Background music for Splash Screen
		myPlayer=MediaPlayer.create(Splash.this, R.raw.music);
		myPlayer.start();
		myPlayer.setLooping(true);
		
		// Animation 
		// Load the ImageView that will host the animation and
        ImageView Img = (ImageView) findViewById(R.id.background);
 
        // set its background to our AnimationDrawable XML resource.
        Img.setBackgroundResource(R.layout.anim);
        AnimationDrawable frameAnimation = (AnimationDrawable) Img.getBackground();
 
        // Start the animation (looped PlayBack by default).
        frameAnimation.start();
		
		// End of Animation
        
        // MUTE BUTTON
        imageButton = (ImageButton) findViewById(R.id.imageButton1);
        imageButton.bringToFront();
		imageButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
		        
			   if(clicked==1){
				   AudioManager aManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
				   aManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
				   Toast.makeText(Splash.this,"Music is ON!", Toast.LENGTH_SHORT).show();
				   imageButton.setImageResource(R.drawable.unmute);
				   clicked=0;
			   }
			   else{
				   AudioManager aManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
				   aManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
				   Toast.makeText(Splash.this,"Music is OFF!", Toast.LENGTH_SHORT).show();
				   imageButton.setImageResource(R.drawable.mute);
				   clicked=1;
						   
			   }
			   
			   }
			   
			   
 
		});
        
		// QUICK START BUTTON
		startButton = (ImageButton) findViewById(R.id.button1);
        startButton.bringToFront();
		startButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				startButton.setImageResource(R.drawable.quick2);
				Intent intent= new Intent("com.android.BrickBreaker.main");
				
	            startActivity(intent);
	            myPlayer.release();
	            }
	    });
	    
	    
	    // SELECT BACKGROUND IMAGE BUTTON
		selectButton = (ImageButton) findViewById(R.id.button2);
        selectButton.bringToFront();
		selectButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	selectButton.setImageResource(R.drawable.select2);
            	 Toast.makeText(Splash.this,"Please Select 'Low or Medium Quality' Images", Toast.LENGTH_LONG).show();
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                 
                startActivityForResult(i, SELECT_IMAGE); 

            }
        });
	    
	
	// EXIT GAME BUTTON
			exitButton = (ImageButton) findViewById(R.id.exitButton);
	        exitButton.bringToFront();
			exitButton.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View arg0) {
	            	exitButton.setImageResource(R.drawable.exit2);
	                Toast.makeText(Splash.this,"Credits: Berk SOYSAL, Aditi ARYA", Toast.LENGTH_LONG).show();
	                
	                Thread timer = new Thread(){
	   		    	 public void run(){
	   		    		try{
	   		    			sleep(2200);
	   		    		} catch (InterruptedException e){
	   		    			e.printStackTrace();
	   		    	           } finally{
	   		    			
	   		    	        	   System.exit(0);
	   		    	                    }
	   		    	
	   		    	                   }
	   		    	
	   		                                  };
	   		                                        timer.start();
	                
	                                          }
												        });
													    }
	
	
	
	
	protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
		    super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

		    if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK && null != imageReturnedIntent) {
		        
		    	
		    	// SCANNING IMAGE FROM GALLERY, INITIATING MAIN ACTIVITY WITH IMAGE DATA
		            Uri selectedImage = imageReturnedIntent.getData();
		            String[] filePathColumn = {MediaStore.Images.Media.DATA};

		            Cursor cursor = getContentResolver().query(
		                               selectedImage, filePathColumn, null, null, null);
		            cursor.moveToFirst();

		            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		            String imagePath = cursor.getString(columnIndex);
		            cursor.close();


		            Intent intent = new Intent(this, Main.class);
		            intent.putExtra("path", imagePath);
		            startActivity(intent);
		            myPlayer.release();
		        }
		    }
		

@Override
protected void onPause() {
	// TODO Auto-generated method stub
		super.onPause();
		myPlayer.release();
		startButton.setImageResource(R.drawable.quick);
		selectButton.setImageResource(R.drawable.select);	
	}
}
