package loggingFramework;

import loggingFramework.observer.LogSubject;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
//        System.out.println("ERROR : "+ msg);
        logSubject.notifyAllObserver(2, msg);
    }
}
