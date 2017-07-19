package com.example.liuliu.xi.cityofanimation.impl;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by zhangxb171 on 2017/7/19.
 */

public class CubeTransformer implements ViewPager.PageTransformer {
    private int maxRotation = 90;

    public CubeTransformer(int maxRotation) {
        this.maxRotation = maxRotation;
    }

    @Override
    public void transformPage(View page, float position) {
        if (position <= 0 && position >= -1) {
            page.setPivotX(page.getMeasuredWidth());
            page.setPivotY(page.getMeasuredHeight() / 2);
            page.setRotationY(position * maxRotation);
        }
        if (position <= 1 && position >= 0) {
            page.setPivotX(0);
            page.setPivotY(page.getMeasuredHeight() / 2);
            page.setRotationY(position * maxRotation);
        }
    }
}
