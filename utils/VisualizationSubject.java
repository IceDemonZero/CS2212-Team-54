package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Part of the observer design pattern.
 * responsible for notifying the observers.
 * @author Jay
 */
public abstract class VisualizationSubject {
    private List<Observer> observers = 	new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(this);
    }
}
