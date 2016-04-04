package com.example.cxx.learnbroadcastreceive;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnsendmsg).setOnClickListener(this);
        findViewById(R.id.btnReg).setOnClickListener(this);
        findViewById(R.id.btnUnreg).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsendmsg:
                //Intent i=new Intent(this,MyReceiver.class);
                Intent i=new Intent(MyReceiver.ACTION);//隐式intent
                i.putExtra("data","这是传递的消息");
                //通过intent发送消息
                //sendBroadcast(i);
                sendOrderedBroadcast(i,null);
                break;
            //注册,AndroidManifest中没有receive的信息
            case R.id.btnReg:
                if(receiver==null){
                    receiver=new MyReceiver();
                    registerReceiver(receiver,new IntentFilter(MyReceiver.ACTION));
                }
                break;
            //注销
            case R.id.btnUnreg:
                if(receiver!=null){
                    unregisterReceiver(receiver);
                    receiver=null;
                }
                break;
        }
    }
    //防止多次注册
    private MyReceiver receiver=null;
}
