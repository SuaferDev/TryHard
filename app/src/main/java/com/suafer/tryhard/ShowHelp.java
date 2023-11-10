package com.suafer.tryhard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class ShowHelp extends AppCompatActivity {

    private SharedPreferences SaveInfo;

    Intent i = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_help);

        TextView textYES = findViewById(R.id.textYES);
        TextView textNO = findViewById(R.id.textNO);
        TextView textdraw = findViewById(R.id.textdraw);

        SaveInfo = getSharedPreferences("info", Activity.MODE_PRIVATE);

        textdraw.setOnClickListener(view -> {
            CustomToast.makeTextWhite(this,"Пример сообщения", Toast.LENGTH_LONG).show();
        });

        textYES.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), Menu.class);
            SaveInfo.edit().putString("info", "1").apply();
            startActivity(i);
            finish();
        });

        textNO.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), Menu.class);
            SaveInfo.edit().putString("info", "0").apply();
            startActivity(i);
            finish();
        });
    }
}