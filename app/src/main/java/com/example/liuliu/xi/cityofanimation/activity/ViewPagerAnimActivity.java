package com.example.liuliu.xi.cityofanimation.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuliu.xi.cityofanimation.R;
import com.example.liuliu.xi.cityofanimation.impl.SimplePageTransform;
import com.example.liuliu.xi.cityofanimation.impl.ZoomInTransform;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAnimActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<View> mPagerAdapterDatas = new ArrayList<>();
    private int[] imageResId = {R.drawable.audrey_hepburn_01, R.drawable.audrey_hepburn_02, R.drawable.audrey_hepburn_03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_anim);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_anim_activity);
        setAdapterData();
        mViewPager.setAdapter(new PagerAdapter());
        //mViewPager.setPageTransformer(true, new ZoomInTransform());//试试效果
        //mViewPager.setPageTransformer(false, new ZoomInTransform());//试试效果
        mViewPager.setPageTransformer(true, new SimplePageTransform());//3D效果
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
