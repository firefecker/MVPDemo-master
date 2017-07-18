package com.autismbug.mvpdemo.login.presenter;

import android.os.Handler;

import com.autismbug.mvpdemo.login.bean.User;
import com.autismbug.mvpdemo.login.biz.IUserBiz;
import com.autismbug.mvpdemo.login.biz.OnLoginListener;
import com.autismbug.mvpdemo.login.biz.UserBiz;
import com.autismbug.mvpdemo.login.view.IUserLoginView;

/**
 * Created by Administrator on 2017/7/17.
 */

public class UserLoginPresenter {
    private IUserBiz mUserBiz;
    private IUserLoginView mUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        mUserLoginView = userLoginView;
        this.mUserBiz = new UserBiz();
    }

    public void login() {
        mUserLoginView.showLoading();
        mUserBiz.login(mUserLoginView.getUserName(), mUserLoginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.toMainActiviy(user);
                        mUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.showFailedError();
                        mUserLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        mUserLoginView.clearUserName();
        mUserLoginView.clearPassWord();
    }
}
