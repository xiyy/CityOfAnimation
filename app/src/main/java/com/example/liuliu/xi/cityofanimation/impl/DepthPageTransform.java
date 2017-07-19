package com.example.liuliu.xi.cityofanimation.impl;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by zhangxb171 on 2017/7/19.
 */

public class DepthPageTransform implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;
    private static final String TAG = "DepthPageTransformer";

    public void transformPage(View view, float position) {
        Log.e(TAG, "transformPage: --------->" + position);
        int pageWidth = view.getWidth();
        if (position > 0 && position <= 1) {//右侧View
            view.setAlpha(1 - position);//右侧View的透明度从0->1
            view.setTranslationX(-pageWidth * position);//右侧View X轴不变动
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));//0.75->1变化
            view.setScaleX(scaleFactor);//View从0.75倍增长为1倍
            view.setScaleY(scaleFactor);
        }
    }
}
