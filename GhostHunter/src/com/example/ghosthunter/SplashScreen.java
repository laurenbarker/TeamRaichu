package com.example.ghosthunter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {
	MediaPlayer splashSound;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen_layout);	
		splashSound = MediaPlayer.create(SplashScreen.this, R.raw.splash_sound);
		splashSound.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}finally {
					Intent openMainActivity = new Intent("android.intent.action.MAINACTIVITY");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		splashSound.release();
		finish();
	}
}
