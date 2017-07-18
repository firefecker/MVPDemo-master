package com.autismbug.mvpdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.autismbug.mvpdemo.list_new.BaseListViewNewActivity;
import com.autismbug.mvpdemo.list_new.presenter.ListViewPresenterNew;
import com.autismbug.mvpdemo.list_new.view.IListViewNew;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewNewActivity extends BaseListViewNewActivity<IListViewNew, ListViewPresenterNew>
        implements IListViewNew, AdapterView.OnItemClickListener {

    @BindView(R.id.list_view)
    ListView mListView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_new);
        ButterKnife.bind(this);
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.updateList();
    }

    @Override
    public ListViewPresenterNew initPresenter() {
        return new ListViewPresenterNew();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClick(position);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setListItem(List<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
