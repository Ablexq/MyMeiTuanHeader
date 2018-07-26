package com.xq.meituan.flexbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.xq.meituan.R;
import com.xq.meituan.recyclerview.model.ModelHomeEntrance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/26.
 */

public class Demo3Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ModelHomeEntrance> homeEntrances;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo3_layout);

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

        recyclerView = ((RecyclerView) this.findViewById(R.id.recyclerview));

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        recyclerView.setLayoutManager(layoutManager);

        RvAdapter rvAdapter = new RvAdapter(homeEntrances);
        recyclerView.setAdapter(rvAdapter);
    }
}
/*
flexDirection

flex-direction 属性决定主轴的方向（即内部子元素的排列方向）。
- row（默认值）：水平显示，起点在左端
- row_reverse：水平显示，起点在右端，与row相反的顺序
- column：垂直显示，起点在顶部
- column_reverse：垂直显示，起点在底部，与column相反的顺序


justifyContent

justifyContent决定元素在主轴上的对齐方式
- flex_start（默认值）：主轴方向起点对齐
- flex_end：主轴方向终点对齐
- center： 主轴方向居中对齐
- space_between：主轴方向两端对齐，元素之间的间隔都相等。
- space-around：每个元素两侧的间隔相等。所以，元素之间的间隔比元素与布局边框的间隔大一倍。


flexWrap

flexWrap 决定是否换行
- nowrap（默认值）：不换行
- wrap：按正常方向换行，第一行在上方
- wrap_reverse：按反方向换行，第一行在下方


alignItems

alignItems决定元素在交叉轴方向上的对齐方式，「交叉轴」 我理解的就是 与主轴交叉垂直的方向，比如主轴是水平的，那么交叉轴就是垂直方向的
- stretch（默认值）：交叉轴方向占满整个父布局。
- flex_start交叉轴的起点对齐
- flex_end交叉轴的终点对齐。
- center交叉轴的居中对齐
- baseline元素第一行文字的基线对齐

alignContent

alignContent决定了多根轴线的对齐方式。如果项目只有一根轴线，该属性不起作用。
- stretch（默认值）：轴线占满整个交叉轴。
- flex_start 交叉轴方向起点对齐
- flex_end 交叉轴方向终点对齐
- center 交叉轴方向居中对齐
- space_between 交叉轴方向两端对齐，元素之间的间隔都相等
- space_around 每个元素两侧的间隔相等。所以，元素之间的间隔比元素与布局边框的间隔大一倍

divider属性

描述了元素间的分割线
- showDividerHorizontal四个属性none | beginning | middle | end，beginning显示线条在布局的上面，end显示线条在布局的下面
- dividerDrawableHorizontal 水平分隔线放在伸缩线之间
- showDividerVertical beginning显示线条在布局的左边，end显示线条在布局的右边
- dividerDrawableVertical 垂直分隔线放在伸缩线之间
- showDivider 配合dividerDrawableHorizontal就是showDividerHorizontal的效果，
    配合dividerDrawableVertical就是showDividerVertical的效果，配合dividerDrawable就是显示水平和垂直方向的线条
- dividerDrawable drawable属性，配合showDivider可以显示水平和垂直方向的线条
*/
