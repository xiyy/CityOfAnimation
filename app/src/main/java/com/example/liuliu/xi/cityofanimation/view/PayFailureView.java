package com.example.liuliu.xi.cityofanimation.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;

/**
 * Created by rookie on 2016/10/19.
 */

public class PayFailureView extends View {
    private static final float PADDING = 40;//圆距离父布局边界距离
    private static final int DEFAULT_RADIUS = 150;//默认圆大小
    private Paint mCirclePanit;
    private Paint mLinePaint;
    private float factor = 0.8f;
    private float temp;
    private float mCenterX, mCenterY;
    private float mRadius = 250;//圆的半径
    private final RectF mRectF = new RectF();
    private int mDegree;
    private Float mLeftValue = 0f;
    private Float mRightValue = 0f;
    private AnimatorSet mAnimatorSet = new AnimatorSet();

    private ValueAnimator mCircleAnim;
    private ValueAnimator mLineLeftAnimator;
    private ValueAnimator mLineRightAnimator;

    private PathMeasure pathLeftMeasure;
    private PathMeasure pathRightMeasure;
    private float[] mLeftPos = new float[2];
    private float[] mRightPos = new float[2];


    public PayFailureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PayFailureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCirclePanit = new Paint();
        mCirclePanit.setAntiAlias(true);
        mCirclePanit.setStrokeJoin(Paint.Join.ROUND);
        mCirclePanit.setStrokeWidth(5);
        mCirclePanit.setColor(Color.WHITE);
        mCirclePanit.setStyle(Paint.Style.STROKE);

        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStrokeJoin(Paint.Join.ROUND);
        mLinePaint.setStrokeWidth(5);
        mLinePaint.setColor(Color.WHITE);
        mLinePaint.setStyle(Paint.Style.STROKE);
        reset();
        reMeasure();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectF.left = mCenterX - mRadius;
        mRectF.top = mCenterY - mRadius;
        mRectF.right = mCenterX + mRadius;
        mRectF.bottom = mCenterY + mRadius;
        canvas.drawArc(mRectF, 0, mDegree, false, mCirclePanit);
        if (mLeftPos[1] > (mCenterY - temp) && mRightPos[1] > (mCenterY - temp)) {
            canvas.drawLine(mCenterX - temp, mCenterY - temp, mLeftPos[0], mLeftPos[1], mLinePaint);
            canvas.drawLine(mCenterX + temp, mCenterY - temp, mRightPos[0], mRightPos[1], mLinePaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        reMeasure();
    }

    private void reMeasure() {
        int mViewWidth = getWidth();
        int mViewHeight = getHeight();
        mCenterX = mViewWidth / 2;
        mCenterY = mViewHeight / 2;

        temp = mRadius / 2.0f * factor;
        Path path = new Path();
        path.moveTo(mCenterX - temp, mCenterY - temp);
        path.lineTo(mCenterX + temp, mCenterY + temp);
        pathLeftMeasure = new PathMeasure(path, false);

        path = new Path();
        path.moveTo(mCenterX + temp, mCenterY - temp);
        path.lineTo(mCenterX - temp, mCenterY + temp);
        pathRightMeasure = new PathMeasure(path, false);


    }

    public void startAnim(int radius) {
        radius = radius <= 0 ? DEFAULT_RADIUS : radius;
        this.mRadius = radius - PADDING;
        if (null != mAnimatorSet && mAnimatorSet.isRunning()) {
            return;
        }
        reset();
        reMeasure();
        mCircleAnim = ValueAnimator.ofInt(0, 360);
        mLineLeftAnimator = ValueAnimator.ofFloat(0, pathLeftMeasure.getLength());
        mLineRightAnimator = ValueAnimator.ofFloat(0, pathRightMeasure.getLength());
        mCircleAnim.setDuration(700);
        mLineLeftAnimator.setDuration(350);
        mLineRightAnimator.setDuration(350);
        mCircleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDegree = (Integer) animation.getAnimatedValue();
                invalidate();
            }
        });
        mLineLeftAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mLeftValue = (Float) valueAnimator.getAnimatedValue();
                pathLeftMeasure.getPosTan(mLeftValue, mLeftPos, null);
                invalidate();
            }
        });
        mLineRightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mRightValue = (Float) animation.getAnimatedValue();
                pathRightMeasure.getPosTan(mRightValue, mRightPos, null);
                invalidate();
            }
        });
        mAnimatorSet.play(mCircleAnim).before(mLineLeftAnimator);
        mAnimatorSet.play(mLineRightAnimator).after(mLineLeftAnimator);
        mAnimatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                failureAnim();
            }
        });
        mAnimatorSet.start();
    }

    private void failureAnim() {
        float currentX = this.getTranslationX();
        ObjectAnimator tansXAnim = ObjectAnimator.ofFloat(this, "translationX", currentX + 15);
        tansXAnim.setDuration(1000);
        tansXAnim.setInterpolator(new CycleInterpolator(3));
        tansXAnim.start();
    }

    public void reset() {
        mDegree = 0;
        mLeftValue = 0f;
        mRightValue = 0f;
        pathLeftMeasure = null;
        pathRightMeasure = null;
    }
}
