package com.example.trainschedule.core.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.trainschedule.R;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

import site.gemus.openingstartanimation.NormalDrawStrategy;
import site.gemus.openingstartanimation.OpeningStartAnimation;
import site.gemus.openingstartanimation.RedYellowBlueDrawStrategy;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/1 9:23 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImmersionBar.with(this)
                .fullScreen(true)
                .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                .transparentNavigationBar()
                .init();

        OpeningStartAnimation openingStartAnimation = new OpeningStartAnimation.Builder(this)
                .setDrawStategy(new RedYellowBlueDrawStrategy())
                .setAppStatement(getString(R.string.app_name))
                .create();
        openingStartAnimation.show(this);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            this.startActivity(intent);
            finish();
        }, 1500);

    }
}

