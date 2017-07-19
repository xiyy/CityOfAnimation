package com.example.liuliu.xi.cityofanimation.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuliu.xi.cityofanimation.R;
import com.example.liuliu.xi.cityofanimation.impl.CubeTransformer;
import com.example.liuliu.xi.cityofanimation.impl.DepthPageTransform;
import com.example.liuliu.xi.cityofanimation.impl.SimplePageTransform;
import com.example.liuliu.xi.cityofanimation.impl.ZoomInTransform;
import com.example.liuliu.xi.cityofanimation.impl.ZoomOutTransform;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    private List<View> mPagerAdapterDatas = new ArrayList<>();
    private int[] imageResId = {R.drawable.audrey_hepburn_01, R.drawable.audrey_hepburn_02, R.drawable.audrey_hepburn_03};
    private Button mStyle1;
    private Button mStyle2;
    private Button mStyle3;
    private Button mStyle4;
    private Button mStyle5;
    private Button mStyle6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_anim);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_anim_activity);
        mStyle1 = (Button) findViewById(R.id.anim1_view_pager_activity);
        mStyle2 = (Button) findViewById(R.id.anim2_view_pager_activity);
        mStyle3 = (Button) findViewById(R.id.anim3_view_pager_activity);
        mStyle4 = (Button) findViewById(R.id.anim4_view_pager_activity);
        mStyle5 = (Button) findViewById(R.id.anim5_view_pager_activity);
        mStyle6 = (Button) findViewById(R.id.anim6_view_pager_activity);
        mStyle1.setOnClickListener(this);
        mStyle2.setOnClickListener(this);
        mStyle3.setOnClickListener(this);
        mStyle4.setOnClickListener(this);
        mStyle5.setOnClickListener(this);
        mStyle6.setOnClickListener(this);
        setAdapterData();
        mViewPager.setAdapter(new PagerAdapter());
    }

    private void setAdapterData() {
        for (int i = 1; i <= 3; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_view_pager_anim, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_item_view_pager_anim);
            TextView textView = (TextView) view.findViewById(R.id.text_view_view_pager_anim);
            imageView.setImageResource(imageResId[i - 1]);
            textView.setText(i + "");
            mPagerAdapterDatas.add(view);
        }
    }

    @Override
    public void onClick(View v) {
        mPagerAdapterDatas.clear();
        setAdapterData();
        switch (v.getId()) {
            case R.id.anim1_view_pager_activity:
                mViewPager.setPageTransformer(true, new ZoomInTransform());
                break;
            case R.id.anim2_view_pager_activity:
                mViewPager.setPageTransformer(false, new ZoomInTransform());
                break;
            case R.id.anim3_view_pager_activity:
                mViewPager.setPageTransformer(true, new SimplePageTransform());
                break;
            case R.id.anim4_view_pager_activity:
                mViewPager.setPageTransformer(true, new DepthPageTransform());
                break;
            case R.id.anim5_view_pager_activity:
                mViewPager.setPageTransformer(true, new ZoomOutTransform());
                break;
            case R.id.anim6_view_pager_activity:
                mViewPager.setPageTransformer(true, new CubeTransformer(90));
                break;
        }
        mViewPager.setAdapter(new PagerAdapter());
    }

    class PagerAdapter extends android.support.v4.view.PagerAdapter {


        @Override
        public int getCount() {
            return mPagerAdapterDatas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mPagerAdapterDatas.get(position));
            return mPagerAdapterDatas.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mPagerAdapterDatas.get(position));
        }
    }
}
