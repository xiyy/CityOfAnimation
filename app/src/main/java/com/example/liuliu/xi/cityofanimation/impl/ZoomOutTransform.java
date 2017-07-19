package com.example.liuliu.xi.cityofanimation.impl;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by zhangxb171 on 2017/7/19.
 */

public class ZoomOutTransform implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;
    private static final String TAG = "ZoomOutTransform";

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        Log.i(TAG, "transformPage----->" + position);
        //a页滑动至b页 ； a页从 0.0 -> -1 ；b页从1 -> 0.0
        if (position >= -1 && position <= 1) {//[-1, 1]
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));//a页面，1 -> 0.85，逐渐变小；b页面，0.85 -> 1，逐渐变大
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);//设置a与b之间的水平间隔
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }
    }
}
