package com.autismbug.mvpdemo.list_new.biz;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface OnRequestListenerNew {
    void onSuccess(List<String> data);
    void onFailed();
}
