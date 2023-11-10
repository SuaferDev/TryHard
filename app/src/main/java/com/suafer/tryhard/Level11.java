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
import android.widget.ImageView;
import android.widget.TextView;

public class Level11 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;
    private TextView levelname, textinfolevel, textinfoclue, buttonclue;

    private ImageView image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11;

    private double level = 0;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveLevel;
    private ImageView lastImage=null;
    /*  !Первая цифра фигуа, вторая цвет!
       1 - Треугольник      1 - Фиолетовый
       2 - Квадрат          2 - Синий
       3 - Круг             3 - Зеленый
       4 - Ромб             4 - Красный
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level11);

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SharedPreferences SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);
        if(Double.parseDouble(SaveInfo.getString("info", ""))==1){
            CustomToast.makeTextBlack(this,"Найдите пары карт",CustomToast.LENGTH_LONG).show();
        }

        ImageView imageback = findViewById(R.id.imageback); ImageView imagehelp = findViewById(R.id.imagehelp);
        image0 = findViewById(R.id.image0); image1 = findViewById(R.id.image1); image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3); image4 = findViewById(R.id.image4); image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6); image7 = findViewById(R.id.image7); image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9); image10 = findViewById(R.id.image10); image11 = findViewById(R.id.image11);

        int[] map = {
                11, 22, 13,
                44, 33, 11,
                33, 11, 22,
                13, 11, 44
        };

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
        });

        imagehelp.setOnClickListener(view ->{
            Dialog dialog = new Dialog(Level11.this);
            dialog.setContentView(R.layout.custom_dialog_help);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);

            levelname = dialog.findViewById(R.id.levelname);
            textinfolevel = dialog.findViewById(R.id.textinfolevel);
            textinfoclue = dialog.findViewById(R.id.textinfoclue);
            buttonclue = dialog.findViewById(R.id.buttonclue);

            levelname.setText(" Уровень 11 \"Карты\" ");
            textinfolevel.setText("    Нажимайте на карты, чтобы увидеть из заднюю сторону. Найдите парные карты, то есть имеющие одинаковую заднюю часть.");
            textinfoclue.setTextSize(0);
            buttonclue.setTextSize(0);
            dialog.show();
            buttonclue.setBackgroundColor(Color.WHITE);
        });

        image0.setOnClickListener(view ->{
            if(map[0]!=0){
                image0.setImageResource(R.drawable.card11);
                if(lastImage!=null && lastImage!=image0 && getImageBackground(lastImage, map)==getImageBackground(image0, map)){
                    image0.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[0]=0;
                    map[getId(lastImage,0)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image0;
                }
            }
        });

        image1.setOnClickListener(view ->{
            if(map[1]!=0){
                image1.setImageResource(R.drawable.card22);
                if(lastImage!=null && lastImage!=image1 && getImageBackground(lastImage, map)==getImageBackground(image1, map)){
                    image1.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[1]=0;
                    map[getId(lastImage,1)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image1;
                }
            }
        });

        image2.setOnClickListener(view ->{
            if(map[2]!=0){
                image2.setImageResource(R.drawable.card13);
                if(lastImage!=null && lastImage!=image2 && getImageBackground(lastImage, map)==getImageBackground(image2, map)){
                    image2.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[2]=0;
                    map[getId(lastImage,2)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image2;
                }
            }
        });

        image3.setOnClickListener(view ->{
            if(map[3]!=0){
                image3.setImageResource(R.drawable.card44);
                if(lastImage!=null && lastImage!=image3 && getImageBackground(lastImage, map)==getImageBackground(image3, map)){
                    image3.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[3]=0;
                    map[getId(lastImage,3)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image3;
                }
            }
        });

        image4.setOnClickListener(view ->{
            if(map[4]!=0){
                image4.setImageResource(R.drawable.card33);
                if(lastImage!=null && lastImage!=image4 && getImageBackground(lastImage, map)==getImageBackground(image4, map)){
                    image4.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[4]=0;
                    map[getId(lastImage,4)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image4;
                }
            }
        });

        image5.setOnClickListener(view ->{
            if(map[5]!=0){
                image5.setImageResource(R.drawable.card11);
                if(lastImage!=null && lastImage!=image5 && getImageBackground(lastImage, map)==getImageBackground(image5, map)){
                    image5.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[5]=0;
                    map[getId(lastImage,5)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image5;
                }
            }
        });

        image6.setOnClickListener(view ->{
            if(map[6]!=0){
                image6.setImageResource(R.drawable.card33);
                if(lastImage!=null && lastImage!=image6 && getImageBackground(lastImage, map)==getImageBackground(image6, map)){
                    image6.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[6]=0;
                    map[getId(lastImage,6)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image6;
                }
            }
        });

        image7.setOnClickListener(view ->{
            if(map[7]!=0){
                image7.setImageResource(R.drawable.card11);
                if(lastImage!=null && lastImage!=image7 && getImageBackground(lastImage, map)==getImageBackground(image7, map)){
                    image7.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[7]=0;
                    map[getId(lastImage,7)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image7;
                }
            }
        });

        image8.setOnClickListener(view ->{
            if(map[8]!=0){
                image8.setImageResource(R.drawable.card22);
                if(lastImage!=null && lastImage!=image8 && getImageBackground(lastImage, map)==getImageBackground(image8, map)){
                    image8.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[8]=0;
                    map[getId(lastImage,8)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image8;
                }
            }
        });

        image9.setOnClickListener(view ->{
            if(map[9]!=0){
                image9.setImageResource(R.drawable.card13);
                if(lastImage!=null && lastImage!=image9 && getImageBackground(lastImage, map)==getImageBackground(image9, map)){
                    image9.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[9]=0;
                    map[getId(lastImage,9)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image9;
                }
            }
        });

        image10.setOnClickListener(view ->{
            if(map[10]!=0){
                image10.setImageResource(R.drawable.card11);
                if(lastImage!=null && lastImage!=image10 && getImageBackground(lastImage, map)==getImageBackground(image10, map)){
                    image10.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[10]=0;
                    map[getId(lastImage,10)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image10;
                }
            }
        });

        image11.setOnClickListener(view ->{
            if(map[11]!=0){
                image11.setImageResource(R.drawable.card44);
                if(lastImage!=null && lastImage!=image11 && getImageBackground(lastImage, map)==getImageBackground(image11, map)){
                    image11.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[11]=0;
                    map[getId(lastImage,11)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image11;
                }
            }
        });
    }

    private int getImageBackground(ImageView image, int[] map){
        if(image==null)return 0;
        if(image.getId()==(int) image0.getId())return map[0];
        if(image.getId()==(int) image1.getId())return map[1];
        if(image.getId()==(int) image2.getId())return map[2];
        if(image.getId()==(int) image3.getId())return map[3];
        if(image.getId()==(int) image4.getId())return map[4];
        if(image.getId()==(int) image5.getId())return map[5];
        if(image.getId()==(int) image6.getId())return map[6];
        if(image.getId()==(int) image7.getId())return map[7];
        if(image.getId()==(int) image8.getId())return map[8];
        if(image.getId()==(int) image9.getId())return map[9];
        if(image.getId()==(int) image10.getId())return map[10];
        if(image.getId()==(int) image11.getId())return map[11];
        return 0;
    }

    private int getId(ImageView image, int last){
        if(image==null)return 0;
        if(image.getId()==(int) image0.getId())return 0;
        if(image.getId()==(int) image1.getId())return 1;
        if(image.getId()==(int) image2.getId())return 2;
        if(image.getId()==(int) image3.getId())return 3;
        if(image.getId()==(int) image4.getId())return 4;
        if(image.getId()==(int) image5.getId())return 5;
        if(image.getId()==(int) image6.getId())return 6;
        if(image.getId()==(int) image7.getId())return 7;
        if(image.getId()==(int) image8.getId())return 8;
        if(image.getId()==(int) image9.getId())return 9;
        if(image.getId()==(int) image10.getId())return 10;
        if(image.getId()==(int) image11.getId())return 11;
        return last;
    }

    private boolean check(int[] a){
        return (a[0]==0) && (a[1]==0) && (a[2]==0) && (a[3]==0) && (a[4]==0) && (a[5]==0) && (a[6]==0) &&
                (a[7]==0) && (a[8]==0) && (a[9]==0) && (a[10]==0) && (a[11]==0);
    }

    private void createDialog(){
        Dialog dialog = new Dialog(Level11.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(level>11){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            level++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), Level12.class);
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

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {}

        @Override
        public void onAnimationRepeat(Animation animation) {}

        @Override
        public void onAnimationStart(Animation animation) {}
    };

    private void createExite(){
        Dialog dialog = new Dialog(Level11.this);
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