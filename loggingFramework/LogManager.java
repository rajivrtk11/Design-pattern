package loggingFramework;

import loggingFramework.observer.ConsoleLogger;
import loggingFramework.observer.FileLogger;
import loggingFramework.observer.LogObserver;
import loggingFramework.observer.LogSubject;

public class LogManager {
    protected static AbstractLogger buildChainOfLogger(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);

        return infoLogger;
    }

    protected static LogSubject buildSubject() {
        LogSubject logSubject = new LogSubject();
        LogObserver consoleLogger = new ConsoleLogger();
        LogObserver fileLogger = new FileLogger();

        logSubject.addObserver(1, consoleLogger);
        logSubject.addObserver(2, consoleLogger);

        logSubject.addObserver(1, fileLogger);

        return logSubject;
    }
}
