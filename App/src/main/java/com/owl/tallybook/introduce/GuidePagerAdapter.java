package com.owl.tallybook.introduce;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.tallybook.R;
import com.owl.tallybook.databinding.ViewGuideBinding;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class GuidePagerAdapter extends PagerAdapter {

    private LayoutInflater mInflater;
    private int mCount;

    public GuidePagerAdapter(Context context, int count) {
        mInflater = LayoutInflater.from(context);
        mCount = count;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return DataBindingUtil.inflate(mInflater, R.layout.view_guide, container, false);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewGuideBinding binding = (ViewGuideBinding) object;
        container.removeView(binding.getRoot());
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        ViewGuideBinding binding = (ViewGuideBinding) object;
        return binding.getRoot() == view;
    }
}
