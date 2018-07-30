package com.yoyozhangh.github.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message = (TextView) findViewById(R.id.tv_message);
        Button mSubButton = (Button) findViewById(R.id.bt_subscription);
        mSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注册事件
                EventBus.getDefault().register(MainActivity.this);
            }
        });

        Button mSecondActivityButton = (Button) findViewById(R.id.bt_message);
        mSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动 secondActivity
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent) {
        tv_message.setText(messageEvent.getMessage());
    }


    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void ononMoonEvent(MessageEvent messageEvent){
        tv_message.setText(messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册事件

        EventBus.getDefault().unregister(MainActivity.this);
    }
}
