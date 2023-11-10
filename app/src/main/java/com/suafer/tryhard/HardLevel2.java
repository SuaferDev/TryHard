package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.Toast;

import com.suafer.tryhard.R;

public class HardLevel2 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;

    private int z=0;

    private TextView textvalue1,textvalue2,textoperation,edittext;

    private int count = 0;

    private int val1, val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level2);

        TextView button0 = findViewById(R.id.button0);
        TextView button1 = findViewById(R.id.button1);
        TextView button2 = findViewById(R.id.button2);
        TextView button3 = findViewById(R.id.button3);
        TextView button4 = findViewById(R.id.button4);
        TextView button5 = findViewById(R.id.button5);
        TextView button6 = findViewById(R.id.button6);
        TextView button7 = findViewById(R.id.button7);
        TextView button8 = findViewById(R.id.button8);
        TextView button9 = findViewById(R.id.button9);
        ImageView imageback = findViewById(R.id.imageback);
        TextView textcount = findViewById(R.id.textcount);
        TextView buttonminus = findViewById(R.id.buttonminus);
        TextView buttonclear = findViewById(R.id.buttonclear);
        TextView buttonravno = findViewById(R.id.buttonravno);
        LinearLayout linearnavigation = findViewById(R.id.linearnavigation);
        edittext = findViewById(R.id.edittext);
        textvalue1 = findViewById(R.id.textvalue1);
        textvalue2 = findViewById(R.id.textvalue2);
        textoperation = findViewById(R.id.textoperation);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        linearnavigation.startAnimation(mFadeInAnimation);

        random();

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });

        button0.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"0");}});
        button1.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"1");}});
        button2.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"2");}});
        button3.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"3");}});
        button4.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"4");}});
        button5.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"5");}});
        button6.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"6");}});
        button7.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"7");}});
        button8.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"8");}
        });
        button9.setOnClickListener(view -> {
            if(edittext.getText().length()<4){edittext.setText(edittext.getText()+"9");}
        });
        buttonminus.setOnClickListener(view -> {
            if(edittext.getText().toString().length()==0){
                edittext.setText("-"+edittext.getText());
            }else{
                if(edittext.getText().charAt(0)!='-'){
                    edittext.setText("-"+edittext.getText());
                }else{
                    String s = "";
                    for(int i=1; i<edittext.getText().length();i++){
                        s=s+edittext.getText().charAt(i);
                    }
                    edittext.setText("");
                    edittext.setText(s);
                }
            }
        });
        buttonclear.setOnClickListener(view -> {edittext.setText("");});
        buttonravno.setOnClickListener(view -> {
            if(textoperation.getText()=="+" && edittext.getText()!=""){
                if(val1+val2==Integer.parseInt((String) edittext.getText())){
                    count++;
                    textcount.setText(count+"/5");
                    if(count==5){
                        createDialog();
                    }else{random();}
                }else{
                    Toast.makeText(HardLevel2.this,"Ошибка",Toast.LENGTH_LONG).show();
                    count=0;
                    textcount.setText(count+"/5");
                }
            }else{
                if(textoperation.getText()=="-" && edittext.getText()!=""){
                    if(val1-val2==Integer.parseInt((String) edittext.getText())){
                        count++;
                        textcount.setText(count+"/5");
                        if(count==5){
                            createDialog();
                        }else{random();}
                    }else{
                        Toast.makeText(HardLevel2.this,"Ошибка",Toast.LENGTH_LONG).show();
                        count=0;
                        textcount.setText(count+"/5");
                    }
                }
            }
        });
    }

    private void random(){
        val1 = (int) (1+Math.random()*300);
        val2 = (int) (1+Math.random()*300);
        textvalue1.setText(String.valueOf(val1));
        textvalue2.setText(String.valueOf(val2));
        z = (int) (1+Math.random()*2);
        edittext.setText("");
        if (z==1){textoperation.setText("+");}
        if (z==2){textoperation.setText("-");}
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel2.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>2){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel3.class);
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
        Dialog dialog = new Dialog(HardLevel2.this);
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