package com.owl.book.main.Form;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;

/**
 * Created by Alamusi on 2017/4/21.
 */

public class FormFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_form, container);
        return getBinding().getRoot();
    }
}
