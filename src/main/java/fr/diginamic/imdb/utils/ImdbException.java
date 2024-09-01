package fr.diginamic.imdb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;

/**
 * Custom app exception handler to log errors and keep our script running
 * 
 * 
 */
public class ImdbException {
    private static final Logger logger = LoggerFactory.getLogger(ImdbException.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", Example.class.getSimpleName());
    }

    /**
     * Log an exception, will be logged in `/logs/imdb_exception.txt`
     * 
     * @param e Exception
     */
    public static void log(Exception e) {
        logger.error("Line problem occurred", e);
    }

    public static void log(String message) {
        logger.error(message);
    }
}