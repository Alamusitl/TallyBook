package com.owl.book.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.owl.book.R;
import com.owl.book.databinding.ViewItemWalletAccountBinding;


/**
 * Created by Imagine Owl on 2017/6/5.
 */

public class AccountView extends FrameLayout {

    private ViewItemWalletAccountBinding mBinding;

    private TextView mAccountViewName;
    private TextView mAccountViewDesc;
    private TextView mAccountViewBalance;

    private GradientDrawable mAccountLabelDrawable;
    private Drawable mAccountIconDrawable;
    private String mAccountName;
    private String mAccountDesc;
    private String mAccountBalance;

    public AccountView(Context context) {
        this(context, null);
    }

    public AccountView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AccountView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (isInEditMode()) {
            return;
        }
        mBinding = ViewItemWalletAccountBinding.inflate(LayoutInflater.from(context), this, true);
        initData(context, attrs, defStyle);
        initChildrenViews();
    }

    private void initData(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AccountView, defStyle, 0);
        int count = a.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.AccountView_accountBg:
                    GradientDrawable accountBgDrawable;
                {
                    int bgColor = a.getColor(attr, 0);
                    accountBgDrawable = getDrawable(R.drawable.shape_bg_wallet_item);
                    accountBgDrawable.setColor(bgColor);
                    setDrawable(mBinding.getRoot(), accountBgDrawable);
                }
                break;
                case R.styleable.AccountView_accountIcon:
                    mAccountIconDrawable = a.getDrawable(attr);
                    break;
                case R.styleable.AccountView_accountName:
                    mAccountName = a.getString(attr);
                    break;
                case R.styleable.AccountView_accountDesc:
                    mAccountDesc = a.getString(attr);
                    break;
                case R.styleable.AccountView_accountBalance:
                    mAccountBalance = a.getString(attr);
                    break;
                case R.styleable.AccountView_accountLabelBg: {
                    int navColor = a.getColor(attr, 0);
                    mAccountLabelDrawable = getDrawable(R.drawable.shape_bg_wallet_item_label);
                    mAccountLabelDrawable.setColor(navColor);
                }
                break;
                default: {
                    int bgColor = a.getColor(attr, 0);
                    int navColor = a.getColor(attr, 0);
                    accountBgDrawable = new GradientDrawable();
                    accountBgDrawable.setColor(bgColor);
                    mAccountLabelDrawable = new GradientDrawable();
                    mAccountLabelDrawable.setColor(navColor);
                }
                break;
            }
        }
        a.recycle();
    }

    private void initChildrenViews() {
        View accountViewLabel = mBinding.idWalletAccountItemLabel;
        ImageView accountViewIcon = mBinding.idWalletAccountItemIcon;
        mAccountViewName = mBinding.idWalletAccountItemName;
        mAccountViewDesc = mBinding.idWalletAccountItemDesc;
        mAccountViewBalance = mBinding.idWalletAccountItemBalance;

        setDrawable(accountViewLabel, mAccountLabelDrawable);
        accountViewIcon.setImageDrawable(mAccountIconDrawable);
        mAccountViewName.setText(mAccountName);
        mAccountViewDesc.setText(mAccountDesc);
        mAccountViewBalance.setText(mAccountBalance);
    }

    public String getAccountName() {
        return mAccountName;
    }

    public void setAccountName(String accountName) {
        mAccountName = accountName;
        mAccountViewName.setText(mAccountName);
    }

    public String getAccountDesc() {
        return mAccountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        mAccountDesc = accountDesc;
        mAccountViewDesc.setText(mAccountDesc);
    }

    public String getAccountBalance() {
        return mAccountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        mAccountBalance = accountBalance;
        mAccountViewBalance.setText(mAccountBalance);
    }

    private GradientDrawable getDrawable(@DrawableRes int id) {
        GradientDrawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = (GradientDrawable) getResources().getDrawable(id, getContext().getTheme());
        } else {
            drawable = (GradientDrawable) getResources().getDrawable(id);
        }
        return drawable;
    }

    private void setDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
