package loggingFramework;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.info("this is info");
//        logger.error("this is error");
//        logger.debug("this is debug");
    }
}
