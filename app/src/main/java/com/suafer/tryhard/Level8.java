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

public class Level8 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private double level = 0;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;
    private int int_text=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level8);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Нажмите на буквы в правильном порядке",CustomToast.LENGTH_LONG).show();
        }

        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);
        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);

        TextView letter1 = findViewById(R.id.letter1);
        TextView letter2 = findViewById(R.id.letter2);
        TextView letter3 = findViewById(R.id.letter3);
        TextView letter4 = findViewById(R.id.letter4);
        TextView letter5 = findViewById(R.id.letter5);
        TextView letter6 = findViewById(R.id.letter6);
        TextView letter7 = findViewById(R.id.letter7);

        TextView textview1 = findViewById(R.id.textview1);  TextView textview19 = findViewById(R.id.textview19);
        TextView textview2 = findViewById(R.id.textview2);  TextView textview20 = findViewById(R.id.textview20);
        TextView textview3 = findViewById(R.id.textview3);  TextView textview21 = findViewById(R.id.textview21);
        TextView textview4 = findViewById(R.id.textview4);  TextView textview22 = findViewById(R.id.textview22);
        TextView textview5 = findViewById(R.id.textview5);  TextView textview23 = findViewById(R.id.textview23);
        TextView textview6 = findViewById(R.id.textview6);  TextView textview24 = findViewById(R.id.textview24);
        TextView textview7 = findViewById(R.id.textview7);  TextView textview25 = findViewById(R.id.textview25);
        TextView textview8 = findViewById(R.id.textview8);  TextView textview26 = findViewById(R.id.textview26);
        TextView textview9 = findViewById(R.id.textview9);  TextView textview27 = findViewById(R.id.textview27);
        TextView textview10 = findViewById(R.id.textview10);    TextView textview28 = findViewById(R.id.textview28);
        TextView textview11 = findViewById(R.id.textview11);    TextView textview29 = findViewById(R.id.textview29);
        TextView textview12 = findViewById(R.id.textview12);    TextView textview30 = findViewById(R.id.textview30);
        TextView textview13 = findViewById(R.id.textview13);    TextView textview31 = findViewById(R.id.textview31);
        TextView textview14 = findViewById(R.id.textview14);    TextView textview32 = findViewById(R.id.textview32);
        TextView textview15 = findViewById(R.id.textview15);    TextView textview33 = findViewById(R.id.textview33);
        TextView textview16 = findViewById(R.id.textview16);    TextView textview34 = findViewById(R.id.textview34);
        TextView textview17 = findViewById(R.id.textview17);    TextView textview35 = findViewById(R.id.textview35);
        TextView textview18 = findViewById(R.id.textview18);

        setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level8.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText("Уровень 8 \"Буквы\"");
            textinfolevel.setText("    Найдите буквы на экране и нажмите на них в правильном порядке так, чтобы образовать слово.");
            textinfoclue.setText("Подсказка выберет первую букву.");
            dialog.show();


            buttonclue.setOnClickListener(v -> {
                if(int_text==1){
                    letter1.setTextColor(0xFFFFFFFF);textview32.setTextColor(0xFFF44336);
                    int_text++;
                    dialog.dismiss();
                }
            });
        });

        textview1.setOnClickListener(view -> {
            if(int_text==2){int_text++;letter3.setTextColor(0xFFFFFFFF);textview1.setTextColor(0xFFF44336);
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);
                setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);;}
        });
        textview2.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});

        textview3.setOnClickListener(view -> {
            if(int_text==6){int_text++;letter7.setTextColor(0xFFFFFFFF);textview3.setTextColor(0xFFF44336);createDialog();
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);;}
        });

        textview4.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});

        textview5.setOnClickListener(view -> {
            if(int_text==6){int_text++;letter7.setTextColor(0xFFFFFFFF);textview5.setTextColor(0xFFF44336);createDialog();
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
        });

        textview6.setOnClickListener(view -> {
            if(int_text==1){int_text++;letter2.setTextColor(0xFFFFFFFF);textview6.setTextColor(0xFFF44336);}
            else{
                if(int_text==5){int_text++;letter6.setTextColor(0xFFFFFFFF);textview6.setTextColor(0xFFF44336);
                }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
            }
        });

        textview7.setOnClickListener(view -> {
            if(int_text==2){int_text++;letter3.setTextColor(0xFFFFFFFF);textview7.setTextColor(0xFFF44336);
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
        });

        textview8.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview9.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview10.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview11.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview12.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview13.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview14.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview15.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview16.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview17.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});

        textview18.setOnClickListener(view -> {
            if(int_text==4){int_text++;letter5.setTextColor(0xFFFFFFFF);textview18.setTextColor(0xFFF44336);
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
        });

        textview19.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview20.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview21.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview22.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});

        textview23.setOnClickListener(view -> {
            if(int_text==4){int_text++;letter3.setTextColor(0xFFFFFFFF);textview23.setTextColor(0xFFF44336);
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
        });

        textview24.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview25.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview26.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview27.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});
        textview28.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});

        textview29.setOnClickListener(view -> {
            if(int_text==1){int_text++;letter2.setTextColor(0xFFFFFFFF);textview29.setTextColor(0xFFF44336);}
            else{
                if(int_text==5){int_text++;letter6.setTextColor(0xFFFFFFFF);textview29.setTextColor(0xFFF44336);
                }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
            }
        });

        textview30.setOnClickListener(view -> {
            if(int_text==3){int_text++;letter4.setTextColor(0xFFFFFFFF);textview30.setTextColor(0xFFF44336);
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
        });

        textview31.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});

        textview32.setOnClickListener(view -> {
            if(int_text==0){int_text++;letter1.setTextColor(0xFFFFFFFF);textview32.setTextColor(0xFFF44336);
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);}
        });        textview33.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});

        textview34.setOnClickListener(view -> {
            if(int_text==6){int_text++;letter7.setTextColor(0xFFFFFFFF);textview32.setTextColor(0xFFF44336);createDialog();
            }else{int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);}
        });

        textview35.setOnClickListener(view -> {int_text=0;setZero(letter1,letter2,letter3,letter4,letter5,letter6,letter7);setWhite(textview1,textview3,textview5,textview6,textview7,textview18,textview23,textview29,textview30,textview32,textview34);});


    }

    private void createDialog(){
        Dialog dialog = new Dialog(Level8.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>8){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), Level9.class);
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

    private void setZero(TextView letter1,TextView letter2,TextView letter3,TextView letter4,TextView letter5,TextView letter6,TextView letter7){
        letter1.setTextColor(0xFF607D8B);   letter5.setTextColor(0xFF607D8B);
        letter2.setTextColor(0xFF607D8B);   letter6.setTextColor(0xFF607D8B);
        letter3.setTextColor(0xFF607D8B);   letter7.setTextColor(0xFF607D8B);
        letter4.setTextColor(0xFF607D8B);
    }

    private void setWhite(TextView textview1, TextView textview2,TextView textview3, TextView textview4,TextView textview5, TextView textview6,
    TextView textview7, TextView textview8, TextView textview9, TextView textview10,TextView textview11){
        textview1.setTextColor(0xFFFFFFFF);    textview7.setTextColor(0xFFFFFFFF);
        textview2.setTextColor(0xFFFFFFFF);    textview8.setTextColor(0xFFFFFFFF);
        textview3.setTextColor(0xFFFFFFFF);    textview9.setTextColor(0xFFFFFFFF);
        textview4.setTextColor(0xFFFFFFFF);    textview10.setTextColor(0xFFFFFFFF);
        textview5.setTextColor(0xFFFFFFFF);    textview11.setTextColor(0xFFFFFFFF);
        textview6.setTextColor(0xFFFFFFFF);


    }

    private void createExite(){
        Dialog dialog = new Dialog(Level8.this);
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