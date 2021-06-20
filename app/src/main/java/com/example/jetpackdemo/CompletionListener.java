package com.example.jetpackdemo;


/**
 * 网络请求响应回调
 * Created by jack_lorf on 18/7/11.
 */

public interface CompletionListener<T> {

    //成功执行接口
    void onSuccess(T model);

    //失败执行接口
    void onFail(String error);
}
