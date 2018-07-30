package com.yoyozhangh.github.eventbusdemo;

/**
 * 定义消息事件类
 */
public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
