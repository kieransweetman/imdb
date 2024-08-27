package fr.diginamic.imdb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImdbException {
    private static final Logger logger = LoggerFactory.getLogger(ImdbException.class);
    private static final String LOG_DIR = "src/main/java/fr/diginamic/imdb/logs";
    private static final String LOG_FILE = "log.txt";

    static {
        // Ensure the logs directory exists
        File logDir = new File(LOG_DIR);
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
    }

    public static void log(Exception e) {
        try (FileWriter fileWriter = new FileWriter(new File(LOG_DIR, LOG_FILE), true)) {
            fileWriter.write("Exception occurred: " + e.getMessage() + "\n");
            for (StackTraceElement element : e.getStackTrace()) {
                fileWriter.write("\tat " + element.toString() + "\n");
            }
        } catch (IOException ioException) {
            logger.error("Failed to write to log file", ioException);
        }

        logger.error("Exception occurred", e);
    }
}
