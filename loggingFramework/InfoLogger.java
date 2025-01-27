package loggingFramework;

import loggingFramework.observer.LogSubject;

public class InfoLogger extends AbstractLogger{

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
//        System.out.println("INFO : "+ msg);
        logSubject.notifyAllObserver(1, msg);
    }
}
