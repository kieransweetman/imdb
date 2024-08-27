package fr.diginamic.imdb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImdbException {
    private static final Logger logger = LoggerFactory.getLogger(ImdbException.class);

    public static void log(Exception e) {
        logger.error("Exception occurred", e);
    }
}