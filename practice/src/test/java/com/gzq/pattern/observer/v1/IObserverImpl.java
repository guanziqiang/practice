package com.gzq.pattern.observer.v1;

public class IObserverImpl implements IObserver {

    @Override
    public void upadate(String message) {
        System.out.println("收到被观察者的通知："+message);
    }

}
