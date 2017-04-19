package com.owl.tallybook.introduce;

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
    private int[] mGuidePicRes = {R.drawable.guide_pic_1, R.drawable.guide_pic_1, R.drawable.guide_pic_1, R.drawable.guide_pic_1};

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mGuideBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_guide, container, false);
        mViewPager = mGuideBinding.idViewPager;
        return mGuideBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGuideModel = new GuideModel(CHILD_COUNT);
        mPresenter = new Presenter();
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
        mGuideBinding.setPresenter(mPresenter);
        mGuideBinding.setGuide(mGuideModel);
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
