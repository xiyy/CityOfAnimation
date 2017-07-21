package com.example.liuliu.xi.cityofanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.liuliu.xi.cityofanimation.R;
import com.example.liuliu.xi.cityofanimation.view.PayFailureView;
import com.example.liuliu.xi.cityofanimation.view.PaySuccessView;

public class PayAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mPaySuccessBtn;
    private Button mPayFailureBtn;
    private PaySuccessView mPaySuccessView;
    private PayFailureView mPayFailureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_anim);
        mPaySuccessBtn = (Button) findViewById(R.id.pay_success);
        mPayFailureBtn = (Button) findViewById(R.id.pay_failure);
        mPaySuccessBtn.setOnClickListener(this);
        mPayFailureBtn.setOnClickListener(this);
        mPaySuccessView = (PaySuccessView) findViewById(R.id.pay_success_view);
        mPayFailureView = (PayFailureView) findViewById(R.id.pay_failure_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pay_success:
                mPaySuccessView.startAnim(100);
                break;
            case R.id.pay_failure:
                mPayFailureView.startAnim(100);
                break;
        }
    }
}
