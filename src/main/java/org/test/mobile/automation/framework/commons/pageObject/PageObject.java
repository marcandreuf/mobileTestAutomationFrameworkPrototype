package org.test.mobile.automation.framework.commons.pageObject;

import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.exceptions.AlternativeEndingTestCaseException;
import org.test.mobile.automation.framework.commons.exceptions.PageObjectException;

/**
 * @author marcandreuf
 */
public abstract class PageObject {
    protected final Device device;
    protected final App app;

    public PageObject(Device device, App app){
        this.device = device;
        this.app = app;
    }

    public abstract boolean isActive();
    public abstract <P extends PageObject> P waitUntilLoaded();
    public abstract <P extends PageObject> P verifyPageElements() throws PageObjectException;
    public abstract <P extends PageObject> P getStubPage();

    public void alternativeEndingTest(String description) throws AlternativeEndingTestCaseException {
        throw new AlternativeEndingTestCaseException(description);
    }
}
