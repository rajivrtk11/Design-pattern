package loggingFramework;

import loggingFramework.observer.LogSubject;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
//        System.out.println("DEBUG : "+ msg);
        logSubject.notifyAllObserver(3, msg);
    }
}
