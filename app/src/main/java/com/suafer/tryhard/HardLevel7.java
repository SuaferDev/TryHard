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
import android.widget.TextView;

import com.suafer.tryhard.R;

public class HardLevel7 extends AppCompatActivity {

    TextView textinfo, textnext, texttomenu;
    TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;
    private EditText edittext11, edittext12, edittext13, edittext14, edittext15, edittext16, edittext17, edittext18, edittext19, edittext110,
            edittext111, edittext21, edittext22, edittext23, edittext24, edittext25, edittext26;
    private int int_text=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level7);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        ImageView imageupdate = findViewById(R.id.imageupdate);
        ImageView imageback = findViewById(R.id.imageback);
        TextView textsmile = findViewById(R.id.textsmile);
        edittext11 = findViewById(R.id.edittext11); edittext12 = findViewById(R.id.edittext12); edittext13 = findViewById(R.id.edittext13);
        edittext14 = findViewById(R.id.edittext14); edittext15 = findViewById(R.id.edittext15); edittext16 = findViewById(R.id.edittext16);
        edittext17 = findViewById(R.id.edittext17); edittext18 = findViewById(R.id.edittext18); edittext19 = findViewById(R.id.edittext19);
        edittext110 = findViewById(R.id.edittext110); edittext111 = findViewById(R.id.edittext111);
        edittext21 = findViewById(R.id.edittext21); edittext22 = findViewById(R.id.edittext22); edittext23 = findViewById(R.id.edittext23);
        edittext24 = findViewById(R.id.edittext24); edittext25 = findViewById(R.id.edittext25); edittext26 = findViewById(R.id.edittext26);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
        });

        imageupdate.setOnClickListener(view -> {
            if(int_text==0){
                int_text=1;
                textsmile.setText("\uD83D\uDCE1\n");
            }else{
                if(int_text==1) {
                    int_text = 2;
                    textsmile.setText("\uD83C\uDFEB\uD83D\uDCDA\uD83D\uDCD6\uD83D\uDC68\u200D\uD83C\uDF93\n");
                }else{
                    if(int_text==2){
                        int_text=0;
                        textsmile.setText("\uD83C\uDFD6✈\uD83D\uDEF3\uD83E\uDDF3");
                    }
                }
            }
            edittext11.setTextColor(0xFFFFFFFF); edittext12.setTextColor(0xFFFFFFFF); edittext13.setTextColor(0xFFFFFFFF);
            edittext14.setTextColor(0xFFFFFFFF); edittext15.setTextColor(0xFFFFFFFF); edittext16.setTextColor(0xFFFFFFFF);
            edittext17.setTextColor(0xFFFFFFFF); edittext18.setTextColor(0xFFFFFFFF); edittext19.setTextColor(0xFFFFFFFF);
            edittext110.setTextColor(0xFFFFFFFF); edittext111.setTextColor(0xFFFFFFFF);

            edittext21.setTextColor(0xFFFFFFFF); edittext22.setTextColor(0xFFFFFFFF); edittext23.setTextColor(0xFFFFFFFF);
            edittext24.setTextColor(0xFFFFFFFF); edittext25.setTextColor(0xFFFFFFFF); edittext26.setTextColor(0xFFFFFFFF);
        });

        edittext11.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext11.getText().toString().length()==1){edittext12.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext12.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext12.getText().toString().length()==1){edittext13.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext13.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext13.getText().toString().length()==1){edittext14.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext14.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext14.getText().toString().length()==1){edittext15.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext15.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext15.getText().toString().length()==1){edittext16.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });
        edittext16.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext16.getText().toString().length()==1){edittext17.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext17.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext17.getText().toString().length()==1){edittext18.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext18.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext18.getText().toString().length()==1){edittext19.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext19.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext19.getText().toString().length()==1){edittext110.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext110.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext110.getText().toString().length()==1){edittext111.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext111.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext111.getText().toString().length()==1){edittext21.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext21.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext21.getText().toString().length()==1){edittext22.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext22.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext22.getText().toString().length()==1){edittext23.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext23.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext23.getText().toString().length()==1){edittext24.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext24.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext24.getText().toString().length()==1){edittext25.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext25.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(edittext25.getText().toString().length()==1){edittext26.requestFocus();}
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });

        edittext26.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(check()){
                    createDialog();
                }}
            @Override public void afterTextChanged(Editable editable) {
            }
        });



    }

    private boolean check(){
        boolean check = true;
        if(int_text==0){
            if(edittext11.getText().toString().equals("П")){
                edittext11.setTextColor(0xFF00FF00);
            }else{edittext11.setTextColor(0xFFF44336); check = false;}

            if(edittext12.getText().toString().equals("У")){
                edittext12.setTextColor(0xFF00FF00);
            }else{edittext12.setTextColor(0xFFF44336); check = false;}

            if(edittext13.getText().toString().equals("Т")){
                edittext13.setTextColor(0xFF00FF00);
            }else{edittext13.setTextColor(0xFFF44336); check = false;}

            if(edittext14.getText().toString().equals("Е")){
                edittext14.setTextColor(0xFF00FF00);
            }else{edittext14.setTextColor(0xFFF44336); check = false;}

            if(edittext15.getText().toString().equals("Ш")){
                edittext15.setTextColor(0xFF00FF00);
            }else{edittext15.setTextColor(0xFFF44336); check = false;}

            if(edittext16.getText().toString().equals("Е")){
                edittext16.setTextColor(0xFF00FF00);
            }else{edittext16.setTextColor(0xFFF44336); check = false;}

            if(edittext17.getText().toString().equals("С")){
                edittext17.setTextColor(0xFF00FF00);
            }else{edittext17.setTextColor(0xFFF44336); check = false;}

            if(edittext18.getText().toString().equals("Т")){
                edittext18.setTextColor(0xFF00FF00);
            }else{edittext18.setTextColor(0xFFF44336); check = false;}

            if(edittext19.getText().toString().equals("В")){
                edittext19.setTextColor(0xFF00FF00);
            }else{edittext19.setTextColor(0xFFF44336); check = false;}

            if(edittext110.getText().toString().equals("И")){
                edittext110.setTextColor(0xFF00FF00);
            }else{edittext110.setTextColor(0xFFF44336); check = false;}

            if(edittext111.getText().toString().equals("Е")){
                edittext111.setTextColor(0xFF00FF00);
            }else{edittext111.setTextColor(0xFFF44336); check = false;}

            if(edittext21.getText().toString().equals("Т")){
                edittext21.setTextColor(0xFF00FF00);
            }else{edittext21.setTextColor(0xFFF44336); check = false;}

            if(edittext22.getText().toString().equals("У")){
                edittext22.setTextColor(0xFF00FF00);
            }else{edittext22.setTextColor(0xFFF44336); check = false;}

            if(edittext23.getText().toString().equals("Р")){
                edittext23.setTextColor(0xFF00FF00);
            }else{edittext23.setTextColor(0xFFF44336); check = false;}

            if(edittext24.getText().toString().equals("И")){
                edittext24.setTextColor(0xFF00FF00);
            }else{edittext24.setTextColor(0xFFF44336); check = false;}

            if(edittext25.getText().toString().equals("З")){
                edittext25.setTextColor(0xFF00FF00);
            }else{edittext25.setTextColor(0xFFF44336); check = false;}

            if(edittext26.getText().toString().equals("М")){
                edittext26.setTextColor(0xFF00FF00);
            }else{edittext26.setTextColor(0xFFF44336); check = false;}

            return check;
        }
        if(int_text==1){
            if(edittext11.getText().toString().equals("Р")){
                edittext11.setTextColor(0xFF00FF00);
            }else{edittext11.setTextColor(0xFFF44336); check = false;}

            if(edittext12.getText().toString().equals("А")){
                edittext12.setTextColor(0xFF00FF00);
            }else{edittext12.setTextColor(0xFFF44336); check = false;}

            if(edittext13.getText().toString().equals("Д")){
                edittext13.setTextColor(0xFF00FF00);
            }else{edittext13.setTextColor(0xFFF44336); check = false;}

            if(edittext14.getText().toString().equals("И")){
                edittext14.setTextColor(0xFF00FF00);
            }else{edittext14.setTextColor(0xFFF44336); check = false;}

            if(edittext15.getText().toString().equals("О")){
                edittext15.setTextColor(0xFF00FF00);
            }else{edittext15.setTextColor(0xFFF44336); check = false;}

            if(edittext16.getText().toString().equals("С")){
                edittext16.setTextColor(0xFF00FF00);
            }else{edittext16.setTextColor(0xFFF44336); check = false;}

            if(edittext17.getText().toString().equals("И")){
                edittext17.setTextColor(0xFF00FF00);
            }else{edittext17.setTextColor(0xFFF44336); check = false;}

            if(edittext18.getText().toString().equals("Г")){
                edittext18.setTextColor(0xFF00FF00);
            }else{edittext18.setTextColor(0xFFF44336); check = false;}

            if(edittext19.getText().toString().equals("Н")){
                edittext19.setTextColor(0xFF00FF00);
            }else{edittext19.setTextColor(0xFFF44336); check = false;}

            if(edittext110.getText().toString().equals("А")){
                edittext110.setTextColor(0xFF00FF00);
            }else{edittext110.setTextColor(0xFFF44336); check = false;}

            if(edittext111.getText().toString().equals("Л")){
                edittext111.setTextColor(0xFF00FF00);
            }else{edittext111.setTextColor(0xFFF44336); check = false;}

            if(edittext21.getText().toString().equals("П")){
                edittext21.setTextColor(0xFF00FF00);
            }else{edittext21.setTextColor(0xFFF44336); check = false;}

            if(edittext22.getText().toString().equals("О")){
                edittext22.setTextColor(0xFF00FF00);
            }else{edittext22.setTextColor(0xFFF44336); check = false;}

            if(edittext23.getText().toString().equals("М")){
                edittext23.setTextColor(0xFF00FF00);
            }else{edittext23.setTextColor(0xFFF44336); check = false;}

            if(edittext24.getText().toString().equals("Е")){
                edittext24.setTextColor(0xFF00FF00);
            }else{edittext24.setTextColor(0xFFF44336); check = false;}

            if(edittext25.getText().toString().equals("Х")){
                edittext25.setTextColor(0xFF00FF00);
            }else{edittext25.setTextColor(0xFFF44336); check = false;}

            if(edittext26.getText().toString().equals("И")){
                edittext26.setTextColor(0xFF00FF00);
            }else{edittext26.setTextColor(0xFFF44336); check = false;}
            return check;
        }
        if(int_text==2){
            if(edittext11.getText().toString().equals("О")){
                edittext11.setTextColor(0xFF00FF00);
            }else{edittext11.setTextColor(0xFFF44336); check = false;}

            if(edittext12.getText().toString().equals("Б")){
                edittext12.setTextColor(0xFF00FF00);
            }else{edittext12.setTextColor(0xFFF44336); check = false;}

            if(edittext13.getText().toString().equals("Р")){
                edittext13.setTextColor(0xFF00FF00);
            }else{edittext13.setTextColor(0xFFF44336); check = false;}

            if(edittext14.getText().toString().equals("А")){
                edittext14.setTextColor(0xFF00FF00);
            }else{edittext14.setTextColor(0xFFF44336); check = false;}

            if(edittext15.getText().toString().equals("З")){
                edittext15.setTextColor(0xFF00FF00);
            }else{edittext15.setTextColor(0xFFF44336); check = false;}

            if(edittext16.getText().toString().equals("О")){
                edittext16.setTextColor(0xFF00FF00);
            }else{edittext16.setTextColor(0xFFF44336); check = false;}

            if(edittext17.getText().toString().equals("В")){
                edittext17.setTextColor(0xFF00FF00);
            }else{edittext17.setTextColor(0xFFF44336); check = false;}

            if(edittext18.getText().toString().equals("А")){
                edittext18.setTextColor(0xFF00FF00);
            }else{edittext18.setTextColor(0xFFF44336); check = false;}

            if(edittext19.getText().toString().equals("Н")){
                edittext19.setTextColor(0xFF00FF00);
            }else{edittext19.setTextColor(0xFFF44336); check = false;}

            if(edittext110.getText().toString().equals("И")){
                edittext110.setTextColor(0xFF00FF00);
            }else{edittext110.setTextColor(0xFFF44336); check = false;}

            if(edittext111.getText().toString().equals("Е")){
                edittext111.setTextColor(0xFF00FF00);
            }else{edittext111.setTextColor(0xFFF44336); check = false;}

            if(edittext21.getText().toString().equals("З")){
                edittext21.setTextColor(0xFF00FF00);
            }else{edittext21.setTextColor(0xFFF44336); check = false;}

            if(edittext22.getText().toString().equals("Н")){
                edittext22.setTextColor(0xFF00FF00);
            }else{edittext22.setTextColor(0xFFF44336); check = false;}

            if(edittext23.getText().toString().equals("А")){
                edittext23.setTextColor(0xFF00FF00);
            }else{edittext23.setTextColor(0xFFF44336); check = false;}

            if(edittext24.getText().toString().equals("Н")){
                edittext24.setTextColor(0xFF00FF00);
            }else{edittext24.setTextColor(0xFFF44336); check = false;}

            if(edittext25.getText().toString().equals("И")){
                edittext25.setTextColor(0xFF00FF00);
            }else{edittext25.setTextColor(0xFFF44336); check = false;}

            if(edittext26.getText().toString().equals("Я")){
                edittext26.setTextColor(0xFF00FF00);
            }else{edittext26.setTextColor(0xFFF44336); check = false;}
            return check;
        }
        return false;
    }


    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel7.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>7){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel8.class);
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
        Dialog dialog = new Dialog(HardLevel7.this);
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