package com.example.liuliu.xi.cityofanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.liuliu.xi.cityofanimation.R;

public class TweenActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox isKeep;
    private CheckBox isReverse;
    private CheckBox isLoop;
    private Button mAlphaAnimation;
    private Button mTranslateAnimation;
    private RadioGroup mScaleStyle;
    private RadioButton mScale1;
    private RadioButton mScale2;
    private RadioButton mScale3;
    private Button mScaleAnimation;
    private Button mRotateAnimation;
    private SeekBar mPivotX;
    private TextView mPivotXValue;
    private SeekBar mPivotY;
    private TextView mPivotYValue;
    private SeekBar mDegree;
    private TextView mDegreeValue;
    private SeekBar mDurationTime;
    private TextView mTimeValue;
    private ImageView mImageIcon;
    private Button mStopAnimation;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        isKeep = (CheckBox) findViewById(R.id.tween_activity_keep);
        isReverse = (CheckBox) findViewById(R.id.tween_activity_reverse);
        isLoop = (CheckBox) findViewById(R.id.tween_activity_loop);
        mAlphaAnimation = (Button) findViewById(R.id.tween_activity_alpha);
        mAlphaAnimation.setOnClickListener(this);
        mTranslateAnimation = (Button) findViewById(R.id.tween_activity_translate);
        mTranslateAnimation.setOnClickListener(this);
        mScaleStyle = (RadioGroup) findViewById(R.id.tween_activity_selectStyle);
        mScale1 = (RadioButton) findViewById(R.id.tween_activity_rb1);
        mScale2 = (RadioButton) findViewById(R.id.tween_activity_rb2);
        mScale3 = (RadioButton) findViewById(R.id.tween_activity_rb3);
        mScaleAnimation = (Button) findViewById(R.id.tween_activity_scale);
        mScaleAnimation.setOnClickListener(this);
        mRotateAnimation = (Button) findViewById(R.id.tween_activity_rotate);
        mRotateAnimation.setOnClickListener(this);
        mPivotX = (SeekBar) findViewById(R.id.tween_activity_pivotX);
        mPivotXValue = (TextView) findViewById(R.id.tween_activity_xvalue);
        mPivotY = (SeekBar) findViewById(R.id.tween_activity_pivotY);
        mPivotYValue = (TextView) findViewById(R.id.tween_activity_yvalue);
        mDegree = (SeekBar) findViewById(R.id.tween_activity_degree);
        mDegreeValue = (TextView) findViewById(R.id.tween_activity_dvalue);
        mDurationTime = (SeekBar) findViewById(R.id.tween_activity_time);
        mTimeValue = (TextView) findViewById(R.id.tween_activity_tValue);
        mImageIcon = (ImageView) findViewById(R.id.tween_activity_icon);
        mStopAnimation = (Button) findViewById(R.id.tween_activity_stopAnim);
        mStopAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tween_activity_alpha:
                alphaAnimation();
                break;
            case R.id.tween_activity_translate:
                translateAnimation();
                break;

            case R.id.tween_activity_scale:
                scaleAnimation();
                break;
            case R.id.tween_activity_rotate:
                rotateAnimation();
                break;
            case R.id.tween_activity_stopAnim:
                stopAnimation();
                break;
        }
    }

    private void alphaAnimation() {
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_tween_activity);
        //动画完成后，是否回到初始状态
        if (isKeep.isChecked()) {
            mAnimation.setFillAfter(true);
        } else {
            mAnimation.setFillAfter(false);
        }
        //重复动画时，是反向（头-尾，尾-头，头-尾），还是重复（头-尾，头-尾，头-尾）
        if (isReverse.isChecked()) {
            mAnimation.setRepeatMode(Animation.REVERSE);
        } else {
            mAnimation.setRepeatMode(Animation.RESTART);
        }
        //设置动画播放次数
        if (isLoop.isChecked()) {
            mAnimation.setRepeatCount(-1);
        } else {
            mAnimation.setRepeatCount(0);
        }
        mImageIcon.startAnimation(mAnimation);
    }

    private void translateAnimation() {

    }

    private void scaleAnimation() {

    }

    private void rotateAnimation() {

    }

    private void stopAnimation() {
        mImageIcon.clearAnimation();
        if (mAnimation != null) {
            mAnimation.cancel();
            mAnimation.reset();
        }
    }
}
