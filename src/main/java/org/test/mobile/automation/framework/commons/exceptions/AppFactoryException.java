package org.test.mobile.automation.framework.commons.exceptions;

/**
 * @author marcandreuf
 */
public class AppFactoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public AppFactoryException(String msg){
		super(msg);
	}

	public AppFactoryException(String msg, Throwable t){
		super(msg, t);
	}
	
}
