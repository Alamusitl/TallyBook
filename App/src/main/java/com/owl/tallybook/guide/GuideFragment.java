package com.owl.tallybook.guide;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.tallybook.R;
import com.owl.tallybook.base.BaseFragment;
import com.owl.tallybook.databinding.FragmentGuideBinding;
import com.owl.tallybook.main.MainActivity;
import com.owl.tallybook.util.SPUtils;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class GuideFragment extends BaseFragment {

    private static final int CHILD_COUNT = 4;
    private FragmentGuideBinding mGuideBinding;
    private ViewPager mViewPager;
    private GuidePagerAdapter mAdapter;
    private GuideModel mGuideModel;
    private Presenter mPresenter;

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mGuideBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_guide, container, false);
        if (mViewPager == null) {
            mViewPager = mGuideBinding.idViewPager;
        }
        return mGuideBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new Presenter();
        mGuideModel = new GuideModel(CHILD_COUNT);
        mGuideBinding.setPresenter(mPresenter);
        mGuideBinding.setGuide(mGuideModel);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mGuideModel.setSelected(position);
                mPresenter.setCurPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mAdapter = new GuidePagerAdapter(getContext(), CHILD_COUNT);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);

    }

    public class Presenter {

        private int mCurPosition;

        public int getCurPosition() {
            return mCurPosition;
        }

        public void setCurPosition(int curPosition) {
            mCurPosition = curPosition;
        }

        public void onEnterMainClick() {
            SPUtils.setFirstLaunchFlag(getContext());
            startActivity(MainActivity.class);
            finish();
        }
    }
}
