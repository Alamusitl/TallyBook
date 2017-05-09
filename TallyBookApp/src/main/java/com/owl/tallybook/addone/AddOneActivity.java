package com.owl.tallybook.addone;

import android.support.v4.app.Fragment;

import com.owl.tallybook.base.BaseActivity;

/**
 * Created by Alamusi on 2017/5/9.
 */

public class AddOneActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new AddOneFragment();
    }
}
