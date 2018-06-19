package com.gzq.pattern.observer.v1;

public interface ISubject {
    void addO(IObserver observer);
    
    void removeO(IObserver observer);
    
    void notifyO();
    
}
