package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Level4 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private EditText edittext1, edittext2, edittext3, edittext4, edittext5, edittext6, edittext7, edittext8,
            edittext9, edittext10;

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
        setContentView(R.layout.activity_level4);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        edittext1 = findViewById(R.id.edittext1); edittext2 = findViewById(R.id.edittext2);
        edittext3 = findViewById(R.id.edittext3); edittext4 = findViewById(R.id.edittext4);
        edittext5 = findViewById(R.id.edittext5); edittext6 = findViewById(R.id.edittext6);
        edittext7 = findViewById(R.id.edittext7); edittext8 = findViewById(R.id.edittext8);
        edittext9 = findViewById(R.id.edittext9); edittext10 = findViewById(R.id.edittext10);
        ImageView imageendlevel = findViewById(R.id.imageendlevel);
        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Решите судоку",CustomToast.LENGTH_LONG).show();
        }

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level4.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 4 \"Судоку\" ");
            textinfolevel.setText("    Заполните свободные поля цифрами от 1 до 4 (1,2,3,4) так, чтобы на одной линии по вертикали, горизонтале и диагонале не стояли одинаковые цифры.");
            textinfoclue.setText("Подсказка откроет две случайные цифры.");
            dialog.show();


            buttonclue.setOnClickListener(v -> {
                edittext4.setText("4");
                edittext4.setTextColor(0xFF00FF00);
                edittext9.setText("2");
                edittext9.setTextColor(0xFF00FF00);
                dialog.dismiss();
            });
        });

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        imageendlevel.setOnClickListener(view ->{

            if(edittext1.getText().toString().equals("2")){edittext1.setTextColor(0xFF00FF00);
            }else{edittext1.setTextColor(0xFFF44336);}

            if(edittext2.getText().toString().equals("1")){edittext2.setTextColor(0xFF00FF00);
            }else{edittext2.setTextColor(0xFFF44336);}

            if(edittext3.getText().toString().equals("3")){edittext3.setTextColor(0xFF00FF00);
            }else{edittext3.setTextColor(0xFFF44336);}

            if(edittext4.getText().toString().equals("4")){edittext4.setTextColor(0xFF00FF00);
            }else{edittext4.setTextColor(0xFFF44336);}

            if(edittext5.getText().toString().equals("2")){edittext5.setTextColor(0xFF00FF00);
            }else{edittext5.setTextColor(0xFFF44336);}

            if(edittext6.getText().toString().equals("3")){edittext6.setTextColor(0xFF00FF00);
            }else{edittext6.setTextColor(0xFFF44336);}

            if(edittext7.getText().toString().equals("4")){edittext7.setTextColor(0xFF00FF00);
            }else{edittext7.setTextColor(0xFFF44336);}

            if(edittext8.getText().toString().equals("4")){edittext8.setTextColor(0xFF00FF00);
            }else{edittext8.setTextColor(0xFFF44336);}

            if(edittext9.getText().toString().equals("2")){edittext9.setTextColor(0xFF00FF00);
            }else{edittext9.setTextColor(0xFFF44336);}

            if(edittext10.getText().toString().equals("1")){edittext10.setTextColor(0xFF00FF00);
            }else{edittext10.setTextColor(0xFFF44336);}

            if(edittext1.getText().toString().equals("2") &&
                    edittext2.getText().toString().equals("1") &&
                    edittext3.getText().toString().equals("3") &&
                    edittext4.getText().toString().equals("4") &&
                    edittext5.getText().toString().equals("2") &&
                    edittext6.getText().toString().equals("3") &&
                    edittext7.getText().toString().equals("4") &&
                    edittext8.getText().toString().equals("4") &&
                    edittext9.getText().toString().equals("2") &&
                    edittext10.getText().toString().equals("1")){

                Dialog dialog = new Dialog(Level4.this);
                dialog.setContentView(R.layout.custom_dialog_clue);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);

                textinfo = dialog.findViewById(R.id.textinfo);
                textnext = dialog.findViewById(R.id.textnext);
                texttomenu = dialog.findViewById(R.id.texttomenu);

                if(level>4){
                    textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
                }else{
                    textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
                    level++;
                }

                dialog.show();
                textnext.setOnClickListener(v -> {
                    dialog.dismiss();
                    i.setClass(getApplicationContext(), Level5.class);
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

        edittext1.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext1.setTextColor(0xFFFFFFFF);
                if(edittext1.getText().toString().length()==1){edittext2.requestFocus();}
                if(checkToClose()){edittext1.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext1.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext2.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext2.setTextColor(0xFFFFFFFF);
                if(edittext2.getText().toString().length()==1){edittext3.requestFocus();}
                if(checkToClose()){edittext2.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext2.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext3.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext3.setTextColor(0xFFFFFFFF);
                if(edittext3.getText().toString().length()==1){edittext4.requestFocus();}
                if(checkToClose()){edittext3.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext3.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext4.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext4.setTextColor(0xFFFFFFFF);
                if(edittext4.getText().toString().length()==1){edittext5.requestFocus();}
                if(checkToClose()){edittext4.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext4.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext5.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext5.setTextColor(0xFFFFFFFF);
                if(edittext5.getText().toString().length()==1){edittext6.requestFocus();}
                if(checkToClose()){edittext5.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext5.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext6.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext6.setTextColor(0xFFFFFFFF);
                if(edittext6.getText().toString().length()==1){edittext7.requestFocus();}
                if(checkToClose()){edittext6.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext6.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext7.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext7.setTextColor(0xFFFFFFFF);
                if(edittext7.getText().toString().length()==1){edittext8.requestFocus();}
                if(checkToClose()){edittext7.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext7.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext8.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext8.setTextColor(0xFFFFFFFF);
                if(edittext8.getText().toString().length()==1){edittext9.requestFocus();}
                if(checkToClose()){edittext8.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext8.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext9.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext9.setTextColor(0xFFFFFFFF);
                if(edittext9.getText().toString().length()==1){edittext10.requestFocus();}
                if(checkToClose()){edittext9.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext9.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext10.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext10.setTextColor(0xFFFFFFFF);
                if(checkToClose()){edittext10.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext10.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
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
        Dialog dialog = new Dialog(Level4.this);
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

    private boolean checkToClose(){
        return edittext1.getText().toString().length()!=0 && edittext2.getText().toString().length()!=0 && edittext3.getText().toString().length()!=0
                && edittext4.getText().toString().length()!= 0 && edittext5.getText().toString().length()!=0 &&
                edittext6.getText().toString().length()!=0 && edittext7.getText().toString().length()!=0 && edittext8.getText().toString().length()!=0
                && edittext9.getText().toString().length()!=0 && edittext10.getText().toString().length()!=0;
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