package org.test.mobile.automation.framework.commons.exceptions;

/**
 * @author marcandreuf
 */
public class ProfileFactoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProfileFactoryException(String msg){
		super(msg);
	}

	public ProfileFactoryException(String msg, Throwable t){
		super(msg, t);
	}
	
}
