package org.test.mobile.automation.framework.commons.app;

import org.test.mobile.automation.framework.commons.pageObject.PageObject;

/**
 *
 * @author marcandreuf
 */
public interface InstalledApp {

    public <T extends PageObject> T launchTo(Class<T> pageObjectType) throws Exception;

    public  <T extends PageObject> T onPage(Class<T> pageObjectClassType) throws Exception;

}
