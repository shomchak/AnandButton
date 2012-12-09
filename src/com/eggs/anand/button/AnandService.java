package com.eggs.anand.button;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class AnandService extends Service {
    public AnandService() {
    }
    
    MediaPlayer mp;
//    MediaPlayer mp = MediaPlayer.create(this, R.raw.anand_noise);
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

	@Override
	public void onCreate() {
		Log.d("anand service", "about to make mediaplayer", null);
		mp = MediaPlayer.create(this, R.raw.anand_noise);
		Log.d("anand service", "made the player i think!", null);
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		mp.reset();
		mp.release();
		super.onDestroy();
	}
	
	

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("anand service", "got into onStartCommand", null);
		
		if(intent.hasExtra("Anand")) {
			System.out.println("has extra 'anand'");
			if(intent.getStringExtra("Anand").equals("Badri")) {
				System.out.println("has value 'badri'");
				MainActivity.playAnandSound(mp);
		    	Toast toast = Toast.makeText(getApplicationContext(), "You suffer Anand!", 1);
		    	toast.show();
			}
		}
		
//		if(mp.isPlaying()) {
//			mp.seekTo(0);
//		}
//		mp.start();
		
		return super.onStartCommand(intent, flags, startId);
	}
    
    
}
