package com.example.liuliu.xi.cityofanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView mFrame1;
    private ImageView mFrame2;
    private ImageView mFrame3;
    private ImageView mFrame4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        mFrame1 = (ImageView) findViewById(R.id.activity_frame_frame1);
        mFrame2 = (ImageView) findViewById(R.id.activity_frame_frame2);
        mFrame3 = (ImageView) findViewById(R.id.activity_frame_frame3);
        mFrame4 = (ImageView) findViewById(R.id.activity_frame_frame4);
        startFrameAnimate();
    }

    private void startFrameAnimate() {
        mFrame1.setImageResource(R.drawable.frame_on_the_way);
        AnimationDrawable onTheWay = (AnimationDrawable) mFrame1.getDrawable();
        onTheWay.start();
        mFrame2.setImageResource(R.drawable.frame_page_loading);
        AnimationDrawable pageLoading = (AnimationDrawable) mFrame2.getDrawable();
        pageLoading.start();
        mFrame3.setImageResource(R.drawable.frame_alipay_success);
        AnimationDrawable alipaySuccess = (AnimationDrawable) mFrame3.getDrawable();
        alipaySuccess.start();
        mFrame4.setImageResource(R.drawable.frame_loading);
        AnimationDrawable loading = (AnimationDrawable) mFrame4.getDrawable();
        loading.start();
    }

    @Override
    public void finish() {
        super.finish();
        //activity退出时，过渡动画
        overridePendingTransition(0, R.anim.zoomout);
    }
}
