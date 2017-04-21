package com.owl.tallybook.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.tallybook.R;
import com.owl.tallybook.base.BaseFragment;

/**
 * Created by Alamusi on 2017/4/21.
 */

public class MoreFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_more, container);
        return getBinding().getRoot();
    }
}
