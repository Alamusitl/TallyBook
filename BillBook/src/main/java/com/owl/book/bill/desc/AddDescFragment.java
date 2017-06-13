package com.owl.book.bill.desc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;
import com.owl.book.bill.AddOneFragment;


/**
 * Created by Imagine Owl on 2017/5/23.
 */

public class AddDescFragment extends BaseFragment<FragmentEditDescriptionBinding> {

    public static final String KEY_DESC = "desc";

    private Presenter mPresenter;
    private EditText mEtDesc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_edit_description, container);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new Presenter();
        mBinding.setPresenter(mPresenter);

        mEtDesc = mBinding.idDescInput;
        mEtDesc.requestFocus();
    }

    public class Presenter {

        public void onBackgroundClick(View view) {
            handleDismiss(null);
        }

        public void onCloseClick(View view) {
            handleDismiss(null);
        }

        public void onConfirmClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_DESC, mEtDesc.getText().toString());
            handleDismiss(bundle);
        }

        public void onChoosePicClick(View view) {

        }

        private void handleDismiss(Bundle bundle) {
            getFragmentManager().beginTransaction().hide(AddDescFragment.this).commit();
            dismiss(AddOneFragment.class.getName(), bundle);
        }
    }
}
