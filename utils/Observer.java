package utils;

/**
 * part of the observer design pattern
 * @author Jay.
 */
public interface Observer {
    /**
     * Updates the observers if the main makes a change
     * @param subject
     */
    void update(VisualizationSubject subject);
}
