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
import android.widget.TextView;

import com.suafer.tryhard.R;

public class HardLevel3 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;

    private EditText edittext11, edittext12, edittext13, edittext14, edittext21, edittext22, edittext23, edittext24, edittext25, edittext26,
            edittext31, edittext32, edittext33, edittext34, edittext35, edittext36, edittext37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level3);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        ImageView imageback = findViewById(R.id.imageback); ImageView imageendlevel = findViewById(R.id.imageendlevel);
        edittext11 = findViewById(R.id.edittext11); edittext12 = findViewById(R.id.edittext12); edittext13 = findViewById(R.id.edittext13);
        edittext14 = findViewById(R.id.edittext14); edittext21 = findViewById(R.id.edittext21); edittext22 = findViewById(R.id.edittext22);
        edittext23 = findViewById(R.id.edittext23); edittext24 = findViewById(R.id.edittext24); edittext25 = findViewById(R.id.edittext25);
        edittext26 = findViewById(R.id.edittext26); edittext31 = findViewById(R.id.edittext31); edittext32 = findViewById(R.id.edittext32);
        edittext33 = findViewById(R.id.edittext33); edittext34 = findViewById(R.id.edittext34); edittext35 = findViewById(R.id.edittext35);
        edittext36 = findViewById(R.id.edittext36); edittext37 = findViewById(R.id.edittext37);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });

        imageendlevel.setOnClickListener(view ->{
            if(check()){
                createDialog();
            }
        });

        edittext11.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext11.setTextColor(0xFFFFFFFF);
                if(edittext11.getText().toString().length()==1){edittext12.requestFocus();}
                if(checkToClose()){edittext11.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext11.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext12.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext12.setTextColor(0xFFFFFFFF);
                if(edittext12.getText().toString().length()==1){edittext13.requestFocus();}
                if(edittext12.getText().toString().length()==0){edittext11.requestFocus();}
                if(checkToClose()){edittext12.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext12.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext13.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext13.setTextColor(0xFFFFFFFF);
                if(edittext13.getText().toString().length()==1){edittext14.requestFocus();}
                if(edittext13.getText().toString().length()==0){edittext12.requestFocus();}
                if(checkToClose()){edittext13.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext13.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext14.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext14.setTextColor(0xFFFFFFFF);
                if(edittext14.getText().toString().length()==1){edittext21.requestFocus();}
                if(edittext14.getText().toString().length()==0){edittext13.requestFocus();}
                if(checkToClose()){edittext14.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext14.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext21.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext21.setTextColor(0xFFFFFFFF);
                if(edittext21.getText().toString().length()==1){edittext22.requestFocus();}
                if(edittext21.getText().toString().length()==0){edittext14.requestFocus();}
                if(checkToClose()){edittext21.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext21.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext22.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext22.setTextColor(0xFFFFFFFF);
                if(edittext22.getText().toString().length()==1){edittext23.requestFocus();}
                if(edittext22.getText().toString().length()==0){edittext21.requestFocus();}
                if(checkToClose()){edittext22.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext22.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext23.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext23.setTextColor(0xFFFFFFFF);
                if(edittext23.getText().toString().length()==1){edittext24.requestFocus();}
                if(edittext23.getText().toString().length()==0){edittext22.requestFocus();}
                if(checkToClose()){edittext23.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext23.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext24.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext24.setTextColor(0xFFFFFFFF);
                if(edittext24.getText().toString().length()==1){edittext25.requestFocus();}
                if(edittext24.getText().toString().length()==0){edittext23.requestFocus();}
                if(checkToClose()){edittext24.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext24.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext25.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext25.setTextColor(0xFFFFFFFF);
                if(edittext25.getText().toString().length()==1){edittext26.requestFocus();}
                if(edittext25.getText().toString().length()==0){edittext24.requestFocus();}
                if(checkToClose()){edittext25.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext25.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext26.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext26.setTextColor(0xFFFFFFFF);
                if(edittext26.getText().toString().length()==1){edittext31.requestFocus();}
                if(edittext26.getText().toString().length()==0){edittext25.requestFocus();}
                if(checkToClose()){edittext26.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext26.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext31.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext31.setTextColor(0xFFFFFFFF);
                if(edittext31.getText().toString().length()==1){edittext32.requestFocus();}
                if(edittext31.getText().toString().length()==0){edittext26.requestFocus();}
                if(checkToClose()){edittext31.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext31.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext32.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext32.setTextColor(0xFFFFFFFF);
                if(edittext32.getText().toString().length()==1){edittext33.requestFocus();}
                if(edittext32.getText().toString().length()==0){edittext31.requestFocus();}
                if(checkToClose()){edittext32.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext32.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext33.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext33.setTextColor(0xFFFFFFFF);
                if(edittext33.getText().toString().length()==1){edittext34.requestFocus();}
                if(edittext33.getText().toString().length()==0){edittext32.requestFocus();}
                if(checkToClose()){edittext33.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext33.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext34.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext34.setTextColor(0xFFFFFFFF);
                if(edittext34.getText().toString().length()==1){edittext35.requestFocus();}
                if(edittext34.getText().toString().length()==0){edittext33.requestFocus();}
                if(checkToClose()){edittext34.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext34.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext35.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext35.setTextColor(0xFFFFFFFF);
                if(edittext35.getText().toString().length()==1){edittext36.requestFocus();}
                if(edittext35.getText().toString().length()==0){edittext34.requestFocus();}
                if(checkToClose()){edittext35.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext35.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext36.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext36.setTextColor(0xFFFFFFFF);
                if(edittext36.getText().toString().length()==1){edittext37.requestFocus();}
                if(edittext36.getText().toString().length()==0){edittext35.requestFocus();}
                if(checkToClose()){edittext36.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext36.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext37.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext37.setTextColor(0xFFFFFFFF);
                if(edittext37.getText().toString().length()==0){edittext36.requestFocus();}
                if(checkToClose()){edittext37.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext37.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

    }

    private boolean check(){
        if(edittext11.getText().toString().equals("н")){
            edittext11.setTextColor(0xFF00FF00);
        }else{edittext11.setTextColor(0xFFF44336); return false;}

        if(edittext12.getText().toString().equals("е")){
            edittext12.setTextColor(0xFF00FF00);
        }else{edittext12.setTextColor(0xFFF44336); return false;}

        if(edittext13.getText().toString().equals("б")){
            edittext13.setTextColor(0xFF00FF00);
        }else{edittext13.setTextColor(0xFFF44336); return false;}

        if(edittext14.getText().toString().equals("е")){
            edittext14.setTextColor(0xFF00FF00);
        }else{edittext14.setTextColor(0xFFF44336); return false;}

        if(edittext21.getText().toString().equals("С")){
            edittext21.setTextColor(0xFF00FF00);
        }else{edittext21.setTextColor(0xFFF44336); return false;}

        if(edittext22.getText().toString().equals("л")){
            edittext22.setTextColor(0xFF00FF00);
        }else{edittext22.setTextColor(0xFFF44336); return false;}

        if(edittext23.getText().toString().equals("о")){
            edittext23.setTextColor(0xFF00FF00);
        }else{edittext23.setTextColor(0xFFF44336); return false;}

        if(edittext24.getText().toString().equals("в")){
            edittext24.setTextColor(0xFF00FF00);
        }else{edittext24.setTextColor(0xFFF44336); return false;}

        if(edittext25.getText().toString().equals("н")){
            edittext25.setTextColor(0xFF00FF00);
        }else{edittext25.setTextColor(0xFFF44336); return false;}

        if(edittext26.getText().toString().equals("о")){
            edittext26.setTextColor(0xFF00FF00);
        }else{edittext26.setTextColor(0xFFF44336); return false;}

        if(edittext31.getText().toString().equals("з")){
            edittext31.setTextColor(0xFF00FF00);
        }else{edittext31.setTextColor(0xFFF44336); return false;}

        if(edittext32.getText().toString().equals("а")){
            edittext32.setTextColor(0xFF00FF00);
        }else{edittext32.setTextColor(0xFFF44336); return false;}

        if(edittext33.getText().toString().equals("п")){
            edittext33.setTextColor(0xFF00FF00);
        }else{edittext33.setTextColor(0xFFF44336); return false;}

        if(edittext34.getText().toString().equals("а")){
            edittext34.setTextColor(0xFF00FF00);
        }else{edittext34.setTextColor(0xFFF44336); return false;}

        if(edittext35.getText().toString().equals("х")){
            edittext35.setTextColor(0xFF00FF00);
        }else{edittext35.setTextColor(0xFFF44336); return false;}

        if(edittext36.getText().toString().equals("о")){
            edittext36.setTextColor(0xFF00FF00);
        }else{edittext36.setTextColor(0xFFF44336); return false;}

        if(edittext37.getText().toString().equals("м")){
            edittext37.setTextColor(0xFF00FF00);
        }else{edittext37.setTextColor(0xFFF44336); return false;}

        return true;
    }

    private boolean checkToClose(){
        return edittext11.getText().toString().length()!=0 && edittext12.getText().toString().length()!=0 && edittext13.getText().toString().length()!=0
        && edittext14.getText().toString().length()!=0 && edittext21.getText().toString().length()!=0 && edittext22.getText().toString().length()!=0 &&
        edittext23.getText().toString().length()!=0 && edittext24.getText().toString().length()!=0 && edittext25.getText().toString().length()!=0 &&
        edittext26.getText().toString().length()!=0 && edittext31.getText().toString().length()!=0 && edittext32.getText().toString().length()!=0 &&
        edittext33.getText().toString().length()!=0 && edittext34.getText().toString().length()!=0 && edittext35.getText().toString().length()!=0 &&
                edittext36.getText().toString().length()!=0 && edittext37.getText().toString().length()!=0;
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel3.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>3){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel4.class);
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
        Dialog dialog = new Dialog(HardLevel3.this);
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