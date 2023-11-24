package com.jiho.adapter;

public class Application {

    public static void main(String[] args) {

        Notice notice = new Notice();
        User1 user1 = new User1("user1");
        User2 user2 = new User2("user2");

        notice.attach(user1);
        notice.attach(user2);
        notice.notifyObservers("공지사항 받으세요!!");

        notice.detach(user2);
        notice.notifyObservers("안녕하세요~~~");
    }
}
