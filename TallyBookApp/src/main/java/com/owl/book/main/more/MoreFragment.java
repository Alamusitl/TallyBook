package com.owl.book.main.more;

import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;
import com.owl.book.databinding.FragmentMoreBinding;

/**
 * Created by Alamusi on 2017/4/21.
 */

public class MoreFragment extends BaseFragment<FragmentMoreBinding> {

    private ObservableArrayList<Object> mFuncItemList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_more, container);
        return getBinding().getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFuncItemList = new ObservableArrayList<>();
        initFuncItemList();
        mBinding.setItemList(mFuncItemList);
    }

    private void initFuncItemList() {
        FuncItem item = new FuncItem();
        item.setFuncItemName("我要借钱");
        item.setFuncItemIcon(R.drawable.icon_loans);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("存钱计划");
        item.setFuncItemIcon(R.drawable.icon_more_save_money);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("换肤");
        item.setFuncItemIcon(R.drawable.icon_clothes);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("账单总结");
        item.setFuncItemIcon(R.drawable.icon_more_bills);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("导出数据");
        item.setFuncItemIcon(R.drawable.icon_more_export);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("提醒");
        item.setFuncItemIcon(R.drawable.icon_more_remind);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("意见反馈");
        item.setFuncItemIcon(R.drawable.icon_more_feedback);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("设置");
        item.setFuncItemIcon(R.drawable.icon_more_setting);
        mFuncItemList.add(item);

        item = new FuncItem();
        item.setFuncItemName("关于我们");
        item.setFuncItemIcon(R.drawable.icon_more_about_us);
        mFuncItemList.add(item);
    }
}
