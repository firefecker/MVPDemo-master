package com.autismbug.mvpdemo.login.biz;

import com.autismbug.mvpdemo.login.bean.User;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
