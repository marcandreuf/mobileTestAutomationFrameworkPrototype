package org.test.mobile.automation.framework.commons.exceptions;

/**
 * @author marcandreuf
 */
public class AlternativeEndingTestCaseException extends Exception {

    private static final long serialVersionUID = 1L;

    public AlternativeEndingTestCaseException(String msg){
        super(msg);
    }

    public AlternativeEndingTestCaseException(String msg, Throwable t){
        super(msg, t);
    }

}
