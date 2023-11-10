package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Level6 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

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
        setContentView(R.layout.activity_level6);

        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        ImageView imageback = findViewById(R.id.imageback);
        EditText edittext = findViewById(R.id.edittext);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Вставьте последнюю букву",CustomToast.LENGTH_LONG).show();
        }

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level6.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 6 \"Загадка\" ");
            textinfolevel.setText("    Классическая задачка о природном объекте, там еще вроде бы песенка или стишок .");
            textinfoclue.setTextSize(0);
            buttonclue.setTextSize(0);
            dialog.show();
            buttonclue.setBackgroundColor(Color.WHITE);
        });

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
                final String _charSeq = _param1.toString();
                edittext.setTextColor(0xFF000000);
                if (edittext.getText().toString().equals("Ф") || edittext.getText().toString().equals("ф")) {
                    Dialog dialog = new Dialog(Level6.this);
                    dialog.setContentView(R.layout.custom_dialog_clue);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.setCancelable(false);

                    textinfo = dialog.findViewById(R.id.textinfo);
                    textnext = dialog.findViewById(R.id.textnext);
                    texttomenu = dialog.findViewById(R.id.texttomenu);

                    if(level>6){
                        textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
                    }else{
                        textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
                        level++;
                    }

                    dialog.show();
                    textnext.setOnClickListener(v -> {
                        dialog.dismiss();
                        i.setClass(getApplicationContext(), Level7.class);
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
            }

            @Override
            public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {

            }

            @Override
            public void afterTextChanged(Editable _param1) {

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
        Dialog dialog = new Dialog(Level6.this);
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