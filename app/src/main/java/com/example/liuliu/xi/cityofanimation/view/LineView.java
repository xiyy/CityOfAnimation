package com.example.liuliu.xi.cityofanimation.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.liuliu.xi.cityofanimation.bean.Point;
import com.example.liuliu.xi.cityofanimation.impl.PointMoveEvaluator;

/**
 * Created by zhangxb171 on 2017/7/20.
 */

public class LineView extends View {
    private static final float RADIUS = 50.0f;
    private Paint mPaint;
    private Point mCurrentPoint;
    private TimeInterpolator mInterpolator;

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        mInterpolator = timeInterpolator;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCurrentPoint != null) {
            drawCircle(canvas);
        }
    }

    public void startAnimation() {
        Point start = new Point(RADIUS, RADIUS);
        Point end = new Point(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointMoveEvaluator(), start, end);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (Point) animation.getAnimatedValue();//当前动画进度值
                invalidate();//通知View涮新，回调onDraw()方法
            }
        });
        valueAnimator.setInterpolator(mInterpolator);
        valueAnimator.start();
    }

    private void drawCircle(Canvas canvas) {
        float x = mCurrentPoint.getX();
        float y = mCurrentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }
}
