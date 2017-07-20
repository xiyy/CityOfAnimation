package com.example.liuliu.xi.cityofanimation.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.liuliu.xi.cityofanimation.bean.Point;
import com.example.liuliu.xi.cityofanimation.impl.ColorEvaluator;
import com.example.liuliu.xi.cityofanimation.impl.PointEvaluator;

/**
 * Created by zhangxb171 on 2017/7/20.
 */

public class LineViewColorChange extends View {
    private static final float RADIUS = 50.0f;
    private Paint mPaint;
    private Point mCurrentPoint;
    private String color;
    private TimeInterpolator mInterpolator;

    public LineViewColorChange(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCurrentPoint != null) {
            drawCircle(canvas);
        }
    }

    public void startAnimation() {
        //点的移动
        Point start = new Point(RADIUS, RADIUS);
        Point end = new Point(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator moveAnim = ValueAnimator.ofObject(new PointEvaluator(), start, end);
        moveAnim.setDuration(5000);
        moveAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (Point) animation.getAnimatedValue();//当前动画进度值
                invalidate();//通知View涮新，回调onDraw()方法
            }
        });
        //点的颜色渐变,改变LineViewColorChange的color属性
        ObjectAnimator colorChangeAnim = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#0000ff", "#ff0000");
        colorChangeAnim.setDuration(5000);
        colorChangeAnim.setInterpolator(mInterpolator);//颜色变化的快慢程度
        AnimatorSet set = new AnimatorSet();
        set.playTogether(moveAnim, colorChangeAnim);
        set.start();
    }

    private void drawCircle(Canvas canvas) {
        float x = mCurrentPoint.getX();
        float y = mCurrentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();//通知View刷新，onDraw()回调
    }

    public String getColor() {
        return color;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        mInterpolator = timeInterpolator;
    }
}
