package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {
    private static final Logger log = LogManager.getLogger();

    public static void logInfo(String massage){
        log.info(massage);
    }
    public static void logError(String massage){
        log.error(massage);
    }
    public static void logDebug(String massage){
        log.debug(massage);
    }






}
