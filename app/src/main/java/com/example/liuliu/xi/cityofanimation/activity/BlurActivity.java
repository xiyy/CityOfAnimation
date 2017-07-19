package com.example.liuliu.xi.cityofanimation.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.liuliu.xi.cityofanimation.R;
import com.example.liuliu.xi.cityofanimation.util.BlurImage;

public class BlurActivity extends AppCompatActivity {
    private ImageView mBluredImg;
    private SeekBar mSeekBar;
    private TextView mSeekBarProcess;
    private Bitmap mOriginalBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
        mBluredImg = (ImageView) findViewById(R.id.blur_activity_blured_img);
        mSeekBar = (SeekBar) findViewById(R.id.blur_activity_seek_bar);
        mSeekBarProcess = (TextView) findViewById(R.id.blur_activity_seek_bar_process);
        mOriginalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blur_activity_scene);
        mBluredImg.setImageBitmap(BlurImage.blur(mOriginalBitmap, 1));//模糊度在1-25之间
        mSeekBar.setMax(25);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mBluredImg.setImageBitmap(BlurImage.blur(mOriginalBitmap, progress));
                mSeekBarProcess.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
