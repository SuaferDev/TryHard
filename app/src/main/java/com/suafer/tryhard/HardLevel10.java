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

public class HardLevel10 extends AppCompatActivity {

    TextView textinfo, textnext, texttomenu;
    TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;
    /*
    1->7     5->16    9->2      13->15
    2->10    6->9     10->4     14->13
    3->8     7->5     11->14    15->3
    4->1     8->6     12->12    16->11
     */
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level10);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        ImageView imageback = findViewById(R.id.imageback);
        image1 = findViewById(R.id.image1); image2 = findViewById(R.id.image2); image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4); image5 = findViewById(R.id.image5); image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7); image8 = findViewById(R.id.image8); image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10); image11 = findViewById(R.id.image11); image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14); image15 = findViewById(R.id.image15); image16 = findViewById(R.id.image16);
        image12 = findViewById(R.id.image12);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
        });

        image1.setOnClickListener(view ->{
            image7.setRotation(getRotation(image7.getRotation()));
            if(check())createDialog();
        });

        image2.setOnClickListener(view ->{
            image10.setRotation(getRotation(image10.getRotation()));
            if(check())createDialog();
        });

        image3.setOnClickListener(view ->{
            image8.setRotation(getRotation(image8.getRotation()));
            if(check())createDialog();
        });

        image4.setOnClickListener(view ->{
            image1.setRotation(getRotation(image1.getRotation()));
            if(check())createDialog();
        });

        image5.setOnClickListener(view ->{
            image16.setRotation(getRotation(image16.getRotation()));
            if(check())createDialog();
        });

        image6.setOnClickListener(view ->{
            image9.setRotation(getRotation(image9.getRotation()));
            if(check())createDialog();
        });

        image7.setOnClickListener(view ->{
            image5.setRotation(getRotation(image5.getRotation()));
            if(check())createDialog();
        });

        image8.setOnClickListener(view ->{
            image6.setRotation(getRotation(image6.getRotation()));
            if(check())createDialog();
        });

        image9.setOnClickListener(view ->{
            image2.setRotation(getRotation(image2.getRotation()));
            if(check())createDialog();
        });

        image10.setOnClickListener(view ->{
            image4.setRotation(getRotation(image4.getRotation()));
            if(check())createDialog();
        });

        image11.setOnClickListener(view ->{
            image14.setRotation(getRotation(image14.getRotation()));
            if(check())createDialog();
        });

        image12.setOnClickListener(view ->{
            image12.setRotation(getRotation(image12.getRotation()));
            if(check())createDialog();
        });

        image13.setOnClickListener(view ->{
            image15.setRotation(getRotation(image15.getRotation()));
            if(check())createDialog();
        });

        image14.setOnClickListener(view ->{
            image13.setRotation(getRotation(image13.getRotation()));
            if(check())createDialog();
        });

        image15.setOnClickListener(view ->{
            image3.setRotation(getRotation(image3.getRotation()));
            if(check())createDialog();
        });

        image16.setOnClickListener(view ->{
            image11.setRotation(getRotation(image11.getRotation()));
            if(check())createDialog();
        });
    }

    private int getRotation(float i){
        if(i==0)return 90;
        if(i==90)return 180;
        if(i==180)return 270;
        return 0;
    }

    private boolean check(){
        if(image1.getRotation()!=0)return false;
        if(image2.getRotation()!=0)return false;
        if(image3.getRotation()!=0)return false;
        if(image4.getRotation()!=0)return false;
        if(image5.getRotation()!=0)return false;
        if(image6.getRotation()!=0)return false;
        if(image7.getRotation()!=0)return false;
        if(image8.getRotation()!=0)return false;
        if(image9.getRotation()!=0)return false;
        if(image10.getRotation()!=0)return false;
        if(image11.getRotation()!=0)return false;
        if(image12.getRotation()!=0)return false;
        if(image13.getRotation()!=0)return false;
        if(image14.getRotation()!=0)return false;
        if(image15.getRotation()!=0)return false;
        return image16.getRotation() == 0;
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel10.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>10){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel11.class);
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
        Dialog dialog = new Dialog(HardLevel10.this);
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