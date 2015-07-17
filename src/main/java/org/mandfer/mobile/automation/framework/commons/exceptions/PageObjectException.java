package org.mandfer.mobile.automation.framework.commons.exceptions;

/**
 * @author marcandreuf
 */
public class PageObjectException extends Exception {

    private static final long serialVersionUID = 1L;

    public PageObjectException(String msg){
        super(msg);
    }
    public PageObjectException(String msg, Throwable t){
        super(msg, t);
    }
}