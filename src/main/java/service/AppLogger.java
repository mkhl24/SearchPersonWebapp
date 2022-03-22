package service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLogger {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static AppLogger INSTANCE;
	
	public AppLogger() {
		setupLogger();
	}
	
	public static AppLogger getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AppLogger();
        }
        return INSTANCE;
    }
	
	private final void setupLogger() {

		LogManager.getLogManager().reset();
		logger.setLevel(Level.ALL);
		
		try {
			FileHandler fh = new FileHandler("%htestproject_logfile.log", 8096, 1, true);
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
		} catch(IOException e) {
			logger.log(Level.SEVERE, "File logger not working", e);
		}
	}
	
	public void writeLog(Level logLevel, String logdata) {
		logger.log(logLevel, logdata);
	}
}
