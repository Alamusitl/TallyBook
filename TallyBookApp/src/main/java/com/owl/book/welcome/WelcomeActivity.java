package com.owl.book.welcome;

import android.support.v4.app.Fragment;

import com.owl.book.base.BaseActivity;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new WelcomeFragment();
    }

}
