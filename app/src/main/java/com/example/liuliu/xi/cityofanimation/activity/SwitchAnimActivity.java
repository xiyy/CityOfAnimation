package com.example.liuliu.xi.cityofanimation.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;

import com.example.liuliu.xi.cityofanimation.R;


public class SwitchAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private Transition mTransiton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_switch_anim);
        findViewById(R.id.exlpode).setOnClickListener(this);
        findViewById(R.id.slide).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//Android 5.0及以上版本才可用
            switch (v.getId()) {
                case R.id.exlpode:
                    mTransiton = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    break;
                case R.id.slide:
                    mTransiton = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                    break;
            }
//            Activity A的退出变换（exit transition）决定了在A调用B的时候，A中的View是如何播放动画的。
//            Activity B的进入变换（enter transition）决定了在A调用B的时候，B中的View是如何播放动画的。
//            Activity B的返回变换（return transition）决定了在B返回A的时候，B中的View是如何播放动画的。
//            Activity A的再次进入变换（reenter transition）决定了在B返回A的时候，A中的View是如何播放动画的。
            //退出时使用
            getWindow().setExitTransition(mTransiton);
            //第一次进入时使用
            getWindow().setEnterTransition(mTransiton);
            //再次进入时使用
            getWindow().setReenterTransition(mTransiton);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            Intent intent = new Intent(this, TweenActivity.class);
            startActivity(intent, bundle);
        }
    }
}
