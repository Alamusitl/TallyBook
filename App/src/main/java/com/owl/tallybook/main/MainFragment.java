package com.owl.tallybook.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.owl.tallybook.R;
import com.owl.tallybook.base.BaseFragment;
import com.owl.tallybook.databinding.FragmentMainBinding;
import com.owl.tallybook.main.fragment.DetailFragment;
import com.owl.tallybook.main.fragment.FormFragment;
import com.owl.tallybook.main.fragment.MoreFragment;
import com.owl.tallybook.main.fragment.WalletFragment;
import com.owl.tallybook.main.model.BottomNav;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class MainFragment extends BaseFragment<FragmentMainBinding> {

    private List<BaseFragment> mFragmentList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_main, container);
        return getBinding().getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BottomNav bottomNav = new BottomNav();
        Presenter presenter = new Presenter();
        getBinding().setBottomNav(bottomNav);
        getBinding().setPresenter(presenter);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new DetailFragment());
        mFragmentList.add(new WalletFragment());
        mFragmentList.add(new FormFragment());
        mFragmentList.add(new MoreFragment());
    }

    public class Presenter {

        public void onNavItemSelected(int index) {
            getBinding().getBottomNav().setItemSelected(index);
            Toast.makeText(getActivity(), "" + index, Toast.LENGTH_SHORT).show();
        }

        public void onNavAddRecordClick() {
            Toast.makeText(getActivity(), "add record", Toast.LENGTH_SHORT).show();
        }
    }
}
