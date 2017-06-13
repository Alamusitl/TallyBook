package com.owl.book.main.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.owl.book.R;
import com.owl.book.base.BaseFragment;
import com.owl.book.dao.BookManager;
import com.owl.book.databinding.FragmentDetailBinding;
import com.owl.book.entity.Book;
import com.owl.book.recycler.BaseRecyclerAdapter;
import com.owl.book.util.DateTimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/4/21.
 */

public class DetailFragment extends BaseFragment<FragmentDetailBinding> implements BaseRecyclerAdapter.OnItemClickListener {

    private Presenter mPresenter;

    private RecyclerView mBooksRecyclerView;
    private TextView mCurBooksTvView;
    private ImageView mCurBooksIvView;
    private TextView mDateView;

    private BooksAdapter mBooksAdapter;
    private BooksFooterAdapter mAdapter;
    private List<Book> mBookList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        instanceBinding(inflater, R.layout.fragment_detail, container);
        return getBinding().getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBooksRecyclerView = mBinding.idDetailBooksRecyclerView;
        mCurBooksTvView = mBinding.idDetailCurBookText;
        mCurBooksIvView = mBinding.idDetailCurBookImg;
        mDateView = mBinding.idDetailTvDate;
        mDateView.setText(DateTimeUtil.getFormatDate(DateTimeUtil.getCurrDate(), "dd"));

        mBooksRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        mBooksRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mBooksAdapter = new BooksAdapter(getContext());
        mBookList = new ArrayList<>();
        mBookList = BookManager.getInstance().getList();
        mBooksAdapter.setDataList(mBookList);
        mBooksAdapter.setItemClickListener(this);

        mAdapter = new BooksFooterAdapter(mBooksAdapter);
        mAdapter.addFooterView(new View(getContext()));
        mAdapter.setItemClickListener(this);
        mBooksRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new Presenter();
        mBinding.setPresenter(mPresenter);

    }

    @Override
    public void onItemClick(View view, int position) {
        if (mAdapter.isHeaderViewPos(position)) {
            return;
        }
        if (mAdapter.isFooterViewPos(position)) {
            Book book = new Book();
            book.setId(mBooksAdapter.getItemCount() + 1);
            book.setBookName("New");
            book.setBookBg(R.drawable.books_others);
            book.setIsBookSelect(false);
            mBookList.add(book);
            BookManager.getInstance().insert(book);
            mBooksAdapter.notifyItemInserted(mBooksAdapter.getItemCount());
            mAdapter.notifyDataSetChanged();
            return;
        }
        for (int i = 0; i < mBooksAdapter.getItemCount(); i++) {
            mBooksAdapter.getDataList().get(i).setIsBookSelect(false);
        }
        mBooksAdapter.getDataList().get(position).setIsBookSelect(true);
        mCurBooksTvView.setText(mBooksAdapter.getDataList().get(position).getBookName());
    }

    @Override
    public void onItemLongClick(View view, int position) {
        if (mAdapter.isHeaderViewPos(position) || mAdapter.isFooterViewPos(position)) {
            return;
        }
        if (mBooksAdapter.getDataList().get(position).getIsBookSelect()) {
            Toast.makeText(getActivity(), "不能删除选中的账本", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getActivity(), "已删除账本" + mBookList.get(position - mAdapter.getHeaderViewCount()).getBookName(), Toast.LENGTH_SHORT).show();
        BookManager.getInstance().delete(mBookList.get(position));
        mBookList.remove(position - mAdapter.getHeaderViewCount());
        mBooksAdapter.notifyItemRemoved(position - mAdapter.getHeaderViewCount());
        mAdapter.notifyDataSetChanged();
    }

    public class Presenter {

        public void onCurBooksClicked(View view) {
            mCurBooksIvView.setSelected(!mCurBooksIvView.isSelected());
            mBooksRecyclerView.setVisibility(mCurBooksIvView.isSelected() ? View.VISIBLE : View.GONE);
        }
    }
}
