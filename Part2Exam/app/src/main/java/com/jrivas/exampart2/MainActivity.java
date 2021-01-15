package com.jrivas.exampart2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView mSun;
    private FrameLayout mSky;
    private ObjectAnimator mSunSet,mGettingDark,mSunRising,mGettingLight;
    private final long mLargeDuration = 4500;
    private final long mShortDuration = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSky = findViewById(R.id.sky);
        mSky.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                startSunset();
                //starSunRising();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.half_moon) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if(id == R.id.hello_world){
            Intent intent = new Intent(this, HelloWorld.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startSunset() {
        mSun = findViewById(R.id.sun);
        System.out.println(mSun.getTop()+" "+mSun.getHeight());
        mSunSet = ObjectAnimator.ofFloat(mSun, "y", 950f);
        mGettingDark=ObjectAnimator.ofArgb(mSky,"backgroundColor",R.color.sky,R.color.middleDay,R.color.afternoon, R.color.night);
        mGettingDark.setDuration(mLargeDuration);
        mSunSet.setDuration(mShortDuration);
        AnimatorSet animatorSetSunSet = new AnimatorSet();
        animatorSetSunSet.playTogether(mSunSet,mGettingDark);
        animatorSetSunSet.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void starSunRising(){
        mSun = findViewById(R.id.sun);
        mSunRising = ObjectAnimator.ofFloat(mSun, "y", -950f);
        mGettingLight=ObjectAnimator.ofArgb(mSky,"backgroundColor",R.color.night,R.color.afternoon,R.color.middleDay,R.color.sky);
        mGettingLight.setDuration(mLargeDuration);
        mSunRising.setDuration(mShortDuration);
        AnimatorSet animatorSetSunRise = new AnimatorSet();
        animatorSetSunRise.playTogether(mSunRising,mGettingLight);
        animatorSetSunRise.start();
    }
}