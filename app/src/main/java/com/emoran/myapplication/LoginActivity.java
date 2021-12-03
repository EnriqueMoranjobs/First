package com.emoran.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView mgirl = findViewById(R.id.girl);
        //glide para cargar la imagen de girls
        Glide.with(this)
                //carga imagen, hay que dar permiso a internet en android manifest
                .load(R.drawable.girl)
                //transition hae que cargue la imagen un poco mas tarde
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .into(mgirl);

    }

//load(R.drawable.girl)

    public void openMain(View w){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openSignUp(View w){
        Intent intent = new Intent(LoginActivity.this,SignUp.class);
        startActivity(intent);
    }
}