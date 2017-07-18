package com.autismbug.mvpdemo.list.view;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface IListView {
    void showLoading();

    void hideLoading();

    void setListItem(List<String> data);

    void showMessage(String message);
}
