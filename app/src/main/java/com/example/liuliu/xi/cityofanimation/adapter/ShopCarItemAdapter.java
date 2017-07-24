package com.example.liuliu.xi.cityofanimation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuliu.xi.cityofanimation.R;

/**
 * Created by zhangxb171 on 2017/7/21.
 */

public class ShopCarItemAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_car_goods_list_item, parent, false);
        GoodsItemViewHolder viewHolder = new GoodsItemViewHolder(itemView);
        viewHolder.goods = (ImageView) itemView.findViewById(R.id.shop_car_goods_list_item_goods_icon);
        viewHolder.add = (ImageView) itemView.findViewById(R.id.shop_car_goods_list_item_plus);
        viewHolder.minus = (ImageView) itemView.findViewById(R.id.shop_car_goods_list_item_minus);
        viewHolder.count = (TextView) itemView.findViewById(R.id.shop_car_goods_list_item_num);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GoodsItemViewHolder viewHolder = (GoodsItemViewHolder) holder;
        viewHolder.goods.setImageResource(getDrawableId(position));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class GoodsItemViewHolder extends RecyclerView.ViewHolder {

        public GoodsItemViewHolder(View itemView) {
            super(itemView);
        }

        ImageView goods;
        ImageView add;
        ImageView minus;
        TextView count;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     * @param position RecyclerView position
     * @return 根据position获取的图片ID
     */
    private int getDrawableId(int position) {
        int mode = position % 4;
        int drawableId = -1;
        switch (mode) {
            case 0:
                drawableId = R.drawable.shop_car_activity_goods_1;
                break;
            case 1:
                drawableId = R.drawable.shop_car_activity_goods_2;
                break;
            case 2:
                drawableId = R.drawable.shop_car_activity_goods_3;
                break;
            case 3:
                drawableId = R.drawable.shop_car_activity_goods_4;
                break;
        }
        return drawableId;
    }
}
