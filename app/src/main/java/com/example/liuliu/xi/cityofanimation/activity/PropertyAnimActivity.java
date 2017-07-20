package com.example.liuliu.xi.cityofanimation.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.liuliu.xi.cityofanimation.R;

import java.io.ObjectStreamException;

public class PropertyAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mAlpha;
    private Button mTranslate;
    private Button mScale;
    private Button mRotate;
    private Button mAnimSet;
    private ImageView mImageView;
    private Button mStopAnim;
    private int mScreenWidth;
    private int mImageViewWidth;
    private ObjectAnimator mObjectAnimator;
    private static final String TAG = "PropertyAnimActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim);
        mAlpha = (Button) findViewById(R.id.alpha);
        mAlpha.setOnClickListener(this);
        mTranslate = (Button) findViewById(R.id.translate);
        mTranslate.setOnClickListener(this);
        mScale = (Button) findViewById(R.id.scale);
        mScale.setOnClickListener(this);
        mRotate = (Button) findViewById(R.id.rotate);
        mRotate.setOnClickListener(this);
        mAnimSet = (Button) findViewById(R.id.set);
        mAnimSet.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.myView);
        mStopAnim = (Button) findViewById(R.id.stop_property_anim);
        mStopAnim.setOnClickListener(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mScreenWidth = displayMetrics.widthPixels;
        mImageViewWidth = mImageView.getWidth();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha:
                alpha();
                break;
            case R.id.translate:
                translate();
                break;
            case R.id.scale:
                scale();
                break;
            case R.id.rotate:
                rotate();
                break;
            case R.id.set:
                animationSet();
                break;
            case R.id.stop_property_anim:
                stopAnim();
                break;
        }
    }

    private void alpha() {
        mObjectAnimator = ObjectAnimator.ofFloat(mImageView, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
        //动画开始、动画结束、动画取消、动画重复执行时，回调
        mObjectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setRepeatCount(-1);
        mObjectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        //mObjectAnimator.setRepeatMode(ObjectAnimator.RESTART);
        //mObjectAnimator.setInterpolator(new AccelerateInterpolator());//动画加速变化,默认是匀速变化
        mObjectAnimator.start();
    }

    private void translate() {
        mObjectAnimator = ObjectAnimator.ofFloat(mImageView, "translationX", 0, (mScreenWidth - mImageViewWidth) / 2, 0, -(mScreenWidth - mImageViewWidth) / 2, 0);
        //相比于AnimatorListener，AnimatorListenerAdapter中的方法可以选择实现，不需要全部重写
        mObjectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
        });
        mObjectAnimator.setDuration(3000);
        mObjectAnimator.setRepeatCount(-1);
        mObjectAnimator.setRepeatMode(ValueAnimator.RESTART);
        //animator.setInterpolator(new DecelerateInterpolator());//动画减速变化
        mObjectAnimator.start();
    }

    private void scale() {
        mObjectAnimator = ObjectAnimator.ofFloat(mImageView, "scaleX", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);//ScaleY是Y轴
        mObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.i(TAG, "onAnimationUpdate currentValue---->" + currentValue);
            }
        });
        mObjectAnimator.setDuration(1000);
        mObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mObjectAnimator.setRepeatCount(-1);
        mObjectAnimator.start();
    }

    private void rotate() {
        //绕中心转
        mObjectAnimator = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);//rotationX：绕Y轴转；rotationY：绕X轴转
        mObjectAnimator.setDuration(1000);
        mObjectAnimator.start();
    }

    private void animationSet() {
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mImageView, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(mImageView, "scaleX", 0.0f, 1.0f);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(mImageView, "scaleY", 0.0f, 2.0f);
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(mImageView, "rotation", 0, 360);
        ObjectAnimator transXAnim = ObjectAnimator.ofFloat(mImageView, "translationX", 100, 400);
        ObjectAnimator transYAnim = ObjectAnimator.ofFloat(mImageView, "translationY", 100, 750);
        AnimatorSet animatorSet = new AnimatorSet();
        //animatorSet.play(alphaAnim).with(scaleXAnim).with(scaleYAnim).before(rotateAnim).after(transXAnim).after(transYAnim);
        animatorSet.playTogether(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    private void stopAnim() {
        if (mObjectAnimator != null) {
            if (mObjectAnimator.isRunning()) {
                mObjectAnimator.end();
            }
        }
        if (mObjectAnimator != null) {
            mObjectAnimator = null;
        }
    }
}
