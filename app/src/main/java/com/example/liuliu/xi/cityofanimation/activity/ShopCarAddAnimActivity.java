package com.example.liuliu.xi.cityofanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.liuliu.xi.cityofanimation.R;
import com.example.liuliu.xi.cityofanimation.adapter.ShopCarItemAdapter;


public class ShopCarAddAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mTypeBtn;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_car_add_anim);
        mTypeBtn = (ImageView) findViewById(R.id.type_shop_car_activity);
        mTypeBtn.setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_shop_car_activity);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ShopCarItemAdapter());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.type_shop_car_activity:

                break;
        }

    }
}
