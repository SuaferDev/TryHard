package com.suafer.tryhard;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.suafer.tryhard.R;

public class HardLevel6 extends AppCompatActivity {

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
        setContentView(R.layout.activity_hard_level6);

        ImageView imageback = findViewById(R.id.imageback);
        EditText edittext1 = findViewById(R.id.edittext1);
        EditText edittext2 = findViewById(R.id.edittext2);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
        });

        edittext1.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if((edittext1.getText().toString().equals("Л") || edittext1.getText().toString().equals("л")) &&
                        (edittext2.getText().toString().equals("Н") || edittext2.getText().toString().equals("н"))){
                    createDialog();
                }
                if(edittext1.getText().toString().length()==1){edittext2.requestFocus();}
            }
            @Override public void afterTextChanged(Editable editable) {}
        });

        edittext2.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if((edittext1.getText().toString().equals("Л") || edittext1.getText().toString().equals("л")) &&
                        (edittext2.getText().toString().equals("Н") || edittext2.getText().toString().equals("н"))){
                    createDialog();
                }
                if(edittext2.getText().toString().length()==1){edittext1.requestFocus();}
            }
            @Override public void afterTextChanged(Editable editable) {}
        });
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel6.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>6){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel7.class);
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
        Dialog dialog = new Dialog(HardLevel6.this);
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