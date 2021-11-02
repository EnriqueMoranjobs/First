package com.emoran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp(true);

        //implements and start animation
        ImageView star = (ImageView) findViewById(R.id.logoSplash);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.fadein);
        star.startAnimation(myanim);


    }
    private void openApp(boolean locationPermission){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen
                        .this,LoginActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }
}
