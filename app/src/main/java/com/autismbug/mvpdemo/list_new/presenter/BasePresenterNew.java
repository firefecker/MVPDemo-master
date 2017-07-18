package com.autismbug.mvpdemo.list_new.presenter;

/**
 * Created by Administrator on 2017/7/17.
 */

public abstract class BasePresenterNew<T> {
    public T mView;
    public void attach(T view){
        this.mView = view;
    }
    public void dettach(){
        mView = null;
    }
}
