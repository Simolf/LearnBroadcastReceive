package com.example.cxx.learnbroadcastreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public static final String ACTION="com.example.cxx.learnbroadcastreceive.intent.ACTION.MyReceiver";
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        //第二个参数是intent，通过intent接收MainActivity传递过来的消息
        System.out.println("接收到了消息:"+intent.getStringExtra("data"));
        abortBroadcast();//终止广播
    }
}
