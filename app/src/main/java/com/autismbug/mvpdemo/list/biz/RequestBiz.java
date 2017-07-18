package com.autismbug.mvpdemo.list.biz;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/17.
 */

public class RequestBiz implements IRequestBiz{
    @Override
    public void requestForData(final OnRequestListener onRequestListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟从服务器获取数据
                    Thread.sleep(2000);
                    ArrayList<String> data = new ArrayList<String>();
                    for (int i = 1; i <= 10; i++) {
                        data.add("item" + i);
                    }
                    if (onRequestListener != null){
                        onRequestListener.onSuccess(data);
                    }else {
                        onRequestListener.onFailed();
                    }
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }).start();
    }
}
