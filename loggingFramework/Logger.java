package loggingFramework;

import loggingFramework.observer.LogSubject;

import java.io.Serializable;
import static loggingFramework.LogManager.buildChainOfLogger;
import static loggingFramework.LogManager.buildSubject;

public class Logger implements  Cloneable, Serializable {
    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSubject logSubject;

    private Logger() {
        if(logger != null) {
            throw  new IllegalStateException("Object already created");
        }
    }

    public static Logger getLogger() {
        if(logger == null) {
            synchronized (Logger.class) {
                if(logger == null) {
                    logger = new Logger();
                    chainOfLogger = buildChainOfLogger();
                    logSubject = buildSubject();
                }
            }
        }

        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return logger;
    }

    private void createLog(int level, String msg) {
        chainOfLogger.logMessage(level, msg, logSubject);
    }

    public void info(String msg) {
        createLog(1, msg);
    }

    public void error(String msg) {
        createLog(2, msg);
    }

    public void debug(String msg) {
        createLog(3, msg);
    }
}
