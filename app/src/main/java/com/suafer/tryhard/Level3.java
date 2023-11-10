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
import android.widget.Toast;

public class Level3 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private EditText edittext11, edittext12, edittext13, edittext14, edittext15, edittext21, edittext22, edittext23, edittext24, edittext25;

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
        setContentView(R.layout.activity_level3);

        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);
        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        ImageView imageendlevel = findViewById(R.id.imageendlevel);
        edittext11 = findViewById(R.id.edittext11);
        edittext12 = findViewById(R.id.edittext12);
        edittext13 = findViewById(R.id.edittext13);
        edittext14 = findViewById(R.id.edittext14);
        edittext15 = findViewById(R.id.edittext15);
        edittext21 = findViewById(R.id.edittext21);
        edittext22 = findViewById(R.id.edittext22);
        edittext23 = findViewById(R.id.edittext23);
        edittext24 = findViewById(R.id.edittext24);
        edittext25 = findViewById(R.id.edittext25);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Вставьте пропущенные слова в стих",CustomToast.LENGTH_LONG).show();
        }

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
            Dialog dialog = new Dialog(Level3.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 3 \"Стих\" ");
            textinfolevel.setText("    Вставьте пропущенные слова в стих. Каждая буква слова в свободную ячейку. Первое слово - наречие из 5 букв, а второе прилагательное из 5 букв.");
            textinfoclue.setText("Подсказка откроет первую и последнюю букву каждого слова.");
            dialog.show();
            if(edittext11.getText().toString()=="Т" && edittext15.getText().toString()=="о" && edittext21.getText().toString()=="Б" && edittext25.getText().toString()=="й"){
                buttonclue.setBackgroundColor(R.drawable.use_help_off);
            }

            buttonclue.setOnClickListener(v -> {
                if(edittext11.getText().toString()=="Т" && edittext15.getText().toString()=="о" && edittext21.getText().toString()=="Б" && edittext25.getText().toString()=="й"){
                    Toast.makeText(Level3.this,"Подсказка не имеет смысла",Toast.LENGTH_LONG).show();
                }else{
                    edittext11.setText("Т");edittext11.setTextColor(0xFF00FF00);
                    edittext15.setText("о");edittext15.setTextColor(0xFF00FF00);
                    edittext21.setText("Б");edittext21.setTextColor(0xFF00FF00);
                    edittext25.setText("й");edittext25.setTextColor(0xFF00FF00);
                }
                dialog.dismiss();
            });
        });

        imageendlevel.setOnClickListener(view ->{
            if(edittext11.getText().toString().equals("Т")){
                edittext11.setTextColor(0xFF00FF00);
            }else{edittext11.setTextColor(0xFFF44336);}


            if(edittext12.getText().toString().equals("о")){
                edittext12.setTextColor(0xFF00FF00);
            }else{edittext12.setTextColor(0xFFF44336);}


            if(edittext13.getText().toString().equals("ч")){
                edittext13.setTextColor(0xFF00FF00);
            }else{edittext13.setTextColor(0xFFF44336);}


            if(edittext14.getText().toString().equals("н")){
                edittext14.setTextColor(0xFF00FF00);
            }else{edittext14.setTextColor(0xFFF44336);}


            if(edittext15.getText().toString().equals("о")){
                edittext15.setTextColor(0xFF00FF00);
            }else{edittext15.setTextColor(0xFFF44336);}


            if(edittext21.getText().toString().equals("Б")){
                edittext21.setTextColor(0xFF00FF00);
            }else{edittext21.setTextColor(0xFFF44336);}

            if(edittext22.getText().toString().equals("е")){
                edittext22.setTextColor(0xFF00FF00);
            }else{edittext22.setTextColor(0xFFF44336);}

            if(edittext23.getText().toString().equals("л")){
                edittext23.setTextColor(0xFF00FF00);
            }else{edittext23.setTextColor(0xFFF44336);}

            if(edittext24.getText().toString().equals("о")){
                edittext24.setTextColor(0xFF00FF00);
            }else{edittext24.setTextColor(0xFFF44336);}

            if(edittext25.getText().toString().equals("й")){
                edittext25.setTextColor(0xFF00FF00);
            }else{edittext25.setTextColor(0xFFF44336);}

            if((edittext11.getText().toString()+
                    edittext12.getText().toString()+
                    edittext13.getText().toString()+
                    edittext14.getText().toString()+
                    edittext15.getText().toString()).equals("Точно") && (edittext21.getText().toString()+
                    edittext22.getText().toString()+
                    edittext23.getText().toString()+
                    edittext24.getText().toString()+
                    edittext25.getText().toString()).equals("Белой")){
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
                if(edittext14.getText().toString().length()==1){edittext15.requestFocus();}
                if(edittext14.getText().toString().length()==0){edittext13.requestFocus();}
                if(checkToClose()){edittext14.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edittext14.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
        edittext15.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext15.setTextColor(0xFFFFFFFF);
                if(edittext15.getText().toString().length()==1){edittext21.requestFocus();}
                if(edittext15.getText().toString().length()==0){edittext14.requestFocus();}
                if(checkToClose()){edittext15.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext15.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });


        edittext21.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext21.setTextColor(0xFFFFFFFF);
                if(edittext21.getText().toString().length()==1){edittext22.requestFocus();}
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
                if(edittext25.getText().toString().length()==0){edittext24.requestFocus();}
                if(checkToClose()){edittext25.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext25.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });
    }

    private void createDialog(){
        Dialog dialog = new Dialog(Level3.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>3){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), Level4.class);
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

    private boolean checkToClose(){
        return edittext25.getText().toString().length()!=0 && edittext24.getText().toString().length()!=0 && edittext23.getText().toString().length()!=0
                && edittext22.getText().toString().length()!= 0 && edittext21.getText().toString().length()!=0 &&
                edittext15.getText().toString().length()!=0 && edittext14.getText().toString().length()!=0 && edittext13.getText().toString().length()!=0
                && edittext12.getText().toString().length()!=0 && edittext11.getText().toString().length()!=0;
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
        Dialog dialog = new Dialog(Level3.this);
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