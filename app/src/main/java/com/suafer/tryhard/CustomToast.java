package com.suafer.tryhard;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class CustomToast extends Toast {
    public CustomToast(Context context) {
        super(context);
    }

    public static CustomToast makeTextWhite(Context context, CharSequence text, int duration) {
        CustomToast customToast = new CustomToast(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);

        TextView textView = layout.findViewById(R.id.custom_toast_text);
        textView.setTextColor(0xFFFFFFFF);
        textView.setText(text);

        FrameLayout frameLayout = layout.findViewById(R.id.linear);

        frameLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        frameLayout.getBackground().setAlpha(128);

        customToast.setView(layout);
        customToast.setDuration(duration);
        customToast.setGravity(Gravity.CENTER, 0, 0);

        return customToast;
    }

    public static CustomToast makeTextBlack(Context context, CharSequence text, int duration) {
        CustomToast customToast = new CustomToast(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);

        TextView textView = layout.findViewById(R.id.custom_toast_text);
        textView.setTextColor(0xFF000000);
        textView.setText(text);

        FrameLayout frameLayout = layout.findViewById(R.id.linear);

        frameLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        //frameLayout.getBackground().setAlpha(128);

        customToast.setView(layout);
        customToast.setDuration(duration);
        customToast.setGravity(Gravity.CENTER, 0, 0);

        return customToast;
    }
}