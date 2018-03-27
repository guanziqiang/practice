package com.gzq.pattern.observer.v1;

import java.util.Vector;

public class ISubjectImpl implements ISubject {
    Vector<IObserver> observers = new Vector<>();

    @Override
    public void addO(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void removeO(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyO() {
        for (IObserver iObserver : observers) {
            iObserver.upadate("通知观察者，被观察者已经变动");
        }
    }

}
