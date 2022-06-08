package com.accenture.util.log;

import org.apache.log4j.Logger;

import com.accenture.exception.response.ApiErrorResponse;

/***
 * Class with utility to write in the log. 
 * If you want to change the log library,
 * you must make the changes only in this class
 * 
 * @author infrahector@hotmail.com
 */
public class LogUtil {
	
	private LogUtil() { }
	
	/**
	 * Log message with INFO category
	 * @param Clase asociada donde se genera el log
	 * @param Message to save in the log
	 */
	public static void info(Class c, String message) {
		Logger logger = Logger.getLogger(c);
		logger.info(message);
	}
	
	/**
	 * Log message with Warning category
	 * @param Associated class where the log is generated
	 * @param Message to save in the log
	 */
	public static void warning(Class c, String message) {
		Logger logger = Logger.getLogger(c);
		logger.warn(message);
	}

	/**
	 * Log message with Error category caused by exception
	 * @param Associated class where the log is generated
	 * @param Message to save in the log
	 * @param Excepcion
	 */
	public static void error(Class c, String message, Throwable e) {
		Logger logger = Logger.getLogger(c);
		
		if(e != null) {
			logger.error(message, e);	
		}else {
			logger.error(message);
		}
	}
	
	/**
	 * Log message with Error category caused by exception
	 * @param Associated class where the log is generated
	 * @param Message to save in the log
	 * @param Excepcion
	 */
	public static void error(Class c, ApiErrorResponse r, Throwable e) {
		Logger logger = Logger.getLogger(c);
		
		if(r != null) {
			if(e != null) {
				logger.error(r.toStringJson(), e);	
			}else {
				logger.error(r.toStringJson());
			}	
		}
	}

	/**
	 * Log message with Error category
	 * associate to ApiErrorResponse
	 * @param Associated class where the log is generated
	 * @param Message to save in the log
	 */
	public static void error(Class c, ApiErrorResponse r) {
		Logger logger = Logger.getLogger(c);
		if(r != null) {
			logger.error(r.toStringJson());
		}
	}
	
	/**
	 * Log message with Error category
	 * @param Associated class where the log is generated
	 * @param Message to save in the log
	 */
	public static void error(Class c, String message) {
		error(c, message, null);
	}
}
