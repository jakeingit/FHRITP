package com.example.fhritp_man;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jakegosskuehn.fhritp_man.R;

public class MainActivity extends Activity {
    
 
    
    private SoundPool soundPool;  
    boolean loaded = false;
    boolean songloaded = false;
    private int _fkritp_sound;

 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
                  
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.toptext);
//        view.setOnTouchListener(this);
 //uncomment these lines below so it will HONK with text... nut will not HONK with noise.. fuck
        // addListenerOnButton();
        // Set the hardware buttons to control the music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                    int status) {
                loaded = true;
//                Toast.makeText(MainActivity.this,
//                        "FULLY LOADED TO HONK!!!", Toast.LENGTH_SHORT).show();
            }
        });
        
        _fkritp_sound = soundPool.load(this, R.raw.fhritp_sound, 1);

        
        
        Toast.makeText(MainActivity.this,
                "Wisdom for the ages", Toast.LENGTH_SHORT).show();
    }
    
    public void amazinghonks(View view)
    {
//        MediaPlayer mp = MediaPlayer.create(this, R.raw.bikehorn);
//        mp.start();
        
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        
       
        
        boolean uno = (loaded);

        //plays if it is loaded
        if(uno)
        {
            soundPool.play(_fkritp_sound, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played sound1");
        }         
    }
 //AWESOME RANDOMIZATION CODE
    double phi = 1.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911374847540880753868917521266338622235369317931800607667263544333890865959395829056383226613199282902678806752087668925017116962070322210432162695486262963136144381497587012203408058879544547492461856953648644492410443207713449470495658467885098743394422125448770664780915884607499887124007652170575179788341662562494075890697040002812104276217711177780531531714101;
    String phistring = String.valueOf(phi);
    int currentadjustable = 1;
    
    public int phiRandom()
    {
        int currentspittable = 0;
        double currentWodentime = (Time.SECOND) + (Time.MINUTE) + (Time.HOUR) + Time.WEDNESDAY; // should take current time
        int currenttimevalue = (int)currentWodentime%10;
        
        
        String startedphistring = phistring;
        char currentdigit = startedphistring.charAt(currentadjustable);
        currentadjustable++;
        
        currentspittable = ((currenttimevalue) * ((int)currentdigit) )%10;
        
        
        
        return currentspittable;
    }


 
}