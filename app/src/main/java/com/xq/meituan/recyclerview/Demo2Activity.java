package com.xq.meituan.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.xq.meituan.R;
import com.xq.meituan.recyclerview.adapter.VpAdapter;
import com.xq.meituan.recyclerview.adapter.RvAdapter;
import com.xq.meituan.recyclerview.model.ModelHomeEntrance;
import com.xq.meituan.recyclerview.util.ScreenUtil;
import com.xq.meituan.recyclerview.widget.IndicatorView;

import java.util.ArrayList;
import java.util.List;


public class Demo2Activity extends AppCompatActivity {

    public static final int HOME_ENTRANCE_PAGE_SIZE = 10;//首页菜单单页显示数量
    private ViewPager viewPager;
    private LinearLayout container;
    private List<ModelHomeEntrance> homeEntrances;
    private IndicatorView indicatorView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo2_layout);

        initData();
        initView();
        init();
    }

    private void initView() {
        container = (LinearLayout) findViewById(R.id.home_entrance);
        viewPager = (ViewPager) findViewById(R.id.main_home_entrance_vp);
        indicatorView = (IndicatorView) findViewById(R.id.main_home_entrance_indicator);
    }


    private void initData() {
        homeEntrances = new ArrayList<>();
        homeEntrances.add(new ModelHomeEntrance("美食", R.mipmap.ic_category_0));
        homeEntrances.add(new ModelHomeEntrance("电影", R.mipmap.ic_category_1));
        homeEntrances.add(new ModelHomeEntrance("酒店住宿", R.mipmap.ic_category_2));
        homeEntrances.add(new ModelHomeEntrance("生活服务", R.mipmap.ic_category_3));
        homeEntrances.add(new ModelHomeEntrance("KTV", R.mipmap.ic_category_4));
        homeEntrances.add(new ModelHomeEntrance("旅游", R.mipmap.ic_category_5));
        homeEntrances.add(new ModelHomeEntrance("学习培训", R.mipmap.ic_category_6));
        homeEntrances.add(new ModelHomeEntrance("汽车服务", R.mipmap.ic_category_7));
        homeEntrances.add(new ModelHomeEntrance("摄影写真", R.mipmap.ic_category_8));
        homeEntrances.add(new ModelHomeEntrance("休闲娱乐", R.mipmap.ic_category_10));
        homeEntrances.add(new ModelHomeEntrance("丽人", R.mipmap.ic_category_11));
        homeEntrances.add(new ModelHomeEntrance("运动健身", R.mipmap.ic_category_12));
        homeEntrances.add(new ModelHomeEntrance("大保健", R.mipmap.ic_category_13));
        homeEntrances.add(new ModelHomeEntrance("团购", R.mipmap.ic_category_14));
        homeEntrances.add(new ModelHomeEntrance("景点", R.mipmap.ic_category_16));
        homeEntrances.add(new ModelHomeEntrance("全部分类", R.mipmap.ic_category_15));
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f));

        //首页菜单分页
        FrameLayout.LayoutParams entrancelayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f + 70));
        container.setLayoutParams(entrancelayoutParams);
        viewPager.setLayoutParams(layoutParams12);

        LayoutInflater inflater = LayoutInflater.from(this);
        //将RecyclerView放至ViewPager中：
        //一共的页数等于 总数/每页数量，并取整。
        int pageCount = (int) Math.ceil(homeEntrances.size() * 1.0 / HOME_ENTRANCE_PAGE_SIZE);
        List<View> viewList = new ArrayList<>();
        for (int index = 0; index < pageCount; index++) {
            //每个页面都是inflate出一个新实例
            RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.item_home_entrance_vp, viewPager, false);
            recyclerView.setLayoutParams(layoutParams12);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
            RvAdapter rvAdapter = new RvAdapter(this, homeEntrances, index, HOME_ENTRANCE_PAGE_SIZE);
            recyclerView.setAdapter(rvAdapter);
            viewList.add(recyclerView);
        }

        //设置viewpager
        VpAdapter vpAdapter = new VpAdapter(viewList);
        viewPager.setAdapter(vpAdapter);

        //设置indicator
        indicatorView.setIndicatorCount(viewPager.getAdapter().getCount());
        indicatorView.setCurrentIndicator(viewPager.getCurrentItem());
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                indicatorView.setCurrentIndicator(position);
            }
        });
    }
}
