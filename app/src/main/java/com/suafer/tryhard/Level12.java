package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Level12 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private double level = 0;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;
    int[][] map = {
            {10,-9,-3},
            {-4,5,2},
            {-3,9,-7}
    };
    int value = map[0][0];
    private TextView lastfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level12);

        ImageView imageback = findViewById(R.id.imageback); ImageView imagehelp = findViewById(R.id.imagehelp);
        ImageView buttonUpdate = findViewById(R.id.buttonUpdate);
        TextView field0 = findViewById(R.id.field0); TextView field1 = findViewById(R.id.field1);
        TextView field2 = findViewById(R.id.field2); TextView field3 = findViewById(R.id.field3);
        TextView field4 = findViewById(R.id.field4); TextView field5 = findViewById(R.id.field5);
        TextView field6 = findViewById(R.id.field6); TextView field7 = findViewById(R.id.field7);
        TextView field8 = findViewById(R.id.field8);

        lastfield = field0;

        LinearLayout linearnavigation = findViewById(R.id.linearnavigation); LinearLayout mainLayout = findViewById(R.id.mainLayout);
        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);
        mainLayout.startAnimation(mFadeInAnimation);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Нажимая на соседние поля для сложения чисел, получиту 0",CustomToast.LENGTH_LONG).show();
        }

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
        });

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level12.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 12 \"Числа\" ");
            textinfolevel.setText("    Нажимайте соседние с выбранным полем поля с числами, складывая числа, для того чтобы получить 0.");
            textinfoclue.setTextSize(0);
            buttonclue.setTextSize(0);
            dialog.show();
            buttonclue.setBackgroundColor(Color.WHITE);
        });

        buttonUpdate.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Level12.class);
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        field1.setOnClickListener(view ->{
            if(map[0][1]!=0 && (lastfield==field0 || lastfield==field2 || lastfield==field4)){
                value=value+map[0][1]; map[0][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field1.setText(String.valueOf(value)); field1.setTextColor(0xFF000000); field1.setBackgroundColor(0xFFFFFFFF);
                lastfield = field1;
                if(value==0){createDialog();}
            }
        });

        field2.setOnClickListener(view ->{
            if(map[0][2]!=0 && (lastfield==field1 || lastfield==field5)){
                value=value+map[0][2]; map[0][2]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field2.setText(String.valueOf(value)); field2.setTextColor(0xFF000000); field2.setBackgroundColor(0xFFFFFFFF);
                lastfield = field2;
                if(value==0){createDialog();}
            }
        });

        field3.setOnClickListener(view ->{
            if(map[1][0]!=0 && (lastfield==field0 || lastfield==field4 || lastfield==field6)){
                value=value+map[1][0]; map[1][0]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field3.setText(String.valueOf(value)); field3.setTextColor(0xFF000000); field3.setBackgroundColor(0xFFFFFFFF);
                lastfield = field3;
                if(value==0){createDialog();}
            }
        });

        field4.setOnClickListener(view ->{
            if(map[1][1]!=0 && (lastfield==field3 || lastfield==field1 || lastfield==field7 || lastfield==field5)){
                value=value+map[1][1]; map[1][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field4.setText(String.valueOf(value)); field4.setTextColor(0xFF000000); field4.setBackgroundColor(0xFFFFFFFF);
                lastfield = field4;
                if(value==0){createDialog();}
            }
        });

        field5.setOnClickListener(view -> {
            if(map[1][2]!=0 && (lastfield==field2 || lastfield==field4 || lastfield==field8)){
                value=value+map[1][2]; map[1][2]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field5.setText(String.valueOf(value)); field5.setTextColor(0xFF000000); field5.setBackgroundColor(0xFFFFFFFF);
                lastfield = field5;
                if(value==0){createDialog();}
            }
        });

        field6.setOnClickListener(view ->{
            if(map[2][0]!=0 && (lastfield==field3 || lastfield==field7)){
                value=value+map[2][0]; map[2][0]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field6.setText(String.valueOf(value)); field6.setTextColor(0xFF000000); field6.setBackgroundColor(0xFFFFFFFF);
                lastfield = field6;
                if(value==0){createDialog();}
            }
        });

        field7.setOnClickListener(view->{
            if(map[2][1]!=0 && (lastfield==field6 || lastfield==field4 || lastfield==field8)){
                value=value+map[2][1]; map[2][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field7.setText(String.valueOf(value)); field7.setTextColor(0xFF000000); field7.setBackgroundColor(0xFFFFFFFF);
                lastfield = field7;
                if(value==0){createDialog();}
            }
        });

        field8.setOnClickListener(view -> {
            if(map[2][2]!=0 && (lastfield==field7 || lastfield==field5)){
                value=value+map[2][2]; map[2][2]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field8.setText(String.valueOf(value)); field8.setTextColor(0xFF000000); field8.setBackgroundColor(0xFFFFFFFF);
                lastfield = field8;
                if(value==0){createDialog();}
            }
        });
    }


    private void createExite(){
        Dialog dialog = new Dialog(Level12.this);
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

    private void createDialog(){
        Dialog dialog = new Dialog(Level12.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>12){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), LevelFinal.class);
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