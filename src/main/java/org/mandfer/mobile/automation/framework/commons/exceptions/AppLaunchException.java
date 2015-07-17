package org.mandfer.mobile.automation.framework.commons.exceptions;

/**
 * @author marcandreuf
 */
public class AppLaunchException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public AppLaunchException(String msg){
		super(msg);
	}
	
	public AppLaunchException(String msg, Throwable t){
		super(msg, t);
	}
	
}
