package com.homework.chat;

/**
 * Created by Yushchenko on 02.10.2014.
 */
public class ChatContact {
    private String nickName;

    public ChatContact(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
