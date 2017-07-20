package com.example.liuliu.xi.cityofanimation.impl;

import android.animation.TypeEvaluator;

import com.example.liuliu.xi.cityofanimation.bean.Point;

/**
 * Created by zhangxb171 on 2017/7/20.
 */

public class PointSinEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = (float) (Math.sin(x * Math.PI / 180) * 100) + endPoint.getY() / 2;
        Point point = new Point(x, y);
        return point;
    }
}
