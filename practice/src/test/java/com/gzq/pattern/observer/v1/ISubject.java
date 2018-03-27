package com.gzq.pattern.observer.v1;

import java.util.Vector;

public interface ISubject {
    void addO(IObserver observer);
    
    void removeO(IObserver observer);
    
    void notifyO();
    
}
