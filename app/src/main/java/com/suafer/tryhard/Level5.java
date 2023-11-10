package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

public class Level5 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private double level = 0;
    private double k = 0;
    private float x = 0;
    private float y = 0;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);

        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        ImageView imageAim = findViewById(R.id.imageAim);
        ImageView imageObject = findViewById(R.id.imageObject);
        ImageView imageLeft = findViewById(R.id.imageLeft);
        ImageView imageRight = findViewById(R.id.imageRight);
        ImageView imageDown = findViewById(R.id.imageDown);
        ImageView imageUp = findViewById(R.id.imageUp);
        TextView textCount = findViewById(R.id.textCount);
        TextView textX1 = findViewById(R.id.textX1);
        TextView textY1 = findViewById(R.id.textY1);
        TextView textX2 = findViewById(R.id.textX2);
        TextView textY2 = findViewById(R.id.textY2);
        LinearLayout linearnavigation =findViewById(R.id.linearnavigation);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Передвиньте объект на координаты",CustomToast.LENGTH_LONG).show();
        }

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level5.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 5 \"Координаты\" ");
            textinfolevel.setText("    Передвиньте объект на указанные координаты нажимая на кнопки для передвижения. Вы можете изменить \"скорость\" передвижения, нажав на кнопку ×1.");
            textinfoclue.setTextSize(0);
            buttonclue.setTextSize(0);
            buttonclue.setBackgroundColor(Color.WHITE);
            dialog.show();
        });

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        x = (float) Math.random() * 400;
        y = (float) Math.random() * 400;
        k = 1;

        textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
        textY1.setText(String.valueOf((int) imageObject.getTranslationY()));

        textX2.setText(String.valueOf((int) x));
        textY2.setText(String.valueOf((int) y));

        imageAim.setTranslationX((float) (imageAim.getTranslationX()+x));
        imageAim.setTranslationY((float) (imageAim.getTranslationY()+y));

        textCount.setOnClickListener(view ->{
            if(k==1){
                k=5;
                textCount.setText("×"+(int) k);
            }else{
                if(k==5){
                    k=10;
                    textCount.setText("×"+(int) k);
                }else{
                    k=1;
                    textCount.setText("×"+(int) k);
                }
            }
        });

        imageLeft.setOnClickListener(view -> {
            imageObject.setTranslationX((float) (imageObject.getTranslationX() - (1 * k)));
            textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
            textY1.setText(String.valueOf((int) imageObject.getTranslationY()));
            if((int) imageObject.getTranslationX()== (int) x && (int) imageObject.getTranslationY()== (int) y){
                Dialog dialog = new Dialog(Level5.this);
                dialog.setContentView(R.layout.custom_dialog_clue);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);

                textinfo = dialog.findViewById(R.id.textinfo);
                textnext = dialog.findViewById(R.id.textnext);
                texttomenu = dialog.findViewById(R.id.texttomenu);

                if(level>5){
                    textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
                }else{
                    textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
                    level++;
                }

                dialog.show();
                textnext.setOnClickListener(v -> {
                    dialog.dismiss();
                    i.setClass(getApplicationContext(), Level6.class);
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
        });
        imageRight.setOnClickListener(view -> {
            imageObject.setTranslationX((float) (imageObject.getTranslationX() + (1 * k)));
            textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
            textY1.setText(String.valueOf((int) imageObject.getTranslationY()));
            if((int) imageObject.getTranslationX()== (int) x && (int) imageObject.getTranslationY()== (int) y){
                Dialog dialog = new Dialog(Level5.this);
                dialog.setContentView(R.layout.custom_dialog_clue);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);

                textinfo = dialog.findViewById(R.id.textinfo);
                textnext = dialog.findViewById(R.id.textnext);
                texttomenu = dialog.findViewById(R.id.texttomenu);

                if(level>5){
                    textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
                }else{
                    textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
                    level++;
                }

                dialog.show();
                textnext.setOnClickListener(v -> {
                    dialog.dismiss();
                    i.setClass(getApplicationContext(), Level6.class);
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
        });
        imageDown.setOnClickListener(view -> {
            imageObject.setTranslationY((float) (imageObject.getTranslationY() - (1 * k)));
            textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
            textY1.setText(String.valueOf((int) imageObject.getTranslationY()));
            if((int) imageObject.getTranslationX()== (int) x && (int) imageObject.getTranslationY()== (int) y){
                Dialog dialog = new Dialog(Level5.this);
                dialog.setContentView(R.layout.custom_dialog_clue);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);

                textinfo = dialog.findViewById(R.id.textinfo);
                textnext = dialog.findViewById(R.id.textnext);
                texttomenu = dialog.findViewById(R.id.texttomenu);

                if(level>5){
                    textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
                }else{
                    textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
                    level++;
                }

                dialog.show();
                textnext.setOnClickListener(v -> {
                    dialog.dismiss();
                    i.setClass(getApplicationContext(), Level6.class);
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
        });
        imageUp.setOnClickListener(view -> {
            imageObject.setTranslationY((float) (imageObject.getTranslationY() + (1 * k)));
            textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
            textY1.setText(String.valueOf((int) imageObject.getTranslationY()));
            if((int) imageObject.getTranslationX()==(int) x && (int) imageObject.getTranslationY()==(int) y){
                Dialog dialog = new Dialog(Level5.this);
                dialog.setContentView(R.layout.custom_dialog_clue);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);

                textinfo = dialog.findViewById(R.id.textinfo);
                textnext = dialog.findViewById(R.id.textnext);
                texttomenu = dialog.findViewById(R.id.texttomenu);

                if(level>5){
                    textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
                }else{
                    textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
                    level++;
                }

                dialog.show();
                textnext.setOnClickListener(v -> {
                    dialog.dismiss();
                    i.setClass(getApplicationContext(), Level6.class);
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
        });
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
        Dialog dialog = new Dialog(Level5.this);
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