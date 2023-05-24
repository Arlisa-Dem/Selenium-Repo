package com.myfirstproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.LoggerUtils;


public class Day15_Log4J2 {


    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());


    @Test
    public void loggerTest1(){

        logger.fatal("Fatal log ...");
        logger.error("Error log ...");//In default
        logger.warn("Warn log ...");//You can see this log after log4j2.xml configuration
        logger.info("Info log ...");//cant see on console
        logger.debug("Debug log ..");//cant see on console

    }

    @Test
    public void loggerTest2(){

        System.out.println("======Utils=======");

        LoggerUtils.fatal("Fatal log from Utils class");
        LoggerUtils.error("Error log from Utils class");
        LoggerUtils.warn("Warn log from Utils class");
        LoggerUtils.info("Info log from Utils class");
        LoggerUtils.debug("Debug log from Utils class");
    }


}
