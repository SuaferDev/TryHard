package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Level7 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private double level = 0;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;
    private int int_text=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level7);

        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);
        ImageView imageback = findViewById(R.id.imageback);
        ImageView imagehelp = findViewById(R.id.imagehelp);
        ImageView imageupdate = findViewById(R.id.imageupdate);
        EditText editetext1 = findViewById(R.id.edittext1);
        EditText editetext2 = findViewById(R.id.edittext2);
        EditText editetext3 = findViewById(R.id.edittext3);
        EditText editetext4 = findViewById(R.id.edittext4);
        EditText editetext5 = findViewById(R.id.edittext5);
        EditText editetext6 = findViewById(R.id.edittext6);
        TextView textsmile = findViewById(R.id.textsmile);

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Угадайте слово, зашифрованное эмоджи",CustomToast.LENGTH_LONG).show();
        }

        imageupdate.setOnClickListener(view -> {
            if(int_text==0){
                int_text=1;
                textsmile.setText("\uD83E\uDDEB\uD83D\uDD2C\uD83E\uDDEC");
            }else{
                if(int_text==1) {
                    int_text = 2;
                    textsmile.setText("\uD83E\uDE7A⚕");
                }else{
                    if(int_text==2){
                        int_text=0;
                        textsmile.setText("\uD83D\uDD25\uD83D\uDC0A✈");
                    }
                }
            }
            editetext1.setTextColor(0xFFFFFFFF);  editetext2.setTextColor(0xFFFFFFFF);  editetext3.setTextColor(0xFFFFFFFF);
            editetext4.setTextColor(0xFFFFFFFF);  editetext5.setTextColor(0xFFFFFFFF);  editetext6.setTextColor(0xFFFFFFFF);
        });

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

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level7.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 7 \"Эмоджи\" ");
            textinfolevel.setText("    Заданы несколько эмоджи, необходимо угадать слово, которое они обозначают.");
            textinfoclue.setText("Подсказка откроет первую и последнюю букву в слове.");
            dialog.show();


            buttonclue.setOnClickListener(v -> {
                if(int_text==0){
                    editetext1.setText("Д");editetext6.setText("Н");
                }
                if(int_text==1){
                    editetext1.setText("У");editetext6.setText("Й");
                }
                if(int_text==2){
                    editetext1.setText("Д");editetext6.setText("Р");
                }
                editetext1.setTextColor(0xFF00FF00);
                editetext6.setTextColor(0xFF00FF00);
                dialog.dismiss();
            });
        });

        editetext1.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editetext1.setTextColor(0xFFFFFFFF);
                if(editetext1.getText().toString().length()==1){editetext2.requestFocus();}
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }}
            @Override public void afterTextChanged(Editable editable) {
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }
            }
        });
        editetext2.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editetext2.setTextColor(0xFFFFFFFF);
                if(editetext2.getText().toString().length()==1){editetext3.requestFocus();}
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }}
            @Override public void afterTextChanged(Editable editable) {
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }
            }
        });
        editetext3.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editetext3.setTextColor(0xFFFFFFFF);
                if(editetext3.getText().toString().length()==1){editetext4.requestFocus();}
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }}
            @Override public void afterTextChanged(Editable editable) {
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }
            }
        });
        editetext4.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editetext4.setTextColor(0xFFFFFFFF);
                if(editetext4.getText().toString().length()==1){editetext5.requestFocus();}
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }}
            @Override public void afterTextChanged(Editable editable) {
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }
            }
        });
        editetext5.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editetext5.setTextColor(0xFFFFFFFF);
                if(editetext5.getText().toString().length()==1){editetext6.requestFocus();}
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }}
            @Override public void afterTextChanged(Editable editable) {
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }
            }
        });
        editetext6.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editetext6.setTextColor(0xFFFFFFFF);
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }
            }
            @Override public void afterTextChanged(Editable editable) {
                if(check(editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                    if(checkTrueAnswer(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6)){
                        createDialog();
                    }else {
                        setMistace(int_text,editetext1,editetext2,editetext3,editetext4,editetext5,editetext6);
                    }
                }
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

    private boolean check(EditText editText1,EditText editText2,EditText editText3,EditText editText4,EditText editText5,EditText editText6){
        if(editText1.getText().toString().equals("")){return false;}
        if(editText2.getText().toString().equals("")){return false;}
        if(editText3.getText().toString().equals("")){return false;}
        if(editText4.getText().toString().equals("")){return false;}
        if(editText5.getText().toString().equals("")){return false;}
        if(editText6.getText().toString().equals("")){return false;}
        return true;
    }

    private boolean checkTrueAnswer(int int_text,EditText editText1,EditText editText2,EditText editText3,EditText editText4,EditText editText5,EditText editText6){
        if(int_text==0){
            return editText1.getText().toString().equals("Д") && editText2.getText().toString().equals("Р")
                    && editText3.getText().toString().equals("А")
                    && editText4.getText().toString().equals("К")
                    && editText5.getText().toString().equals("О")
                    && editText6.getText().toString().equals("Н");
        }
        if(int_text==1){
            return editText1.getText().toString().equals("У") && editText2.getText().toString().equals("Ч")
                    && editText3.getText().toString().equals("Ё")
                    && editText4.getText().toString().equals("Н")
                    && editText5.getText().toString().equals("Ы")
                    && editText6.getText().toString().equals("Й");
        }
        if(int_text==2){
            return editText1.getText().toString().equals("Д") && editText2.getText().toString().equals("О")
                    && editText3.getText().toString().equals("К")
                    && editText4.getText().toString().equals("Т")
                    && editText5.getText().toString().equals("О")
                    && editText6.getText().toString().equals("Р");
        }
        return false;
    }

    private void setMistace(int int_text, EditText editText1,EditText editText2,EditText editText3,EditText editText4,EditText editText5,EditText editText6){
        if(int_text==0){
            if(editText1.getText().toString().equals("Д")){editText1.setTextColor(0xFF00FF00);}
            else{editText1.setTextColor(0xFFF44336);}

            if(editText2.getText().toString().equals("Р")){editText2.setTextColor(0xFF00FF00);}
            else{editText2.setTextColor(0xFFF44336);}

            if(editText3.getText().toString().equals("А")){editText3.setTextColor(0xFF00FF00);}
            else{editText3.setTextColor(0xFFF44336);}

            if(editText4.getText().toString().equals("К")){editText4.setTextColor(0xFF00FF00);}
            else{editText4.setTextColor(0xFFF44336);}

            if(editText5.getText().toString().equals("О")){editText5.setTextColor(0xFF00FF00);}
            else{editText5.setTextColor(0xFFF44336);}

            if(editText6.getText().toString().equals("Н")){editText6.setTextColor(0xFF00FF00);}
            else{editText6.setTextColor(0xFFF44336);}
        }

        if(int_text==1){
            if(editText1.getText().toString().equals("У")){editText1.setTextColor(0xFF00FF00);}
            else{editText1.setTextColor(0xFFF44336);}

            if(editText2.getText().toString().equals("Ч")){editText2.setTextColor(0xFF00FF00);}
            else{editText2.setTextColor(0xFFF44336);}

            if(editText3.getText().toString().equals("Ё")){editText3.setTextColor(0xFF00FF00);}
            else{editText3.setTextColor(0xFFF44336);}

            if(editText4.getText().toString().equals("Н")){editText4.setTextColor(0xFF00FF00);}
            else{editText4.setTextColor(0xFFF44336);}

            if(editText5.getText().toString().equals("Ы")){editText5.setTextColor(0xFF00FF00);}
            else{editText5.setTextColor(0xFFF44336);}

            if(editText6.getText().toString().equals("Й")){editText6.setTextColor(0xFF00FF00);}
            else{editText6.setTextColor(0xFFF44336);}
        }

        if(int_text==0){
            if(editText1.getText().toString().equals("Д")){editText1.setTextColor(0xFF00FF00);}
            else{editText1.setTextColor(0xFFF44336);}

            if(editText2.getText().toString().equals("О")){editText2.setTextColor(0xFF00FF00);}
            else{editText2.setTextColor(0xFFF44336);}

            if(editText3.getText().toString().equals("К")){editText3.setTextColor(0xFF00FF00);}
            else{editText3.setTextColor(0xFFF44336);}

            if(editText4.getText().toString().equals("Т")){editText4.setTextColor(0xFF00FF00);}
            else{editText4.setTextColor(0xFFF44336);}

            if(editText5.getText().toString().equals("О")){editText5.setTextColor(0xFF00FF00);}
            else{editText5.setTextColor(0xFFF44336);}

            if(editText6.getText().toString().equals("Р")){editText6.setTextColor(0xFF00FF00);}
            else{editText6.setTextColor(0xFFF44336);}
        }
    }

    private void createDialog(){
        Dialog dialog = new Dialog(Level7.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>7){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), Level8.class);
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

    private void createExite(){
        Dialog dialog = new Dialog(Level7.this);
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