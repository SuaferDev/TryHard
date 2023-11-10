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
import android.widget.TextView;

import com.suafer.tryhard.R;

public class HardLevel5 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;

    private double level = 0;
    private double k = 0;
    private float x = 0;
    private float y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level5);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        ImageView imageback = findViewById(R.id.imageback);
        TextView textCount = findViewById(R.id.textCount);
        TextView textX1 = findViewById(R.id.textX1);
        TextView textY1 = findViewById(R.id.textY1);
        TextView textX2 = findViewById(R.id.textX2);
        TextView textY2 = findViewById(R.id.textY2);
        ImageView imageObject = findViewById(R.id.imageObject);
        ImageView imageLeft = findViewById(R.id.imageLeft);
        ImageView imageRight = findViewById(R.id.imageRight);
        ImageView imageDown = findViewById(R.id.imageDown);
        ImageView imageUp = findViewById(R.id.imageUp);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
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
                createDialog();
            }
        });
        imageRight.setOnClickListener(view -> {
            imageObject.setTranslationX((float) (imageObject.getTranslationX() + (1 * k)));
            textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
            textY1.setText(String.valueOf((int) imageObject.getTranslationY()));
            if((int) imageObject.getTranslationX()== (int) x && (int) imageObject.getTranslationY()== (int) y){
                createDialog();
            }
        });
        imageDown.setOnClickListener(view -> {
            imageObject.setTranslationY((float) (imageObject.getTranslationY() - (1 * k)));
            textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
            textY1.setText(String.valueOf((int) imageObject.getTranslationY()));
            if((int) imageObject.getTranslationX()== (int) x && (int) imageObject.getTranslationY()== (int) y){
                createDialog();
            }
        });
        imageUp.setOnClickListener(view -> {
            imageObject.setTranslationY((float) (imageObject.getTranslationY() + (1 * k)));
            textX1.setText(String.valueOf((int) imageObject.getTranslationX()));
            textY1.setText(String.valueOf((int) imageObject.getTranslationY()));
            if((int) imageObject.getTranslationX()==(int) x && (int) imageObject.getTranslationY()==(int) y){
                createDialog();
            }
        });
    }
    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel5.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>5){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel6.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });
        texttomenu.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), LevelMenu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
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
        Dialog dialog = new Dialog(HardLevel5.this);
        dialog.setContentView(R.layout.custom_dialog_exite);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        textclosetomenu = dialog.findViewById(R.id.textclosetomenu);
        textclose = dialog.findViewById(R.id.textclose);

        dialog.show();
        textclosetomenu.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), LevelMenu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });
        textclose.setOnClickListener(v -> {
            dialog.dismiss();
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
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
        SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
    }
}