package org.mandfer.mobile.automation.framework.commons.exceptions;


/**
 * Exception thrown when there is any issue while creating any device instance.
 * 
 * @author marcandreuf
 *
 */
public class DeviceFactoryException extends Exception {
	
	private static final long serialVersionUID = 1L;	
	
	public DeviceFactoryException(String msg){
		super(msg);
	}
	public DeviceFactoryException(String msg, Throwable t){
		super(msg, t);
	}
}
