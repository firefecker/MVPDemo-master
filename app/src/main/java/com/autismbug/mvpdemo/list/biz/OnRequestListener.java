package com.autismbug.mvpdemo.list.biz;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface OnRequestListener {
    void onSuccess(List<String> data);
    void onFailed();
}
