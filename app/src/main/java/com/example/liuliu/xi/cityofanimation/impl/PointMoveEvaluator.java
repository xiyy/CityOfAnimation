package com.example.liuliu.xi.cityofanimation.impl;

import android.animation.TypeEvaluator;

import com.example.liuliu.xi.cityofanimation.bean.Point;

/**
 * Created by zhangxb171 on 2017/7/20.
 */

public class PointMoveEvaluator implements TypeEvaluator {
    /**
     * @param fraction   0.0-1.0，表示动画已经完成的进度
     * @param startValue 动画初始值
     * @param endValue   动画结束值
     * @return 动画下一个值，计算方法 next = startValue+(endValue-startValue)*fraction
     */
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point start = (Point) startValue;
        Point end = (Point) endValue;
        float x = start.getX() + fraction * (end.getX() - start.getX());
        float y = start.getY() + fraction * (end.getY() - start.getY());
        return new Point(x, y);
    }
}
