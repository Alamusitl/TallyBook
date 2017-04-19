package com.owl.tallybook.welcome;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.owl.tallybook.R;
import com.owl.tallybook.base.BaseFragment;
import com.owl.tallybook.databinding.FragmentWelcomeBinding;
import com.owl.tallybook.introduce.GuideActivity;
import com.owl.tallybook.main.MainActivity;
import com.owl.tallybook.util.SPUtils;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class WelcomeFragment extends BaseFragment {

    private Presenter mPresenter;

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentWelcomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);
        mPresenter = new Presenter();
        binding.setPresenter(mPresenter);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.onSkipClick();
            }
        }, 1000);
    }

    public class Presenter {
        public void onSkipClick() {
            if (SPUtils.isFirstLaunch(getContext())) {
                startActivity(GuideActivity.class);
            } else {
                startActivity(MainActivity.class);
            }
            finish();
        }

        public void onAdClick() {
            Toast.makeText(getContext(), "点击广告", Toast.LENGTH_SHORT).show();
        }
    }
}
