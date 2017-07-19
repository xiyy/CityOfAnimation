package com.example.liuliu.xi.cityofanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
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
    private float pivotXValue;
    private float pivotYValue;
    private float degree;
    private float time;

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
        mPivotX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pivotXValue = progress / 100.f;
                mPivotXValue.setText(pivotXValue + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mPivotY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pivotYValue = progress / 100.f;
                mPivotYValue.setText(pivotYValue + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mDegree.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                degree = 360 * progress / 100.f;
                mDegreeValue.setText(degree + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mDurationTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress <= 10) {
                    progress = 10;
                } else if (progress >= 100) {
                    progress = 100;
                }
                time = 100 * progress;
                mTimeValue.setText(time + " ms");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_activity_alpha);
        setProperty();
        mImageIcon.startAnimation(mAnimation);
    }

    private void translateAnimation() {
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_activity_translate);
        setProperty();
        mImageIcon.startAnimation(mAnimation);
    }

    private void scaleAnimation() {
        //xml文件中，pivotX、pivotY代表从哪个点开始缩放，含义和rotateAnimation()中4、6参数相同
        if (mScale1.isChecked()) {
            mAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_activity_scale_1);
        } else if (mScale2.isChecked()) {
            mAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_activity_scale_2);
        } else {
            mAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_activity_scale_3);
        }
        setProperty();
        mImageIcon.startAnimation(mAnimation);
    }

    private void rotateAnimation() {
        //第4和第6个参数，决定了图像围绕哪个点旋转，如(0,0)，则图像围绕左上顶点旋转；(0.2,0.5)，
        // 则图像围绕(0.2*imageView.width,0.5*imageView.height)旋转；(0.5,0.5)则图像围绕图像中心旋转;
        //(1.0,1.0)，则图像围绕右下顶点旋转；
        //参数3,5代表相对本身旋转
        mAnimation = new RotateAnimation(-degree, degree, Animation.RELATIVE_TO_SELF,
                pivotXValue, Animation.RELATIVE_TO_SELF, pivotYValue);
        mAnimation.setDuration((int) time);
        setProperty();
        mImageIcon.startAnimation(mAnimation);
    }

    private void stopAnimation() {
        mImageIcon.clearAnimation();
        if (mAnimation != null) {
            mAnimation.cancel();
            mAnimation.reset();
        }
    }

    private void setProperty() {
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

    }
}
