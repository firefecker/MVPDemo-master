package com.autismbug.mvpdemo.login.view;

import com.autismbug.mvpdemo.login.bean.User;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface IUserLoginView {
    String getUserName();
    String getPassWord();

    void showLoading();
    void hideLoading();

    //成功，跳转Main
    void toMainActiviy(User user);
    void showFailedError();

    void clearUserName();
    void clearPassWord();
}
