package com.owl.tallybook.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.owl.tallybook.R;
import com.owl.tallybook.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }
}
