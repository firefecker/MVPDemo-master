package com.autismbug.mvpdemo.list_new.biz;


import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/17.
 */

public class RequestBizNew implements IRequestBizNew {
    @Override
    public void requestForData(final OnRequestListenerNew onRequestListenerNew) {
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
                    if (onRequestListenerNew != null){
                        onRequestListenerNew.onSuccess(data);
                    }else {
                        onRequestListenerNew.onFailed();
                    }
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }).start();
    }
}
