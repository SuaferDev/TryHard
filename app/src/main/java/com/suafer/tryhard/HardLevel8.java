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
import android.widget.Toast;

import com.suafer.tryhard.R;

public class HardLevel8 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;
    private String string="";

    private TextView textview1, textview2, textview3, textview4,textview5, textview6, textview7, textview8, textview9, textview10, textview11,
    textview12, textview13, textview14, textview15, textview16, textview17, textview18, textview19, textview20, textview21, textview22, textview23,
    textview24, textview25, textview26, textview27, textview28, textview29, textview30, textview31, textview32, textview33, textview34, textview35,
    textview36, textview37, textview38, textview39, textview40, textview41, textview42, textview43, textview44, textview45, textview46, textview47,
            textview48, textview49, textview50, textview51, textview52, textview53, textview54, textview55, textview56;
    private TextView letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8, letter9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level8);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        ImageView imageback = findViewById(R.id.imageback);
        textview1 = findViewById(R.id.textview1);  textview19 = findViewById(R.id.textview19); textview37 = findViewById(R.id.textview37);
        textview2 = findViewById(R.id.textview2);  textview20 = findViewById(R.id.textview20); textview38 = findViewById(R.id.textview38);
        textview3 = findViewById(R.id.textview3);  textview21 = findViewById(R.id.textview21); textview39 = findViewById(R.id.textview39);
        textview4 = findViewById(R.id.textview4);  textview22 = findViewById(R.id.textview22); textview40 = findViewById(R.id.textview40);
        textview5 = findViewById(R.id.textview5);  textview23 = findViewById(R.id.textview23); textview41 = findViewById(R.id.textview41);
        textview6 = findViewById(R.id.textview6);  textview24 = findViewById(R.id.textview24); textview42 = findViewById(R.id.textview42);
        textview7 = findViewById(R.id.textview7);  textview25 = findViewById(R.id.textview25); textview43 = findViewById(R.id.textview43);
        textview8 = findViewById(R.id.textview8);  textview26 = findViewById(R.id.textview26); textview44 = findViewById(R.id.textview44);
        textview9 = findViewById(R.id.textview9);  textview27 = findViewById(R.id.textview27); textview45 = findViewById(R.id.textview45);
        textview10 = findViewById(R.id.textview10); textview28 = findViewById(R.id.textview28); textview46 = findViewById(R.id.textview46);
        textview11 = findViewById(R.id.textview11); textview29 = findViewById(R.id.textview29); textview47 = findViewById(R.id.textview47);
        textview12 = findViewById(R.id.textview12); textview30 = findViewById(R.id.textview30); textview48 = findViewById(R.id.textview48);
        textview13 = findViewById(R.id.textview13); textview31 = findViewById(R.id.textview31); textview49 = findViewById(R.id.textview49);
        textview14 = findViewById(R.id.textview14); textview32 = findViewById(R.id.textview32); textview50 = findViewById(R.id.textview50);
        textview15 = findViewById(R.id.textview15); textview33 = findViewById(R.id.textview33); textview51 = findViewById(R.id.textview51);
        textview16 = findViewById(R.id.textview16); textview34 = findViewById(R.id.textview34); textview52 = findViewById(R.id.textview52);
        textview17 = findViewById(R.id.textview17); textview35 = findViewById(R.id.textview35); textview53 = findViewById(R.id.textview53);
        textview18 = findViewById(R.id.textview18); textview36 = findViewById(R.id.textview36); textview54 = findViewById(R.id.textview54);
        textview55 = findViewById(R.id.textview55); textview56 = findViewById(R.id.textview56);
        letter1 = findViewById(R.id.letter1); letter4 = findViewById(R.id.letter4); letter7 = findViewById(R.id.letter7);
        letter2 = findViewById(R.id.letter2); letter5 = findViewById(R.id.letter5); letter8 = findViewById(R.id.letter8);
        letter3 = findViewById(R.id.letter3); letter6 = findViewById(R.id.letter6); letter9 = findViewById(R.id.letter9);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
        });

        textview1.setOnClickListener(view ->{
            string="";
            clear();
        }); textview2.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview3.setOnClickListener(view -> {
            if(string.length()==0){
                letter1.setTextColor(0xFFFFFFFF); textview3.setTextColor(0xFFF44336); string=string+"H";
            } else{
                clear();string="";
            }
        });
        textview4.setOnClickListener(view ->{
            string="";
            clear();
        }); textview5.setOnClickListener(view ->{
            string="";
            clear();
        }); textview6.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview7.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='L'){
                letter6.setTextColor(0xFFFFFFFF); textview7.setTextColor(0xFFF44336); string=string+"E";
            }else{
                if(string.length()!=0 && string.charAt(string.length()-1)=='V') {
                    letter8.setTextColor(0xFFFFFFFF); textview7.setTextColor(0xFFF44336); string=string+"E";
                }else{
                    clear();string="";
                }
            }

        });
        textview8.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview9.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='A'){
                letter3.setTextColor(0xFFFFFFFF); textview9.setTextColor(0xFFF44336); string=string+"R";
            } else{
                clear();string="";
            }
        });
        textview10.setOnClickListener(view ->{
            string="";
            clear();
        }); textview11.setOnClickListener(view ->{
            string="";
            clear();
        }); textview12.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview13.setOnClickListener(view ->{
            string="";
            clear();
        }); textview14.setOnClickListener(view ->{
            string="";
            clear();
        }); textview15.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview16.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview17.setOnClickListener(view -> {
            if(string.length()==0){
                letter1.setTextColor(0xFFFFFFFF); textview17.setTextColor(0xFFF44336); string=string+"H";
            } else{
                clear();string="";
            }
        });
        textview18.setOnClickListener(view ->{
            string="";
            clear();
        }); textview19.setOnClickListener(view ->{
            string="";
            clear();
        }); textview20.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview21.setOnClickListener(view ->{
            string="";
            clear();
        }); textview22.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview23.setOnClickListener(view -> {
            if(string.length()==0){
                letter1.setTextColor(0xFFFFFFFF); textview23.setTextColor(0xFFF44336); string=string+"H";
            } else{
                clear();string="";
            }
        });
        textview24.setOnClickListener(view ->{
            string="";
            clear();
        }); textview25.setOnClickListener(view ->{
            string="";
            clear();
        }); textview26.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview27.setOnClickListener(view ->{
            if(string.length()!=0 && string.charAt(string.length()-1)=='E'){
                letter7.setTextColor(0xFFFFFFFF); textview27.setTextColor(0xFFF44336); string=string+"V";
            } else{
                clear();string="";
            }
        }); textview28.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview29.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='H'){
                letter2.setTextColor(0xFFFFFFFF); textview29.setTextColor(0xFFF44336); string=string+"A";
            } else{
                clear();string="";
            }
        });
        textview30.setOnClickListener(view ->{
            string="";
            clear();
        }); textview31.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview32.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='L'){
                letter6.setTextColor(0xFFFFFFFF); textview32.setTextColor(0xFFF44336); string=string+"E";
            }else{
                if(string.length()!=0 && string.charAt(string.length()-1)=='V') {
                    letter8.setTextColor(0xFFFFFFFF); textview32.setTextColor(0xFFF44336); string=string+"E";
                }else{
                    clear();string="";
                }
            }

        });
        textview33.setOnClickListener(view ->{
            string="";
            clear();
        }); textview34.setOnClickListener(view ->{
            string="";
            clear();
        }); textview35.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview36.setOnClickListener(view -> {
            if(string.length()!=0 && String.valueOf(string.charAt(string.length() - 1)).equals("D")){
                letter5.setTextColor(0xFFFFFFFF); textview36.setTextColor(0xFFF44336); string=string+"L";
            }else{
                if(string.length()!=0 && string.charAt(string.length()-1)=='E') {
                    createDialog();
                    letter9.setTextColor(0xFFFFFFFF); textview36.setTextColor(0xFFF44336); string=string+"L";
                }else{
                    clear();string="";
                }
            }

        });
        textview37.setOnClickListener(view ->{
            string="";
            clear();
        }); textview38.setOnClickListener(view ->{
            string="";
            clear();
        }); textview39.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview40.setOnClickListener(view ->{
            string="";
            clear();
        }); textview41.setOnClickListener(view ->{
            string="";
            clear();
        }); textview42.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview43.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview44.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='R'){
                letter4.setTextColor(0xFFFFFFFF); textview44.setTextColor(0xFFF44336); string=string+"D";
            } else{
                clear();string="";
            }
        });
        textview45.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview46.setOnClickListener(view ->{
            string="";
            clear();
        }); textview47.setOnClickListener(view ->{
            string="";
            clear();
        }); textview48.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview49.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='D'){
                letter5.setTextColor(0xFFFFFFFF); textview49.setTextColor(0xFFF44336); string=string+"L";
            }else{
                if(string.length()!=0 && string.charAt(string.length()-1)=='E') {
                    letter9.setTextColor(0xFFFFFFFF); textview49.setTextColor(0xFFF44336); string=string+"L";
                    createDialog();
                }else{
                    clear();string="";
                }
            }

        });
        textview50.setOnClickListener(view ->{
            string="";
            clear();
        }); textview51.setOnClickListener(view ->{
            string="";
            clear();
        }); textview52.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview53.setOnClickListener(view ->{
            string="";
            clear();
        }); textview56.setOnClickListener(view ->{
            string="";
            clear();
        });
        textview54.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='D'){
                letter5.setTextColor(0xFFFFFFFF); textview54.setTextColor(0xFFF44336); string=string+"L";
            }else{
                if(string.length()!=0 && string.charAt(string.length()-1)=='E') {
                    letter9.setTextColor(0xFFFFFFFF); textview54.setTextColor(0xFFF44336); string=string+"L";
                    createDialog();
                }else{
                    clear();string="";
                }
            }

        });
        textview55.setOnClickListener(view -> {
            if(string.length()!=0 && string.charAt(string.length()-1)=='A'){
                letter3.setTextColor(0xFFFFFFFF); textview55.setTextColor(0xFFF44336); string=string+"R";
            } else{
                clear();string="";
            }
        });

    }

    private void clear(){
        textview1.setTextColor(0xFFFFFFFF); textview19.setTextColor(0xFFFFFFFF); textview37.setTextColor(0xFFFFFFFF);
        textview2.setTextColor(0xFFFFFFFF); textview20.setTextColor(0xFFFFFFFF); textview38.setTextColor(0xFFFFFFFF);
        textview3.setTextColor(0xFFFFFFFF); textview21.setTextColor(0xFFFFFFFF); textview39.setTextColor(0xFFFFFFFF);
        textview4.setTextColor(0xFFFFFFFF); textview22.setTextColor(0xFFFFFFFF); textview40.setTextColor(0xFFFFFFFF);
        textview5.setTextColor(0xFFFFFFFF); textview23.setTextColor(0xFFFFFFFF); textview41.setTextColor(0xFFFFFFFF);
        textview6.setTextColor(0xFFFFFFFF); textview24.setTextColor(0xFFFFFFFF); textview42.setTextColor(0xFFFFFFFF);
        textview7.setTextColor(0xFFFFFFFF); textview25.setTextColor(0xFFFFFFFF); textview43.setTextColor(0xFFFFFFFF);
        textview8.setTextColor(0xFFFFFFFF); textview26.setTextColor(0xFFFFFFFF); textview44.setTextColor(0xFFFFFFFF);
        textview9.setTextColor(0xFFFFFFFF); textview27.setTextColor(0xFFFFFFFF); textview45.setTextColor(0xFFFFFFFF);
        textview10.setTextColor(0xFFFFFFFF); textview28.setTextColor(0xFFFFFFFF); textview46.setTextColor(0xFFFFFFFF);
        textview11.setTextColor(0xFFFFFFFF); textview29.setTextColor(0xFFFFFFFF); textview47.setTextColor(0xFFFFFFFF);
        textview12.setTextColor(0xFFFFFFFF); textview30.setTextColor(0xFFFFFFFF); textview48.setTextColor(0xFFFFFFFF);
        textview13.setTextColor(0xFFFFFFFF); textview31.setTextColor(0xFFFFFFFF); textview49.setTextColor(0xFFFFFFFF);
        textview14.setTextColor(0xFFFFFFFF); textview32.setTextColor(0xFFFFFFFF); textview50.setTextColor(0xFFFFFFFF);
        textview15.setTextColor(0xFFFFFFFF); textview33.setTextColor(0xFFFFFFFF); textview51.setTextColor(0xFFFFFFFF);
        textview16.setTextColor(0xFFFFFFFF); textview34.setTextColor(0xFFFFFFFF); textview52.setTextColor(0xFFFFFFFF);
        textview17.setTextColor(0xFFFFFFFF); textview35.setTextColor(0xFFFFFFFF); textview53.setTextColor(0xFFFFFFFF);
        textview18.setTextColor(0xFFFFFFFF); textview36.setTextColor(0xFFFFFFFF); textview54.setTextColor(0xFFFFFFFF);
        textview55.setTextColor(0xFFFFFFFF); textview56.setTextColor(0xFFFFFFFF);
        letter1.setTextColor(0xFF607D8B); letter2.setTextColor(0xFF607D8B); letter3.setTextColor(0xFF607D8B); letter4.setTextColor(0xFF607D8B);
        letter5.setTextColor(0xFF607D8B); letter6.setTextColor(0xFF607D8B); letter7.setTextColor(0xFF607D8B); letter8.setTextColor(0xFF607D8B);
        letter9.setTextColor(0xFF607D8B);
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel8.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>8){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel9.class);
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
        Dialog dialog = new Dialog(HardLevel8.this);
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