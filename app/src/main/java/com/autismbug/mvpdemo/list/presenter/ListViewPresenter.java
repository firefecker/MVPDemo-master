package com.autismbug.mvpdemo.list.presenter;

import android.os.Handler;

import com.autismbug.mvpdemo.list.biz.IRequestBiz;
import com.autismbug.mvpdemo.list.biz.OnRequestListener;
import com.autismbug.mvpdemo.list.biz.RequestBiz;
import com.autismbug.mvpdemo.list.view.IListView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class ListViewPresenter {
    private IRequestBiz mRequestBiz;
    private IListView mListView;
    private Handler mHandler;

    public ListViewPresenter(IListView listView) {
        mListView = listView;
        mRequestBiz = new RequestBiz();
        mHandler = new Handler();
    }

    public void updateList() {
        mListView.showLoading();
        mRequestBiz.requestForData(new OnRequestListener() {
            @Override
            public void onSuccess(final List<String> data) {
                //在子线程中请求数据，所以要在 main 线程中更新 UI
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListView.hideLoading();
                        mListView.setListItem(data);
                    }
                });
            }

            @Override
            public void onFailed() {
                //这里也是子线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListView.hideLoading();
                        mListView.showMessage("请求失败");
                    }
                });
            }
        });
    }

    public void onItemClick(int position) {
        mListView.showMessage("点击了item" + (position + 1));
    }
}
