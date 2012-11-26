package com.eggs.anand.button;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


@SuppressWarnings("unused")
public class MainActivity extends Activity {

	MediaPlayer mp;
	ImageView background;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mp = MediaPlayer.create(this, R.raw.anand_noise);
        
        background = (ImageView) findViewById(R.id.background);
        background.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		if(mp.isPlaying()) {
        			mp.seekTo(0);
        		}
        		mp.start();
        	}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
