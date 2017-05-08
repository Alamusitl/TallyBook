package com.owl.tallybook.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.owl.tallybook.R;

/**
 * Created by Alamusi on 2017/4/19.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Fragment mFragment;

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        FragmentManager fm = getSupportFragmentManager();
        mFragment = fm.findFragmentById(R.id.id_fragmentContainer);
        if (mFragment == null) {
            mFragment = createFragment();
            fm.beginTransaction().add(R.id.id_fragmentContainer, mFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (mFragment instanceof BaseFragment) {
            if (((BaseFragment) mFragment).onBackPressed()) {
                return;
            }
        }
        super.onBackPressed();
    }
}
