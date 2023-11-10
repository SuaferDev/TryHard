package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suafer.tryhard.Menu;
import com.suafer.tryhard.R;

public class HardLevel1 extends AppCompatActivity {

    private int k=0;

    TextView textinfo, textnext, texttomenu;
    TextView textclosetomenu, textclose;

    private LinearLayout linear1, linear2, linear3, linear4, linear5, linear6, linear7, linear8, linear9, linear10;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private SharedPreferences SaveHardLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level1);

        linear1 = findViewById(R.id.linear1); linear6 = findViewById(R.id.linear6);
        linear2 = findViewById(R.id.linear2); linear7 = findViewById(R.id.linear7);
        linear3 = findViewById(R.id.linear3); linear8 = findViewById(R.id.linear8);
        linear4 = findViewById(R.id.linear4); linear9 = findViewById(R.id.linear9);
        linear5 = findViewById(R.id.linear5); linear10 = findViewById(R.id.linear10);

        ImageView imageback = findViewById(R.id.imageback);
        TextView textlevel = findViewById(R.id.textlevel);
        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
        });

        linear1.setOnClickListener(view -> {
            if(k==0){
                linear1.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear9.setOnClickListener(view -> {
            if(k==1){
                linear9.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear8.setOnClickListener(view -> {
            if(k==2){
                linear8.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear3.setOnClickListener(view -> {
            if(k==3){
                linear3.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear6.setOnClickListener(view -> {
            if(k==4){
                linear6.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear5.setOnClickListener(view -> {
            if(k==5){
                linear5.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear7.setOnClickListener(view -> {
            if(k==6){
                linear7.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear2.setOnClickListener(view -> {
            if(k==7){
                linear2.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear10.setOnClickListener(view -> {
            if(k==8){
                linear10.setBackgroundColor(0xFF000000);k++;
            }else{
                clear();
                k=0;
            }
        });

        linear4.setOnClickListener(view -> {
            if(k==9){
                linear4.setBackgroundColor(0xFF000000);k++;
                linearnavigation.setBackgroundResource(R.drawable.level_navigation_white_corner);
                textlevel.setTextColor(0xFF000000);
                imageback.setImageResource(R.drawable.back_black);
                createDialog();
            }else{
                clear();
                k=0;
            }
        });
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel1.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>1){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel2.class);
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

    private void clear(){
        linear1.setBackgroundColor(0xFFFFFFFF); linear6.setBackgroundColor(0xFFFFFFFF);
        linear2.setBackgroundColor(0xFFFFFFFF); linear7.setBackgroundColor(0xFFFFFFFF);
        linear3.setBackgroundColor(0xFFFFFFFF); linear8.setBackgroundColor(0xFFFFFFFF);
        linear4.setBackgroundColor(0xFFFFFFFF); linear9.setBackgroundColor(0xFFFFFFFF);
        linear5.setBackgroundColor(0xFFFFFFFF); linear10.setBackgroundColor(0xFFFFFFFF);
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
        Dialog dialog = new Dialog(HardLevel1.this);
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