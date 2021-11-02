package com.emoran.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ImageView mman = findViewById(R.id.man);
//glide para cargar la imagen de girls
        Glide.with(this)
                //carga imagen, hay que dar permiso a internet en android manifest
                .load(R.drawable.hipman)
                //transition hae que cargue la imagen un poco mas tarde
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .into(mman);

    }
}