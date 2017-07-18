package com.autismbug.mvpdemo.list_new;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.autismbug.mvpdemo.list_new.presenter.BasePresenterNew;

/**
 * Created by Administrator on 2017/7/17.
 */

public abstract class BaseListViewNewActivity<V, T extends BasePresenterNew<V>> extends AppCompatActivity {
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    public abstract T initPresenter();
}
