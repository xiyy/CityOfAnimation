package com.example.liuliu.xi.cityofanimation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.liuliu.xi.cityofanimation.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mFrameButton;
    private Button mTweenButton;
    private Button mBlurButton;
    private Button mActivityTransitonButton;
    private Button mViewPagerButton;
    private Button mPropertyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameButton = (Button) findViewById(R.id.main_activity_frame_animation_button);
        mFrameButton.setOnClickListener(this);
        mTweenButton = (Button) findViewById(R.id.main_activity_tween_animation_button);
        mTweenButton.setOnClickListener(this);
        mBlurButton = (Button) findViewById(R.id.main_activity_blur_button);
        mBlurButton.setOnClickListener(this);
        mActivityTransitonButton = (Button) findViewById(R.id.main_activity_transition_activity);
        mActivityTransitonButton.setOnClickListener(this);
        mViewPagerButton = (Button) findViewById(R.id.main_activity_view_pager);
        mViewPagerButton.setOnClickListener(this);
        mPropertyButton = (Button) findViewById(R.id.main_activity_property_animation_button);
        mPropertyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_frame_animation_button:
                Intent intent = new Intent(MainActivity.this, FrameAnimationActivity.class);
                startActivity(intent);
                //activity跳转，过渡动画
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
            case R.id.main_activity_tween_animation_button:
                Intent tweenIntent = new Intent(MainActivity.this, TweenActivity.class);
                startActivity(tweenIntent);
                //activity跳转，从底部缓进，缓缓退出底部
                overridePendingTransition(R.anim.enter_from_bottom, R.anim.exit_to_bottom);
                break;
            case R.id.main_activity_blur_button:
                Intent blurIntent = new Intent(MainActivity.this, BlurActivity.class);
                startActivity(blurIntent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
            case R.id.main_activity_transition_activity:
                Intent transitionIntent = new Intent(MainActivity.this, SwitchAnimActivity.class);
                startActivity(transitionIntent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
            case R.id.main_activity_view_pager:
                Intent viewPagerIntent = new Intent(MainActivity.this, ViewPagerAnimActivity.class);
                startActivity(viewPagerIntent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
            case R.id.main_activity_property_animation_button:
                Intent propertyAnimIntent = new Intent(MainActivity.this, PropertyAnimEnterActivity.class);
                startActivity(propertyAnimIntent);
                break;
        }
    }
}
