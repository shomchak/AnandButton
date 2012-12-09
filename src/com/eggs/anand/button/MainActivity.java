package com.eggs.anand.button;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;


@SuppressWarnings("unused")
public class MainActivity extends Activity {

	MediaPlayer mp;
	ImageView background;	
	Map<String,String> favorites = new HashMap<String,String>();

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.anand_noise);
        background = (ImageView) findViewById(R.id.background);
        background.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		playAnandSound(mp);
        	}
        });
        favorites.put("B", "19496486030");
        favorites.put("Dicks", "19492019903");
        favorites.put("Scott Clark", "15033474589");
        favorites.put("Eggs", "19254135293");
    }
    
    public void makeToast(MenuItem item) {
    	Toast toast = Toast.makeText(getApplicationContext(), item.getTitle().toString() + " suffers Anand!", 1);
    	toast.show();
    }
    
    public void showPopup(View v) {
    	PopupMenu remotes = new PopupMenu(this,v);
    	MenuInflater inflater = remotes.getMenuInflater();
    	inflater.inflate(R.menu.favorites, remotes.getMenu());
    	remotes.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
    		@Override
    		public boolean onMenuItemClick(MenuItem item) {
				makeToast(item);
    			playAnandSound(mp);
    			return false;
    		}
    	});
    	remotes.show();
    }
    
    @Override
	protected void onStop() {
		mp.release();
		super.onStop();
	}
    
    

	@Override
	protected void onDestroy() {
		mp.release();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		mp.release();
		super.onPause();
	}

	@Override
	protected void onRestart() {
		mp = MediaPlayer.create(this, R.raw.anand_noise);
		super.onRestart();
	}

	@Override
	protected void onResume() {
		mp = MediaPlayer.create(this, R.raw.anand_noise);
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	
	public static void playAnandSound(MediaPlayer mp) {
		if(mp.isPlaying()) {
			mp.seekTo(0);
		}
		mp.start();
	}
    
}
