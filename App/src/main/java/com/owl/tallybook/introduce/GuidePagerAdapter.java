package com.owl.tallybook.introduce;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.tallybook.R;
import com.owl.tallybook.databinding.ViewGuideBinding;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class GuidePagerAdapter extends PagerAdapter {

    private int[] mGuidePicRes = {R.drawable.guide_pic_1, R.drawable.guide_pic_2,
            R.drawable.guide_pic_3, R.drawable.guide_pic_4};

    private LayoutInflater mInflater;
    private int mCount;
    private SparseArray<View> mViewSparseArray;

    public GuidePagerAdapter(Context context, int count) {
        mInflater = LayoutInflater.from(context);
        mCount = count;
        mViewSparseArray = new SparseArray<>();
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGuideBinding binding = DataBindingUtil.inflate(mInflater, R.layout.view_guide, container, false);
        View view = binding.getRoot();
        view.setTag(String.valueOf(position));
        view.setBackgroundResource(mGuidePicRes[position]);
        if (mViewSparseArray.get(position) != null) {
            return mViewSparseArray.get(position);
        } else {
            container.addView(view);
            mViewSparseArray.put(position, view);
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = mViewSparseArray.get(position);
        if (view == null) {
            return;
        }
        container.removeView(view);
        mViewSparseArray.remove(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.getTag() == ((View) object).getTag();
    }


}
