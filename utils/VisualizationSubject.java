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

    /**
     * Attach a new observer.
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Remove a new observer
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Update the observers on a change.
     */
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(this);
    }
}
