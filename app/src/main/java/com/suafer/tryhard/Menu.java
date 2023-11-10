package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Menu extends AppCompatActivity {

    private double level;
    private int hardlevel;

    private double info;

    private MediaPlayer mediaPlayer;

    Intent i = new Intent();
    private static final Timer _timer = new Timer();
    private SharedPreferences SaveLevel;
    private SharedPreferences SaveInfo;
    private SharedPreferences SaveHardlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black));

        SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if (SaveInfo.getString("info", "").equals("")) {
            i.setClass(getApplicationContext(), ShowHelp.class);
            startActivity(i);
            finish();
        }
        info = Double.parseDouble(SaveInfo.getString("info", ""));

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        if (SaveLevel.getString("level", "").equals("")) {
            SaveLevel.edit().putString("level", "1").apply();
        }
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SaveHardlevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        if (SaveHardlevel.getString("hardlevel", "").equals("")) {
            SaveHardlevel.edit().putString("hardlevel", "0").apply();
        }
        hardlevel = Integer.parseInt((SaveHardlevel.getString("hardlevel", "")));

        mediaPlayer = MediaPlayer.create(this, R.raw.maintheme_01);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);



        TextView texttry = findViewById(R.id.texttry);
        TextView texthard = findViewById(R.id.texthard);
        TextView cursor1 = findViewById(R.id.cursor1);
        TextView cursor2 = findViewById(R.id.cursor2);
        TextView continietext = findViewById(R.id.continietext);
        TextView alllevelstext = findViewById(R.id.alllevelstext);


        final int[] k = {0};
        String[] word = {"T","R","Y","H","A","R","D"};

        continietext.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), startLevel(level));
            mediaPlayer.stop();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        alllevelstext.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), LevelMenu.class);
            mediaPlayer.stop();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            SaveHardlevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
            startActivity(i);
            finish();
        });



        CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, 600) {
            public void onTick(long millisUntilFinished) {
                if(cursor1.getCurrentTextColor() == Color.BLACK){
                    cursor1.setTextColor(Color.WHITE);
                }else{
                    cursor1.setTextColor(Color.BLACK);
                }
            }
            public void onFinish() {}
        }.start();

        new CountDownTimer(1050, 350) {
            public void onTick(long millisUntilFinished) {
                texttry.setText(texttry.getText()+word[k[0]]);
                k[0]++;
            }
            public void onFinish() {
                timer.cancel();
                cursor1.setTextColor(Color.BLACK);
                cursor2.setTextColor(Color.WHITE);
                new CountDownTimer(Long.MAX_VALUE, 600) {
                    public void onTick(long millisUntilFinished) {
                        if(cursor2.getCurrentTextColor() == Color.BLACK){
                            cursor2.setTextColor(Color.WHITE);
                        }else{
                            cursor2.setTextColor(Color.BLACK);
                        }
                    }
                    public void onFinish() {}
                }.start();
                new CountDownTimer(1400, 350) {
                    public void onTick(long millisUntilFinished) {
                        texthard.setText(texthard.getText()+word[k[0]]);
                        k[0]++;
                    }
                    public void onFinish() {setRedTest(texthard);}
                }.start();
            }
        }.start();
    }

    private Class<?> startLevel(double level){
        if(level==1){return Level1.class;}
        if(level==2){return Level2.class;}
        if(level==3){return Level3.class;}
        if(level==4){return Level4.class;}
        if(level==5){return Level5.class;}
        if(level==6){return Level6.class;}
        if(level==7){return Level7.class;}
        if(level==8){return Level8.class;}
        if(level==9){return Level9.class;}
        if(level==10){return Level10.class;}
        if(level==11){return Level11.class;}
        if(level==12){return Level12.class;}
        return Level1.class;
    }

    private void setRedTest(TextView textview5){
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textview5.setTextColor(0xFFFFEBEE));
            }
        };
        _timer.schedule(t, (int) (50));
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textview5.setTextColor(0xFFFFCDD2));
            }
        };
        _timer.schedule(t, (int) (100));
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textview5.setTextColor(0xFFEF9A9A));
            }
        };
        _timer.schedule(t, (int) (150));
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textview5.setTextColor(0xFFE57373));
            }
        };
        _timer.schedule(t, (int) (200));
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textview5.setTextColor(0xFFEF5350));
            }
        };
        _timer.schedule(t, (int) (250));
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textview5.setTextColor(0xFFEF5350));
            }
        };
        _timer.schedule(t, (int) (300));
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textview5.setTextColor(0xFFF44336));
            }
        };
        _timer.schedule(t, (int) (350));
    }

    @Override
    public void onPause(){
        super.onPause();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if(!mediaPlayer.isPlaying()) {

            mediaPlayer = MediaPlayer.create(this, R.raw.maintheme_01);

            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

    }



    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
        SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
    }
}