package com.yoyozhangh.github.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button mSendButton = (Button)findViewById(R.id.bt_send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送事件
                EventBus.getDefault().post(new MessageEvent("欢迎关注 yoyozhangh  的博客"));
                finish();
            }
        });

        Button mStickyButton = (Button) findViewById(R.id.bt_send_stick_event);
        mStickyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送 sticky  事件
                EventBus.getDefault().postSticky(new MessageEvent("黏性事件"));
                finish();
            }
        });
    }
}
