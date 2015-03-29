package org.test.mobile.automation.framework.commons.exceptions;


/**
 * Exception thrown when there is any issue while creating any device instance.
 * 
 * @author marcandreuf
 *
 */
public class DeviceException extends Exception {
	
	private static final long serialVersionUID = 1L;	
	
	public DeviceException(String msg){
		super(msg);
	}
	public DeviceException(String msg, Throwable t){
		super(msg, t);
	}
}
