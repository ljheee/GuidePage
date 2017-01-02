package com.ljheee.guidepage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * 引导页适配器类
 */
public class VpageAdapter extends PagerAdapter{

    private List<View> views;
    private Context context;

    public VpageAdapter(List<View> views, Context context) {

        this.views = views;
        this.context = context;
    }

    /**
     * 当滑到另外一页时把上一页从视图中去除
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(View container, int position, Object object) {

        ((ViewPager)container).removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(View container, int position) {

        ((ViewPager) container).addView(views.get(position));
        return views.get(position);
    }

    @Override
    public int getCount() {

        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0==arg1);
    }

}