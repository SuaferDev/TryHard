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

import com.suafer.tryhard.R;

public class HardLevel9 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;
    private int x=6; private int y=4;
    private TextView fieldNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level9);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        ImageView imageback = findViewById(R.id.imageback);
        TextView field11 = findViewById(R.id.field11); TextView field31 = findViewById(R.id.field31); TextView field16 = findViewById(R.id.field16);
        TextView field12 = findViewById(R.id.field12); TextView field32 = findViewById(R.id.field32); TextView field26 = findViewById(R.id.field26);
        TextView field13 = findViewById(R.id.field13); TextView field33 = findViewById(R.id.field33); TextView field36 = findViewById(R.id.field36);
        TextView field14 = findViewById(R.id.field14); TextView field34 = findViewById(R.id.field34); TextView field46 = findViewById(R.id.field46);
        TextView field15 = findViewById(R.id.field15); TextView field35 = findViewById(R.id.field35); TextView field56 = findViewById(R.id.field56);
        TextView field21 = findViewById(R.id.field21); TextView field41 = findViewById(R.id.field41);
        TextView field22 = findViewById(R.id.field22); TextView field42 = findViewById(R.id.field42);
        TextView field23 = findViewById(R.id.field23); TextView field43 = findViewById(R.id.field43);
        TextView field24 = findViewById(R.id.field24); TextView field44 = findViewById(R.id.field44);
        TextView field25 = findViewById(R.id.field25); TextView field45 = findViewById(R.id.field45);
        TextView field51 = findViewById(R.id.field51); TextView field54 = findViewById(R.id.field54);
        TextView field52 = findViewById(R.id.field52); TextView field55 = findViewById(R.id.field55);
        TextView field53 = findViewById(R.id.field53); TextView field61 = findViewById(R.id.field61);
        TextView field62 = findViewById(R.id.field62); TextView field63 = findViewById(R.id.field63);
        TextView field64 = findViewById(R.id.field64); TextView field65 = findViewById(R.id.field65);
        TextView field66 = findViewById(R.id.field66);
        fieldNow = field64;

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
            finish();
        });

        field11.setOnClickListener(view -> {
            if(checkField(x,y,1,1)){
                x=1; y=1;
                field11.setText("♘");
                fieldNow.setText("");
                fieldNow=field11;
            }
        });
        field12.setOnClickListener(view -> {
            if(checkField(x,y,1,2)){
                x=1; y=2;
                field12.setText("♘");
                fieldNow.setText("");
                fieldNow=field12;
            }
        });
        field13.setOnClickListener(view -> {
            if(checkField(x,y,1,3)){
                x=1; y=3;
                field13.setText("♘");
                fieldNow.setText("");
                fieldNow=field13;
            }
        });
        field14.setOnClickListener(view -> {
            if(checkField(x,y,1,4)){
                x=1; y=4;
                field14.setText("♘");
                fieldNow.setText("");
                fieldNow=field14;
            }
        });
        field15.setOnClickListener(view -> {
            if(checkField(x,y,1,5)){
                x=1; y=5;
                field15.setText("♘");
                fieldNow.setText("");
                fieldNow=field15;
            }
        });
        field16.setOnClickListener(view -> {
            if(checkField(x,y,1,6)){
                x=1; y=6;
                field16.setText("♘");
                fieldNow.setText("");
                fieldNow=field16;
            }
        });

        field21.setOnClickListener(view -> {
            if(checkField(x,y,2,1)){
                x=2; y=1;
                field21.setText("♘");
                fieldNow.setText("");
                fieldNow=field21;
            }
        });
        field22.setOnClickListener(view -> {
            if(checkField(x,y,2,2)){
                x=2; y=2;
                field22.setText("♘");
                fieldNow.setText("");
                fieldNow=field22;
            }
        });
        field23.setOnClickListener(view -> {
            if(checkField(x,y,2,3)){
                x=2; y=3;
                field23.setText("♘");
                fieldNow.setText("");
                fieldNow=field23;
            }
        });
        field24.setOnClickListener(view -> {
            if(checkField(x,y,2,4)){
                x=2; y=4;
                field24.setText("♘");
                fieldNow.setText("");
                fieldNow=field24;
            }
        });
        field25.setOnClickListener(view -> {
            if(checkField(x,y,2,5)){
                x=2; y=5;
                field25.setText("♘");
                fieldNow.setText("");
                fieldNow=field25;
            }
        });
        field26.setOnClickListener(view -> {
            if(checkField(x,y,2,6)){
                x=2; y=6;
                field26.setText("♘");
                fieldNow.setText("");
                fieldNow=field26;
            }
        });

        field31.setOnClickListener(view -> {
            if(checkField(x,y,3,1)){
                x=3; y=1;
                field31.setText("♘");
                fieldNow.setText("");
                fieldNow=field31;
            }
        });
        field32.setOnClickListener(view -> {
            if(checkField(x,y,3,2)){
                x=3; y=2;
                field32.setText("♘");
                fieldNow.setText("");
                fieldNow=field32;
            }
        });
        field33.setOnClickListener(view -> {
            if(checkField(x,y,3,3)){
                x=3; y=3;
                field33.setText("♘");
                fieldNow.setText("");
                fieldNow=field33;
            }
        });
        field34.setOnClickListener(view -> {
            if(checkField(x,y,3,4)){
                x=3; y=4;
                field34.setText("♘");
                fieldNow.setText("");
                fieldNow=field34;
            }
        });
        field35.setOnClickListener(view -> {
            if(checkField(x,y,3,5)){
                x=3; y=5;
                field35.setText("♘");
                fieldNow.setText("");
                fieldNow=field35;
            }
        });
        field36.setOnClickListener(view -> {
            if(checkField(x,y,3,6)){
                x=3; y=6;
                field36.setText("♘");
                fieldNow.setText("");
                fieldNow=field36;
            }
        });

        field41.setOnClickListener(view -> {
            if(checkField(x,y,4,1)){
                x=4; y=1;
                field41.setText("♘");
                fieldNow.setText("");
                fieldNow=field41;
            }
        });
        field42.setOnClickListener(view -> {
            if(checkField(x,y,4,2)){
                x=4; y=2;
                field42.setText("♘");
                fieldNow.setText("");
                fieldNow=field42;
            }
        });
        field43.setOnClickListener(view -> {
            if(checkField(x,y,4,3)){
                x=4; y=3;
                field43.setText("♘");
                fieldNow.setText("");
                fieldNow=field43;
            }
        });
        field44.setOnClickListener(view -> {
            if(checkField(x,y,4,4)){
                x=4; y=4;
                field44.setText("♘");
                fieldNow.setText("");
                fieldNow=field44;
            }
        });
        field45.setOnClickListener(view -> {
            if(checkField(x,y,4,5)){
                x=4; y=5;
                field45.setText("♘");
                fieldNow.setText("");
                fieldNow=field45;
            }
        });
        field46.setOnClickListener(view -> {
            if(checkField(x,y,4,6)){
                x=4; y=6;
                field46.setText("♘");
                fieldNow.setText("");
                fieldNow=field46;
            }
        });

        field51.setOnClickListener(view -> {
            if(checkField(x,y,5,1)){
                x=5; y=1;
                field51.setText("♘");
                fieldNow.setText("");
                fieldNow=field51;
                createDialog();
            }
        });
        field52.setOnClickListener(view -> {
            if(checkField(x,y,5,2)){
                x=5; y=2;
                field52.setText("♘");
                fieldNow.setText("");
                fieldNow=field52;
            }
        });
        field53.setOnClickListener(view -> {
            if(checkField(x,y,5,3)){
                x=5; y=3;
                field53.setText("♘");
                fieldNow.setText("");
                fieldNow=field53;
            }
        });
        field54.setOnClickListener(view -> {
            if(checkField(x,y,5,4)){
                x=5; y=4;
                field54.setText("♘");
                fieldNow.setText("");
                fieldNow=field54;
            }
        });
        field55.setOnClickListener(view -> {
            if(checkField(x,y,5,5)){
                x=5; y=5;
                field55.setText("♘");
                fieldNow.setText("");
                fieldNow=field55;
            }
        });
        field56.setOnClickListener(view -> {
            if(checkField(x,y,5,6)){
                x=5; y=6;
                field56.setText("♘");
                fieldNow.setText("");
                fieldNow=field56;
            }
        });

        field61.setOnClickListener(view -> {
            if(checkField(x,y,6,1)){
                x=6; y=1;
                field61.setText("♘");
                fieldNow.setText("");
                fieldNow=field61;
                createDialog();
            }
        });
        field62.setOnClickListener(view -> {
            if(checkField(x,y,6,2)){
                x=6; y=2;
                field62.setText("♘");
                fieldNow.setText("");
                fieldNow=field62;
            }
        });
        field63.setOnClickListener(view -> {
            if(checkField(x,y,6,3)){
                x=6; y=3;
                field63.setText("♘");
                fieldNow.setText("");
                fieldNow=field63;
                createDialog();
            }
        });
        field64.setOnClickListener(view -> {
            if(checkField(x,y,6,4)){
                x=6; y=4;
                field64.setText("♘");
                fieldNow.setText("");
                fieldNow=field64;
            }
        });
        field65.setOnClickListener(view -> {
            if(checkField(x,y,6,5)){
                x=6; y=5;
                field66.setText("♘");
                fieldNow.setText("");
                fieldNow=field66;
            }
        });
        field66.setOnClickListener(view -> {
            if(checkField(x,y,6,6)){
                x=6; y=6;
                field66.setText("♘");
                fieldNow.setText("");
                fieldNow=field66;
            }
        });
    }

    private boolean checkField(int x1,int y1, int x2, int y2){
        return (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2);
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel9.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>9){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel10.class);
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
        Dialog dialog = new Dialog(HardLevel9.this);
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