package com.example.liuliu.xi.cityofanimation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liuliu.xi.cityofanimation.R;

public class PropertyAnimEnterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mPropertyButton;
    private Button mPropertyValueButton;
    private Button mAliPayButton;
    private Button mShopCarButton;
    private Button mLayoutAnimaton;
    private Button mRevealAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        mPropertyButton = (Button) findViewById(R.id.property_property_anim_enter_activity);
        mPropertyButton.setOnClickListener(this);
        mPropertyValueButton = (Button) findViewById(R.id.value_property_anim_enter_activity);
        mPropertyValueButton.setOnClickListener(this);
        mAliPayButton = (Button) findViewById(R.id.ali_pay_property_anim_activity);
        mAliPayButton.setOnClickListener(this);
        mShopCarButton = (Button) findViewById(R.id.shop_car_add_property_anim_activity);
        mShopCarButton.setOnClickListener(this);
        mLayoutAnimaton = (Button) findViewById(R.id.Layout_Animations_property_anim_activity);
        mLayoutAnimaton.setOnClickListener(this);
        mRevealAnimation = (Button) findViewById(R.id.Reveal_Animator_propterty_anim_activity);
        mRevealAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.property_property_anim_enter_activity:
                Intent propertyIntent = new Intent(this, PropertyAnimActivity.class);
                startActivity(propertyIntent);
                break;
            case R.id.value_property_anim_enter_activity:
                Intent valueAnimatorIntent = new Intent(this, ValueAnimatorActivity.class);
                startActivity(valueAnimatorIntent);
                overridePendingTransition(R.anim.enter_from_bottom, R.anim.exit_to_bottom);
                break;
            case R.id.ali_pay_property_anim_activity:
                Intent payAnimIntent = new Intent(this, PayAnimActivity.class);
                startActivity(payAnimIntent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
            case R.id.shop_car_add_property_anim_activity:
                Intent shopCarAddIntent = new Intent(this, ShopCarAddAnimActivity.class);
                startActivity(shopCarAddIntent);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
            case R.id.Layout_Animations_property_anim_activity:

                break;
            case R.id.Reveal_Animator_propterty_anim_activity:

                break;
        }

    }
}
