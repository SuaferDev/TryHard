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

public class HardLevel4 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;
    private EditText edittext1, edittext2, edittext3, edittext4, edittext5, edittext6, edittext7, edittext8, edittext9, edittext10, edittext11,
    edittext12, edittext13, edittext14, edittext15, edittext16, edittext17, edittext18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level4);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        edittext1 = findViewById(R.id.edittext1); edittext2 = findViewById(R.id.edittext2); edittext3 = findViewById(R.id.edittext3);
        edittext4 = findViewById(R.id.edittext4); edittext5 = findViewById(R.id.edittext5); edittext6 = findViewById(R.id.edittext6);
        edittext7 = findViewById(R.id.edittext7); edittext8 = findViewById(R.id.edittext8); edittext9 = findViewById(R.id.edittext9);
        edittext10 = findViewById(R.id.edittext10); edittext11 = findViewById(R.id.edittext11); edittext12 = findViewById(R.id.edittext12);
        edittext13 = findViewById(R.id.edittext13); edittext14 = findViewById(R.id.edittext14); edittext15 = findViewById(R.id.edittext15);
        edittext16 = findViewById(R.id.edittext16); edittext17 = findViewById(R.id.edittext17); edittext18 = findViewById(R.id.edittext18);
        ImageView imageendlevel = findViewById(R.id.imageendlevel); ImageView imageback = findViewById(R.id.imageback);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });

        imageendlevel.setOnClickListener(view ->{
            if(check()){createDialog();}
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
                if(edittext10.getText().toString().length()==1){edittext11.requestFocus();}
                if(checkToClose()){edittext10.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext10.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext11.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
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
                if(checkToClose()){edittext12.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext12.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext13.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext13.setTextColor(0xFFFFFFFF);
                if(edittext13.getText().toString().length()==1){edittext14.requestFocus();}
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
                if(checkToClose()){edittext14.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext14.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext15.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext15.setTextColor(0xFFFFFFFF);
                if(edittext15.getText().toString().length()==1){edittext16.requestFocus();}
                if(checkToClose()){edittext15.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext15.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext16.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext16.setTextColor(0xFFFFFFFF);
                if(edittext16.getText().toString().length()==1){edittext17.requestFocus();}
                if(checkToClose()){edittext16.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext16.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext17.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext17.setTextColor(0xFFFFFFFF);
                if(edittext17.getText().toString().length()==1){edittext18.requestFocus();}
                if(checkToClose()){edittext17.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext17.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext18.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edittext18.setTextColor(0xFFFFFFFF);
                if(checkToClose()){edittext18.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext18.getWindowToken(), 0);}}
            @Override public void afterTextChanged(Editable editable) {}
        });

    }
    
    private boolean check(){
        if(edittext1.getText().toString().equals("5")){edittext1.setTextColor(0xFF00FF00);
        }else{edittext1.setTextColor(0xFFF44336); return false;}

        if(edittext2.getText().toString().equals("3")){edittext2.setTextColor(0xFF00FF00);
        }else{edittext2.setTextColor(0xFFF44336); return false;}

        if(edittext3.getText().toString().equals("4")){edittext3.setTextColor(0xFF00FF00);
        }else{edittext3.setTextColor(0xFFF44336); return false;}

        if(edittext4.getText().toString().equals("2")){edittext4.setTextColor(0xFF00FF00);
        }else{edittext4.setTextColor(0xFFF44336); return false;}

        if(edittext5.getText().toString().equals("4")){edittext5.setTextColor(0xFF00FF00);
        }else{edittext5.setTextColor(0xFFF44336); return false;}

        if(edittext6.getText().toString().equals("2")){edittext6.setTextColor(0xFF00FF00);
        }else{edittext6.setTextColor(0xFFF44336); return false;}

        if(edittext7.getText().toString().equals("5")){edittext7.setTextColor(0xFF00FF00);
        }else{edittext7.setTextColor(0xFFF44336); return false;}

        if(edittext8.getText().toString().equals("1")){edittext8.setTextColor(0xFF00FF00);
        }else{edittext8.setTextColor(0xFFF44336); return false;}

        if(edittext9.getText().toString().equals("2")){edittext9.setTextColor(0xFF00FF00);
        }else{edittext9.setTextColor(0xFFF44336); return false;}

        if(edittext10.getText().toString().equals("3")){edittext10.setTextColor(0xFF00FF00);
        }else{edittext10.setTextColor(0xFFF44336); return false;}

        if(edittext11.getText().toString().equals("1")){edittext11.setTextColor(0xFF00FF00);
        }else{edittext11.setTextColor(0xFFF44336); return false;}

        if(edittext12.getText().toString().equals("5")){edittext12.setTextColor(0xFF00FF00);
        }else{edittext12.setTextColor(0xFFF44336); return false;}

        if(edittext13.getText().toString().equals("4")){edittext13.setTextColor(0xFF00FF00);
        }else{edittext13.setTextColor(0xFFF44336); return false;}

        if(edittext14.getText().toString().equals("2")){edittext14.setTextColor(0xFF00FF00);
        }else{edittext14.setTextColor(0xFFF44336); return false;}

        if(edittext15.getText().toString().equals("3")){edittext15.setTextColor(0xFF00FF00);
        }else{edittext15.setTextColor(0xFFF44336); return false;}

        if(edittext16.getText().toString().equals("5")){edittext16.setTextColor(0xFF00FF00);
        }else{edittext16.setTextColor(0xFFF44336); return false;}

        if(edittext17.getText().toString().equals("1")){edittext17.setTextColor(0xFF00FF00);
        }else{edittext17.setTextColor(0xFFF44336); return false;}

        if(edittext18.getText().toString().equals("2")){edittext18.setTextColor(0xFF00FF00);
        }else{edittext18.setTextColor(0xFFF44336); return false;}
        
        return true;
    }

    private boolean checkToClose(){
        return edittext1.getText().toString().length()!=0 && edittext2.getText().toString().length()!=0 && edittext3.getText().toString().length()!=0
                && edittext4.getText().toString().length()!= 0 && edittext5.getText().toString().length()!=0 &&
                edittext6.getText().toString().length()!=0 && edittext7.getText().toString().length()!=0 && edittext8.getText().toString().length()!=0
                && edittext9.getText().toString().length()!=0 && edittext10.getText().toString().length()!=0 && edittext11.getText().toString().length()!=0 &&
        edittext12.getText().toString().length()!=0 && edittext13.getText().toString().length()!=0 && edittext14.getText().toString().length()!=0 &&
                edittext15.getText().toString().length()!=0 && edittext16.getText().toString().length()!=0 && edittext17.getText().toString().length()!=0 &&
                edittext18.getText().toString().length()!=0;
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel4.this);
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
            i.setClass(getApplicationContext(), HardLevel5.class);
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
        Dialog dialog = new Dialog(HardLevel4.this);
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