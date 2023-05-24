package utilities;

import com.myfirstproject.Day15_Log4J2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {


    //We will use this class for logging info in Test classes
    private static Logger logger = LogManager.getLogger(LoggerUtils.class.getName());

    public static void fatal(String message){
        logger.fatal(message);
    }

    public static void error(String message){
        logger.error(message);//In default
    }

    public static void warn(String message){
        logger.warn(message);//You can see this log after log4j2.xml configuration

    }

    public static void info(String message){
        logger.info(message);//cant see on console

    }

    public static void debug(String message ){
        logger.debug(message);//cant see on console

    }

}
