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

public class Level9 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private double level;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;
    private int x=1; private int y=1;
    private TextView fieldNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level9);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Передвиньте коня на поле с кружком",CustomToast.LENGTH_LONG).show();
        }

        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);
        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        TextView field11 = findViewById(R.id.field11);  TextView field31 = findViewById(R.id.field31);
        TextView field12 = findViewById(R.id.field12);  TextView field32 = findViewById(R.id.field32);
        TextView field13 = findViewById(R.id.field13);  TextView field33 = findViewById(R.id.field33);
        TextView field14 = findViewById(R.id.field14);  TextView field34 = findViewById(R.id.field34);
        TextView field15 = findViewById(R.id.field15);  TextView field35 = findViewById(R.id.field35);
        TextView field21 = findViewById(R.id.field21);  TextView field41 = findViewById(R.id.field41);
        TextView field22 = findViewById(R.id.field22);  TextView field42 = findViewById(R.id.field42);
        TextView field23 = findViewById(R.id.field23);  TextView field43 = findViewById(R.id.field43);
        TextView field24 = findViewById(R.id.field24);  TextView field44 = findViewById(R.id.field44);
        TextView field25 = findViewById(R.id.field25);  TextView field45 = findViewById(R.id.field45);
        TextView field51 = findViewById(R.id.field51);    TextView field54 = findViewById(R.id.field54);
        TextView field52 = findViewById(R.id.field52);    TextView field55 = findViewById(R.id.field55);
        TextView field53 = findViewById(R.id.field53);
        fieldNow = field11;


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

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level9.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText("Уровень 9 \"Шахматы\"");
            textinfolevel.setText("    Передвиньте фигуру \"коня\" на поле с кружком. \"Коня\" ходит буквой \"Г\", то есть сначала на две клетки в любом направлении (вверх, влево, вправо, вниз), а потом на одну клетку в бок.");
            buttonclue.setTextSize(0);
            buttonclue.setBackgroundColor(Color.WHITE);
            dialog.show();
        });

        field11.setOnClickListener(view -> {
            if(checkField(x,y,1,1)){
                x=1; y=1;
                field11.setText("♘");
                fieldNow.setText("");
                fieldNow=field11;
            }
        });
        field12.setOnClickListener(view -> {
            if(checkField(x,y,1,2)){
                x=1; y=2;
                field12.setText("♘");
                fieldNow.setText("");
                fieldNow=field12;
            }
        });
        field13.setOnClickListener(view -> {
            if(checkField(x,y,1,3)){
                x=1; y=3;
                field13.setText("♘");
                fieldNow.setText("");
                fieldNow=field13;
            }
        });
        field14.setOnClickListener(view -> {
            if(checkField(x,y,1,4)){
                x=1; y=4;
                field14.setText("♘");
                fieldNow.setText("");
                fieldNow=field14;
            }
        });
        field15.setOnClickListener(view -> {
            if(checkField(x,y,1,5)){
                x=1; y=5;
                field15.setText("♘");
                fieldNow.setText("");
                fieldNow=field15;
            }
        });

        field21.setOnClickListener(view -> {
            if(checkField(x,y,1,1)){
                x=1; y=1;
                field11.setText("♘");
                fieldNow.setText("");
                fieldNow=field11;
            }
        });
        field22.setOnClickListener(view -> {
            if(checkField(x,y,2,2)){
                x=2; y=2;
                field22.setText("♘");
                fieldNow.setText("");
                fieldNow=field22;
            }
        });
        field23.setOnClickListener(view -> {
            if(checkField(x,y,2,3)){
                x=2; y=3;
                field23.setText("♘");
                fieldNow.setText("");
                fieldNow=field23;
            }
        });
        field24.setOnClickListener(view -> {
            if(checkField(x,y,2,4)){
                x=2; y=4;
                field24.setText("♘");
                fieldNow.setText("");
                fieldNow=field24;
            }
        });
        field25.setOnClickListener(view -> {
            if(checkField(x,y,2,5)){
                x=2; y=5;
                field25.setText("♘");
                fieldNow.setText("");
                fieldNow=field25;
            }
        });

        field31.setOnClickListener(view -> {
            if(checkField(x,y,1,1)){
                x=1; y=1;
                field11.setText("♘");
                fieldNow.setText("");
                fieldNow=field11;
            }
        });
        field32.setOnClickListener(view -> {
            if(checkField(x,y,3,2)){
                x=3; y=2;
                field32.setText("♘");
                fieldNow.setText("");
                fieldNow=field32;
            }
        });
        field33.setOnClickListener(view -> {
            if(checkField(x,y,3,3)){
                x=3; y=3;
                field33.setText("♘");
                fieldNow.setText("");
                fieldNow=field33;
            }
        });
        field34.setOnClickListener(view -> {
            if(checkField(x,y,3,4)){
                x=3; y=4;
                field34.setText("♘");
                fieldNow.setText("");
                fieldNow=field34;
            }
        });
        field35.setOnClickListener(view -> {
            if(checkField(x,y,1,1)){
                x=1; y=1;
                field11.setText("♘");
                fieldNow.setText("");
                fieldNow=field11;
            }
        });

        field41.setOnClickListener(view -> {
            if(checkField(x,y,4,1)){
                x=4; y=1;
                field41.setText("♘");
                fieldNow.setText("");
                fieldNow=field41;
            }
        });
        field42.setOnClickListener(view -> {
            if(checkField(x,y,4,2)){
                x=4; y=2;
                field42.setText("♘");
                fieldNow.setText("");
                fieldNow=field42;
            }
        });
        field43.setOnClickListener(view -> {
            if(checkField(x,y,1,1)){
                x=1; y=1;
                field11.setText("♘");
                fieldNow.setText("");
                fieldNow=field11;
            }
        });
        field44.setOnClickListener(view -> {
            if(checkField(x,y,4,4)){
                x=4; y=4;
                field44.setText("♘");
                fieldNow.setText("");
                fieldNow=field44;
            }
        });
        field45.setOnClickListener(view -> {
            if(checkField(x,y,4,5)){
                x=4; y=5;
                field45.setText("♘");
                fieldNow.setText("");
                fieldNow=field45;
            }
        });

        field51.setOnClickListener(view -> {
            if(checkField(x,y,5,1)){
                x=5; y=1;
                field51.setText("♘");
                fieldNow.setText("");
                fieldNow=field51;
                createDialog();
            }
        });
        field52.setOnClickListener(view -> {
            if(checkField(x,y,5,2)){
                x=5; y=2;
                field52.setText("♘");
                fieldNow.setText("");
                fieldNow=field52;
            }
        });
        field53.setOnClickListener(view -> {
            if(checkField(x,y,5,3)){
                x=5; y=3;
                field53.setText("♘");
                fieldNow.setText("");
                fieldNow=field53;
            }
        });
        field54.setOnClickListener(view -> {
            if(checkField(x,y,5,4)){
                x=5; y=4;
                field54.setText("♘");
                fieldNow.setText("");
                fieldNow=field54;
            }
        });
        field55.setOnClickListener(view -> {
            if(checkField(x,y,5,5)){
                x=5; y=5;
                field55.setText("♘");
                fieldNow.setText("");
                fieldNow=field55;
            }
        });

    }
    private void createDialog(){
        Dialog dialog = new Dialog(Level9.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>9){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), Level10.class);
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

    private boolean checkField(int x1,int y1, int x2, int y2){
        return (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2);
    }

    private void createExite(){
        Dialog dialog = new Dialog(Level9.this);
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