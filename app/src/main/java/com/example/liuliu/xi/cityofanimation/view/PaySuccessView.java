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
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by rookie on 2016/10/19.
 */

public class PaySuccessView extends View {
    private static final float PADDING = 40;//圆距离父布局的距离
    private static final int DEFAULT_RADIUS = 150;//圆的默认半径
    private Paint mCirclePanit;
    private Paint mLinePaint;
    private float mCenterX, mCenterY;//中心点
    private float mRadius = 150;//圆的半径
    private final RectF mRectF = new RectF();
    private int mDegree;
    private Float mLeftValue = 0f;
    private Float mRightValue = 0f;
    private AnimatorSet mAnimatorSet = new AnimatorSet();
    private ValueAnimator mCircleAnim;
    private ValueAnimator mLineLeftAnimator;
    private ValueAnimator mLineRightAnimator;

    public PaySuccessView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectF.left = mCenterX - mRadius;//圆的最左侧
        mRectF.top = mCenterY - mRadius;//圆的顶部
        mRectF.right = mCenterX + mRadius;//圆的最右侧
        mRectF.bottom = mCenterY + mRadius;//圆的底部
        canvas.drawArc(mRectF, 0, mDegree, false, mCirclePanit);//画圆
        canvas.drawLine(mCenterX - mRadius / 2, mCenterY,
                mCenterX - mRadius / 2 + mLeftValue, mCenterY + mLeftValue, mLinePaint);//画左线
        canvas.drawLine(mCenterX, mCenterY + mRadius / 2,
                mCenterX + mRightValue, mCenterY + mRadius / 2 - (3f / 2f) * mRightValue, mLinePaint);//画右线
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
        mLineLeftAnimator = ValueAnimator.ofFloat(0, this.mRadius / 2f);//(起始值，终点值)
        mLineRightAnimator = ValueAnimator.ofFloat(0, this.mRadius / 2f);
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
                invalidate();
            }
        });
        mLineRightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mRightValue = (Float) animation.getAnimatedValue();
                invalidate();
            }
        });
        mAnimatorSet.play(mCircleAnim).before(mLineLeftAnimator);
        mAnimatorSet.play(mLineRightAnimator).after(mLineLeftAnimator);
        mAnimatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                SuccessAnim();
            }
        });
        mAnimatorSet.start();
    }

    private void SuccessAnim() {
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 1.1f, 1.0f);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 1.1f, 1.0f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(scaleXAnim, scaleYAnim);
        set.start();
    }

    public void reset() {
        mDegree = 0;
        mLeftValue = 0f;
        mRightValue = 0f;
        mCirclePanit.setColor(Color.WHITE);
        mLinePaint.setColor(Color.WHITE);
    }
}
