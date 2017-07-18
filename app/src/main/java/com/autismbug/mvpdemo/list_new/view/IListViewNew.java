package com.autismbug.mvpdemo.list_new.view;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface IListViewNew extends BaseViewNew {


    void setListItem(List<String> data);

    void showMessage(String message);
}
