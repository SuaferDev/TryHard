package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LevelMenu extends AppCompatActivity {

    private double level;
    private int hardlevel;

    private TextView button_Reset;

    private MediaPlayer mediaPlayer;
    Intent i = new Intent();
    private SharedPreferences SaveLevel;
    private SharedPreferences SaveHardLevel;

    private Toast toast;
    

    private LinearLayout  line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11;
    private TextView level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11, level12;

    private LinearLayout  hardline1, hardline2, hardline3, hardline4, hardline5, hardline6, hardline7, hardline8, hardline9, hardline10,
            hardline11;
    private TextView hardlevel1, hardlevel2, hardlevel3, hardlevel4, hardlevel5, hardlevel6, hardlevel7, hardlevel8, hardlevel9, hardlevel10,
            hardlevel11, hardlevel12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black));

        SaveLevel = getSharedPreferences("level", Activity.MODE_PRIVATE);
        level = Double.parseDouble(SaveLevel.getString("level", ""));

        SaveHardLevel = getSharedPreferences("hardlevel", Activity.MODE_PRIVATE);
        hardlevel = Integer.parseInt((SaveHardLevel.getString("hardlevel", "")));

        toast = Toast.makeText(LevelMenu.this, "Пройдите предыдущие уровни", Toast.LENGTH_LONG);

        ImageView backimageview = findViewById(R.id.backimageview);
        ImageView buttonReset = findViewById(R.id.buttonReset);
        ImageView buttonHelp = findViewById(R.id.buttonHelp);
        
        {
            line1 = findViewById(R.id.line1); line2 = findViewById(R.id.line2); line3 = findViewById(R.id.line3);
            line4 = findViewById(R.id.line4); line5 = findViewById(R.id.line5); line6 = findViewById(R.id.line6);
            line7 = findViewById(R.id.line7); line8 = findViewById(R.id.line8); line9 = findViewById(R.id.line9);
            line10 = findViewById(R.id.line10); line11 = findViewById(R.id.line11);

            level1 = findViewById(R.id.level1); level2 = findViewById(R.id.level2); level3 = findViewById(R.id.level3);
            level4 = findViewById(R.id.level4); level5 = findViewById(R.id.level5); level6 = findViewById(R.id.level6);
            level7 = findViewById(R.id.level7); level8 = findViewById(R.id.level8); level9 = findViewById(R.id.level9);
            level10 = findViewById(R.id.level10); level11 = findViewById(R.id.level11); level12 = findViewById(R.id.level12);
        }setLevel(level);

        {
            hardline1 = findViewById(R.id.hardline1); hardline2 = findViewById(R.id.hardline2); hardline3 = findViewById(R.id.hardline3);
            hardline4 = findViewById(R.id.hardline4); hardline5 = findViewById(R.id.hardline5); hardline6 = findViewById(R.id.hardline6);
            hardline7 = findViewById(R.id.hardline7); hardline8 = findViewById(R.id.hardline8); hardline9 = findViewById(R.id.hardline9);
            hardline10 = findViewById(R.id.hardline10); hardline11 = findViewById(R.id.hardline11);

            hardlevel1 = findViewById(R.id.hardlevel1); hardlevel2 = findViewById(R.id.hardlevel2); hardlevel3 = findViewById(R.id.hardlevel3);
            hardlevel4 = findViewById(R.id.hardlevel4); hardlevel5 = findViewById(R.id.hardlevel5); hardlevel6 = findViewById(R.id.hardlevel6);
            hardlevel7 = findViewById(R.id.hardlevel7); hardlevel8 = findViewById(R.id.hardlevel8); hardlevel9 = findViewById(R.id.hardlevel9);
            hardlevel10 = findViewById(R.id.hardlevel10); hardlevel11 = findViewById(R.id.hardlevel11); hardlevel12 = findViewById(R.id.hardlevel12);
        }setHardLevel(hardlevel);

        backimageview.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
            mediaPlayer.start();
            SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
            startActivity(i);
            finish();
        });

        buttonReset.setOnClickListener(view ->{
            Dialog dialog = new Dialog(LevelMenu.this);
            dialog.setContentView(R.layout.custom_dialog_reset);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);
            button_Reset = dialog.findViewById(R.id.button_Reset);
            dialog.show();
            button_Reset.setOnClickListener(v -> {
                level=1;
                hardlevel=0;
                i.setClass(getApplicationContext(), LevelMenu.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf(hardlevel)).apply();
                startActivity(i);
                finish();
            });
        });

        buttonHelp.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), ShowHelp.class);
            startActivity(i);
            finish();
        });

        level1.setOnClickListener(view ->{
            if(level>=1){
                i.setClass(getApplicationContext(), Level1.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level2.setOnClickListener(view ->{
            if(level>=2){
                i.setClass(getApplicationContext(), Level2.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level3.setOnClickListener(view ->{
            if(level>=3){
                i.setClass(getApplicationContext(), Level3.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level4.setOnClickListener(view ->{
            if(level>=4){
                i.setClass(getApplicationContext(), Level4.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level5.setOnClickListener(view ->{
            if(level>=5){
                i.setClass(getApplicationContext(), Level5.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level6.setOnClickListener(view ->{
            if(level>=6){
                i.setClass(getApplicationContext(), Level6.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level7.setOnClickListener(view ->{
            if(level>=7){
                i.setClass(getApplicationContext(), Level7.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level8.setOnClickListener(view ->{
            if(level>=8){
                i.setClass(getApplicationContext(), Level8.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level9.setOnClickListener(view ->{
            if(level>=9){
                i.setClass(getApplicationContext(), Level9.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level10.setOnClickListener(view ->{
            if(level>=10){
                i.setClass(getApplicationContext(), Level10.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level11.setOnClickListener(view ->{
            if(level>=11){
                i.setClass(getApplicationContext(), Level11.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        level12.setOnClickListener(view ->{
            if(level>=12){
                i.setClass(getApplicationContext(), Level12.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });

        hardlevel1.setOnClickListener(view ->{
            if(hardlevel>=1){
                i.setClass(getApplicationContext(), HardLevel1.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel2.setOnClickListener(view ->{
            if(hardlevel>=2){
                i.setClass(getApplicationContext(), HardLevel2.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel3.setOnClickListener(view ->{
            if(hardlevel>=3){
                i.setClass(getApplicationContext(), HardLevel3.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel4.setOnClickListener(view ->{
            if(hardlevel>=4){
                i.setClass(getApplicationContext(), HardLevel4.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel5.setOnClickListener(view ->{
            if(hardlevel>=5){
                i.setClass(getApplicationContext(), HardLevel5.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel6.setOnClickListener(view ->{
            if(hardlevel>=6){
                i.setClass(getApplicationContext(), HardLevel6.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel7.setOnClickListener(view ->{
            if(hardlevel>=7){
                i.setClass(getApplicationContext(), HardLevel7.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel8.setOnClickListener(view ->{
            if(hardlevel>=8){
                i.setClass(getApplicationContext(), HardLevel8.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel9.setOnClickListener(view ->{
            if(hardlevel>=9){
                i.setClass(getApplicationContext(), HardLevel9.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel10.setOnClickListener(view ->{
            if(hardlevel>=10){
                i.setClass(getApplicationContext(), HardLevel10.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel11.setOnClickListener(view ->{
            if(hardlevel>=11){
                i.setClass(getApplicationContext(), HardLevel11.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });
        hardlevel12.setOnClickListener(view ->{
            if(hardlevel>=12){
                i.setClass(getApplicationContext(), HardLevel12.class);
                mediaPlayer = MediaPlayer.create(this, R.raw.levelsound);
                mediaPlayer.start();
                SaveHardLevel.edit().putString("hardlevel", String.valueOf((long)(hardlevel))).apply();
                startActivity(i);
                finish();
            }else{toast.show();}
        });

    }

    private void setLevel(double level){
        if(level>=1){
            level1.setText("1"); line1.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=2){
            level1.setText("✔"); level2.setText("2"); line1.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=3){
            level2.setText("✔"); level3.setText("3"); line2.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=4){
            level3.setText("✔"); level4.setText("4"); line3.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=5){
            level4.setText("✔"); level5.setText("5"); line4.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=6){
            level5.setText("✔"); level6.setText("6"); line5.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=7){
            level6.setText("✔"); level7.setText("7"); line6.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=8){
            level7.setText("✔"); level8.setText("8"); line7.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=9){
            level8.setText("✔"); level9.setText("9"); line8.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=10){
            level9.setText("✔"); level10.setText("10"); line9.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=11){
            level10.setText("✔"); level11.setText("11"); line10.setBackgroundColor(0xFF95B6F0);
        }else{return;}

        if(level>=12){
            level11.setText("✔"); level12.setText("12"); line11.setBackgroundColor(0xFF95B6F0);
        } else{return;}

        if(level>=13){
            level12.setText("✔");
        }else{return;}
    }

    private void setHardLevel(int hardLevel){
        if(hardLevel>=1){
            hardlevel1.setText("1"); hardline1.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=2){
            hardlevel1.setText("✔"); hardlevel2.setText("2"); hardline1.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=3){
            hardlevel2.setText("✔"); hardlevel3.setText("3"); hardline2.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=4){
            hardlevel3.setText("✔"); hardlevel4.setText("4"); hardline3.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=5){
            hardlevel4.setText("✔"); hardlevel5.setText("5"); hardline4.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=6){
            hardlevel5.setText("✔"); hardlevel6.setText("6"); hardline5.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=7){
            hardlevel6.setText("✔"); hardlevel7.setText("7"); hardline6.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=8){
            hardlevel7.setText("✔"); hardlevel8.setText("8"); hardline7.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=9){
            hardlevel8.setText("✔"); hardlevel9.setText("9"); hardline8.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=10){
            hardlevel9.setText("✔"); hardlevel10.setText("10"); hardline9.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=11){
            hardlevel10.setText("✔"); hardlevel11.setText("11"); hardline10.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=12){
            hardlevel11.setText("✔"); hardlevel12.setText("12"); hardline11.setBackgroundColor(0xFFEE6666);
        }else{return;}

        if(hardLevel>=13){
            hardlevel12.setText("✔");
        }else{return;}
    }

    @Override
    public void onPause() {
        super.onPause();
        toast.cancel();
    }


    @Override
    public void onStop() {
        super.onStop();
        toast.cancel();
        SaveLevel.edit().putString("level", String.valueOf((long)(level))).apply();
    }
}