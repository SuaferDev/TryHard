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

public class HardLevel11 extends AppCompatActivity {

    private TextView textinfo, textnext, texttomenu;
    private TextView textclosetomenu, textclose;

    private int hardlevel;
    private Animation mFadeInAnimation;
    Intent i = new Intent();
    private MediaPlayer mediaPlayer;
    private SharedPreferences SaveHardLevel;

    private ImageView image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14,
    image15, image16, image17, image18, image19;

    private ImageView lastImage=null;
    /*  !Первая цифра фигуа, вторая цвет!
       1 - Треугольник      1 - Фиолетовый
       2 - Квадрат          2 - Синий
       3 - Круг             3 - Зеленый
       4 - Ромб             4 - Красный
       5 - Закругленный квадрат
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level11);

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        //linearnavigation.startAnimation(mFadeInAnimation);

        int[] map = {
                34, 52, 34, 13,
                52, 11, 44, 11,
                32, 33, 22, 44,
                44, 13, 11, 32,
                11, 22, 33, 44
        };

        ImageView imageback = findViewById(R.id.imageback);
        image0 = findViewById(R.id.image0); image1 = findViewById(R.id.image1); image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3); image4 = findViewById(R.id.image4); image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6); image7 = findViewById(R.id.image7); image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9); image10 = findViewById(R.id.image10); image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12); image13 = findViewById(R.id.image13); image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15); image16 = findViewById(R.id.image16); image17 = findViewById(R.id.image17);
        image18 = findViewById(R.id.image18); image19 = findViewById(R.id.image19);

        imageback.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
            startActivity(i);
        });

        image0.setOnClickListener(view ->{
            if(map[0]!=0){
                image0.setImageResource(R.drawable.card34);
                if(lastImage!=null && lastImage!=image0 && getImageBackground(lastImage, map)==getImageBackground(image0, map)){
                    image0.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[0]=0;
                    map[getId(lastImage,0)]=0;
                    lastImage=null;
                    if(check(map)){createDialog();}
                }else{
                    if(lastImage!=null){lastImage.setImageResource(R.drawable.card_back);}
                }
                lastImage=image0;
            }
        });
        image1.setOnClickListener(view ->{
            if(map[1]!=0){
                image1.setImageResource(R.drawable.card52);
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
                image2.setImageResource(R.drawable.card34);
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
                image3.setImageResource(R.drawable.card13);
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
                image4.setImageResource(R.drawable.card52);
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
                image6.setImageResource(R.drawable.card44);
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
                image8.setImageResource(R.drawable.card32);
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
                image9.setImageResource(R.drawable.card33);
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
                image10.setImageResource(R.drawable.card22);
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

        image12.setOnClickListener(view ->{
            if(map[12]!=0){
                image12.setImageResource(R.drawable.card44);
                if(lastImage!=null && lastImage!=image12 && getImageBackground(lastImage, map)==getImageBackground(image12, map)){
                    image12.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[12]=0;
                    map[getId(lastImage,12)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image12;
                }
            }
        });

        image13.setOnClickListener(view ->{
            if(map[13]!=0){
                image13.setImageResource(R.drawable.card13);
                if(lastImage!=null && lastImage!=image13 && getImageBackground(lastImage, map)==getImageBackground(image13, map)){
                    image13.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[13]=0;
                    map[getId(lastImage,13)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image13;
                }
            }
        });

        image14.setOnClickListener(view ->{
            if(map[14]!=0){
                image14.setImageResource(R.drawable.card11);
                if(lastImage!=null && lastImage!=image14 && getImageBackground(lastImage, map)==getImageBackground(image14, map)){
                    image14.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[14]=0;
                    map[getId(lastImage,14)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image14;
                }
            }
        });

        image15.setOnClickListener(view ->{
            if(map[15]!=0){
                image15.setImageResource(R.drawable.card32);
                if(lastImage!=null && lastImage!=image15 && getImageBackground(lastImage, map)==getImageBackground(image15, map)){
                    image15.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[15]=0;
                    map[getId(lastImage,15)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image15;
                }
            }
        });

        image16.setOnClickListener(view ->{
            if(map[16]!=0){
                image16.setImageResource(R.drawable.card11);
                if(lastImage!=null && lastImage!=image16 && getImageBackground(lastImage, map)==getImageBackground(image16, map)){
                    image16.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[16]=0;
                    map[getId(lastImage,16)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image16;
                }
            }
        });

        image17.setOnClickListener(view ->{
            if(map[17]!=0){
                image17.setImageResource(R.drawable.card22);
                if(lastImage!=null && lastImage!=image17 && getImageBackground(lastImage, map)==getImageBackground(image17, map)){
                    image17.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[17]=0;
                    map[getId(lastImage,17)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image17;
                }
            }
        });

        image18.setOnClickListener(view ->{
            if(map[18]!=0){
                image18.setImageResource(R.drawable.card33);
                if(lastImage!=null && lastImage!=image18 && getImageBackground(lastImage, map)==getImageBackground(image18, map)){
                    image18.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[18]=0;
                    map[getId(lastImage,18)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image18;
                }
            }
        });

        image19.setOnClickListener(view ->{
            if(map[19]!=0){
                image19.setImageResource(R.drawable.card44);
                if(lastImage!=null && lastImage!=image19 && getImageBackground(lastImage, map)==getImageBackground(image19, map)){
                    image19.setImageResource(R.drawable.card_none);
                    lastImage.setImageResource(R.drawable.card_none);
                    map[19]=0;
                    map[getId(lastImage,19)]=0;
                    lastImage=null;
                    if(check(map)){
                        createDialog();
                    }
                }else{
                    if(lastImage!=null){
                        lastImage.setImageResource(R.drawable.card_back);
                    }
                    lastImage=image19;
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
        if(image.getId()==(int) image12.getId())return map[12];
        if(image.getId()==(int) image13.getId())return map[13];
        if(image.getId()==(int) image14.getId())return map[14];
        if(image.getId()==(int) image15.getId())return map[15];
        if(image.getId()==(int) image16.getId())return map[16];
        if(image.getId()==(int) image17.getId())return map[17];
        if(image.getId()==(int) image18.getId())return map[18];
        if(image.getId()==(int) image19.getId())return map[19];
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
        if(image.getId()==(int) image12.getId())return 12;
        if(image.getId()==(int) image13.getId())return 13;
        if(image.getId()==(int) image14.getId())return 14;
        if(image.getId()==(int) image15.getId())return 15;
        if(image.getId()==(int) image16.getId())return 16;
        if(image.getId()==(int) image17.getId())return 17;
        if(image.getId()==(int) image18.getId())return 18;
        if(image.getId()==(int) image19.getId())return 19;

        return last;
    }

    private boolean check(int[] a){
        return (a[0]==0) && (a[1]==0) && (a[2]==0) && (a[3]==0) && (a[4]==0) && (a[5]==0) && (a[6]==0) &&
                (a[7]==0) && (a[8]==0) && (a[9]==0) && (a[10]==0) && (a[11]==0) && (a[12]==0) && (a[13]==0)
                && (a[14]==0)  && (a[15]==0)  && (a[16]==0)  && (a[17]==0)  && (a[18]==0)  && (a[19]==0);
    }

    private void createDialog(){
        Dialog dialog = new Dialog(HardLevel11.this);
        dialog.setContentView(R.layout.custom_dialog_clue);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        textinfo = dialog.findViewById(R.id.textinfo);
        textnext = dialog.findViewById(R.id.textnext);
        texttomenu = dialog.findViewById(R.id.texttomenu);

        if(hardlevel>11){
            textinfo.setText("Вы уже прошли данный уровень ранее, но снова поздравляем.");
        }else{
            textinfo.setText("Вы можете перейти к следующему уровню или вернуться в меню.");
            hardlevel++;
        }

        dialog.show();
        textnext.setOnClickListener(v -> {
            dialog.dismiss();
            i.setClass(getApplicationContext(), HardLevel12.class);
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
        Dialog dialog = new Dialog(HardLevel11.this);
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