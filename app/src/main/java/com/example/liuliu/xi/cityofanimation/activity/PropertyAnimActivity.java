package com.example.liuliu.xi.cityofanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.liuliu.xi.cityofanimation.R;

public class PropertyAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mAlpha;
    private Button mTranslate;
    private Button mScale;
    private Button mRotate;
    private Button mAnimSet;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim);
        mAlpha = (Button) findViewById(R.id.alpha);
        mAlpha.setOnClickListener(this);
        mTranslate = (Button) findViewById(R.id.translate);
        mTranslate.setOnClickListener(this);
        mScale = (Button) findViewById(R.id.scale);
        mScale.setOnClickListener(this);
        mRotate = (Button) findViewById(R.id.rotate);
        mRotate.setOnClickListener(this);
        mAnimSet = (Button) findViewById(R.id.set);
        mAnimSet.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.myView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha:

                break;
            case R.id.translate:

                break;
            case R.id.scale:

                break;
            case R.id.rotate:

                break;
            case R.id.set:

                break;
        }
    }
}
