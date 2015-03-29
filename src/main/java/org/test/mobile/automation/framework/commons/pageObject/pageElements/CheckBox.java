package org.test.mobile.automation.framework.commons.pageObject.pageElements;

import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.pageObject.pageElements.PageElement;

/**
 * @author marcandreuf
 */
public class CheckBox extends PageElement {
    public CheckBox(Device device, String elemId, String... options) {
        super(device, elemId, options);
    }
}
