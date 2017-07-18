package com.example.liuliu.xi.cityofanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mFrameButton;
    private Button mTweenButton;
    private Button mBlurButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameButton = (Button) findViewById(R.id.main_activity_frame_animation_button);
        mFrameButton.setOnClickListener(this);
        mTweenButton = (Button) findViewById(R.id.main_activity_tween_animation_button);
        mTweenButton.setOnClickListener(this);
        mBlurButton = (Button) findViewById(R.id.main_activity_blur_button);
        mBlurButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_frame_animation_button:
                Intent intent = new Intent(MainActivity.this, FrameAnimationActivity.class);
                startActivity(intent);
                //activity跳转，过渡动画
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
            case R.id.main_activity_tween_animation_button:

                break;
            case R.id.main_activity_blur_button:

                break;
        }
    }
}
