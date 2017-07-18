package com.autismbug.mvpdemo.login.biz;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface IUserBiz {
    void login(String username,String password,OnLoginListener loginListener);
}
