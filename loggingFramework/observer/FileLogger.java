package loggingFramework.observer;

public class FileLogger implements LogObserver{
    @Override
    public void log(String msg) {
        System.out.println("FILE_LOGGER : "+ msg);
    }
}
