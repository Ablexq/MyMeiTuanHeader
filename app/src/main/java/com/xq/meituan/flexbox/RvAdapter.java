package com.xq.meituan.flexbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xq.meituan.R;
import com.xq.meituan.recyclerview.model.ModelHomeEntrance;
import com.xq.meituan.recyclerview.util.ScreenUtil;

import java.util.List;

/**
 * Created by lenovo on 2018/7/26.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.VHolder> {

    private List<ModelHomeEntrance> mData;

    public RvAdapter(List<ModelHomeEntrance> mData) {
        this.mData = mData;
    }

    /*
    * 映射Item Layout Id，创建VH并返回。
    * */
    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demo3, parent, false);//要写成这样
//        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,null);//不可写成这种

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();//去掉这个可实现流布局
        layoutParams.width = ScreenUtil.getScreenWidth() / 5;
        view.setLayoutParams(layoutParams);

        return new VHolder(view);
    }

    /*
    * 为holder设置指定数据。
    * */
    @Override
    public void onBindViewHolder(RvAdapter.VHolder holder, final int position) {
        holder.mTextView.setText(mData.get(position).getName());
        holder.imageView.setImageResource(mData.get(position).getImage());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //item的点击事件
                System.out.println("name=========" + mData.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class VHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView imageView;
        private LinearLayout container;

        public VHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.entrance_name);
            imageView = (ImageView) itemView.findViewById(R.id.entrance_image);
            container = (LinearLayout) itemView.findViewById(R.id.container);
        }
    }
}