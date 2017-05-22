package com.owl.book.tally;

import android.support.v4.app.Fragment;

import com.owl.book.base.BaseActivity;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class AddOneActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new AddOneFragment();
    }
}
