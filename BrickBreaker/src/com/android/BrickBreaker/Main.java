package com.android.BrickBreaker;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class Main extends Activity implements OnClickListener {
	 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String image_path = getIntent().getStringExtra("path");
           
        ImageView image= new ImageView(this);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        
        Bitmap bitmap = BitmapFactory.decodeFile(image_path,options);
        image.setImageBitmap(bitmap);

        
        if(bitmap==null){
        	image.setImageResource(R.drawable.wp2);
        }
        

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        FrameLayout game = new FrameLayout(this);
        GameView gameView = new GameView (this);
        LinearLayout gameWidgets = new LinearLayout (this);
        RelativeLayout imgLayout = new RelativeLayout(this);

        imgLayout.addView(image);
        gameView.setZOrderOnTop(true);
        
        gameView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        
        game.addView(imgLayout);
        game.addView(gameView);
        game.addView(gameWidgets);
        setContentView(game);        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
  
    }

    public void onClick(View v) {
         Intent intent = new Intent(this, Main.class);
         startActivity(intent);
        
        
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}
  
}
    
