package com.owl.book.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.book.R;
import com.owl.book.addone.AddOneActivity;
import com.owl.book.base.BaseFragment;
import com.owl.book.databinding.FragmentMainBinding;
import com.owl.book.main.fragment.DetailFragment;
import com.owl.book.main.fragment.FormFragment;
import com.owl.book.main.fragment.MoreFragment;
import com.owl.book.main.fragment.WalletFragment;
import com.owl.book.main.model.BottomNav;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/4/19.
 */

public class MainFragment extends BaseFragment<FragmentMainBinding> {

    private List<BaseFragment> mFragmentList;
    private FragmentManager mFragmentManager;

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
        mFragmentManager = getChildFragmentManager();
        mFragmentManager.beginTransaction().add(mBinding.idMainContentContainer.getId(), mFragmentList.get(0)).commit();
    }

    public class Presenter {

        public void onNavItemSelected(int index) {
            getBinding().getBottomNav().setItemSelected(index);
            mFragmentManager.beginTransaction().replace(mBinding.idMainContentContainer.getId(), mFragmentList.get(index)).commit();
        }

        public void onNavAddRecordClick() {
            startActivity(AddOneActivity.class);
        }
    }
}
