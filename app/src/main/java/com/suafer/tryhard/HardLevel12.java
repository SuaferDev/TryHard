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

public class HardLevel12 extends AppCompatActivity {

    TextView textinfo, textnext, texttomenu;
    TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;
    int[][] map = {
            {10, -9, -4, 3},
            {-5, -2, -10, 2},
            {-7, 1, -1, -2},
            {-7, 2, -5, -1}
    };
    int value = map[0][0];
    private TextView lastfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level12);

        ImageView imageback = findViewById(R.id.imageback);
        ImageView buttonUpdate = findViewById(R.id.buttonUpdate);
        TextView field0 = findViewById(R.id.field0); TextView field1 = findViewById(R.id.field1);
        TextView field2 = findViewById(R.id.field2); TextView field3 = findViewById(R.id.field3);
        TextView field4 = findViewById(R.id.field4); TextView field5 = findViewById(R.id.field5);
        TextView field6 = findViewById(R.id.field6); TextView field7 = findViewById(R.id.field7);
        TextView field8 = findViewById(R.id.field8); TextView field9 = findViewById(R.id.field9);
        TextView field10 = findViewById(R.id.field10); TextView field11 = findViewById(R.id.field11);
        TextView field12 = findViewById(R.id.field12); TextView field13 = findViewById(R.id.field13);
        TextView field14 = findViewById(R.id.field14); TextView field15 = findViewById(R.id.field15);
        lastfield=field0;

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });

        buttonUpdate.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), HardLevel12.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });

        field1.setOnClickListener(view ->{
            if(map[0][1]!=0 && (lastfield==field0 || lastfield==field5 || lastfield==field2)){
                value=value+map[0][1]; map[0][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field1.setText(String.valueOf(value)); field1.setTextColor(0xFF000000); field1.setBackgroundColor(0xFFFFFFFF);
                lastfield = field1;
                if(value==0){createDialog();}
            }
        });

        field2.setOnClickListener(view ->{
            if(map[0][2]!=0 && (lastfield==field1 || lastfield==field6 || lastfield==field3)){
                value=value+map[0][2]; map[0][2]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field2.setText(String.valueOf(value)); field2.setTextColor(0xFF000000); field2.setBackgroundColor(0xFFFFFFFF);
                lastfield = field2;
                if(value==0){createDialog();}
            }
        });

        field3.setOnClickListener(view ->{
            if(map[0][3]!=0 && (lastfield==field2 || lastfield==field7)){
                value=value+map[0][3]; map[0][3]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field3.setText(String.valueOf(value)); field3.setTextColor(0xFF000000); field3.setBackgroundColor(0xFFFFFFFF);
                lastfield = field3;
                if(value==0){createDialog();}
            }
        });

        field4.setOnClickListener(view ->{
            if(map[1][0]!=0 && (lastfield==field0 || lastfield==field5 || lastfield==field8)){
                value=value+map[1][0]; map[1][0]=0;
                lastfield.setText(""); lastfield.setBackgroundColor(0xFF000000);
                field4.setText(String.valueOf(value)); field4.setTextColor(0xFF000000); field4.setBackgroundColor(0xFFFFFFFF);
                lastfield = field4;
                if(value==0){createDialog();}
            }
        });

        field5.setOnClickListener(view -> {
            if(map[1][1]!=0 && (lastfield==field1 || lastfield==field4 || lastfield==field9 || lastfield==field6)){
                value=value+map[1][1]; map[1][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field5.setText(String.valueOf(value)); field5.setTextColor(0xFF000000); field5.setBackgroundColor(0xFFFFFFFF);
                lastfield = field5;
                if(value==0){createDialog();}
            }
        });

        field6.setOnClickListener(view ->{
            if(map[1][2]!=0 && (lastfield==field2 || lastfield==field5 || lastfield==field7 || lastfield==field11)){
                value=value+map[1][2]; map[1][2]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field6.setText(String.valueOf(value)); field6.setTextColor(0xFF000000); field6.setBackgroundColor(0xFFFFFFFF);
                lastfield = field6;
                if(value==0){createDialog();}
            }
        });

        field7.setOnClickListener(view -> {
            if(map[1][3]!=0 && (lastfield==field3 || lastfield==field6 || lastfield==field11)){
                value=value+map[1][1]; map[1][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field7.setText(String.valueOf(value)); field7.setTextColor(0xFF000000); field7.setBackgroundColor(0xFFFFFFFF);
                lastfield = field7;
                if(value==0){createDialog();}
            }
        });

        field8.setOnClickListener(view ->{
            if(map[2][0]!=0 && (lastfield==field4 || lastfield==field12 || lastfield==field9)){
                value=value+map[1][1]; map[1][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field8.setText(String.valueOf(value)); field8.setTextColor(0xFF000000); field8.setBackgroundColor(0xFFFFFFFF);
                lastfield = field8;
                if(value==0){createDialog();}
            }
        });

        field9.setOnClickListener(view ->{
            if(map[2][1]!=0 && (lastfield==field5 || lastfield==field8 || lastfield==field13 || lastfield==field10)){
                value=value+map[2][1]; map[2][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field9.setText(String.valueOf(value)); field9.setTextColor(0xFF000000); field9.setBackgroundColor(0xFFFFFFFF);
                lastfield = field9;
                if(value==0){createDialog();}
            }
        });

        field10.setOnClickListener(view -> {
            if(map[2][2]!=0 && (lastfield==field6 || lastfield==field9 || lastfield==field14 || lastfield==field11)){
                value=value+map[2][2]; map[2][2]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field10.setText(String.valueOf(value)); field10.setTextColor(0xFF000000); field10.setBackgroundColor(0xFFFFFFFF);
                lastfield = field10;
                if(value==0){createDialog();}
            }
        });

        field11.setOnClickListener(view ->{
            if(map[2][3]!=0 && (lastfield==field15 || lastfield==field10 || lastfield==field7)){
                value=value+map[2][3]; map[2][3]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field11.setText(String.valueOf(value)); field11.setTextColor(0xFF000000); field11.setBackgroundColor(0xFFFFFFFF);
                lastfield = field11;
                if(value==0){createDialog();}
            }
        });

        field12.setOnClickListener(view ->{
            if(map[3][0]!=0 && (lastfield==field8 || lastfield==field13)){
                value=value+map[3][0]; map[3][0]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field12.setText(String.valueOf(value)); field12.setTextColor(0xFF000000); field12.setBackgroundColor(0xFFFFFFFF);
                lastfield = field12;
                if(value==0){createDialog();}
            }
        });

        field13.setOnClickListener(view ->{
            if(map[3][1]!=0 && (lastfield==field12 || lastfield==field9 || lastfield==field14)){
                value=value+map[3][1]; map[3][1]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field13.setText(String.valueOf(value)); field13.setTextColor(0xFF000000); field13.setBackgroundColor(0xFFFFFFFF);
                lastfield = field13;
                if(value==0){createDialog();}
            }
        });

        field14.setOnClickListener(view ->{
            if(map[3][2]!=0 && (lastfield==field10 || lastfield==field15 || lastfield==field13)){
                value=value+map[3][2]; map[3][2]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field14.setText(String.valueOf(value)); field14.setTextColor(0xFF000000); field14.setBackgroundColor(0xFFFFFFFF);
                lastfield = field14;
                if(value==0){createDialog();}
            }
        });

        field15.setOnClickListener(view ->{
            if(map[3][3]!=0 && (lastfield==field11 || lastfield==field14)){
                value=value+map[3][3]; map[3][3]=0;
                lastfield.setText("");lastfield.setBackgroundColor(0xFF000000);
                field15.setText(String.valueOf(value)); field15.setTextColor(0xFF000000); field15.setBackgroundColor(0xFFFFFFFF);
                lastfield = field15;
                if(value==0){createDialog();}
            }
        });
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel12.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>12){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), EndActivity.class);
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
        Dialog dialog = new Dialog(HardLevel12.this);
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