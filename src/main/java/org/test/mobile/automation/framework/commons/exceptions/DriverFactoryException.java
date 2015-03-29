package org.test.mobile.automation.framework.commons.exceptions;


/**
 * Exception thrown when there is any issue while creating any device instance.
 * 
 * @author marcandreuf
 *
 */
public class DriverFactoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public DriverFactoryException(String msg){
		super(msg);
	}
	public DriverFactoryException(String msg, Throwable t){
		super(msg, t);
	}
}
