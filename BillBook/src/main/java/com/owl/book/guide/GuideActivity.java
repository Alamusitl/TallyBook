package com.owl.book.guide;

import android.support.v4.app.Fragment;

import com.owl.book.base.BaseActivity;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class GuideActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new GuideFragment();
    }
}
