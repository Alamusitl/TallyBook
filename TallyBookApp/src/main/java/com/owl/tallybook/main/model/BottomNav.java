package com.owl.tallybook.main.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;

import com.owl.tallybook.R;

/**
 * Created by Alamusi on 2017/4/20.
 */

public class BottomNav extends BaseObservable {

    private ObservableArrayList<BottomNavItem> mBottomNavItemList;
    private int mCurSelectItem;

    public BottomNav() {
        mBottomNavItemList = new ObservableArrayList<>();
        mCurSelectItem = 0;
        mBottomNavItemList.add(new BottomNavItem(0, R.drawable.main_detail_focus, R.drawable.main_detail_default, R.string.main_bottom_detail, true));
        mBottomNavItemList.add(new BottomNavItem(1, R.drawable.main_wallet_focus, R.drawable.main_wallet_default, R.string.main_bottom_wallet, false));
        mBottomNavItemList.add(new BottomNavItem(2, R.drawable.main_form_focus, R.drawable.main_form_default, R.string.main_bottom_form, false));
        mBottomNavItemList.add(new BottomNavItem(3, R.drawable.main_more_focus, R.drawable.main_more_default, R.string.main_bottom_more, false));
    }

    public BottomNavItem getBottomNavItemList(int index) {
        return mBottomNavItemList.get(index);
    }

    public void setItemSelected(int index) {
        if (mCurSelectItem == index) {
            return;
        }
        getBottomNavItemList(mCurSelectItem).setSelect();
        getBottomNavItemList(index).setSelect();
        mCurSelectItem = index;
    }
}
