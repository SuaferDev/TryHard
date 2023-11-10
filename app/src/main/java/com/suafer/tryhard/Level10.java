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
import android.widget.ImageView;
import android.widget.TextView;

public class Level10 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private double level = 0;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;
    private int[] image_rotation = {3,2,1,4,1,3,4,3,2};
    /*
    1->8    6->1
    2->5    7->2
    3->4    8->9
    4->6    9->3
    5->7
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level10);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Составьте картинку из частей",CustomToast.LENGTH_LONG).show();
        }

        //Animation flipAnimation = AnimationUtils.loadAnimation(this, R.anim.flip_animation);

        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        ImageView image1 = findViewById(R.id.image1);ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);ImageView image4 = findViewById(R.id.image4);
        ImageView image5 = findViewById(R.id.image5);ImageView image6 = findViewById(R.id.image6);
        ImageView image7 = findViewById(R.id.image7);ImageView image8 = findViewById(R.id.image8);
        ImageView image9 = findViewById(R.id.image9);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level10.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 10 \"Мозайка\" ");
            textinfolevel.setText("    Поверните части изображения так, чтобы они образовывали цельную картинку. При нажатии поворачивается не сама картинка, а другая, случайная.");
            textinfoclue.setTextSize(0);
            buttonclue.setTextSize(0);
            dialog.show();
            buttonclue.setBackgroundColor(Color.WHITE);
        });

        image1.setOnClickListener(view ->{
            image_rotation[7]=setValue(image_rotation[7]);
            image8.setRotation(setRotation(image_rotation[7]));
            if(check(image_rotation))createDialog();
        });

        image2.setOnClickListener(view ->{
            image_rotation[4]=setValue(image_rotation[4]);
            image5.setRotation(setRotation(image_rotation[4]));
            if(check(image_rotation))createDialog();
        });

        image3.setOnClickListener(view ->{
            image_rotation[3]=setValue(image_rotation[3]);
            image4.setRotation(setRotation(image_rotation[3]));
            if(check(image_rotation))createDialog();
        });

        image4.setOnClickListener(view ->{
            image_rotation[5]=setValue(image_rotation[5]);
            image6.setRotation(setRotation(image_rotation[5]));
            if(check(image_rotation))createDialog();
        });

        image5.setOnClickListener(view ->{
            if(image_rotation[6]==1)image_rotation[6]=2;
            else image_rotation[6]=1;
            image7.setRotation(setRotation(image_rotation[6]));
            if(check(image_rotation))createDialog();
        });

        image6.setOnClickListener(view ->{
            image_rotation[0]=setValue(image_rotation[0]);
            image1.setRotation(setRotation(image_rotation[0]));
            if(check(image_rotation))createDialog();
        });

        image7.setOnClickListener(view ->{
            image_rotation[1]=setValue(image_rotation[1]);
            image2.setRotation(setRotation(image_rotation[1]));
            if(check(image_rotation))createDialog();
        });

        image8.setOnClickListener(view ->{
            image_rotation[8]=setValue(image_rotation[8]);
            image9.setRotation(setRotation(image_rotation[8]));
            if(check(image_rotation))createDialog();
        });

        image9.setOnClickListener(view ->{
            image_rotation[2]=setValue(image_rotation[2]);
            image3.setRotation(setRotation(image_rotation[2]));
            if(check(image_rotation))createDialog();
        });
    }

    private int setValue(int i){
        if(i==1)return 2;
        if(i==2)return 3;
        if(i==3)return 4;
        if(i==4)return 1;
        return 0;
    }

    private int setRotation(int i){
        if(i==1)return 0;
        if(i==2)return 90;
        if(i==3)return 180;
        if(i==4)return 270;
        return 0;
    }

    private boolean check(int[] a){
        return a[0] == 1 && a[1] == 1 && a[2] == 1 && a[3] == 1 &&
                a[4] == 1 && a[5] == 1 && a[6] == 1 && a[7] == 1 && a[8] == 1;
    }


    private void createDialog(){
        Dialog dialog = new Dialog(Level10.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>10){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), Level11.class);
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

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {}

        @Override
        public void onAnimationRepeat(Animation animation) {}

        @Override
        public void onAnimationStart(Animation animation) {}
    };

    private void createExite(){
        Dialog dialog = new Dialog(Level10.this);
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