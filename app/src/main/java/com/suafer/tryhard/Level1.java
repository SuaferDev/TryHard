package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Level1 extends AppCompatActivity {

    private int k=0;

    TextView textinfo, textnext, texttomenu;
    TextView textclosetomenu, textclose;
    TextView levelname, textinfolevel, textinfoclue, buttonclue;


    private double level = 0;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        LinearLayout linear1 = findViewById(R.id.linear1);
        LinearLayout linear2 = findViewById(R.id.linear2);
        LinearLayout linear3 = findViewById(R.id.linear3);
        LinearLayout linear4 = findViewById(R.id.linear4);
        LinearLayout linear5 = findViewById(R.id.linear5);

        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        TextView textlevel = findViewById(R.id.textlevel);
        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Нажмите на клавиши \"пианино\" в правильном порядке.",CustomToast.LENGTH_LONG).show();
        }

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);


        imagehelp.setOnClickListener(view ->{
            createHelp(linear2,linear4);
        });

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        linear1.setOnClickListener(view -> {
            if(k==4){
                linear1.setBackgroundColor(0xFF000000);
                linearnavigation.setBackgroundResource(R.drawable.level_navigation_white_corner);
                textlevel.setTextColor(0xFF000000);
                imageback.setImageResource(R.drawable.back_black);
                imagehelp.setImageResource(R.drawable.help_black);

                createDialog();
            }else{
                clear(linear1,linear2,linear3,linear4,linear5);
                k=0;
            }
        });

        linear2.setOnClickListener(view -> {
            if(k==1){
                linear2.setBackgroundColor(0xFF000000);k++;
            }else{
                clear(linear1,linear2,linear3,linear4,linear5);
                k=0;
            }
        });

        linear3.setOnClickListener(view -> {
            if(k==3){
                linear3.setBackgroundColor(0xFF000000);k++;
            }else{
                clear(linear1,linear2,linear3,linear4,linear5);
                k=0;
            }
        });

        linear4.setOnClickListener(view -> {
            k=1;
            linear4.setBackgroundColor(0xFF000000);
        });

        linear5.setOnClickListener(view -> {
            if(k==2){
                linear5.setBackgroundColor(0xFF000000);k++;
            }else{
                clear(linear1,linear2,linear3,linear4,linear5);
                k=0;
            }
        });
    }

    private void createDialog(){
        Dialog dialog = new Dialog(Level1.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>1){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), Level2.class);
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });
        texttomenu.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), LevelMenu.class);
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });
    }

    private void createHelp(LinearLayout linear2, LinearLayout linear4){
        Dialog dialog = new Dialog(Level1.this);
        dialog.setContentView(R.layout.custom_dialog_help);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        levelname = dialog.findViewById(R.id.levelname);
        textinfolevel = dialog.findViewById(R.id.textinfolevel);
        textinfoclue = dialog.findViewById(R.id.textinfoclue);
        buttonclue = dialog.findViewById(R.id.buttonclue);

        levelname.setText(" Уровень 1 \"Пианино\" ");
        textinfolevel.setText("    Нажмите на клавиши \"пианино\" в правильном порядке.");
        textinfoclue.setText("Подсказка покажет первую правильную \"клавишу\".");
        dialog.show();

        if(linear2.getSolidColor()==0xFF000000){
            buttonclue.setBackgroundColor(R.drawable.use_help_off);
        }
        buttonclue.setOnClickListener(v -> {
            linear4.setBackgroundColor(0xFF000000);k++;
            dialog.dismiss();
        });
    }

    private void clear(LinearLayout l1, LinearLayout l2, LinearLayout l3, LinearLayout l4, LinearLayout l5){
        l1.setBackgroundColor(0xFFFFFFFF);
        l2.setBackgroundColor(0xFFFFFFFF);
        l3.setBackgroundColor(0xFFFFFFFF);
        l4.setBackgroundColor(0xFFFFFFFF);
        l5.setBackgroundColor(0xFFFFFFFF);
    }

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {}

        @Override
        public void onAnimationRepeat(Animation animation) {}

        @Override
        public void onAnimationStart(Animation animation) {}
    };

    private void createExite(){
        Dialog dialog = new Dialog(Level1.this);
        dialog.setContentView(R.layout.custom_dialog_exite);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        textclosetomenu = dialog.findViewById(R.id.textclosetomenu);
        textclose = dialog.findViewById(R.id.textclose);

        dialog.show();
        textclosetomenu.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), LevelMenu.class);
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });
        textclose.setOnClickListener(v -> {
            dialog.dismiss();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        createExite();
    }

    @Override
    public void onStop() {
        super.onStop();
        SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
    }
}