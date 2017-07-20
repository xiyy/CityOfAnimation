package com.example.liuliu.xi.cityofanimation.activity;

import android.animation.TimeInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.liuliu.xi.cityofanimation.R;
import com.example.liuliu.xi.cityofanimation.view.LineView;
import com.example.liuliu.xi.cityofanimation.view.LineViewColorChange;

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton mLine;
    private RadioButton mLineColor;
    private RadioButton mLineSin;
    private RadioButton mAccelerateInterpolator;
    private RadioButton mBounceInterpolator;
    private RadioButton mAccelerateDecelerateInterpolator;
    private RadioButton mDecelerateInterpolator;
    private RadioButton mAnticipateInterpolator;
    private RadioButton mLinearInterpolator;
    private RadioButton mLinearOutSlowInInterpolator;
    private RadioButton mOvershootInterpolator;
    private Button mStart;
    private Button mStop;
    private LineView mLineView;
    private LineViewColorChange mLineViewColorChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        mLine = (RadioButton) findViewById(R.id.line_value_animator_activity);
        mLineColor = (RadioButton) findViewById(R.id.line_color_value_animator_activity);
        mLineSin = (RadioButton) findViewById(R.id.line_sin_value_animator_activity);
        mLinearInterpolator = (RadioButton) findViewById(R.id.LinearInterpolator_value_animator_activity);
        mAccelerateInterpolator = (RadioButton) findViewById(R.id.accelerate__interpolator_value_animator_activity);
        mDecelerateInterpolator = (RadioButton) findViewById(R.id.DecelerateInterpolator_value_animator_activity);
        mAccelerateDecelerateInterpolator = (RadioButton) findViewById(R.id.accelerate_decelerate_interpolator_value_animator_activity);
        mBounceInterpolator = (RadioButton) findViewById(R.id.bounce_interpolator_value_animator_activity);
        mAnticipateInterpolator = (RadioButton) findViewById(R.id.AnticipateInterpolator_value_animator_activity);
        mLinearOutSlowInInterpolator = (RadioButton) findViewById(R.id.LinearOutSlowInInterpolator_value_animator_activity);
        mOvershootInterpolator = (RadioButton) findViewById(R.id.OvershootInterpolator_value_animator_activity);
        mStart = (Button) findViewById(R.id.start_anim_button_value_animator_activity);
        mStop = (Button) findViewById(R.id.stop_anim_button_value_animator_activity);
        mStart.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mLineView = (LineView) findViewById(R.id.line_view_value_animator_activity);
        mLineViewColorChange = (LineViewColorChange) findViewById(R.id.line_view_color_change);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_anim_button_value_animator_activity:
                startAnimation();
                break;
            case R.id.stop_anim_button_value_animator_activity:
                stopAnimation();
                break;
        }
    }

    private void startAnimation() {
        if (mLine.isChecked()) {
            mLineView.setVisibility(View.VISIBLE);
            mLineView.setInterpolator(getInterpolator());
            mLineView.startAnimation();

        } else if (mLineColor.isChecked()) {
            mLineViewColorChange.setVisibility(View.VISIBLE);
            mLineViewColorChange.setInterpolator(getInterpolator());
            mLineViewColorChange.startAnimation();
        } else {

        }

    }

    private void stopAnimation() {
        if (mLineView.getVisibility() == View.VISIBLE) {
            mLineView.clearAnimation();
            mLineView.setVisibility(View.GONE);
        }
        if (mLineViewColorChange.getVisibility() == View.VISIBLE) {
            mLineViewColorChange.clearAnimation();
            mLineViewColorChange.setVisibility(View.GONE);
        }

    }

    private TimeInterpolator getInterpolator() {
        if (mLinearInterpolator.isChecked()) {
            return new LinearInterpolator();
        } else if (mAccelerateInterpolator.isChecked()) {
            return new AccelerateInterpolator();
        } else if (mDecelerateInterpolator.isChecked()) {
            return new DecelerateInterpolator();
        } else if (mAccelerateDecelerateInterpolator.isChecked()) {
            return new AccelerateDecelerateInterpolator();
        } else if (mBounceInterpolator.isChecked()) {
            return new BounceInterpolator();
        } else if (mAnticipateInterpolator.isChecked()) {
            return new AnticipateInterpolator();
        } else if (mLinearOutSlowInInterpolator.isChecked()) {
            return new LinearOutSlowInInterpolator();
        } else {
            return new OvershootInterpolator();
        }
    }
}
